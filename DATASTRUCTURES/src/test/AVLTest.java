package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.myLib.datastructures.nodes.TNode;
import main.java.myLib.datastructures.trees.AVL;

public class AVLTest {

    @Test
    public void testInsert() {
        AVL tree = new AVL();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        assertEquals(tree.search(10).getData(), 10);
        assertEquals(tree.search(20).getData(), 20);
        assertEquals(tree.search(30).getData(), 30);
    }

    @Test
    public void testDelete() {
        AVL tree = new AVL();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.delete(20);
        assertEquals(tree.search(10).getData(), 10);
        assertEquals(tree.search(20), null);
        assertEquals(tree.search(30).getData(), 30);
    }

    @Test
    public void testSearch() {
        AVL tree = new AVL();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        assertEquals(tree.search(10).getData(), 10);
        assertEquals(tree.search(20).getData(), 20);
        assertEquals(tree.search(30).getData(), 30);
        assertEquals(tree.search(40), null);
    }

    @Test
    public void testPrintInOrder() {
        AVL tree = new AVL();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);
        tree.printInOrder();
    }

    @Test
    public void testGetRoot() {
        AVL tree = new AVL();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        assertEquals(tree.getRoot().getData(), 20);
    }

    @Test
    public void testSetRoot() {
        AVL tree = new AVL();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        TNode newRoot = new TNode(40, 0, null, null, null);
        tree.setRoot(newRoot);
        assertEquals(tree.getRoot().getData(), 40);
    }

}
