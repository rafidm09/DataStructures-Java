package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class QueueLL extends SLL {

    // Default constructor with no arguments
    public QueueLL() {
        super();
    }

    // Overload constructor with a Node object argument to use as head
    public QueueLL(SNode head) {
        super(head);
    }

    // Inserts node object at the tail of the list (same as enqueue in queue)
    public void enqueue(SNode node) {
        super.insertTail(node);
    }

    // Deletes the head node (same as dequeue in queue)
    public void dequeue() {
        super.deleteHead();
    }

    // Returns the head node without deleting it
    public SNode peek() {
        return super.head;
    }

    // Override the insertHead method to have empty body as it does not apply to Queue behavior
    @Override
    public void insertHead(SNode node) {
        // do nothing
    }

    // Override the insert method to have empty body as it does not apply to Queue behavior
    @Override
    public void insert(SNode node, int position) {
        // do nothing
    }

    // Override the sortedInsert method to have empty body as it does not apply to Queue behavior
    @Override
    public void sortedInsert(SNode node) {
        // do nothing
    }
}
