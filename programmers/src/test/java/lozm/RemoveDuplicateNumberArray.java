package lozm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class RemoveDuplicateNumberArray {

    @Test
    void testCase1() {
        // Given
        int[] arr = {1,1,3,3,0,1,1};

        // When
        int[] solution = solution(arr);

        // Then
        int[] answer = {1,3,0,1};
        Assertions.assertArrayEquals(answer, solution);
    }

    @Test
    void testCase2() {
        // Given
        int[] arr = {4,4,4,3,3};

        // When
        int[] solution = solution(arr);

        // Then
        int[] answer = {4,3};
        Assertions.assertArrayEquals(answer, solution);
    }

    public int[] solution(int[] arr) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int number : arr) {
            if (linkedList.size() == 0 || !linkedList.getLast().equals(number)) {
                linkedList.add(number);
            }
        }

        return linkedList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
