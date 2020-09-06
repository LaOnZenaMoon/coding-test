package lozm.algotest3;

public class HeapSort {

    public static void main(String[] args) {
        int nodeNumber = 10;
        int[] data = new int[nodeNumber];
        for (int i = 0; i < nodeNumber; i++) {
            data[i] = (int) (Math.random() * 100);
        }

        System.out.print("정렬 전 : ");
        for (int i = 0; i < nodeNumber; i++) {
            System.out.print(data[i] + " ");
        }

        heapify(data, nodeNumber);

        for (int i = nodeNumber-1; i > 0; i--) {
            //Swap
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            heapify(data, i);
        }


        System.out.print("\n정렬 후 : ");
        for (int i = 0; i < nodeNumber; i++) {
            System.out.print(data[i] + " ");
        }

    }

    public static void heapify(int[] data, int nodeNumber) {
        for (int i = 1; i < nodeNumber; i++) {
            int child = i;

            while(child > 0) {
                int parent = (child - 1) / 2;

                if(data[child] > data[parent]) {
                    //Swap
                    int temp = data[child];
                    data[child] = data[parent];
                    data[parent] = temp;
                }

                child = parent;
            }
        }
    }

}
