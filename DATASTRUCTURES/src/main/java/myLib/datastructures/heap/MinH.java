package main.java.myLib.datastructures.heap;

public class MinH extends Heap {
    // Constructor that creates an empty MinHeap
    public MinH() {
        super(0);
    }

    // Constructor that creates a MinHeap of a specified size
    public MinH(int size) {
        super(size);
    }

    // Constructor that creates a MinHeap from an array
    public MinH(int[] array) {
        super(array);
        buildMinHeap();
    }

    // MinHeapify the subtree rooted at index i
    protected void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < getSize() && elements.get(l) < elements.get(smallest)) {
            smallest = l;
        }
        if (r < getSize() && elements.get(r) < elements.get(smallest)) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    // Build a MinHeap from the current vector elements
    protected void buildMinHeap() {
        for (int i = getSize() / 2 - 1; i >= 0; i--) {
            minHeapify(i);
        }
    }

    // Insert a key into the MinHeap
    public void insert(Integer key) {
        elements.add(key);
        int i = getSize() - 1;
        while (i > 0 && elements.get(parent(i)) > elements.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Delete a key from the MinHeap
    public void delete(Integer key) {
        int i = elements.indexOf(key);
        if (i == -1) {
            return;
        }
        int lastIdx = getSize() - 1;
        swap(i, lastIdx);
        elements.remove(lastIdx);
        minHeapify(i);
    }
}
