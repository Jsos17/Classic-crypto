/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.datastructures;

import crypto.helpers.CharIndexPair;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class DoublyLinkedListTest {

    private DoublyLinkedList list;

    @Before
    public void setUp() {
        this.list = new DoublyLinkedList();
    }

    @Test
    public void listHeadIsNull1() {
        assertTrue(this.list.getHead() == null);
    }

    @Test
    public void insertTest1() {
        this.list.insert("Solmu", 1);
        assertEquals("Solmu", this.list.getHead().getKey());
        assertTrue(this.list.getHead().next == null);
        assertTrue(this.list.getHead().prev == null);
    }

    @Test
    public void insertTest2() {
        this.list.insert("Solmu", 7);
        this.list.insert("Solmu2", 8);
        assertEquals("Solmu2", this.list.getHead().getKey());
        assertEquals(8, this.list.getHead().getValue());
    }

    @Test
    public void insertTest3() {
        this.list.insert("Solmu", 457);
        this.list.insert("Solmu2", 456);
        this.list.insert("Solmu3", 213);
        assertEquals(213, this.list.getHead().getValue());
        assertEquals(456, this.list.getHead().next.getValue());
        assertEquals(457, this.list.getHead().next.next.getValue());
    }

    @Test
    public void searchTest1() {
        this.list.insert("Solmu", -1000);
        this.list.insert("solmu", 1990);
        this.list.insert("node", 0);

        assertTrue(this.list.search("lista") == null);
    }

    @Test
    public void searchTest2() {
        this.list.insert("Solmu", 85);
        this.list.insert("solmu", 10000);
        this.list.insert("node", 2222);

        assertEquals("solmu", this.list.search("solmu").getKey());
        assertEquals(85, this.list.search("Solmu").getValue());
        assertEquals(2222, this.list.search("node").getValue());
    }

    @Test
    public void searchTest3() {
        this.list.insert("Solmu", 5000);
        this.list.insert("solmu", 3000);
        this.list.insert("node", 2000);

        assertEquals("Solmu", this.list.search("solmu").next.getKey());
        assertEquals("node", this.list.search("solmu").prev.getKey());
    }

    @Test
    public void nextPrevTest1() {
        this.list.insert("TiRa", 10);
        this.list.insert("TiRaLabra", 4);
        this.list.insert("LaMa", 5);
        assertTrue(this.list.getHead().prev == null);
        assertEquals("LaMa", this.list.getHead().getKey());
        assertEquals("TiRaLabra", this.list.getHead().next.getKey());
        assertEquals("TiRa", this.list.getHead().next.next.getKey());
    }

    @Test
    public void nextPrevTest2() {
        this.list.insert('B', 3);
        this.list.insert('C', 4);
        this.list.insert('x', 27);

        assertEquals(27, this.list.getHead().getValue());
        assertEquals(4, this.list.getHead().next.getValue());
        assertEquals(3, this.list.getHead().next.next.getValue());
    }

    @Test
    public void deleteTest1() {
        this.list.insert('B', 3);
        this.list.insert('C', 4);
        this.list.insert('x', 27);

        ListNode found = this.list.search('C');
        this.list.delete(found);
        assertEquals('B', this.list.getHead().next.getKey());
        assertEquals('x', this.list.search('B').prev.getKey());
    }

    @Test
    public void deleteTest2() {
        this.list.insert("TION", 50000);
        assertEquals("TION", this.list.getHead().getKey());

        this.list.delete(this.list.search("TION"));
        assertTrue(this.list.getHead() == null);
    }

    @Test
    public void deleteTest3() {
        this.list.insert("Solmu", 86);
        this.list.insert("solmu", 100);
        this.list.insert("2", 344);

        assertEquals("2", this.list.getHead().getKey());
        this.list.delete(this.list.search("2"));
        assertEquals("solmu", this.list.getHead().getKey());
        this.list.delete(this.list.search("solmu"));
        assertEquals("Solmu", this.list.getHead().getKey());
    }

    @Test
    public void deleteTest4() {
        CharIndexPair ci1 = new CharIndexPair('x', 45);
        CharIndexPair ci2 = new CharIndexPair('a', 42);
        CharIndexPair ci3 = new CharIndexPair('T', 3);
        this.list.insert(ci1, 56);
        this.list.insert(ci2, 20);
        this.list.insert(ci3, 111);

        this.list.delete(this.list.search(ci1));
        this.list.delete(this.list.search(ci3));

        assertEquals(ci2, this.list.getHead().getKey());
        assertTrue(this.list.getHead().next == null);
        assertTrue(this.list.getHead().prev == null);
    }

    @Test
    public void emptyTest1() {
        assertTrue(this.list.isEmpty());
    }

    @Test
    public void emptyTest2() {
        this.list.insert("Enigma", 1944);
        assertFalse(this.list.isEmpty());
    }

    @Test
    public void getSizeTest1() {
        assertEquals(0, this.list.getSize());
        this.list.insert("Solmu", 86);
        this.list.insert("solmu", 100);
        this.list.insert("2", 344);
        assertEquals(3, this.list.getSize());
    }

    @Test
    public void getSizeTest3() {
        this.list.insert("Solmu", 86);
        this.list.insert("solmu", 100);
        this.list.insert("2", 344);
        assertEquals(3, this.list.getSize());
        this.list.delete(this.list.search("Solmu"));
        this.list.delete(this.list.search("solmu"));
        assertEquals(1, this.list.getSize());
    }
}
