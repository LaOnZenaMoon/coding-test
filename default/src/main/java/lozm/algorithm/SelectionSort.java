package lozm.algorithm;

public class SelectionSort {

    public static int[] perform(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = 0;
            int minIndex = 0;
            int min = Integer.MAX_VALUE;

            for (int j = i; j < array.length; j++) {
                if(min > array[j]) {
                    minIndex = j;
                    min = array[j];
                }
            }

            //Swap
            temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] data = {3,5,2,1,4,6,5,9};

        int[] perform = perform(data);

        for (int item : perform) {
            System.out.println("item = " + item);
        }
    }

}
