package lozm.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GymSuit {

    @Test
    void testCase1() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        int solution = solution(n, lost, reserve);

        Assertions.assertEquals(5, solution);
    }

    @Test
    void testCase2() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {3};

        int solution = solution(n, lost, reserve);

        Assertions.assertEquals(4, solution);
    }

    @Test
    void testCase3() {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};

        int solution = solution(n, lost, reserve);

        Assertions.assertEquals(2, solution);
    }

    @Test
    void testCase4() {
        int n = 10;
        int[] lost = {3, 5, 7};
        int[] reserve = {3, 5, 10};

        int solution = solution(n, lost, reserve);

        Assertions.assertEquals(9, solution);
    }

    @Test
    void testCase5() {
        int n = 5;
        int[] lost = {2, 3, 4};
        int[] reserve = {1, 2, 3};

        int solution = solution(n, lost, reserve);

        Assertions.assertEquals(4, solution);
    }

    @DisplayName("연속적 옷 도난")
    @Test
    void testCase7() {
        int n = 7;
        int[] lost = {1, 2, 3, 4, 5, 6, 7};
        int[] reserve = {1, 2, 3};

        int solution = solution(n, lost, reserve);

        Assertions.assertEquals(3, solution);
    }

    /**
     * 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
     * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
     * <p>
     * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
     * 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
     * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
     */
    public int solution(int n, int[] lost, int[] reserve) {
        final int lostFlag = 1;
        final int reserveFlag = 0;
        int[] studentArray = new int[n];

        // 1. 체육복을 도난당한 학생일 경우
        for (int index : lost) {
            int currentStudent = index - 1;
            studentArray[currentStudent] = lostFlag;
        }

        // 2. 여분 체육복을 가진 학생이 도난당한 경우
        List<Integer> filterReserveList = new ArrayList<>();
        for (int index : reserve) {
            int currentStudent = index - 1;

            if (studentArray[currentStudent] == lostFlag) {
                studentArray[currentStudent] = reserveFlag;
                continue;
            }

            filterReserveList.add(index);
        }

        // 3. 체육복을 빌려받을 수 있는 경우
        for (Integer index : filterReserveList) {
            int currentStudent = index - 1;

            int prevStudent = currentStudent - 1;
            if (prevStudent >= 0 && studentArray[prevStudent] == lostFlag) {
                studentArray[prevStudent] = reserveFlag;
                continue;
            }

            int nextStudent = currentStudent + 1;
            if (nextStudent < n && studentArray[nextStudent] == lostFlag) {
                studentArray[nextStudent] = reserveFlag;
                continue;
            }
        }

        // 3. 체육복을 가지고 있는 학생 수 찾기
        int lostStudentSum = Arrays.stream(studentArray).sum();
        return n - lostStudentSum;
    }

}
