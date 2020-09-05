package lozm.algotest2;

public class Queue {

    private LinkedList instance;

    public Queue() {
        this.instance = new LinkedList();
    }

    public void enqueue(Object input) {
        this.instance.insertNodeAt(input, this.instance.getSize());
    }

    public LinkedList.Node dequeue() {
        return this.instance.removeNodeAt(0);
    }

}
