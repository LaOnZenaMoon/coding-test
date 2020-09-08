package lozm.algotest6;

public class SelectionSort {

    public static void main(String[] args) {
        int[] data = {3,5,2,1,4,6,5,9};

        int[] perform = perform(data);

        for (int item : perform) {
            System.out.println("item = " + item);
        }
    }

    private static int[] perform(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = 0;
            int minValue = Integer.MAX_VALUE;

            for (int j = i; j < data.length; j++) {
                if(minValue > data[j]) {
                    minIndex = j;
                    minValue = data[j];
                }
            }

            //Swap
            int temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }

        return data;
    }

}
