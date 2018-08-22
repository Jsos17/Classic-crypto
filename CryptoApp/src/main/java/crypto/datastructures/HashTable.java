/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.datastructures;

/**
 *
 * @author jpssilve
 */
public class HashTable<K, V> {

    private final int[] middlePrimes;
    private int index;
    private int tableSize;
    public DoublyLinkedList[] hashtable;
    private int currentSize;
    private final double HIGH_THRESHOLD;
    private final double LOW_THRESHOLD;
    private final int SHRINK_TRIGGER;

    public HashTable() {
        this.middlePrimes = new int[]{11, 23, 47, 97, 193, 389, 769, 1543, 3079, 6143,
            12_289, 24_571, 49_157, 98_317, 196_613, 393_209,
            786_433, 1_572_869, 3_145_721, 6_291_469, 12_582_917, 25_165_813,
            50_331_653, 100_663_291, 201_326_611, 402_653_189, 805_306_357, 1_610_612_741};
        this.index = 2;
        this.tableSize = this.middlePrimes[this.index];
        this.hashtable = new DoublyLinkedList[this.tableSize];
        this.currentSize = 0;
        this.HIGH_THRESHOLD = 0.75;
        this.LOW_THRESHOLD = 0.25;
        this.SHRINK_TRIGGER = 12_289;
    }

    /**
     * Currently, the prime number 402_653_189 is the biggest middle prime that
     * is approximately between successive powers of two, and does not cause
     * java.lang.OutOfMemoryError and thus Array size is limited to that.
     *
     * @param size
     */
    public HashTable(int size) {
        this.middlePrimes = new int[]{11, 23, 47, 97, 193, 389, 769, 1543, 3079, 6143,
            12_289, 24_571, 49_157, 98_317, 196_613, 393_209,
            786_433, 1_572_869, 3_145_721, 6_291_469, 12_582_917, 25_165_813,
            50_331_653, 100_663_291, 201_326_611, 402_653_189, 805_306_357, 1_610_612_741};

        if (size >= this.middlePrimes[this.middlePrimes.length - 1]) {
            this.index = this.middlePrimes.length - 3; // 402_653_189
        } else if (size > 0) {
            int i = 0;
            while (i < this.middlePrimes.length && size > this.middlePrimes[i]) {
                i++;
            }

            this.index = i;
        } else {
            this.index = 2;
        }

        this.tableSize = this.middlePrimes[this.index];
        this.hashtable = new DoublyLinkedList[this.tableSize];
        this.HIGH_THRESHOLD = 0.75;
        this.LOW_THRESHOLD = 0.25;
        this.SHRINK_TRIGGER = 12_289;
    }

    public int getTableSize() {
        return tableSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    protected int hashFunction(K key) {
        return (key.hashCode() & 0x7fffffff) % this.tableSize;
    }

    public ListNode hashSearch(K key) {
        if (this.hashtable[hashFunction(key)] == null) {
            return null;
        }

        return this.hashtable[hashFunction(key)].search(key);
    }

    public V get(K key) {
        ListNode node = hashSearch(key);
        if (node == null) {
            return null;
        }

        return (V) node.getValue();
    }

    public V getOrDefault(K key, V defaultValue) {
        ListNode node = hashSearch(key);
        if (node == null) {
            return defaultValue;
        }

        return (V) node.getValue();
    }

    public void hashInsert(K key, V value) {
        if (this.hashtable[hashFunction(key)] == null) {
            this.hashtable[hashFunction(key)] = new DoublyLinkedList();
        }

        this.hashtable[hashFunction(key)].insert(key, value);
        this.currentSize++;
        checkThreshold();
    }

    public void hashDelete(ListNode node) {
        K key = (K) node.getKey();
        if (this.hashtable[hashFunction(key)] == null) {
            return;
        }

        this.hashtable[hashFunction(key)].delete(node);
        this.currentSize--;
        checkThreshold();
    }

    private void checkThreshold() {
        double loadFactor = (double) this.currentSize / this.tableSize;
        if (loadFactor > this.HIGH_THRESHOLD) {
            grow();
        } else if (this.currentSize >= this.SHRINK_TRIGGER && loadFactor < this.LOW_THRESHOLD) {
            shrink();
        }
    }

    private void grow() {

    }

    private void shrink() {

    }

}
