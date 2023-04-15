package main.java.mylib .datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private TNode root;

    public BST() {
        this.root = null;
    }

    public BST(int val) {
        this.root = new TNode(val);
    }

    public BST(TNode obj) {
        this.root = obj;
    }

    public TNode getRoot() {
        return this.root;
    }

    public void setRoot(TNode node) {
        this.root = node;
    }

    public void insert(int val) {
        TNode node = new TNode(val);
        if (root == null) {
            root = node;
            return;
        }
        TNode curr = root;
        while (true) {
            if (val < curr.getData()) {
                if (curr.getLeft() == null) {
                    curr.setLeft(node);
                    return;
                }
                curr = curr.getLeft();
            } else {
                if (curr.getRight() == null) {
                    curr.setRight(node);
                    return;
                }
                curr = curr.getRight();
            }
        }
    }

    public void insert(TNode node) {
        if (root == null) {
            root = node;
            return;
        }
        TNode curr = root;
        while (true) {
            if (node.getData() < curr.getData()) {
                if (curr.getLeft() == null) {
                    curr.setLeft(node);
                    return;
                }
                curr = curr.getLeft();
            } else {
                if (curr.getRight() == null) {
                    curr.setRight(node);
                    return;
                }
                curr = curr.getRight();
            }
        }
    }

    public TNode search(int val) {
        TNode curr = root;
        while (curr != null) {
            if (val == curr.getData()) {
                return curr;
            } else if (val < curr.getData()) {
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
        }
        return null;
    }

    public void delete(int val) {
        root = deleteNode(root, val);
    }

    private TNode deleteNode(TNode root, int val) {
        if (root == null) {
            return root;
        }
        if (val < root.getData()) {
            root.setLeft(deleteNode(root.getLeft(), val));
        } else if (val > root.getData()) {
            root.setRight(deleteNode(root.getRight(), val));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }
            TNode minNode = findMinNode(root.getRight());
            root.setData(minNode.getData());
            root.setRight(deleteNode(root.getRight(), minNode.getData()));
        }
        return root;
    }

    private TNode findMinNode(TNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public void printInOrder() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(TNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.getLeft());
        System.out.print(node.getData() + " ");
        inOrderTraversal(node.getRight());
    }

    public void printBF() {
        if (root == null) {
            return;
        }
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TNode curr = queue.poll();
                System.out.print(curr.getData() + " ");
                if (curr.getLeft() != null) {
                    queue.add(curr.getLeft());
                }
                if (curr.getRight() != null) {
                    queue.add(curr.getRight());
                }
            }
            System.out.println();
        }
    }
}