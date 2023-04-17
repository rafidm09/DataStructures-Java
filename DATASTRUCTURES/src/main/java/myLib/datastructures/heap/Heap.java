package main.java.myLib.datastructures.heap;

import java.util.Vector;

public abstract class Heap {
    protected Vector<Integer> elements;

    public Heap(int[] array) {
        this.elements = new Vector<Integer>();
    }

    public Heap(int size) {
        this.elements = new Vector<Integer>(size);
    }

    public abstract void insert(Integer key);

    public abstract void delete(Integer key);

    protected int parent(int i) {
        return (i - 1) / 2;
    }

    protected int left(int i) {
        return 2 * i + 1;
    }

    protected int right(int i) {
        return 2 * i + 2;
    }

    protected void swap(int x, int y) {
        Integer temp = elements.get(x);
        elements.set(x, elements.get(y));
        elements.set(y, temp);
    }

    protected void heapifyDown(int i) {
        int leftIndex = left(i);
        int rightIndex = right(i);
        int largest = i;
        if (leftIndex < elements.size() && elements.get(leftIndex) > elements.get(largest)) {
            largest = leftIndex;
        }
        if (rightIndex < elements.size() && elements.get(rightIndex) > elements.get(largest)) {
            largest = rightIndex;
        }
        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    protected void heapifyUp(int i) {
        while (i > 0 && elements.get(i) > elements.get(parent(i))) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    protected Vector<Integer> heapify(int[] array) {
        Vector<Integer> heap = new Vector<Integer>(array.length);
        for (int i = 0; i < array.length; i++) {
            heap.add(array[i]);
        }
        for (int i = (heap.size() - 1) / 2; i >= 0; i--) {
            heapifyDown(i);
        }
        return heap;
    }

    public int getSize() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void clear() {
        elements.clear();
    }

    public boolean contains(Integer i) {
        return elements.contains(i);
    }

    public void print() {
        for (int i = 0; i < elements.size(); i++) {
            System.out.print(parent(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < elements.size(); i++) {
            System.out.print(elements.get(i) + " ");
        }
        System.out.println();
    }
}
