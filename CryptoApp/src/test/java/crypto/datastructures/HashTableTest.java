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

    @Before
    public void setUp() {
        this.hashT = new HashTable();
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
}
