package lozm.algotest;

public class InsertionSort {

    private static int[] perform(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int index = i;
            int temp = 0;

            while(array[index] > array[index+1]) {
                //Swap
                temp = array[index];
                array[index] = array[index+1];
                array[index+1] = temp;

                if(index > 0) index--;
            }
        }

        return array;
    }

}
