package lozm.algotest5;

public class SelectionSort {

    public static void main(String[] args) {
        int[] data = {3,5,2,1,4,6,5,9};

        int[] perform = perform(data);

        for (int item : perform) {
            System.out.println("item = " + item);
        }
    }

    private static int[] perform(int[] data) {
        for (int i = 0; i < data.length-1; i++) {
            int minIndex = 0;
            int minValue = Integer.MAX_VALUE;

            for (int j = i; j < data.length; j++) {
                if(data[j] < minValue) {
                    minIndex = j;
                    minValue = data[j];
                }
            }

            //Swap
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }

        return data;
    }

}
