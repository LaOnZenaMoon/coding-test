package lozm.dataStructure;

public class Stack {

    private SinglyLinkedList instance;

    public Stack() {
        instance = new SinglyLinkedList();
    }

    public void push(Object input) {
        instance.insertNodeAt(input, instance.getSize());
    }

    public SinglyLinkedList.Node pop() {
        return instance.removeNodeAt(instance.getSize()-1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("test1");
        stack.push("test2");
        stack.push("test3");

        SinglyLinkedList.Node pop1 = stack.pop();
        System.out.println("pop1 = " + pop1);
        SinglyLinkedList.Node pop2 = stack.pop();
        System.out.println("pop2 = " + pop2);
        SinglyLinkedList.Node pop3 = stack.pop();
        System.out.println("pop3 = " + pop3);
    }

}
