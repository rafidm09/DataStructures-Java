package main.java.myLib.datastructures.trees;
import main.java.myLib.datastructures.nodes.TNode;
public class AVL extends BST {
    private TNode root;

    public AVL() {
        this.root = null;
    }

    public AVL(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }

    public AVL(TNode obj) {
        this.root = null;
        if (obj != null) {
            insert(obj.getData());
            if (obj.getLeft() != null) {
                insert(new TNode(obj.getLeft().getData(), 0, null, null, null));
                this.root.setLeft(obj.getLeft().getLeft());
            }
            if (obj.getRight() != null) {
                insert(new TNode(obj.getRight().getData(), 0, null, null, null));
                this.root.setRight(obj.getRight().getRight());
            }
        }
    }

    public TNode getRoot() {
        return root;
    }

    public void setRoot(TNode node) {
        this.root = node;
        if (node.getLeft() != null || node.getRight() != null) {
            balance(node);
        }
    }

    private int getHeight(TNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
    }

    private int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    private TNode rotateLeft(TNode node) {
        TNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        return newRoot;
    }

    private TNode rotateRight(TNode node) {
        TNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        return newRoot;
    }

    private TNode balance(TNode node) {
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private TNode insert(TNode node, int val) {
        if (node == null) {
            return new TNode(val, 0, null, null, null);
        }
        if (val < node.getData()) {
            node.setLeft(insert(node.getLeft(), val));
        } else {
            node.setRight(insert(node.getRight(), val));
        }
        return balance(node);
    }

    public void delete(int val) {
        root = delete(root, val);
    }

    private TNode delete(TNode node, int val) {
        if (node == null) {
            System.out.println("Value not found in the tree");
            return null;
        }
        if (val < node.getData()) {
            node.setLeft(delete(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(delete(node.getRight(), val));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                TNode successor = findSuccessor(node);
                node.setData(successor.getData());
                node.setRight(delete(node.getRight(), successor.getData()));
            }
        }
        node.setHeight(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1 && getBalanceFactor(node.getLeft()) >= 0) {
            return rotateRight(node);
        }
        if (balanceFactor > 1 && getBalanceFactor(node.getLeft()) < 0) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.getRight()) <= 0) {
            return rotateLeft(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.getRight()) > 0) {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }
        return node;
    }

    // Helper method to find the successor of a given node
    private TNode findSuccessor(TNode node) {
        TNode successor = node.getRight();
        while (successor.getLeft() != null) {
            successor = successor.getLeft();
        }
        return successor;
    }
    public TNode search(int val) {
        // searches for the node with val as data and returns it or returns null if not found.
        return search(root, val);
    }

    private TNode search(TNode node, int val) {
        if (node == null || node.getData() == val) {
            return node;
        }
        if (val < node.getData()) {
            return search(node.getLeft(), val);
        } else {
            return search(node.getRight(), val);
        }
    }

    public void printInOrder() {
        // prints the content data of the tree in ascending order
        printInOrder(root);
    }

    private void printInOrder(TNode node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrder(node.getRight());
        }
    }

    public void printBF() {
        // prints the balance factor of each node in the tree
        printBF(root);
    }

    private void printBF(TNode node) {
        if (node != null) {
            printBF(node.left);
            System.out.print(getBalanceFactor(node) + " ");
            printBF(node.right);
        }
    }

}
