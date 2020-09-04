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

    }
}
