package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.DNode;

public class DLL {
    private DNode head;
    private DNode tail;
    private int size;
    private boolean sorted;

    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.sorted = true;
    }

    public DLL(DNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
        this.sorted = true;

        DNode current = head;
        DNode previous = null;
        while (current != null) {
            current.setPrev(previous);
            previous = current;
            current = current.getNext();
        }
    }

    public DNode getHead() { return this.head; }


    public DNode getTail() {
        if (head == null) {
            return null;
        }

        DNode tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }

        return tail;
    }

    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        this.sorted = false;
        size++;
    }

    public void insertTail(DNode node) {
        if(tail == null) {
            head = node;
            tail = node;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
        this.sorted = false;
        size++;
    }

    public void insert(DNode node, int position) {
        if(position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        } else if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            DNode current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            node.setPrev(current);
            current.getNext().setPrev(node);
            current.setNext(node);
            size++;
            this.sorted = false;
        }
    }

    public void sort() {
        if (!sorted) {
            DNode curr = head;
            while (curr != null) {
                DNode next = curr.getNext();
                while (next != null) {
                    if (curr.getData() > next.getData()) {
                        int temp = curr.getData();
                        curr.setData(next.getData());
                        next.setData(temp);
                    }
                    next = next.getNext();
                }
                curr = curr.getNext();
            }
            sorted = true;
        }
    }

    public void sortedInsert(DNode node) {
        if (head == null) {
            this.head = node;
            this.tail = node;
            size++;
            this.sorted = true;
            return;
        }
        if (!sorted) {
            sort();
        }
        DNode prev = null;
        DNode curr = head;
        while (curr != null && node.getData() > curr.getData()) {
            prev = curr;
            curr = curr.getNext();
        }
        if (prev == null) {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        } else if (curr == null) {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        } else {
            prev.setNext(node);
            node.setPrev(prev);
            node.setNext(curr);
            curr.setPrev(node);
        }
        size++;
        this.sorted = true;
    }

    public DNode search(DNode node) {
        DNode current = head;

        while (current != null) {
            if (current.getData() == node.getData()) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void deleteHead() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        size--;
    }

    public void deleteTail() {
        if (tail == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        size--;
    }

    public void delete(DNode node) {
        if (head == null) {
            System.out.println("The list is empty.");
            System.out.println();
            return;
        }
        if (node.equals(head)) {
            deleteHead();
            return;
        }
        if (node.equals(tail)) {
            deleteTail();
            return;
        }
        DNode prev = node.getPrev();
        DNode next = node.getNext();

        prev.setNext(next);
        next.setPrev(prev);

        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
        sorted = true;
    }

    public void print() {
        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("List length: " + size);
            System.out.println("Sorted Status: " + (sorted ? "sorted" : "not sorted"));
            System.out.print("List content: ");
            DNode curr = head;
            while (curr != null) {
                System.out.print(curr.getData() + " ");
                curr = curr.getNext();
            }
            System.out.println();
        }
    }
}