package lozm.algotest;

public class HeapSort {

    public static void main(String[] args) {
        int nodeNumber = 20;
        int[] data = new int[nodeNumber];
        for (int i = 0; i < nodeNumber; i++) {
            data[i] = (int) (Math.random() * 100);
        }

        System.out.println("정렬 전: ============================");

        for (int item : data) {
            System.out.println("item = " + item);
        }

        System.out.println("정렬 후: ============================");

        int[] perform = perform(data);

        for (int item : perform) {
            System.out.println("item = " + item);
        }
    }

    private static int[] perform(int[] data) {
        heapify(data, data.length);

        for (int i = data.length-1; i > 0; i--) {
            //Swap
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            heapify(data, i);
        }

        return data;
    }

    private static void heapify(int[] data, int nodeNumber) {
        for (int i = 1; i < nodeNumber; i++) {
            int child = i;

            while (child > 0) {
                int parent = (child-1)/2;

                if(data[child] > data[child]) {
                    //Swap
                    int temp = data[parent];
                    data[parent] = data[child];
                    data[child] = temp;
                }

                child = parent;
            }
        }
    }
}
