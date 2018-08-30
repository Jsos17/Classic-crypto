/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.datastructures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class HashedSetTest {

    private HashedSet<String> set;

    @Before
    public void setUp() {
        this.set = new HashedSet<>();
    }

    @Test
    public void containsTest1() {
        this.set.insert("words");
        assertTrue(this.set.contains("words"));
    }

    @Test
    public void containsTest2() {
        assertFalse(this.set.contains("words"));
    }

    @Test
    public void containsTest3() {
        this.set.insert("Jj");
        assertFalse(this.set.contains("KK"));
    }

    @Test
    public void insertTest1() {
        this.set.insert("codes");
        assertEquals(1, this.set.getCurrentSize());
    }

    @Test
    public void insertTest2() {
        this.set.insert("codes");
        this.set.insert("codes");
        this.set.insert("codes");
        assertEquals(1, this.set.getCurrentSize());
    }

    @Test
    public void insertTest3() {
        this.set.insert("codes");
        this.set.insert("Codes");
        this.set.insert("CODES");
        assertEquals(3, this.set.getCurrentSize());
    }

    @Test
    public void deleteTest1() {
        this.set.insert("codes");
        assertEquals(1, this.set.getCurrentSize());
        this.set.delete("codes");
        assertEquals(0, this.set.getCurrentSize());
    }

    @Test
    public void deleteTest2() {
        this.set.insert("codes");
        assertEquals(1, this.set.getCurrentSize());
        this.set.delete("Codes");
        assertEquals(1, this.set.getCurrentSize());
    }

    @Test
    public void deleteTest3() {
        this.set.insert("Jj");
        assertEquals(1, this.set.getCurrentSize());
        this.set.delete("KK");
        assertEquals(1, this.set.getCurrentSize());
    }

    /*
    "KK".hashCode() & 0x7fffffff = 2400
    "Jj".hashCode() & 0x7fffffff = 2400
    
    Thus they map to the same list regardless of the modulus.
     */
    @Test
    public void sameHashDifferentObjectsIsNoticedTest1() {
        assertFalse(this.set.contains("KK"));
        assertFalse(this.set.contains("Jj"));
        this.set.insert("KK");
        this.set.insert("Jj");
        assertTrue(this.set.contains("KK"));
        assertTrue(this.set.contains("Jj"));
    }

    @Test
    public void reSizingWorksTest1() {
        HashedSet<Integer> set2 = new HashedSet<>();
        assertEquals(47, set2.getTableCapacity());
        int n = 100;
        for (int i = 1; i < n; i++) {
            set2.insert(i);
        }

        assertEquals(193, set2.getTableCapacity());
    }

    @Test
    public void reSizingWorksTest2() {
        HashedSet<Integer> set2 = new HashedSet<>(30000);
        assertEquals(49_157, set2.getTableCapacity());
        int n = 20000;
        for (int i = 1; i <= n; i++) {
            set2.insert(i);
        }

        for (int i = 1; i <= 15000; i++) {
            set2.delete(i);
        }

        assertEquals(12_289, set2.getTableCapacity());
    }

    @Test
    public void resizingMaintainsContents1() {
        HashedSet<Integer> set2 = new HashedSet<>();
        assertEquals(47, set2.getTableCapacity());
        int n = 10000;
        for (int i = 1; i <= n; i++) {
            set2.insert(i);
        }
        assertEquals(24_571, set2.getTableCapacity());

        for (int i = 1; i <= n; i++) {
            assertTrue(set2.contains(i));
        }
    }

    @Test
    public void resizingMaintainsContents2() {
        HashedSet<Integer> set2 = new HashedSet<>();
        assertEquals(47, set2.getTableCapacity());
        int n = 10000;
        for (int i = 1; i <= n; i++) {
            set2.insert(i);
        }
        assertEquals(24_571, set2.getTableCapacity());

        int k = (int) n / 2;
        for (int i = 1; i <= k; i++) {
            set2.delete(i);
        }
        assertEquals(12_289, set2.getTableCapacity());
        for (int i = k + 1; i <= n; i++) {
            assertTrue(set2.contains(i));
        }
    }

    @Test
    public void tableSizeTest1() {
        HashedSet<String> set = new HashedSet<>(45_000_000);
        assertEquals(50_331_653, set.getTableCapacity());
    }

    @Test
    public void tableSizeTest2() {
        HashedSet<String> set = new HashedSet<>(-50);
        assertEquals(47, set.getTableCapacity());
    }

    @Test
    public void tableSizeTest3() {
        HashedSet<String> set = new HashedSet<>(3);
        assertEquals(11, set.getTableCapacity());
    }

    @Test
    public void tableSizeTest4() {
        HashedSet<String> set = new HashedSet<>(500_000_000);
        assertEquals(50_331_653, set.getTableCapacity());
    }
}
