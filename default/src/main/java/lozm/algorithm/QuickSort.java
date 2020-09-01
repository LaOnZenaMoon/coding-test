package lozm.algorithm;

public class QuickSort {

    private static int[] perform(int[] array, int start, int end) {
        //원소가 1개인 경우
        if(start >= end) return array;

        int pivot = start;
        int i = start + 1;
        int j = end;
        int temp = 0;

        //엇갈릴 때까지 반복
        while(i <= j) {
            //기준값(pivot)보다 큰 값
            while(array[i] <= array[pivot] && i <= end) {
                i++;
            }

            //기준값(pivot)보다 작은 값
            while(array[j] >= array[pivot] && j > start) {
                j--;
            }

            //현재 엇갈린 상태면 기준값과 교체
            if(i > j) {
                //Swap
                temp = array[j];
                array[j] = array[pivot];
                array[pivot] = temp;
            } else {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        perform(array, start, j-1);
        perform(array, j+1, end);

        return array;
    }

    public static void main(String[] args) {
        int[] data = {3,5,2,1,4,6,5,9};

        int[] perform = perform(data, 0, data.length-1);

        for (int item : perform) {
            System.out.println("item = " + item);
        }
    }

}