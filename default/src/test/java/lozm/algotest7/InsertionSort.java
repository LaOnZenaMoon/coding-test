package lozm.algotest7;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] data = {3,5,2,1,4,6,5,9};

        int[] perform = perform(data);

        Arrays.stream(perform)
                .asDoubleStream()
                .forEach(System.out::println);
    }

    private static int[] perform(int[] data) {
        for (int i=0; i <data.length-1; i++) {
            int index = i;

            while(data[index] > data[index+1]) {
                //Swap
                int temp = data[index];
                data[index] = data[index+1];
                data[index+1] = temp;

                if(index > 0) index--;
            }
        }

        return data;
    }

}