package lozm.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LargestNumber {

    @Test
    public void testCase1() {
        // Given
        int[] numbers = {6, 10, 2};

        // When
        final String solution = solution(numbers);

        // Then
        Assertions.assertEquals("6210", solution);
    }

    @Test
    public void testCase2() {
        // Given
        int[] numbers = {3, 30, 34, 5, 9};

        // When
        final String solution = solution(numbers);

        // Then
        Assertions.assertEquals("9534330", solution);
    }

    @Test
    public void testCase3() {
        // Given
        int[] numbers = {0, 0, 0};

        // When
        final String solution = solution(numbers);

        // Then
        Assertions.assertEquals("0", solution);
    }

    @Test
    public void testCase4() {
        // Given
        int[] numbers = {121, 12};

        // When
        final String solution = solution(numbers);

        // Then
        Assertions.assertEquals("12121", solution);
    }

    @Test
    public void testCase5() {
        // Given
        int[] numbers = {121, 12, 0};

        // When
        final String solution = solution(numbers);

        // Then
        Assertions.assertEquals("121210", solution);
    }

    @Test
    public void testCase6() {
        // Given
        int[] numbers = {10, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // When
        final String solution = solution(numbers);

        // Then
        Assertions.assertEquals("987654321101000", solution);
    }



    /**
     * 가장 큰 수
     * https://programmers.co.kr/learn/courses/30/lessons/42746
     * <p>
     * 1. 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
     * 2. 0 또는 양의 정수가 담긴 배열 numbers가 매개변수
     * 3. 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return
     */
    public String solution(int[] numbers) {
        List<CustomNumber> numberList = new ArrayList<>();
        for (int number : numbers) {
            numberList.add(new CustomNumber(String.valueOf(number)));
        }
        numberList.sort(CustomNumber::compareTo);

        StringBuilder answer = new StringBuilder();
        for (CustomNumber customNumber : numberList) {
            if (answer.toString().equals("0") && customNumber.getOriginalNumber().equals("0")) {
                continue;
            }

            answer.append(customNumber.getOriginalNumber());
        }

        return answer.toString();
    }

    class CustomNumber implements Comparable {
        private String originalNumber;
        private String repeatedNumber;

        public CustomNumber(String originalNumber) {
            this.originalNumber = originalNumber;
            this.repeatedNumber = originalNumber.equals("0") ? "0" : getFiveTimesRepeatedString(originalNumber).substring(0, 5);
        }

        public String getOriginalNumber() {
            return originalNumber;
        }

        public String getRepeatedNumber() {
            return repeatedNumber;
        }

        @Override
        public int compareTo(Object o) {
            final CustomNumber customNumber = (CustomNumber) o;
            return customNumber.getRepeatedNumber().compareTo(getRepeatedNumber());
        }
    }

    private String getFiveTimesRepeatedString(String value) {
        StringBuilder repeatedNumber = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            repeatedNumber.append(value);
        }
        return repeatedNumber.toString();
    }

}
