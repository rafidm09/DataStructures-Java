package test;
import main.java.myLib.datastructures.nodes.TNode;
import main.java.myLib.datastructures.trees.BST;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class BSTTest {

    @Test
    public void testInsert(){
        BST bst = new BST();

        bst.insert(5);
        bst.insert(3);
        bst.insert(8);
        bst.insert(2);
        bst.insert(1);

        TNode root = bst.getRoot();
        assertEquals(5, root.getData());
        assertEquals(3, root.getLeft().getData());
        assertEquals(8, root.getRight().getData());


    }
    @Test
    public void insertNode(){
        BST bst = new BST();
        bst.insert(new TNode(5));
        bst.insert(new TNode(3));
        bst.insert(new TNode(8));
        bst.insert(new TNode(4));
        bst.insert(new TNode(2));


        TNode root = bst.getRoot();
        assertEquals(5, root.getData());
        assertEquals(3, root.getLeft().getData());
        assertEquals(8,root.getRight().getData());

    }

    @Test
    public void testDelete() {
        BST tree = new BST();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        // Test deleting a leaf node
        tree.delete(1);
        assertNull(tree.search(1)); // Check that 1 is no longer in the tree

        // Test deleting a node with one child
        tree.delete(7);
        assertNull(tree.search(7)); // Check that 7 is no longer in the tree
        assertNotNull(tree.search(6)); // Check that 6 (the child of 7) is still in the tree

        // Test deleting a node with two children
        tree.delete(3);
        assertNull(tree.search(3)); // Check that 3 is no longer in the tree
        assertNotNull(tree.search(4)); // Check that 4 (the left child of 3) is still in the tree
        assertNotNull(tree.search(5)); // Check that 5 (the parent of 3) is still in the tree
        assertNotNull(tree.search(6)); // Check that 6 (the right child of 3) is still in the tree
        assertNotNull(tree.search(8)); // Check that 8 (a descendant of 3) is still in the tree

        // Test deleting a node that doesn't exist
        tree.delete(2);
        assertNotNull(tree.search(4)); // Check that 4 is still in the tree
        assertNotNull(tree.search(5)); // Check that 5 is still in the tree
        assertNotNull(tree.search(6)); // Check that 6 is still in the tree
        assertNotNull(tree.search(8)); // Check that 8 is still in the tree
    }


    @Test
    public void testSearch() {
        BST tree = new BST();
        TNode root = new TNode(5);
        TNode left = new TNode(3);
        TNode right = new TNode(7);
        root.setLeft(left);
        root.setRight(right);
        tree.setRoot(root);

        TNode node1 = new TNode(2);
        TNode node2 = new TNode(4);
        TNode node3 = new TNode(6);
        TNode node4 = new TNode(8);
        left.setLeft(node1);
        left.setRight(node2);
        right.setLeft(node3);
        right.setRight(node4);
        node4.setParent(right);
        node3.setParent(right);
        node2.setParent(left);
        node1.setParent(left);

        TNode result1 = tree.search(5);
        assertEquals(result1, root);

        TNode result2 = tree.search(2);
        assertEquals(result2, node1);

        TNode result3 = tree.search(8);
        assertEquals(result3, node4);

        TNode result4 = tree.search(10);
        assertNull(result4);
    }

    @Test
    public void testPrintInOrder() {
        BST tree = new BST();
        TNode root = new TNode(8);
        TNode left1 = new TNode(3);
        TNode right1 = new TNode(10);
        root.setLeft(left1);
        root.setRight(right1);
        TNode left2 = new TNode(1);
        TNode right2 = new TNode(6);
        left1.setLeft(left2);
        left1.setRight(right2);
        TNode left3 = new TNode(4);
        TNode right3 = new TNode(7);
        right2.setLeft(left3);
        right2.setRight(right3);
        TNode right4 = new TNode(14);
        right1.setRight(right4);
        TNode left5 = new TNode(13);
        right4.setLeft(left5);
        tree.setRoot(root);

        // redirect standard output to a stream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // call the method to print in order
        tree.printInOrder();

        // restore standard output
        System.setOut(System.out);

        // assert that the printed output matches the expected order
        assertEquals("1 3 4 6 7 8 10 13 14 ", outContent.toString());
    }

    @Test
    public void testPrintBF() {

        TNode node1 = new TNode(1);
        TNode node2 = new TNode(2);
        TNode node3 = new TNode(3);
        TNode node4 = new TNode(4);
        TNode node5 = new TNode(5);
        TNode node6 = new TNode(6);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node3.setLeft(node5);
        node3.setRight(node6);

        // Set up the binary tree object
        BST tree = new BST();
        tree.setRoot(node1);

        // Capture the console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method to be tested
        tree.printBF();


    }


    @Test
    public void testEmptyBST() {
        BST bst = new BST();
        assertNull(bst.getRoot());
    }

    @Test
    public void testInsertIntoEmptyBST() {
        BST bst = new BST();
        bst.insert(5);
        assertNotNull(bst.getRoot());
        assertEquals(5, bst.getRoot().getData());
    }

    @Test
    public void testInsertAndDelete() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        assertNotNull(bst.getRoot());
        assertEquals(5, bst.getRoot().getData());
        assertNotNull(bst.search(7));
        bst.delete(7);
        assertNull(bst.search(7));
        assertNotNull(bst.search(1));
        bst.delete(1);
        assertNull(bst.search(1));
        assertEquals(8, bst.getRoot().getRight().getData());
    }

    @Test
    public void testClearBST() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.delete(5);
        bst.delete(3);
        bst.delete(7);
        assertNull(bst.getRoot());
        bst.insert(10);
        assertNotNull(bst.getRoot());
        assertEquals(10, bst.getRoot().getData());
    }
}


