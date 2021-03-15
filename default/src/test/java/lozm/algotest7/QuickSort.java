package lozm.algotest7;

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
        }
    }

}