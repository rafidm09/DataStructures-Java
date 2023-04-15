package main.java.mylib.datastructures.linear;


import main.java.mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {
    private SNode head;
    private SNode tail;
    private int size;
    public CSLL() {
        super();
        if (head != null) {
            tail.setNext(head);
        }
        size = 0;
    }

    public CSLL(SNode head) {
        super(head);
        if (this.head != null) {
            this.tail.setNext(this.head);
        }
        size = 1;
    }

    public CSLL(SNode node, int size) {
        super(node);
        this.size = size;
        SNode current = head;
        while (current.getNext() != null && size > 1) {
            current = current.getNext();
            size--;
        }
        if (size > 1) {
            throw new IllegalArgumentException("Size cannot be greater than the number of nodes in the list");
        } else if (size == 1) {
            tail = current;
            tail.setNext(head);
        } else {
            tail = current;
            tail.setNext(node);
        }
    }

    public void InsertHead(SNode node) {
        if (head == null) {
            super.InsertHead(node);
            tail = node;
            tail.setNext(head);
        } else {
            super.InsertHead(node);
            tail.setNext(head);
        }
    }

    public void InsertTail(SNode node) {
        if (head == null) {
            super.InsertTail(node);
            tail = node;
            tail.setNext(head);
        } else {
            super.InsertTail(node);
            tail.setNext(head);
        }
    }

    public void Insert(SNode node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        } else if (position == 0) {
            InsertHead(node);
        } else if (position == size) {
            InsertTail(node);
        } else {
            super.Insert(node, position);
            tail.setNext(head);
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
            tail.setNext(head);
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
            SNode temp = head;
            while (temp.getNext() != tail) {
                temp = temp.getNext();
            }
            tail = temp;
            tail.setNext(head);
        }
        size--;
    }

    public void Delete(SNode node) {
        if (head == null) {
            return;
        }
        if (head.equals(node)) {
            DeleteHead();
            return;
        }
        SNode current = head;
        while (current.getNext() != null && !current.getNext().equals(node)) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            return;
        }
        current.setNext(current.getNext().getNext());
        if (current.getNext() == null) {
            tail = current;
            tail.setNext(head);
        }
        size--;
    }
    public void SortedInsert(SNode node) {
        if (!isSorted()) {
            Sort();
        }
        if (head == null || node.getData() < head.getData()) {
            InsertHead(node);
            return;
        }
        SNode current = head.getNext();
        SNode prev = head;
        while (current != null && node.getData() > current.getData()) {
            prev = current;
            current = current.getNext();
        }
        prev.setNext(node);
        node.setNext(current);
        if (current == null) {
            tail = node;
            tail.setNext(head);
        }
        size++;
    }


    public SNode Search(SNode node) {
        if (head == null) {
            return null;
        }
        SNode current = head;
        do {
            if (current.equals(node)) {
                return current;
            }
            current = current.getNext();
        } while (current != head);
        return null;
    }

    public void Sort() {
        if (head == null || head == tail) {
            return;
        }
        SNode sorted = null;
        SNode current = head;
        while (current != null) {
            SNode next = current.getNext();
            if (sorted == null || current.getData() < sorted.getData()) {
                current.setNext(sorted);
                sorted = current;
            } else {
                SNode innerCurrent = sorted;
                while (innerCurrent.getNext() != null && current.getData() > innerCurrent.getNext().getData()) {
                    innerCurrent = innerCurrent.getNext();
                }
                current.setNext(innerCurrent.getNext());
                innerCurrent.setNext(current);
            }
            current = next;
        }
        tail = sorted;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        tail.setNext(head);
    }


    public void Clear() {
        super.Clear();
        tail = null;
    }

    @Override
    public void Print() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "sorted" : "unsorted"));
        System.out.print("List content: ");
        SNode current = head;
        do {
            System.out.print(current.toString() + " ");
            current = current.getNext();
        } while (current != head);
        System.out.println();
    }

}
