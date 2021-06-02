package lozm.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MakePrimeNumberCombiningNumbers {

    @Test
    public void testCase1() {
        // Given
        String numbers = "17";

        // When
        final int solution = solution(numbers);

        // Then
        Assertions.assertEquals(3, solution);
    }

    @Test
    public void testCase2() {
        // Given
        String numbers = "011";

        // When
        final int solution = solution(numbers);

        // Then
        Assertions.assertEquals(2, solution);
    }

    /**
     * 소수 찾기
     * https://programmers.co.kr/learn/courses/30/lessons/42839
     *
     * 1. 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers
     * 2. 종이 조각으로 만들 수 있는 소수가 몇 개인지 return
     * 3. numbers는 길이 1 이상 7 이하인 문자열입니다.
     */
    public int solution(String numbers) {
        int answer = 0;



        return answer;
    }

    public List<Integer> findPrimeNumberList(int number) {
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

        return primeNumberList;
    }

}
