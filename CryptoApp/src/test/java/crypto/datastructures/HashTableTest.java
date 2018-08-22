/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.datastructures;

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
public class HashTableTest {

    private HashTable hashT;
    private HashTable<String, Long> ht;

    @Before
    public void setUp() {
        this.hashT = new HashTable();
        this.ht = new HashTable<>();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void initialTableSizeTest1() {
        assertEquals(47, this.hashT.getTableSize());
    }

    @Test
    public void initialTableSizeTest2() {
        HashTable ht2 = new HashTable(100_000);
        assertEquals(196_613, ht2.getTableSize());
    }

    @Test
    public void initialTableSizeTest3() {
        HashTable ht2 = new HashTable(Integer.MAX_VALUE - 1000);
        assertEquals(402_653_189, ht2.getTableSize());
    }

    @Test
    public void initialTableSizeTest4() {
        HashTable ht2 = new HashTable(1);
        assertEquals(11, ht2.getTableSize());
    }

    @Test
    public void initialTableSizeTest5() {
        HashTable ht2 = new HashTable(22);
        assertEquals(23, ht2.getTableSize());
    }

    @Test
    public void insertSearchTest1() {
        String text = "ATTA";
        this.hashT.hashInsert(text, 50001);
        assertEquals(50001, this.hashT.hashSearch(text).getValue());
    }

    @Test
    public void insertSearchTest2() {
        HashTable<String, Integer> ht2 = new HashTable<>();
        String text1 = "ATTA";
        String text2 = "TION";
        String text3 = "abcd";
        ht2.hashInsert(text1, -12000);
        ht2.hashInsert(text2, 31345);
        ht2.hashInsert(text3, 34);
        assertEquals(31345, ht2.hashSearch(text2).getValue());
        assertEquals(-12000, ht2.hashSearch(text1).getValue());
        assertEquals(34, ht2.hashSearch(text3).getValue());
    }

    @Test
    public void insertSearchTest3() {
        String text1 = "ATTA";
        String text2 = "TION";
        String text3 = "abcd";
        this.ht.hashInsert(text1, 100023526262l);
        this.ht.hashInsert(text2, 235626262252l);
        this.ht.hashInsert(text3, 2151526262l);
        assertTrue(this.ht.hashSearch("atta") == null);
        assertTrue(this.ht.hashSearch("tion") == null);
        assertTrue(this.ht.hashSearch("ATTa") == null);
        assertTrue(this.ht.hashSearch("abcde") == null);
    }

    @Test
    public void deleteTest1() {
        this.ht.hashInsert("crypto", 4l);
        this.ht.hashDelete(this.ht.hashSearch("crypto"));
        assertTrue(this.ht.hashSearch("crypto") == null);
    }

    @Test
    public void deleteTest2() {
        this.hashT.hashInsert("crypto", 3);
        this.hashT.hashInsert("crypto", 3);
        this.hashT.hashInsert("crypto", 3);
        this.hashT.hashDelete(this.hashT.hashSearch("crypto"));
        this.hashT.hashDelete(this.hashT.hashSearch("crypto"));
        assertEquals("crypto", this.hashT.hashSearch("crypto").getKey());
    }

    @Test
    public void insertSearchDeleteTest1() {
        String text1 = "ATTA";
        String text2 = "TION";
        String text3 = "abcd";
        this.ht.hashInsert(text1, 55630l);
        this.ht.hashInsert(text2, -141525l);
        this.ht.hashInsert(text3, 94252l);

        assertEquals(-141525l, this.ht.hashSearch(text2).getValue());
        this.ht.hashDelete(this.ht.hashSearch(text2));
        assertTrue(this.ht.hashSearch(text2) == null);
    }

    @Test
    public void currentSizeTest1() {
        this.hashT.hashInsert("gggd", 'b');
        this.hashT.hashInsert("gfgd", 'c');
        this.hashT.hashInsert("gatr", 'd');
        this.hashT.hashInsert("qged", 't');

        assertEquals(4, this.hashT.getCurrentSize());
    }
}
