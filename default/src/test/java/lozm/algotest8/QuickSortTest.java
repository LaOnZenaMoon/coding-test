package lozm.algotest8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSortTest {

    @Test
    public void testCase() {
        // Given
        int[] sourceArray = {2, 4, 1, 3, 4, 5, 7, 8, 1};

        // When
        quickSort(sourceArray, 0, sourceArray.length - 1);

        // Then
        int[] answerArray = {1, 1, 2, 3, 4, 4, 5, 7, 8};
        Assertions.assertArrayEquals(answerArray, sourceArray);
    }

    private void quickSort(int[] sourceArray, int start, int end) {
        if (start < end) {
            int middle = partition(sourceArray, start, end);
            quickSort(sourceArray, start, middle - 1);
            quickSort(sourceArray, middle, end);
        }
    }

    private int partition(int[] sourceArray, int start, int end) {
        int pivot = sourceArray[(start + end) / 2];

        while (start <= end) {
            while (sourceArray[start] < pivot) start++;
            while (pivot < sourceArray[end]) end--;

            if (start <= end) {
                // swap
                int temp = sourceArray[start];
                sourceArray[start] = sourceArray[end];
                sourceArray[end] = temp;

                start++;
                end--;
            }
        }

        return start;
    }


}
