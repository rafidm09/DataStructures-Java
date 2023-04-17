package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class CSLL {
    private SNode head;
    private int size;

    // Default constructor with no arguments
    public CSLL() {
        this.head = null;
        this.size = 0;
    }

    // Overload constructor with a Node object argument to use as head
    public CSLL(SNode node) {
        this.head = node;
        this.head.setNext(this.head);
        this.size = 1;
    }

    // Returns true if the list is empty
    public boolean isEmpty() {
        return this.head == null;
    }

    // Returns the size of the list
    public int size() {
        return this.size;
    }

    // Insert node object at the head of the list
    public void insertHead(SNode node) {
        if (isEmpty()) {
            this.head = node;
            this.head.setNext(this.head);
        } else {
            node.setNext(this.head);
            SNode current = this.head;
            while (current.getNext() != this.head) {
                current = current.getNext();
            }
            current.setNext(node);
            this.head = node;
        }
        size++;
    }

    // Insert node object at the tail of the list
    public void insertTail(SNode node) {
        if (isEmpty()) {
            this.head = node;
            this.head.setNext(this.head);
        } else {
            SNode current = this.head;
            while (current.getNext() != this.head) {
                current = current.getNext();
            }
            current.setNext(node);
            node.setNext(this.head);
        }
        size++;
    }

    // Insert node object in the specified position
    public void insert(SNode node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            SNode current = this.head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    // Looks up node in the list
    public SNode search(SNode node) {
        SNode current = this.head;
        int count = 0;
        while (current != null && count < size) {
            if (current == node) {
                return current;
            }
            current = current.getNext();
            count++;
        }
        return null;
    }

    // Delete head node
    public void deleteHead() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        SNode current = this.head;
        while (current.getNext() != this.head) {
            current = current.getNext();
        }
        current.setNext(this.head.getNext());
        this.head = this.head.getNext();
        size--;
    }

    // Delete tail node
    public void deleteTail() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        SNode current = this.head;
        SNode previous = null;
        while (current.getNext() != this.head) {
            previous = current;
            current = current.getNext();
        }
        if (previous != null) {
            previous.setNext(this.head);
        } else {
            this.head = null;
        }
        size--;
    }

    // Delete node in the specified position
    public void delete(int position) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            deleteHead();
        } else if (position == size - 1) {
            deleteTail();
        } else {
            SNode current = this.head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            size--;
        }
    }

    // Returns the first node in the list
    public SNode getHead() {
        return this.head;
    }

    // Returns the last node in the list
    public SNode getTail() {
        if (isEmpty()) {
            return null;
        }
        SNode current = this.head;
        while (current.getNext() != this.head) {
            current = current.getNext();
        }
        return current;
    }

    // Prints out all the elements in the list
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            SNode current = this.head;
            while (current.getNext() != this.head) {
                System.out.print(current.getData() + " -> ");
                current = current.getNext();
            }
            System.out.println(current.getData());
        }
    }

    // Test the implementation
    public static void main(String[] args) {
        CSLL list = new CSLL();
        list.insertTail(new SNode(1));
        list.insertTail(new SNode(2));
        list.insertTail(new SNode(3));
        list.printList();
        list.deleteTail();
        list.printList();
        list.delete(1);
        list.printList();
    }
}
