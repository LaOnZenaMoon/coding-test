package lozm.algotest;

public class BubbleSort {

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

            for (int j = 0; j < (data.length-1) - i; j++) {
                if(data[j] > data[j+1]) {
                    //Swap
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }

        return data;
    }

}
