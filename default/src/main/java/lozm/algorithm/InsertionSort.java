package lozm.algorithm;

public class InsertionSort {

    private static int[] perform(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int j = 0, temp = 0;
            j = i;

            while(array[j] > array[j+1]) {
                //Swap
                temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;

                if(j>0) j--;
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
