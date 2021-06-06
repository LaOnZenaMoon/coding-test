package lozm.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Carpet {

    @Test
    public void testCase1() {
        // Given
        int brown = 10;
        int yellow = 2;

        // When
        final int[] solution = solution(brown, yellow);

        // Then
        int[] result = {4, 3};
        Assertions.assertArrayEquals(result, solution);
    }

    @Test
    public void testCase2() {
        // Given
        int brown = 8;
        int yellow = 1;

        // When
        final int[] solution = solution(brown, yellow);

        // Then
        int[] result = {3, 3};
        Assertions.assertArrayEquals(result, solution);
    }

    @Test
    public void testCase3() {
        // Given
        int brown = 10;
        int yellow = 2;

        // When
        final int[] solution = solution(brown, yellow);

        // Then
        int[] result = {8, 6};
        Assertions.assertArrayEquals(result, solution);
    }

    /**
     * 완전탐색 > 카펫
     * https://programmers.co.kr/learn/courses/30/lessons/42842
     *
     *
     */
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        return answer;
    }

}
