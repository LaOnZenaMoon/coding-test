package lozm.algorithm;

public class MergeSort {

    //정렬 배열은 정적 변수로 활용
    static int[] sorted;

    public static int[] merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        int leftPointer = leftIndex;
        int rightPointer = middleIndex+1;
        int k = leftIndex;

        //작은 순서대로 배열에 삽입
        while (leftPointer<=middleIndex && rightPointer<=rightIndex) {
            if(array[leftPointer] <= array[rightPointer]) {
                sorted[k] = array[leftPointer];
                leftPointer++;
            } else {
                sorted[k] = array[rightPointer];
                rightPointer++;
            }
            k++;
        }

        //남은 데이터 삽입
        if(leftPointer > middleIndex) {
            for (int l = rightPointer; l <= rightIndex; l++) {
                sorted[k] = array[l];
                k++;
            }
        } else {
            for (int l = leftPointer; l <= middleIndex; l++) {
                sorted[k] = array[l];
                k++;
            }
        }

        //정렬된 배열을 삽입
        for (int l = leftIndex; l <= rightIndex; l++) {
            array[l] = sorted[l];
        }

        return array;
    }

    public static int[] mergeSort(int[] array, int leftIndex, int rightIndex) {
        //크기가 1보다 큰 경우
        if(leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            mergeSort(array, leftIndex, middleIndex);
            mergeSort(array, middleIndex+1, rightIndex);
            merge(array, leftIndex, middleIndex, rightIndex);
        }

        return array;
    };

    public static void main(String[] args) {
        int[] data = {3,5,2,1,4,6,5,9};

        sorted = new int[data.length];

        int[] perform = mergeSort(data, 0, data.length-1);

        for (int item : perform) {
            System.out.println("item = " + item);
        }
    }

}