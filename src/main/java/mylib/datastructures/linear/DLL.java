package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class DLL {
    private DNode head;
    private DNode tail;
    private int size;

    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DLL(int data) {
        DNode node = new DNode(data);
        this.head = node;
        this.tail = node;
        this.size = 1;
    }


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
    }

    public void InsertTail(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

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
        }
    }

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
    }

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
    }

    public void Delete(DNode node) {
        if (head == null) {
            return;
        }
        if (head.equals(node)) {
            DeleteHead();
            return;
        }
        if (tail.equals(node)) {
            DeleteTail();
            return;
        }
        DNode current = head;
        while (current.getNext() != null && !current.getNext().equals(node)) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            return;
        }
        current.setNext(current.getNext().getNext());
        current.getNext().setPrev(current);
        size--;
    }
    public void SortedInsert(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        if (node.getData() <= head.getData()) {
            node.setNext(head);
            head.setPrev(node);
            head = node;
            size++;
            return;
        }
        DNode curr = head.getNext();
        while (curr != null && node.getData() > curr.getData()) {
            curr = curr.getNext();
        }
        if (curr == null) {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        } else {
            node.setPrev(curr.getPrev());
            node.setNext(curr);
            curr.getPrev().setNext(node);
            curr.setPrev(node);
        }
        size++;
    }

    public DNode Search(DNode node) {
        DNode curr = head;
        while (curr != null) {
            if (curr.getData() == node.getData()) {
                return curr;
            }
            curr = curr.getNext();
        }
        return null;
    }

    public void Sort() {
        if (head == null || head.getNext() == null) {
            return;
        }
        DNode curr = head.getNext();
        while (curr != null) {
            DNode key = curr;
            DNode j = curr.getPrev();
            while (j != null && j.getData() > key.getData()) {
                j.getNext().setData(j.getData());
                j = j.getPrev();
            }
            key.setData(key.getData());
            curr = curr.getNext();
        }
    }

    public void Clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void Print() {
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + isSorted());
        System.out.print("List content: ");
        DNode curr = head;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    public boolean isSorted() {
        if (head == null || head.getNext() == null) {
            return true;
        }
        DNode curr = head.getNext();
        while (curr != null) {
            if (curr.getData() < curr.getPrev().getData()) {
                return false;
            }
            curr = curr.getNext();
        }
        return true;
    }

}
