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

    private final int MAXIMUM_ARRAY_SIZE;
    private final int[] middlePrimes;
    private int index;
    public DoublyLinkedList<K, V>[] hashtable;
    private int currentSize;
    private final double HIGH_THRESHOLD;
    private final double LOW_THRESHOLD;
    private final int SHRINK_TRIGGER;

    public HashTable() {
        this.MAXIMUM_ARRAY_SIZE = 402_653_189;
        this.middlePrimes = new int[]{11, 23, 47, 97, 193, 389, 769, 1543, 3079, 6143,
            12_289, 24_571, 49_157, 98_317, 196_613, 393_209,
            786_433, 1_572_869, 3_145_721, 6_291_469, 12_582_917, 25_165_813,
            50_331_653, 100_663_291, 201_326_611, 402_653_189, 805_306_357, 1_610_612_741};
        this.index = 2;
        this.hashtable = new DoublyLinkedList[this.middlePrimes[this.index]];
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
        this.MAXIMUM_ARRAY_SIZE = 402_653_189;
        this.middlePrimes = new int[]{11, 23, 47, 97, 193, 389, 769, 1543, 3079, 6143,
            12_289, 24_571, 49_157, 98_317, 196_613, 393_209,
            786_433, 1_572_869, 3_145_721, 6_291_469, 12_582_917, 25_165_813,
            50_331_653, 100_663_291, 201_326_611, 402_653_189, 805_306_357, 1_610_612_741};

        if (size >= this.middlePrimes[this.middlePrimes.length - 1]) {
            this.index = this.middlePrimes.length - 3; // the value at index: 402_653_189
        } else if (size > 0) {
            int i = 0;
            while (i < this.middlePrimes.length && size > this.middlePrimes[i]) {
                i++;
            }

            this.index = i;
        } else {
            this.index = 2;
        }

        this.hashtable = new DoublyLinkedList[this.middlePrimes[this.index]];
        this.HIGH_THRESHOLD = 0.75;
        this.LOW_THRESHOLD = 0.25;
        this.SHRINK_TRIGGER = 12_289;
    }

    public int getMaxArrayCapacity() {
        return this.hashtable.length;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    protected int hashFunction(K key) {
        return (key.hashCode() & 0x7fffffff) % this.hashtable.length;
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
        if (node == null) {
            return;
        }

        K key = (K) node.getKey();
        if (this.hashtable[hashFunction(key)] == null) {
            return;
        }

        this.hashtable[hashFunction(key)].delete(node);
        this.currentSize--;
        checkThreshold();
    }

    private void checkThreshold() {
        double loadFactor = (double) this.currentSize / this.hashtable.length;
        if (loadFactor > this.HIGH_THRESHOLD) {
            grow();
        } else if (this.currentSize >= this.SHRINK_TRIGGER && loadFactor < this.LOW_THRESHOLD) {
            shrink();
        }
    }

    private void grow() {
        if (this.hashtable.length >= this.MAXIMUM_ARRAY_SIZE) {
            return;
        }

        this.index++;
        reHash(this.middlePrimes[this.index]);
    }

    private void shrink() {
        this.index--;
        if (this.index < 0) {
            return;
        }

        reHash(this.middlePrimes[this.index]);
    }

    private void reHash(int newSize) {
        DoublyLinkedList<K, V>[] newTable = new DoublyLinkedList[newSize];
        int newCurrSize = 0;

        for (int i = 0; i < this.hashtable.length; i++) {
            if (this.hashtable[i] != null) {
                ListNode x = this.hashtable[i].getHead();
                while (x != null) {
                    int hash = (x.getKey().hashCode() & 0x7fffffff) % newSize;
                    if (newTable[hash] == null) {
                        newTable[hash] = new DoublyLinkedList<>();
                    }

                    newTable[hash].insert((K) x.getKey(), (V) x.getValue());
                    newCurrSize++;
                    x = x.next;
                }
            }
        }

        this.hashtable = newTable;
        this.currentSize = newCurrSize;
    }
}
