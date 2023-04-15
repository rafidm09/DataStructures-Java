package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {
    private DNode head;
    private DNode tail;
    private int size;

    public CDLL() {
        super();
        head = tail = null;
        this.size = 0;
    }

    public CDLL(int data) {
        super(data);
        if (head == null) {
            head = new DNode(data);
            tail = head;
            head.setNext(head);
            head.setPrev(tail);
        }
        head.setPrev(tail);
        tail.setNext(head);
        this.size = 1;
    }

    @Override
    public void InsertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        size++;
        head.setPrev(tail);
        tail.setNext(head);
    }

    @Override
    public void InsertTail(DNode node) {
        if (head == null) {
            head = node;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
        }
        tail = node;
        size++;
        head.setPrev(tail);
        tail.setNext(head);
    }

    @Override
    public void Insert(DNode node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        } else if (position == 0) {
            InsertHead(node);
        } else if (position == size) {
            InsertTail(node);
        } else {
            DNode current = head;
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            node.setPrev(current);
            current.getNext().setPrev(node);
            current.setNext(node);
            size++;
            head.setPrev(tail);
            tail.setNext(head);
        }
    }

    @Override
    public void DeleteHead() {
        if (head == null) {
            System.out.println("List is empty");
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
        head.setPrev(tail);
        tail.setNext(head);
    }

    @Override
    public void DeleteTail() {
        if (head == null) {
            System.out.println("List is empty");
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
        head.setPrev(tail);
        tail.setNext(head);
    }
    @Override
    public void Delete(DNode node) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        DNode current = head;
        while (current != null && current != node) {
            current = current.getNext();
        }
        if (current == null) {
            System.out.println("Node not found");
            return;
        }
        if (current == head) {
            DeleteHead();
        } else if (current == tail) {
            DeleteTail();
        } else {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            size--;
            head.setPrev(tail);
            tail.setNext(head);
        }
    }
    @Override
    public void Sort() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        DNode current = head.getNext();
        while (current != head) {
            DNode next = current.getNext();
            SortedInsert(current);
            current = next;
        }
    }

    public void SortedInsert(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            node.setNext(node);
            node.setPrev(node);
        } else if (node.getData() <= head.getData()) {
            node.setNext(head);
            node.setPrev(tail);
            head.setPrev(node);
            tail.setNext(node);
            head = node;
        } else {
            DNode current = head.getNext();
            while (current != head && node.getData() > current.getData()) {
                current = current.getNext();
            }
            node.setNext(current);
            node.setPrev(current.getPrev());
            current.getPrev().setNext(node);
            current.setPrev(node);
            if (current == head) {
                tail = node;
            }
        }
    }
    @Override
    public void Clear() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public void Print() {
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "Sorted" : "Unsorted"));
        System.out.print("List content: ");
        if (head == null) {
            System.out.println("Empty");
        } else {
            DNode current = head;
            System.out.print(current.getData());
            current = current.getNext();
            while (current != head) {
                System.out.print(" -> " + current.getData());
                current = current.getNext();
            }
            System.out.println();
        }
    }

    public boolean isSorted() {
        if (head == null) {
            return true;
        }
        DNode current = head.getNext();
        while (current != head) {
            if (current.getData() < current.getPrev().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
    public DNode Search(DNode node) {
        DNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.equals(node)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }


}