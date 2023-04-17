package test;

import main.java.myLib.datastructures.linear.StackLL;
import main.java.myLib.datastructures.nodes.SNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackLLTest {

    @Test
    public void testPush() {
        StackLL stack = new StackLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        assertFalse(stack.isEmpty());
        assertEquals(node1, stack.peek());
        stack.push(node2);
        assertFalse(stack.isEmpty());
        assertEquals(node2, stack.peek());
    }

    @Test(expected = IllegalStateException.class)
    public void testPopEmptyStack() {
        StackLL stack = new StackLL();
        stack.pop();
    }

    @Test
    public void testPop() {
        StackLL stack = new StackLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        stack.push(node2);
        assertEquals(node2, stack.pop());
        assertEquals(node1, stack.peek());
        assertEquals(node1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekEmptyStack() {
        StackLL stack = new StackLL();
        stack.peek();
    }

    @Test
    public void testPeek() {
        StackLL stack = new StackLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        assertEquals(node1, stack.peek());
        stack.push(node2);
        assertEquals(node2, stack.peek());
    }

    // Test insert methods are disabled
    @Test(expected = UnsupportedOperationException.class)
    public void testInsert() {
        StackLL stack = new StackLL();
        stack.insert(new SNode(1), 0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSortedInsert() {
        StackLL stack = new StackLL();
        stack.sortedInsert(new SNode(1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testInsertTail() {
        StackLL stack = new StackLL();
        stack.insertTail(new SNode(1));
    }

    // Test delete methods are disabled
    @Test(expected = UnsupportedOperationException.class)
    public void testDelete() {
        StackLL stack = new StackLL();
        stack.delete(new SNode(1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDeleteTail() {
        StackLL stack = new StackLL();
        stack.deleteTail();
    }
}
