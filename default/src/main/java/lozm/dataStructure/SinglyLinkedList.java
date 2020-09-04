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

    public String printAll() {
        if(head == null) return "[]";

        Node node = this.head;
        String str = "[";

        while (node.nextNode != null) {
            str += node.data + ", ";
            node = node.nextNode;
        }

        str += node.data;
        return str + "]";
    }

    public Object removeFirst() {
        Node removeNode = this.head;
        head = removeNode.nextNode;

        Object removeNodeData = removeNode.data;
        removeNode = null;
        size--;

        return removeNodeData;
    }

    public Object removeNodeAt(int index) {
        if(index == 0) removeFirst();

        Node preNode = findNodeUsingIndex(index - 1);
        Node targetNode = preNode.nextNode;

        Node nextNode = preNode.nextNode.nextNode;
        preNode.nextNode = nextNode;

        Object removeNodeData = targetNode.data;
        if(targetNode == tail) tail = preNode;

        targetNode = null;
        size--;

        return removeNodeData;
    }

    public Object getNodeAt(int index) {
        return findNodeUsingIndex(index).data;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst("test1");
        list.addFirst("test2");
        list.addFirst("test3");

        System.out.println("list = " + list);
    }

}
