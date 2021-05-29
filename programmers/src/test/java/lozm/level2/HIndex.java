package lozm.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class HIndex {

    @Test
    public void testCase1() {
        // Given
        int[] citations = {3, 0, 6, 1, 5};

        // When
        final int solution = solution(citations);

        // Then
        Assertions.assertEquals(3, solution);
    }

    @Test
    public void testCase2() {
        // Given
        int[] citations = {0, 0, 0, 0};

        // When
        final int solution = solution(citations);

        // Then
        Assertions.assertEquals(0, solution);
    }

    @Test
    public void testCase3() {
        // Given
        int[] citations = {10, 4, 10, 5};

        // When
        final int solution = solution(citations);

        // Then
        Assertions.assertEquals(4, solution);
    }

    /**
     * H-Index
     * https://programmers.co.kr/learn/courses/30/lessons/42747
     * <p>
     * 1. 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상 이고
     * 2. 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index
     */
    public int solution(int[] citations) {
        Integer[] citationArray = Arrays.stream(citations)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(citationArray, Comparator.reverseOrder());

        int hIndex = citationArray[0];
        while (hIndex >= 0) {
            int bigger = 0;
            int smaller = 0;

            for (Integer target : citationArray) {
                if (target >= hIndex) {
                    bigger++;
                    continue;
                }
                smaller++;
            }

            if (bigger >= hIndex && hIndex >= smaller) {
                return hIndex;
            }

            hIndex--;
        }

        return hIndex;
    }

    public int solution1(int[] citations) {
        Integer[] citationArray = Arrays.stream(citations)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(citationArray, Comparator.reverseOrder());

        for (Integer source : citationArray) {
            int bigger = 0;
            int smaller = 0;

            for (Integer target : citationArray) {
                if (target >= source) {
                    bigger++;
                    continue;
                }
                smaller++;
            }

            if (bigger >= source && source >= smaller) {
                return source;
            }
        }

        return 0;
    }

}
