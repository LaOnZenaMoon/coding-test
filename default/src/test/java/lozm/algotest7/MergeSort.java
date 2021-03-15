package lozm.algotest7;

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

    private static void mergeSort(int[] data, int start, int end) {
        if(start < end) {
            int middle = (start + end) / 2;
            mergeSort(data, start, middle);
            mergeSort(data, middle+1, end);
            merge(data, start, middle, end);
        }
    }

    private static void merge(int[] data, int start, int middle, int end) {
        int left = start;
        int right = middle + 1;
        int index = start;

        while (left <= middle && right <= end) {
            if(data[left] <= data[right]) {
                sorted[index++] = data[left++];
            } else {
                sorted[index++] = data[right++];
            }
        }

        while (left <= middle) {
            sorted[index++] = data[left++];
        }

        while (right <= end) {
            sorted[index++] = data[right++];
        }

        for (int i = start; i <= end; i++) {
            data[i] = sorted[i];
        }
    }

}