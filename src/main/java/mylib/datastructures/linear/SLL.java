package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class SLL {
    private SNode head;
    private SNode tail;
    private int size;

    public SLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public SLL(SNode head) {
        this.head = head;
        tail = head;
        size = 1;
    }

    public void InsertHead(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public void InsertTail(SNode node) {
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public void Insert(SNode node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        } else if (position == 0) {
            InsertHead(node);
        } else if (position == size) {
            InsertTail(node);
        } else {
            SNode current = head;
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    public boolean isSorted() {
        if (head == null || head.getNext() == null) {
            return true;
        }
        SNode current = head;
        while (current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }


    public void SortedInsert(SNode node) {
        if (!isSorted()) {
            Sort();
        }
        if (head == null || node.getData() <= head.getData()) {
            InsertHead(node);
        } else if (node.getData() >= tail.getData()) {
            InsertTail(node);
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

    public SNode Search(SNode node) {
        SNode current = head;
        while (current != null) {
            if (current.getData() == node.getData()) {
                return current;
            }
            current = current.getNext();
        }
        return null;
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
            tail.setNext(null);
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
        }
        size--;
    }
    public void Sort() {
        if (head == null || head.getNext() == null) {
            // the list is already sorted, or it has only one element
            return;
        }

        SNode sortedList = null;
        SNode current = head;
        while (current != null) {
            SNode nextNode = current.getNext();
            if (sortedList == null || current.getData() <= sortedList.getData()) {
                // insert current node at the beginning of the sorted list
                current.setNext(sortedList);
                sortedList = current;
            } else {
                // find the position where the current node belongs in the sorted list
                SNode temp = sortedList;
                while (temp.getNext() != null && current.getData() > temp.getNext().getData()) {
                    temp = temp.getNext();
                }
                // insert current node after temp node
                current.setNext(temp.getNext());
                temp.setNext(current);
            }
            current = nextNode;
        }

        // update head and tail references
        head = sortedList;
        SNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        tail = temp;
    }

    public void Clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void Print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // print list length
        System.out.println("List length: " + size);

        // print sorted status
        if (isSorted()) {
            System.out.println("List is sorted");
        } else {
            System.out.println("List is not sorted");
        }

        // print list content
        System.out.print("List content: ");
        SNode current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

}