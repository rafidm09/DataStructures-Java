package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class StackLL extends SLL {

    // Constructor
    public StackLL() {
        super();
    }

    // Adds a node to the top of the stack
    public void push(SNode node) {
        super.insertHead(node);
    }

    // Removes and returns the node at the top of the stack
    public SNode pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        SNode top = super.head;
        super.deleteHead();
        return top;
    }

    // Returns the node at the top of the stack without removing it
    public SNode peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return super.head;
    }

    // Override insert methods to prevent their use in a stack
    @Override
    public void insert(SNode node, int position) {}

    @Override
    public void sortedInsert(SNode node) {}

    @Override
    public void insertTail(SNode node) {}

    // Override delete methods to prevent their use in a stack
    @Override
    public void delete(SNode node) {}

    @Override
    public void deleteTail() {}
}
