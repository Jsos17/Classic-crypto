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
        this.node = new ListNode(ci, null, null);
    }

    @Test
    public void getObjTest1() {
        CharIndexPair ci2 = new CharIndexPair('x', 45);
        assertEquals(ci2, this.node.getObj());
    }

    @Test
    public void getObjTest2() {
        CharIndexPair ci2 = new CharIndexPair('X', 45);
        assertNotEquals(ci2, this.node.getObj());
    }

    @Test
    public void nodeTest1() {
        ListNode node2 = new ListNode("node", this.node, null);
        ListNode node3 = new ListNode("Solmu", null, node2);

        assertEquals(this.node.getObj(), node2.next.getObj());
        assertEquals(node2.getObj(), node3.prev.getObj());
    }
}
