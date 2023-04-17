package main.java.myLib.datastructures.nodes;
public class TNode {
    private int data;
    public TNode left;
    public TNode right;
    private TNode parent;
    private int balance;
    public int height;

    public TNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }


    // Default constructor
    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
        this.height = 1;
    }
    public TNode(int data, int balance, TNode P, TNode L, TNode R) {
        this.data = data;
        this.balance = balance;
        this.parent = P;
        this.left = L;
        this.right = R;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TNode getLeft() {
        return left;
    }



    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public TNode getParent() {
        return parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void print() {
        String dataString = toString();
        System.out.println("data: " + dataString + ", balance: " + balance);
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
