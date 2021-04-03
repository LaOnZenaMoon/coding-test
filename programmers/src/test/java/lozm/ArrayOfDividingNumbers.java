package lozm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOfDividingNumbers {

    @Test
    void testCase1() {
        // Given
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        // When
        int[] solution = solution(arr, divisor);

        // Then
        int[] answer = {5, 10};
        Assertions.assertArrayEquals(answer, solution);
    }

    @Test
    void testCase2() {
        // Given
        int[] arr = {2, 36, 1, 3};
        int divisor = 1;

        // When
        int[] solution = solution(arr, divisor);

        // Then
        int[] answer = {1, 2, 3, 36};
        Assertions.assertArrayEquals(answer, solution);
    }

    @Test
    void testCase3() {
        // Given
        int[] arr = {3,2,6};
        int divisor = 10;

        // When
        int[] solution = solution(arr, divisor);

        // Then
        int[] answer = {-1};
        Assertions.assertArrayEquals(answer, solution);
    }

    /**
     * array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수,
     * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
     */
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answerList = new ArrayList<>();

        for (int number : arr) {
            if (number % divisor == 0) {
                answerList.add(number);
            }
        }

        if (answerList.size() == 0) {
            answerList.add(-1);
        }

        return answerList.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }

    public int[] bestSolution(int[] array, int divisor) {
        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
    }

}
