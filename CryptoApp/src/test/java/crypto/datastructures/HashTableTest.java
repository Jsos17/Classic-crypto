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
public class HashTableTest {

    private HashTable hashT;
    private HashTable<String, Long> ht;

    @Before
    public void setUp() {
        this.hashT = new HashTable();
        this.ht = new HashTable<>();
    }

    @Test
    public void initialTableSizeTest1() {
        assertEquals(47, this.hashT.getTableCapacity());
    }

    @Test
    public void initialTableSizeTest2() {
        HashTable ht2 = new HashTable(100_000);
        assertEquals(196_613, ht2.getTableCapacity());
    }

    @Test
    public void initialTableSizeTest3() {
        HashTable ht2 = new HashTable(Integer.MAX_VALUE - 1000);
        assertEquals(402_653_189, ht2.getTableCapacity());
    }

    @Test
    public void initialTableSizeTest4() {
        HashTable ht2 = new HashTable(1);
        assertEquals(11, ht2.getTableCapacity());
    }

    @Test
    public void initialTableSizeTest5() {
        HashTable ht2 = new HashTable(22);
        assertEquals(23, ht2.getTableCapacity());
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
        this.hashT.hashInsert("ged", 't');

        assertEquals(4, this.hashT.getCurrentSize());
    }

    @Test
    public void getTest1() {
        this.hashT.hashInsert("gggd", 'b');
        this.hashT.hashInsert("gfgd", 'c');
        this.hashT.hashInsert("gatr", 'd');
        this.hashT.hashInsert("ged", 't');

        assertEquals('b', this.hashT.get("gggd"));
        assertEquals('c', this.hashT.get("gfgd"));
        assertEquals('d', this.hashT.get("gatr"));
        assertEquals('t', this.hashT.get("ged"));
    }

    @Test
    public void getOrDefaultTest1() {
        this.hashT.hashInsert("gggd", 'b');
        this.hashT.hashInsert("gfgd", 'c');
        this.hashT.hashInsert("gatr", 'd');
        this.hashT.hashInsert("ged", 't');

        assertEquals('b', this.hashT.getOrDefault("gggd", 'x'));
        assertEquals('c', this.hashT.getOrDefault("gfgd", 'y'));
        assertEquals('m', this.hashT.getOrDefault("gatro", 'm'));
        assertEquals('d', this.hashT.getOrDefault("gd", 'd'));
    }

    @Test
    public void growingMaintainsContentsTest1() {
        HashTable<Integer, Integer> hashtable = new HashTable<>();

        int n = 100;
        int[] set1 = new int[n];
        int[] set2 = new int[n];
        for (int i = 0; i < n; i++) {
            set1[i] = i + 1;
            set2[i] = 10 * (i + 1);
            hashtable.hashInsert(set1[i], set2[i]);
        }

        for (int i = 0; i < n; i++) {
            assertEquals(set2[i], (int) hashtable.get(set1[i]));
        }

    }

    @Test
    public void growingMaintainsContentsTest2() {
        HashTable<Integer, Integer> hashtable = new HashTable<>();

        int n = 100;
        int[] set1 = new int[n];
        int[] set2 = new int[n];
        for (int i = 0; i < n; i++) {
            set1[i] = i + 1;
            set2[i] = 10 * (i + 1);
            hashtable.hashInsert(set1[i], set2[i]);
        }

        for (int i = 0; i < n; i++) {
            assertEquals(set2[i], (int) hashtable.getOrDefault(set1[i], -1000));
        }

    }

    @Test
    public void shrinkingMaintainsContentsTest1() {
        HashTable<Integer, Integer> hashtable = new HashTable<>();

        int n = 20000;
        int[] set1 = new int[n];
        int[] set2 = new int[n];
        for (int i = 0; i < n; i++) {
            set1[i] = i + 1;
            set2[i] = 10 * (i + 1);
            hashtable.hashInsert(set1[i], set2[i]);
        }

        int remove = 10000;
        for (int i = 0; i < remove; i++) {
            hashtable.hashDelete(hashtable.hashSearch(set1[i]));
        }

        for (int i = remove; i < n; i++) {
            assertEquals(set2[i], (int) hashtable.get(set1[i]));
        }
    }

    @Test
    public void growWorksTest1() {
        HashTable<Integer, Integer> hashtable = new HashTable<>();
        assertEquals(47, hashtable.getTableCapacity());

        int n = 1000;
        int[] set1 = new int[n];
        int[] set2 = new int[n];
        for (int i = 0; i < n; i++) {
            set1[i] = i + 1;
            set2[i] = 10 * (i + 1);
            hashtable.hashInsert(set1[i], set2[i]);
        }

        assertEquals(1543, hashtable.getTableCapacity());
    }

    @Test
    public void shrinkWorksTest1() {
        HashTable<Integer, Integer> hashtable = new HashTable<>();
        assertEquals(47, hashtable.getTableCapacity());

        int n = 50_000;
        int[] set1 = new int[n];
        int[] set2 = new int[n];
        for (int i = 0; i < n; i++) {
            set1[i] = i + 1;
            set2[i] = 10 * (i + 1);
            hashtable.hashInsert(set1[i], set2[i]);
        }

        assertEquals(98317, hashtable.getTableCapacity());

        for (int i = 0; i < 30_000; i++) {
            hashtable.hashDelete(hashtable.hashSearch(set1[i]));
        }

        assertEquals(49_157, hashtable.getTableCapacity());
    }

    @Test
    public void removeTest1() {
        this.ht.hashInsert("aaaa", 42l);
        assertEquals(42l, (long) this.ht.get("aaaa"));
        this.ht.remove("aaaa");
        assertTrue(this.ht.get("aaaa") == null);
    }

    @Test
    public void removeTest2() {
        this.ht.remove("bbbb");
        assertTrue(this.ht.get("bbbb") == null);
    }

    @Test
    public void containsKeyTest1() {
        assertFalse(this.ht.containsKey("machine"));
        this.ht.hashInsert("machine", 1942l);
        assertTrue(this.ht.containsKey("machine"));
    }

    @Test
    public void containsKeyTest2() {
        assertFalse(this.ht.containsKey("machine"));
        this.ht.hashInsert("machine", 1942l);
        assertTrue(this.ht.containsKey("machine"));
        this.ht.remove("machine");
        assertFalse(this.ht.containsKey("machine"));
    }

    @Test
    public void containsKeyTest3() {
        this.ht.hashInsert("Machine", 1942l);
        assertFalse(this.ht.containsKey("machine"));
    }

    @Test
    public void tableSizeTest1() {
        HashTable<String, Integer> table = new HashTable<>(300_000_000);
        assertEquals(402_653_189, table.getTableCapacity());
    }

    @Test
    public void tableSizeTest2() {
        HashTable<String, Integer> table = new HashTable<>(-50);
        assertEquals(47, table.getTableCapacity());
    }

    @Test
    public void tableSizeTest3() {
        HashTable<String, Integer> table = new HashTable<>(3);
        assertEquals(11, table.getTableCapacity());
    }

    @Test
    public void deleteNonExistentListNodeTest1() {
        HashTable<Character, Integer> ht2 = new HashTable<>();
        assertEquals(0, ht2.getCurrentSize());
        ht2.hashDelete(null);
        assertEquals(0, ht2.getCurrentSize());
    }

    @Test
    public void deleteListNodeNotInTableTest1() {
        HashTable<Character, Integer> ht2 = new HashTable<>();
        ListNode x = new ListNode("node", 42, null, null);
        assertEquals(0, ht2.getCurrentSize());
        ht2.hashDelete(x);
        assertEquals(0, ht2.getCurrentSize());
    }
}
