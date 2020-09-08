package lozm.algotest6;

public class Queue {

    private LinkedList instance;

    public Queue() {
        this.instance = new LinkedList();
    }

    public void enqueue(Object input) {
        this.instance.insertNodeAt(instance.getSize(), input);
    }

    public LinkedList.Node dequeue() {
        return this.instance.removeNodeAt(0);
    }

}
