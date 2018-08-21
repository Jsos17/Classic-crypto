/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.datastructures;

import crypto.ciphers.CharIndexPair;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void listHeadIsNull1() {
        assertTrue(this.list.getHead() == null);
    }
    
    @Test
    public void insertTest1() {
        this.list.insert("Solmu");
        assertEquals("Solmu", this.list.getHead().getObj());
        assertTrue(this.list.getHead().next == null);
        assertTrue(this.list.getHead().prev == null);        
    }
    
    @Test
    public void insertTest2() {
        this.list.insert("Solmu");
        this.list.insert("Solmu2");
        assertEquals("Solmu2", this.list.getHead().getObj());
    }
    
    @Test
    public void insertTest3() {
        this.list.insert("Solmu");
        this.list.insert("Solmu2");
        this.list.insert("Solmu3");
        assertEquals("Solmu3", this.list.getHead().getObj());
        assertEquals("Solmu2", this.list.getHead().next.getObj());
        assertEquals("Solmu", this.list.getHead().next.next.getObj());
    }
    
    @Test
    public void searchTest1() {
        this.list.insert("Solmu");
        this.list.insert("solmu");
        this.list.insert("node");
        
        assertTrue(this.list.search("lista") == null);
    }    
    
    @Test
    public void searchTest2() {
        this.list.insert("Solmu");
        this.list.insert("solmu");
        this.list.insert("node");
        
        assertEquals("solmu", this.list.search("solmu").getObj());
        assertEquals("Solmu", this.list.search("Solmu").getObj());
        assertEquals("node", this.list.search("node").getObj());
    }
    
    @Test
    public void searchTest3() {
        this.list.insert("Solmu");
        this.list.insert("solmu");
        this.list.insert("node");
        
        assertEquals("Solmu", this.list.search("solmu").next.getObj());
        assertEquals("node", this.list.search("solmu").prev.getObj());
    }    
    
    @Test
    public void nextPrevTest1() {
        this.list.insert("TiRa");
        this.list.insert("TiRaLabra");
        this.list.insert("LaMa");
        assertTrue(this.list.getHead().prev == null);
        assertEquals("LaMa", this.list.getHead().getObj());
        assertEquals("TiRaLabra", this.list.getHead().next.getObj());
        assertEquals("TiRa", this.list.getHead().next.next.getObj());
    }
    
    @Test
    public void nextPrevTest2() {
        CharIndexPair ci1 = new CharIndexPair('x', 45);
        CharIndexPair ci2 = new CharIndexPair('a', 42);
        CharIndexPair ci3 = new CharIndexPair('T', 3);
        this.list.insert(ci3);
        this.list.insert(ci2);
        this.list.insert(ci1);
        
        assertEquals(ci1, this.list.getHead().getObj());
        assertEquals(ci2, this.list.getHead().next.getObj());
        assertEquals(ci3, this.list.getHead().next.next.getObj());
    }
    
    @Test
    public void deleteTest1() {
        this.list.insert("Solmu");
        this.list.insert("solmu");
        this.list.insert("2");
        
        ListNode found = this.list.search("solmu");
        this.list.delete(found);
        assertEquals("Solmu", this.list.getHead().next.getObj());
        assertEquals("2", this.list.search("Solmu").prev.getObj());
    }
    
    @Test
    public void deleteTest2() {
        this.list.insert("solmu");
        assertEquals("solmu", this.list.getHead().getObj());
        
        this.list.delete(this.list.search("solmu"));
        assertTrue(this.list.getHead() == null);
    }
    
    @Test
    public void deleteTest3() {
        this.list.insert("Solmu");
        this.list.insert("solmu");
        this.list.insert("2");
        
        assertEquals("2", this.list.getHead().getObj());
        this.list.delete(this.list.search("2"));
        assertEquals("solmu", this.list.getHead().getObj());
        this.list.delete(this.list.search("solmu"));
        assertEquals("Solmu", this.list.getHead().getObj());
    }
    
    @Test
    public void deleteTest4() {
        CharIndexPair ci1 = new CharIndexPair('x', 45);
        CharIndexPair ci2 = new CharIndexPair('a', 42);
        CharIndexPair ci3 = new CharIndexPair('T', 3);
        this.list.insert(ci1);
        this.list.insert(ci2);
        this.list.insert(ci3);
        
        this.list.delete(this.list.search(ci1));
        this.list.delete(this.list.search(ci3));
        
        assertEquals(ci2, this.list.getHead().getObj());
        assertTrue(this.list.getHead().next == null);
        assertTrue(this.list.getHead().prev == null);
    }
    
    @Test
    public void emptyTest1() {
        assertTrue(this.list.isEmpty());
    }
    
    @Test
    public void emptyTest2() {
        this.list.insert("Enigma");
        assertFalse(this.list.isEmpty());
    }
}
