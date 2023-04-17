package main.java.myLib.datastructures.heap;

public class MaxH extends Heap {
    private int[] array;

    // Constructor that creates an empty MaxHeap
    public MaxH() {
        super(0);
    }

    // Constructor that creates a MaxHeap of a specified size
    public MaxH(int size) {
        super(size);
        this.array = new int[size];
    }

    // Constructor that creates a MaxHeap from an array
    public MaxH(int[] array) {
        super(array);
        this.array = array;
        buildMaxHeap();
    }

    // MaxHeapify the subtree rooted at index i
    protected void maxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < getSize() && array[l] > array[largest]) {
            largest = l;
        }
        if (r < getSize() && array[r] > array[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    // Build a MaxHeap from the current vector elements
    protected void buildMaxHeap() {
        for (int i = getSize() / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    // Insert a key into the MaxHeap
    public void insert(Integer key) {
        elements.add(key);
        array[getSize() - 1] = key;
        int i = getSize() - 1;
        while (i > 0 && elements.get(parent(i)) < elements.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Delete a key from the MaxHeap
    public void delete(Integer key) {
        int i = elements.indexOf(key);
        if (i == -1) {
            return;
        }
        int lastIdx = getSize() - 1;
        swap(i, lastIdx);
        elements.remove(lastIdx);
        array[lastIdx] = 0;
        maxHeapify(i);
    }
}
