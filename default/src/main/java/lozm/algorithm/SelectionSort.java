package lozm.algorithm;

public class SelectionSort {

    public static int[] perform(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = 0, min = 999999999, temp = 0;

            for (int j = i; j < array.length; j++) {
                if(min > array[j]) {
                    index = j;
                    min = array[j];
                }
            }

            //Swap
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
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
