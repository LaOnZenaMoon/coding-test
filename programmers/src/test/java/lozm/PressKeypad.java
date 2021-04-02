package lozm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PressKeypad {

    @Test
    void testCase1() {
        // Given
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        // When
        String solution = solution(numbers, hand);

        // Then
        Assertions.assertEquals("LRLLLRLLRRL", solution);
    }

    @Test
    void testCase2() {
        // Given
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        // When
        String solution = solution(numbers, hand);

        // Then
        Assertions.assertEquals("LRLLRRLLLRR", solution);
    }

    @Test
    void testCase3() {
        // Given
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";

        // When
        String solution = solution(numbers, hand);

        // Then
        Assertions.assertEquals("LLRLLRLLRL", solution);
    }

    @Test
    void testCaseRandom() {
        // Given
        int[] numbers = {2};
        String hand = "left";

        // When
        String solution = solution(numbers, hand);

        // Then
        Assertions.assertEquals("R", solution);
    }

    /**
     * 1. 맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작
     * 2. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
     * 3. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
     * 4. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
     * 5. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
     * 4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
     * <p>
     * 순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수
     */

    static final String usingRightHand = "R";
    static final String usingLeftHand = "L";

    public String solution(int[] numbers, String hand) {
        String answer = "";

        final int[] usingRightHandArray = {3, 6, 9};
        final int[] usingLeftHandArray = {1, 4, 7};

        Point rightHandPoint = new Point(2, 3);
        Point leftHandPoint = new Point(0, 3);

        Point twoPoint = new Point(1, 0);
        Point fivePoint = new Point(1, 1);
        Point eightPoint = new Point(1, 2);
        Point zeroPoint = new Point(1, 3);

        for (int i = 0; i < numbers.length; i++) {
            int targetNumber = numbers[i];

            int rightHandIndex = checkNumberArray(usingRightHandArray, targetNumber);
            if (rightHandIndex != -1) {
                rightHandPoint = new Point(2, rightHandIndex);
                answer += usingRightHand;
                continue;
            }

            int leftHandIndex = checkNumberArray(usingLeftHandArray, targetNumber);
            if (leftHandIndex != -1) {
                leftHandPoint = new Point(0, leftHandIndex);
                answer += usingLeftHand;
                continue;
            }

            Point checkPoint = null;
            if (targetNumber == 2) {
                checkPoint = twoPoint;
            } else if (targetNumber == 5) {
                checkPoint = fivePoint;
            } else if (targetNumber == 8) {
                checkPoint = eightPoint;
            } else if (targetNumber == 0) {
                checkPoint = zeroPoint;
            }

            String pressHand = process(hand, rightHandPoint, leftHandPoint, checkPoint);
            answer += pressHand;
            if (usingRightHand.equals(pressHand)) {
                rightHandPoint = checkPoint;
            } else {
                leftHandPoint = checkPoint;
            }
        }

        return answer;
    }

    private String process(String hand, Point rightHandPoint, Point leftHandPoint, Point checkPoint) {
        double rightHandDistance = rightHandPoint.comparePoint(checkPoint);
        double leftHandDistance = leftHandPoint.comparePoint(checkPoint);

        String usingHand = null;
        usingHand = rightHandDistance < leftHandDistance ? usingRightHand : usingLeftHand;

        if (rightHandDistance == leftHandDistance) {
            if ("right".equals(hand)) {
                usingHand = usingRightHand;
            } else {
                usingHand = usingLeftHand;
            }
        }

        return usingHand;
    }

    private int checkNumberArray(int[] handArray, int targetNumber) {
        int index = -1;

        for (int i = 0; i < handArray.length; i++) {
            int handArrayNumber = handArray[i];

            if (targetNumber == handArrayNumber) {
                index = i;
                break;
            }
        }

        return index;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double comparePoint(Point targetPoint) {
            return Math.abs(this.x - targetPoint.x) + Math.abs(this.y - targetPoint.y);
        }
    }

}
