/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.datastructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class DoublyLinkedMemberListTest {

    private DoublyLinkedMemberList<String> list;

    @Before
    public void setUp() {
        this.list = new DoublyLinkedMemberList<>();
    }

    @Test
    public void containsTest1() {
        assertFalse(this.list.contains("plaintext"));
    }

    @Test
    public void containsTest2() {
        this.list.insert("plaintext");
        assertTrue(this.list.contains("plaintext"));
    }

    @Test
    public void insertOnlyOneSameObjectTest1() {
        this.list.insert("word");
        assertEquals(1, this.list.getSize());
        this.list.insert("word");
        assertEquals(1, this.list.getSize());
    }

    @Test
    public void insertOnlyOneSameObjectTest2() {
        this.list.insert("puzzle");
        assertEquals(1, this.list.getSize());
        this.list.insert("puzzle");
        this.list.insert("puzzle");
        this.list.insert("puzzle");
        assertEquals(1, this.list.getSize());
    }

    @Test
    public void deleteTest1() {
        assertEquals(0, this.list.getSize());
        this.list.insert("enigma");
        assertEquals(1, this.list.getSize());
        this.list.delete("enigma");
        assertEquals(0, this.list.getSize());
    }

    @Test
    public void deleteTest2() {
        assertEquals(0, this.list.getSize());
        this.list.insert("enigma");
        this.list.insert("entropy");
        assertEquals(2, this.list.getSize());
        this.list.delete("enigmA");
        this.list.delete("Entropy");
        this.list.delete("enigma ");
        this.list.delete(" entropy");
        assertEquals(2, this.list.getSize());
    }

    @Test
    public void deleteTest3() {
        assertEquals(0, this.list.getSize());
        this.list.insert("enigma");
        this.list.insert("entropy");
        this.list.insert("code");
        assertEquals(3, this.list.getSize());
        this.list.delete("entropy");
        this.list.delete("enigma");
        assertEquals(1, this.list.getSize());
    }

    @Test
    public void getHeadTest1() {
        assertTrue(this.list.getHead() == null);
    }

    @Test
    public void getHeadTest2() {
        this.list.insert("absurd");
        assertEquals("absurd", this.list.getHead().getObject());
        this.list.insert("meaning");
        assertEquals("meaning", this.list.getHead().getObject());
        this.list.insert("machine");
        assertEquals("machine", this.list.getHead().getObject());
    }

    @Test
    public void sizeTest1() {
        this.list.insert("coin");
        this.list.insert("coin");
        this.list.insert("coin");
        this.list.insert("coin");
        assertEquals(1, this.list.getSize());
    }

    @Test
    public void emptinessTest1() {
        assertTrue(this.list.isEmpty());
        this.list.insert("coin");
        assertFalse(this.list.isEmpty());
        this.list.delete("coin");
        assertTrue(this.list.isEmpty());
    }
}
