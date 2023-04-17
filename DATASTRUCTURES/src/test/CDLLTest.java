package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.myLib.datastructures.linear.CDLL;
import main.java.myLib.datastructures.nodes.DNode;


public class CDLLTest {

    private CDLL list;
    private DNode node1;
    private DNode node2;
    private DNode node3;
    private DNode node4;

    @Before
    public void setUp() throws Exception {
        node1 = new DNode(1);
        node2 = new DNode(2);
        node3 = new DNode(3);
        node4 = new DNode(4);
        list = new CDLL(node1);
        list.insertTail(node2);
        list.insertTail(node3);
    }

    @Test
    public void testInsertHead() {
        DNode node0 = new DNode(0);
        list.insertHead(node0);
        assertEquals(node0, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(4, list.getSize());
    }

    @Test
    public void testInsertTail() {
        DNode node4 = new DNode(4);
        list.insertTail(node4);
        assertEquals(node1, list.getHead());
        assertEquals(node4, list.getTail());
        assertEquals(4, list.getSize());
    }

    @Test
    public void testInsert() {
        DNode node5 = new DNode(5);
        list.insert(node5, 2);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(4, list.getSize());
    }

    @Test
    public void testDeleteHead() {
        list.deleteHead();
        assertEquals(node2, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(2, list.getSize());
    }

    @Test
    public void testDeleteTail() {
        list.deleteTail();
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(2, list.getSize());
    }

    @Test
    public void testDelete() {
        list.delete(node2);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(2, list.getSize());
    }

}
