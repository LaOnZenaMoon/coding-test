package lozm.dataStructure;

public class SinglyLinkedList {

    private final String HEAD = "HEAD";
    private final String TAIL = "TAIL";

    class Node {
        private Object data;
        private Node nextNode;

        public Node(Object input) {
            this.data = input;
            this.nextNode = null;
        }
    }

    private int size;
    private Node headNode;
    private Node tailNode;

    public SinglyLinkedList() {
        this.headNode = new Node(HEAD);
        this.tailNode = new Node(TAIL);
        headNode.nextNode = tailNode;
    }

    public void insertNodeAt(Object input, int index) {
        Node prevNode = getNodeAt(index - 1);
        Node newNode = new Node(input);
        Node nextNode = prevNode.nextNode;

        prevNode.nextNode = newNode;
        newNode.nextNode = nextNode;
        
        size++;
    }

    public Node removeNodeAt(int index) {
        Node prevNode = getNodeAt(index-1);
        Node removeNode = prevNode.nextNode;
        Node nextNode = removeNode.nextNode;

        prevNode.nextNode = nextNode;

        size--;

        return removeNode;
    }

    public void printAll() {
        Node currentNode = this.headNode;
        while(!currentNode.nextNode.data.equals(TAIL)) {
            currentNode = currentNode.nextNode;
            System.out.println("currentNode = " + currentNode);
        }
    }

    public int getSize() {
        return this.size;
    }

    public Node getNodeAt(int index) {
        Node returnNode = this.headNode;

        for (int i = 0; i < index; i++) {
            returnNode = returnNode.nextNode;
        }

        return returnNode;
    }

}
