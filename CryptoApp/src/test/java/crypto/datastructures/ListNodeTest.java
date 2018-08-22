/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.datastructures;

import crypto.ciphers.CharIndexPair;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class ListNodeTest {

    private ListNode node;

    @Before
    public void setUp() {
        CharIndexPair ci = new CharIndexPair('x', 45);
        this.node = new ListNode(1, ci, null, null);
    }

    @Test
    public void getKeyTest1() {
        assertEquals(1, this.node.getKey());
    }

    @Test
    public void getValueTest2() {
        CharIndexPair ci2 = new CharIndexPair('x', 45);
        assertEquals(ci2, this.node.getValue());
    }

    @Test
    public void nodeTest1() {
        ListNode node2 = new ListNode("node", 1, this.node, null);
        ListNode node3 = new ListNode("Solmu", 2, null, node2);
        CharIndexPair ci2 = new CharIndexPair('x', 45);

        assertEquals(ci2, node2.next.getValue());
        assertEquals(1, node3.prev.getValue());
        assertEquals("node", node3.prev.getKey());
    }
}
