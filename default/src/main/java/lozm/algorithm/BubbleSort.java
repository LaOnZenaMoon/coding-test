package lozm.algorithm;

public class BubbleSort {

    public static int[] perform(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = 0;

            for (int j = 0; j < (array.length-1) - i; j++) {
                if(array[j] > array[j+1]) {
                    //Swap
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
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
