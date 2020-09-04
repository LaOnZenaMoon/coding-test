package lozm.algotest;

public class MergeSort {

    //정렬 배열은 정적 변수로 활용
    static int[] sorted;

    public static void main(String[] args) {
        int[] data = {3,5,2,1,4,6,5,9};

        sorted = new int[data.length];

        mergeSort(data, 0, data.length-1);

        for (int item : data) {
            System.out.println("item = " + item);
        }
    }

    private static void mergeSort(int[] data, int leftIndex, int rightIndex) {
        if(leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            mergeSort(data, leftIndex, middleIndex);
            mergeSort(data, middleIndex+1, rightIndex);
            merge(data, leftIndex, middleIndex, rightIndex);
        }
    }

    private static void merge(int[] data, int leftIndex, int middleIndex, int rightIndex) {
        int leftPointer = leftIndex;
        int rightPointer = middleIndex+1;
        int tempIndex = leftIndex;

        while(leftPointer <= middleIndex && rightPointer <= rightIndex) {
            if(data[leftPointer] <= data[rightPointer]) {
                sorted[tempIndex++] = data[leftPointer++];
            } else {
                sorted[tempIndex++] = data[rightPointer++];
            }
        }

        while(leftPointer <= middleIndex) {
            sorted[tempIndex++] = data[leftPointer++];
        }

        while(rightPointer <= rightIndex) {
            sorted[tempIndex++] = data[rightPointer++];
        }

        for (int i = leftIndex; i <= rightIndex; i++) {
            data[i] = sorted[i];
        }
    }

}
