package test;

import main.java.myLib.datastructures.linear.CSLL;
import main.java.myLib.datastructures.nodes.SNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class CSLLTest {

    @Test
    public void testIsEmpty() {
        CSLL list = new CSLL();
        assertTrue(list.isEmpty());
        list.insertHead(new SNode(1));
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        CSLL list = new CSLL();
        assertEquals(0, list.size());
        list.insertHead(new SNode(1));
        assertEquals(1, list.size());
        list.insertTail(new SNode(2));
        assertEquals(2, list.size());
        list.deleteTail();
        assertEquals(1, list.size());
    }

    @Test
    public void testInsertHead() {
        CSLL list = new CSLL();
        list.insertHead(new SNode(1));
        assertEquals(1, list.size());
        assertEquals(1, list.getHead().getData());
        list.insertHead(new SNode(2));
        assertEquals(2, list.size());
        assertEquals(2, list.getHead().getData());
    }

    @Test
    public void testInsertTail() {
        CSLL list = new CSLL();
        list.insertTail(new SNode(1));
        assertEquals(1, list.size());
        assertEquals(1, list.getTail().getData());
        list.insertTail(new SNode(2));
        assertEquals(2, list.size());
        assertEquals(2, list.getTail().getData());
    }

    @Test
    public void testInsert() {
        CSLL list = new CSLL();
        list.insert(new SNode(1), 0);
        assertEquals(1, list.size());
        assertEquals(1, list.getHead().getData());
        list.insert(new SNode(3), 1);
        assertEquals(2, list.size());
        assertEquals(3, list.getTail().getData());
        list.insert(new SNode(2), 1);
        assertEquals(3, list.size());
        assertEquals(2, list.getHead().getNext().getData());
    }

    @Test
    public void testSearch() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        list.insertHead(node1);
        list.insertHead(node2);
        assertEquals(node2, list.search(node2));
        assertEquals(null, list.search(new SNode(3)));
    }

    @Test
    public void testDeleteHead() {
        CSLL list = new CSLL();
        list.insertHead(new SNode(1));
        list.insertHead(new SNode(2));
        list.deleteHead();
        assertEquals(1, list.size());
        assertEquals(1, list.getHead().getData());
        list.deleteHead();
        assertEquals(0,list.size());
    }

    @Test
    public void testDeleteTail() {
        CSLL list = new CSLL();
        list.insertHead(new SNode(1));
        list.insertHead(new SNode(2));
        list.deleteTail();
        assertEquals(1, list.size());
        assertEquals(2, list.getHead().getData());
        list.deleteTail();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testDelete() {
        CSLL list = new CSLL();
        list.insertHead(new SNode(1));
        list.insertHead(new SNode(2));
        list.insertHead(new SNode(3));
        list.delete(1);
        assertEquals(2, list.size());
        assertEquals(3, list.getHead().getData());
        assertEquals(1, list.getTail().getData());
        list.delete(0);
        assertEquals(1, list.size());
        assertEquals(1, list.getHead().getData());
        list.delete(0);
        assertEquals(0,list.size());
    }
}