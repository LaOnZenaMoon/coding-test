package lozm.algotest3;

public class Stack {

    private LinkedList instance;

    public Stack() {
        this.instance = new LinkedList();
    }

    public void push(Object input) {
        this.instance.insertNodeAt(instance.getSize(), input);
    }

    public LinkedList.Node pop() {
        return this.instance.removeNodeAt(instance.getSize()-1);
    }

}
