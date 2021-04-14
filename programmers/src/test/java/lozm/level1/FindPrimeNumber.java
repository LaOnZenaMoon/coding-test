package lozm.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FindPrimeNumber {

    @Test
    public void testCase1() {
        // Given
        int n = 10;

        // When
        int solution = solution(n);

        // Then
        Assertions.assertEquals(4, solution);
    }

    @Test
    public void testCase2() {
        // Given
        int n = 5;

        // When
        int solution = solution(n);

        // Then
        Assertions.assertEquals(3, solution);
    }

    @Test
    public void testCase3() {
        // Given
        int n = 99;

        // When
        int solution = solution(n);

        // Then
        Assertions.assertEquals(3, solution);
    }

    /**
     * 소수 찾기
     * https://programmers.co.kr/learn/courses/30/lessons/12921
     *
     * 1. 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
     */
    public int worstSolution(int number) {
        String answer = "";

        while (number > 1) {
            boolean primeNumber = true;

            int divider = number - 1;
            while (divider != 1) {
                if (number % divider == 0) {
                    primeNumber = false;
                    break;
                }

                divider--;
            }

            if (primeNumber) {
                answer += number;
            }

            number --;
        }

        return answer.length();
    }

    /**
     * 에라토스테네스의 체
     * https://firework-ham.tistory.com/8
     */
    public int solution(int number) {
        List<Integer> primeNumberList = new ArrayList<>();
        primeNumberList.add(2);

        for (int i = 2; i <= number; i++) {
            for (int j = 0; j < primeNumberList.size(); j++) {
                if (i % primeNumberList.get(j) == 0) {
                    break;
                }

                if (primeNumberList.size() == j + 1) {
                    primeNumberList.add(i);
                }
            }
        }

        return primeNumberList.size();
    }


}
