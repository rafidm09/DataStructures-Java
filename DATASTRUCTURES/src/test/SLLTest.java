package test;

import main.java.myLib.datastructures.linear.SLL;
import main.java.myLib.datastructures.nodes.SNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SLLTest {

    private SLL list;

    @Before
    public void setUp() {
        list = new SLL();
    }

    @Test
    public void testInsertHead() {
        SNode node = new SNode(1);
        list.insertHead(node);
        assertEquals(node, list.head);
        assertEquals(node, list.tail);
        assertEquals(1, list.size());
    }

    @Test
    public void testInsertTail() {
        SNode node = new SNode(1);
        list.insertTail(node);
        assertEquals(node, list.head);
        assertEquals(node, list.tail);
        assertEquals(1, list.size());
    }

    @Test
    public void testInsert() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insert(node1, 0);
        list.insert(node3, 1);
        list.insert(node2, 1);
        assertEquals(node1, list.head);
        assertEquals(node3, list.tail);
        assertEquals(3, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertInvalidPosition() {
        SNode node = new SNode(1);
        list.insert(node, -1);
    }

    @Test
    public void testSortedInsert() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.sortedInsert(node2);
        list.sortedInsert(node1);
        list.sortedInsert(node3);
        assertEquals(node1, list.head);
        assertEquals(node3, list.tail);
        assertEquals(3, list.size());
    }

    @Test
    public void testSearch() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        list.insertHead(node1);
        list.insertTail(node2);
        assertEquals(node1, list.search(node1));
        assertEquals(node2, list.search(node2));
        assertNull(list.search(new SNode(3)));
    }

    @Test
    public void testDeleteHead() {
        SNode node = new SNode(1);
        list.insertHead(node);
        list.deleteHead();
        assertNull(list.head);
        assertNull(list.tail);
        assertEquals(0, list.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeleteHeadEmptyList() {
        list.deleteHead();
    }

    @Test
    public void testDeleteTail() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertHead(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.deleteTail();
        assertEquals(node2, list.tail);
        assertEquals(2, list.size());
        list.deleteTail();
        assertEquals(node1, list.head);
        assertEquals(node1, list.tail);
        assertEquals(1, list.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeleteTailEmptyList() {
        list.deleteTail();
    }

    @Test
    public void testDelete() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertHead(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.delete(node2);
        assertEquals(node1, list.head);
        assertEquals(node3, list.tail);
        assertEquals(2, list.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeleteEmptyList() {
        SNode node = new SNode(1);
        list.delete(node);
    }

}
