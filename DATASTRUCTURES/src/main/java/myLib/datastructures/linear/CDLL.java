package main.java.myLib.datastructures.linear;

import main.java.myLib.datastructures.nodes.DNode;

public class CDLL extends DLL {
    private DNode head;
    private DNode tail;
    private int size;
    private boolean sorted;

    public CDLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.sorted = true;
    }

    public CDLL(DNode head) {
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
        if (tail != null) {
            tail.setNext(head);
            head.setPrev(tail);
        }
    }


    public DNode getHead() {return this.head;}
    public DNode getTail() {return this.tail;}
    public int getSize() {return this.size;}


    @Override
    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            node.setNext(head);
            node.setPrev(tail);
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
            head.setPrev(tail);
            tail.setNext(head);
        }
        this.sorted = false;
        size++;
    }


    @Override
    public void insertTail(DNode node) {
        if(tail == null) {
            head = node;
            tail = node;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
        tail.setNext(head);
        head.setPrev(tail);

        this.sorted = false;
        size++;
    }

    @Override
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
        tail.setNext(head);
        head.setPrev(tail);
    }

    @Override
    public void sort() {
        if (!sorted) {
            DNode curr = head;
            do {
                DNode next = curr.getNext();
                while (next != head) {
                    if (curr.getData() > next.getData()) {
                        int temp = curr.getData();
                        curr.setData(next.getData());
                        next.setData(temp);
                    }
                    next = next.getNext();
                }
                curr = curr.getNext();
            } while (curr != head);
            sorted = true;
        }
    }

    @Override
    public void sortedInsert(DNode node) {
        if (head == null) {
            this.head = node;
            this.tail = node;
            size++;
            this.sorted = true;
            head.setPrev(tail);
            tail.setNext(head);
            return;
        }
        if (!sorted) {
            sort();
        }
        DNode prev = null;
        DNode curr = head;
        while (curr != tail && node.getData() > curr.getData()) {
            prev = curr;
            curr = curr.getNext();
        }
        if (prev == null && node.getData() <= head.getData()) { // new head
            node.setNext(head);
            head.setPrev(node);
            head = node;
            tail.setNext(head); // update tail pointer
        } else if (curr == tail && node.getData() > tail.getData()) { // new tail
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
            head.setPrev(tail); // update head pointer
        } else { // insert in the middle
            prev.setNext(node);
            node.setPrev(prev);
            node.setNext(curr);
            curr.setPrev(node);
        }
        size++;
        this.sorted = true;
    }

    @Override
    public DNode search(DNode node) {
        DNode current = head;
        do {
            if (current.getData() == node.getData()) {
                return current;
            }
            current = current.getNext();
        } while (current != head);

        return null;
    }

    @Override
    public void deleteHead() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(tail);
            tail.setNext(head);
        }
        size--;
    }

    @Override
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
            head.setPrev(tail); // update head's prev to tail since it's circular
        }
        size--;
    }

    @Override
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

    @Override
    public void clear() {
        if (head == null) {
            return;
        }

        tail.setNext(null);
        head.setPrev(null);

        head = null;
        tail = null;
        size = 0;
        sorted = true;
    }

    @Override
    public void print() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        } else {
            System.out.println("List length: " + size);
            System.out.println("Sorted Status: " + (sorted ? "sorted" : "not sorted"));
            System.out.print("List content: ");
            DNode curr = head;
            do {
                System.out.print(curr.getData() + " ");
                curr = curr.getNext();
            } while (curr != head && curr != null);

            System.out.println();
        }
    }


}