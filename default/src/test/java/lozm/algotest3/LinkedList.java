package lozm.algotest3;

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
        this.headNode.nextNode = tailNode;
        this.size = 0;
    }

    public Node getNodeAt(int index) {
        Node headNode = this.headNode;

        for (int i = 0; i < index+1; i++) {
            headNode = headNode.nextNode;
        }

        return headNode;
    }

    public void insertNodeAt(int index, Object input) {
        Node prevNode = getNodeAt(index - 1);
        Node insertNode = new Node(input);
        Node nextNode = prevNode.nextNode;

        prevNode.nextNode = insertNode;
        insertNode.nextNode = nextNode;

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

    public void printAllNode() {
        Node node = this.headNode;
        while (!node.nextNode.data.equals("TAIL")) {
            Node currentNode = node.nextNode;
            System.out.println("currentNode = " + currentNode);
        }
    }

}
