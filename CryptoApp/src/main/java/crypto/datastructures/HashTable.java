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
public class HashTable {

    private final int[] middlePrimes;
    private int index;
    private int tableSize;
    private DoublyLinkedList[] hashtable;
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

    public HashTable(int size) {
        this.middlePrimes = new int[]{11, 23, 47, 97, 193, 389, 769, 1543, 3079, 6143,
            12_289, 24_571, 49_157, 98_317, 196_613, 393_209,
            786_433, 1_572_869, 3_145_721, 6_291_469, 12_582_917, 25_165_813,
            50_331_653, 100_663_291, 201_326_611, 402_653_189, 805_306_357, 1_610_612_741};

        if (size >= this.middlePrimes[this.middlePrimes.length - 1]) {
            this.index = this.middlePrimes.length - 3;
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

    protected int hashFunction(Object obj) {
        return obj.hashCode() % this.tableSize;
    }

    public ListNode hashSearch(Object obj) {
        if (this.hashtable[hashFunction(obj)] == null) {
            return null;
        }

        DoublyLinkedList list = this.hashtable[hashFunction(obj)];
        return list.search(obj);
    }

    public void hashInsert(Object obj) {
        if (this.hashtable[hashFunction(obj)] == null) {
            this.hashtable[hashFunction(obj)] = new DoublyLinkedList();
        }

        DoublyLinkedList list = this.hashtable[hashFunction(obj)];
        list.insert(obj);
        this.currentSize++;
        checkThreshold();
    }

    public void hashDelete(ListNode node) {
        if (this.hashtable[hashFunction(node.getObj())] == null) {
            return;
        }

        DoublyLinkedList list = this.hashtable[hashFunction(node.getObj())];
        list.delete(node);
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
