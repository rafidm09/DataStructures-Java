package main.java.mylib.datastructures.nodes;

public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;

    // Default constructor
    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    // Overload constructor
    public TNode(int data, int balance, TNode parent, TNode left, TNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.balance = balance;
    }

    public TNode(int val) {
    this.data = val;
    }

    // Setters
    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // Getters
    public int getData() {
        return this.data;
    }

    public TNode getLeft() {
        return this.left;
    }

    public TNode getRight() {
        return this.right;
    }

    public TNode getParent() {
        return this.parent;
    }

    public int getBalance() {
        return this.balance;
    }

    // Print method
    public void print() {
        System.out.println("Data: " + this.data);
        System.out.println("Balance: " + this.balance);
        if (this.left != null) {
            System.out.println("Left Child: " + this.left.getData());
        } else {
            System.out.println("Left Child: null");
        }
        if (this.right != null) {
            System.out.println("Right Child: " + this.right.getData());
        } else {
            System.out.println("Right Child: null");
        }
        if (this.parent != null) {
            System.out.println("Parent: " + this.parent.getData());
        } else {
            System.out.println("Parent: null");
        }
    }

    // toString method
    public String toString() {
        return String.valueOf(this.data);
    }
}

