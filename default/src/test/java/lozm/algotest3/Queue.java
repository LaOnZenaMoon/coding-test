package lozm.algotest3;

public class Queue {

    private LinkedList instance;

    public Queue() {
        this.instance = new LinkedList();
    }

    public void enqueue(Object input) {
        this.instance.insertNodeAt(instance.getSize(), input);
    }

    public void dequeue() {
        this.instance.removeNodeAt(0);
    }

}
