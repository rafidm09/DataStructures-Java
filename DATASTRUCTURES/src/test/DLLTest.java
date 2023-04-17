package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.java.myLib.datastructures.linear.DLL;
import main.java.myLib.datastructures.nodes.DNode;

public class DLLTest {

    @Test
    public void testInsertHead() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        dll.insertHead(node1);
        assertEquals(dll.getHead(), node1);

        dll.insertHead(node2);
        assertEquals(dll.getHead(), node2);
        assertEquals(dll.getHead().getNext(), node1);
        assertEquals(dll.getHead().getNext().getPrev(), node2);
    }

    @Test
    public void testInsertTail() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        dll.insertTail(node1);
        assertEquals(dll.getTail(), node1);

        dll.insertTail(node2);
        assertEquals(dll.getTail(), node2);
        assertEquals(dll.getTail().getPrev(), node1);
        assertEquals(dll.getTail().getPrev().getNext(), node2);
    }

    @Test
    public void testInsert() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.insert(node1, 0);
        assertEquals(dll.getHead(), node1);

        dll.insert(node3, 1);
        assertEquals(dll.getTail(), node3);
        assertEquals(dll.getTail().getPrev(), node1);

        dll.insert(node2, 1);
        assertEquals(dll.getHead().getNext(), node2);
        assertEquals(dll.getTail().getPrev(), node2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertException() {
        DLL dll = new DLL();
        DNode node = new DNode(1);

        dll.insert(node, -1);
    }

    @Test
    public void testSortedInsert() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.sortedInsert(node2);
        assertEquals(dll.getHead(), node2);
        assertEquals(dll.getTail(), node2);

        dll.sortedInsert(node1);
        assertEquals(dll.getHead(), node1);
        assertEquals(dll.getTail(), node2);

        dll.sortedInsert(node3);
        assertEquals(dll.getTail(), node3);
        assertEquals(dll.getTail().getPrev(), node2);
    }

    @Test
    public void testSearch() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.insertHead(node1);
        dll.insertTail(node2);
        dll.insertTail(node3);

        assertEquals(dll.search(node1), node1);
        assertEquals(dll.search(node2), node2);
        assertEquals(dll.search(node3), node3);
        assertNull(dll.search(new DNode(4)));
    }

    @Test
    public void testDeleteHead() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.insertHead(node1);
        dll.insertTail(node2);
        dll.insertTail(node3);

        dll.deleteHead();
        assertEquals(dll.getHead(), node2);
        assertEquals(dll.getHead().getPrev(), null);
        assertEquals(dll.getHead().getNext(), node3);

        dll.deleteHead();
        assertEquals(dll.getHead(), node3);
        assertEquals(dll.getHead().getPrev(), null);
        assertEquals(dll.getHead().getNext(), null);

        dll.deleteHead();
        assertNull(dll.getHead());
        assertNull(dll.getTail());
    }

    @Test
    public void testDeleteTail() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.insertHead(node1);
        dll.insertTail(node2);
        dll.insertTail(node3);

        dll.deleteTail();
        assertEquals(dll.getTail(), node2);
        assertEquals(dll.getTail().getPrev(), node1);
        assertEquals(dll.getTail().getNext(), null);

        dll.deleteTail();
        assertEquals(dll.getTail(), node1);
        assertEquals(dll.getTail().getPrev(), null);
        assertEquals(dll.getTail().getNext(), null);

        dll.deleteTail();
        assertNull(dll.getHead());
        assertNull(dll.getTail());
    }


    @Test
    public void testDelete() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.insertHead(node1);
        dll.insertTail(node2);
        dll.insertTail(node3);

        dll.delete(node1);

        assertEquals(dll.getTail(), node3);
        assertEquals(dll.getHead().getNext(), node3);

    }
}
