package lozm.algotest6;

public class LinkedList {

    class Node {
        private Object data;
        private Node nextNode;

        public Node(Object input) {
            this.data = input;
            this.nextNode = null;
        }
    }

    private Node headNode;
    private Node tailNode;
    private int size;

    public LinkedList() {
        this.headNode = new Node("HEAD");
        this.tailNode = new Node("TAIL");
        headNode.nextNode = tailNode;
        size = 0;
    }

    public Node getNodeAt(int index) {
        Node node = this.headNode;

        for (int i = 0; i < index+1; i++) {
            node = this.headNode.nextNode;
        }

        return node;
    }

    public void insertNodeAt(int index, Object input) {
        Node prevNode = getNodeAt(index - 1);
        Node newNode = new Node(input);
        Node nextNode = prevNode.nextNode;

        prevNode.nextNode = newNode;
        newNode.nextNode = nextNode;

        size++;
    }

    public Node removeNodeAt(int index) {
        Node prevNode = getNodeAt(index - 1);
        Node removeNode = prevNode.nextNode;
        Node nextNode = removeNode.nextNode;

        prevNode.nextNode = nextNode;

        size--;

        return removeNode;
    }

    public int getSize() {
        return this.size;
    }

    public void printAll() {
        Node headNode = this.headNode;
        while (!headNode.nextNode.data.equals("TAIL")) {
            Node nextNode = headNode.nextNode;
            System.out.println("nextNode = " + nextNode);
        }
    }

}
