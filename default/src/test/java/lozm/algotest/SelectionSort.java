package lozm.algotest;

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
            int temp = 0;
            int minIndex = 0;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < data.length; j++) {
                if(min > data[j]) {
                    minIndex = j;
                    min = data[j];
                }
            }

            //Swap
            temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }

        return data;
    }

}
