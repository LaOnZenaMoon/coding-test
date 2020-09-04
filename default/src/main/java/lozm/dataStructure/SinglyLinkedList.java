package lozm.dataStructure;

public class SinglyLinkedList {

    class Node {
        private Object data;
        private Node nextNode;

        public Node(Object input) {
            this.data = input;
            this.nextNode = null;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public void addFirst(Object input) {
        Node newNode = new Node(input);

        newNode.nextNode = head;
        head = newNode;

        size++;

        if(head.nextNode == null) tail = head;
    }

    public void addLast(Object input) {
        Node newNode = new Node(input);

        if(size == 0) addFirst(input);
        else {
            tail.nextNode = newNode;
            tail = newNode;

            size++;
        }

    }

    public Node findNodeUsingIndex(int index) {
        Node findNode = this.head;

        for (int i = 0; i < index; i++) {
            findNode = findNode.nextNode;
        }

        return findNode;
    }

    public void addNodeAt(Object input, int index) {
        if(index == 0) addFirst(input);
        else {
            Node preNode = findNodeUsingIndex(index-1);
            Node targetNode = preNode.nextNode;

            Node newNode = new Node(input);
            preNode.nextNode = newNode;
            newNode.nextNode = targetNode;

            size++;

            if(newNode.nextNode == null) tail = newNode;
        }
    }


    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst("test1");
        list.addFirst("test2");
        list.addFirst("test3");

        System.out.println("list = " + list);
    }

}
