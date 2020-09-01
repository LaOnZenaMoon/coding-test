package lozm.dataStructure;

public class SingleLinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {

        private Object data;
        private Node nextNode;

        public Node(Object inputData) {
            this.data = inputData;
            this.nextNode = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + String.valueOf(data) +
                    '}';
        }
    }

    public void addNode(int index, Object input) throws Exception {
        Node newNode = new Node(input);

        if(index == 0) {

        } else {

        }
    }

    public void deleteNode(int index) {

    }

}
