package lozm.algorithm;

public class HeapSort {

    public static int[] perform(int[] heap) {
        //힙을 구성
        for (int i = 1; i < heap.length; i++) {
            int c = i;
            do {
                int root = (c-1) / 2;

                if(heap[root] < heap[c]) {
                    //Swap
                    int temp = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp;
                }

                c = root;
            } while (c != 0);
        }

        //크기를 줄여가며 반복적으로 힙을 구성
        for(int i=heap.length-1; i>=0; i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            int root = 0;
            int c = 1;

            do {
                c = 2 * root + 1;

                //자식 중에 더 큰 값을 찾기
                if(c<i-1 && heap[c]<heap[c+1]) {
                    c++;
                }

                //루트보다 자식이 크다면 교환
                if(c<i && heap[root]<heap[c]) {
                    temp = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp;
                }

                root = c;
            } while (c < i);
        }

        return heap;
    }

    public static void main(String[] args) {
        int[] data = {3,5,2,1,4,6,5,9};

        int[] perform = perform(data);

        for (int item : perform) {
            System.out.println("item = " + item);
        }
    }

}
