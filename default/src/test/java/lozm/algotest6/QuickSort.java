package lozm.algotest6;

public class QuickSort {

    public static void main(String[] args) {
        int[] data = {3,5,2,1,4,6,5,9};

        quickSort(data, 0, data.length-1);

        for (int item : data) {
            System.out.println("item = " + item);
        }
    }

    private static void quickSort(int[] data, int start, int end) {
        if(start < end) {
            int middle = partition(data, start, end);
            quickSort(data, start, middle-1);
            quickSort(data, middle, end);
        }
    }

    private static int partition(int[] data, int start, int end) {
        int pivot = data[(start + end) / 2];

        while (start <= end) {
            while (data[start] < pivot) start++;
            while (pivot < data[end]) end--;

            if(start <= end) {
                //Swap
                int temp = data[start];
                data[start] = data[end];
                data[end] = temp;

                start++;
                end--;
            }
        }

        return start;
    }


}
