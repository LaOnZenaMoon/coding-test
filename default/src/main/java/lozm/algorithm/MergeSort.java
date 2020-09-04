package lozm.algorithm;

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

    private static void mergeSort(int[] data, int left, int right) {
        if(left < right) {
            int middle = (left + right) / 2;
            mergeSort(data, left, middle);
            mergeSort(data, middle+1, right);
            merge(data, left, middle, right);
        }
    }

    private static void merge(int[] data, int left, int middle, int right) {
        int pointerLeft = left;
        int pointerRight = middle+1;
        int index = left;

        while(pointerLeft <= middle && pointerRight <= right) {
            if(data[pointerLeft] <= data[pointerRight]) {
                sorted[index++] = data[pointerLeft++];
            } else {
                sorted[index++] = data[pointerRight++];
            }
        }

        while (pointerLeft <= middle) {
            sorted[index++] = data[pointerLeft++];
        }

        while(pointerRight <= right) {
            sorted[index++] = data[pointerRight++];
        }

        for (int i = left; i <= right; i++) {
            data[i] = sorted[i];
        }
    }

}