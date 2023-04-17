package test;

import main.java.myLib.datastructures.linear.QueueLL;
import main.java.myLib.datastructures.nodes.SNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueLLTest {

    @Test
    public void testEnqueue() {
        QueueLL queue = new QueueLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        queue.enqueue(node1);
        queue.enqueue(node2);
        queue.enqueue(node3);
        assertEquals(node1, queue.head);
        assertEquals(node3, queue.tail);
    }

    @Test
    public void testDequeue() {
        QueueLL queue = new QueueLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        queue.enqueue(node1);
        queue.enqueue(node2);
        queue.dequeue();
        assertEquals(node2, queue.head);
    }

    @Test
    public void testPeek() {
        QueueLL queue = new QueueLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        queue.enqueue(node1);
        queue.enqueue(node2);
        assertEquals(node1, queue.peek());
    }
}
