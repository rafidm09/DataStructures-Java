package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.SNode;

public class SLL {
    public SNode head;
    public SNode tail;
    private int size;

    // Default constructor with no arguments
    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Overload constructor with a Node object argument to use as head
    public SLL(SNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    // Insert node object at head of the list
    public void insertHead(SNode node) {
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
        size++;
    }

    // Insert node object at the tail of the list
    public void insertTail(SNode node) {
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
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
            SNode current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    // Inserts node object in its proper position in a sorted list
    public void sortedInsert(SNode node) {
        if (isEmpty() || node.getData() < head.getData()) {
            insertHead(node);
        } else if (node.getData() >= tail.getData()) {
            insertTail(node);
        } else {
            SNode current = head;
            while (current.getNext() != null && current.getNext().getData() < node.getData()) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    // Looks up node in the list
    public SNode search(SNode node) {
        SNode current = head;
        while (current != null && current != node) {
            current = current.getNext();
        }
        return current;
    }

    // Delete head node
    public void deleteHead() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        this.head = this.head.getNext();
        size--;
        if (isEmpty()) {
            this.tail = null;
        }
    }

    // Delete tail node
    public void deleteTail() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            SNode current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            current.setNext(null);
            this.tail = current;
        }
        size--;
    }

    // Deletes the node if found in the list
    public void delete(SNode node) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");

        } else if (node == head) {
            deleteHead();
        } else if (node == tail) {
            deleteTail();
        } else {
            SNode current = head;
            while (current.getNext() != node) {
                current = current.getNext();
            }
            current.setNext(node.getNext());
            size--;
        }
    }

    // Returns whether the list is empty or not
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the size of the list
    public int size() {
        return size;
    }

    // Prints the elements of the list
    public void printList() {
        SNode current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}