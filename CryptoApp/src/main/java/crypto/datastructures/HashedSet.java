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
public class HashedSet<T> {

    private final int MAXIMUM_ARRAY_SIZE;
    private final int[] middlePrimes;
    private int index;
    public DoublyLinkedMemberList<T>[] hashtable;
    private int currentSize;
    private final double HIGH_THRESHOLD;
    private final double LOW_THRESHOLD;

    public HashedSet() {
        this.MAXIMUM_ARRAY_SIZE = 100_663_291;
        this.middlePrimes = new int[]{11, 23, 47, 97, 193, 389, 769, 1543, 3079, 6143,
            12_289, 24_571, 49_157, 98_317, 196_613, 393_209,
            786_433, 1_572_869, 3_145_721, 6_291_469, 12_582_917, 25_165_813,
            50_331_653, 100_663_291, 201_326_611, 402_653_189, 805_306_357, 1_610_612_741};
        this.index = 2;
        this.hashtable = new DoublyLinkedMemberList[this.middlePrimes[this.index]];
        this.currentSize = 0;
        this.HIGH_THRESHOLD = 0.75;
        this.LOW_THRESHOLD = 0.25;
    }

    /**
     * Large array sizes cause java.lang.OutOfMemoryError and thus there is an
     * attempt to mitigate this problem by restricting the maximum array size to
     * 100_663_291, since on different machines different values cause problems,
     * but there is no guarantee that this is a small enough value.
     *
     * @param size
     */
    public HashedSet(int size) {
        this.MAXIMUM_ARRAY_SIZE = 100_663_291;
        this.middlePrimes = new int[]{11, 23, 47, 97, 193, 389, 769, 1543, 3079, 6143,
            12_289, 24_571, 49_157, 98_317, 196_613, 393_209,
            786_433, 1_572_869, 3_145_721, 6_291_469, 12_582_917, 25_165_813,
            50_331_653, 100_663_291, 201_326_611, 402_653_189, 805_306_357, 1_610_612_741};

        if (size >= this.middlePrimes[this.middlePrimes.length - 3]) {
            this.index = this.middlePrimes.length - 5; // the value at index: 100_663_291
        } else if (size > 0) {
            int i = 0;
            while (i < this.middlePrimes.length && size > this.middlePrimes[i]) {
                i++;
            }

            this.index = i;
        } else {
            this.index = 2;
        }

        this.hashtable = new DoublyLinkedMemberList[this.middlePrimes[this.index]];
        this.HIGH_THRESHOLD = 0.75;
        this.LOW_THRESHOLD = 0.25;
    }

    public int getTableCapacity() {
        return this.hashtable.length;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    protected int hashFunction(T obj) {
        return (obj.hashCode() & 0x7fffffff) % this.hashtable.length;
    }

    public boolean contains(T object) {
        if (this.hashtable[this.hashFunction(object)] == null) {
            return false;
        }

        return this.hashtable[this.hashFunction(object)].contains(object);
    }

    public void insert(T object) {
        if (this.hashtable[this.hashFunction(object)] == null) {
            this.hashtable[this.hashFunction(object)] = new DoublyLinkedMemberList<>();
        }

        if (this.hashtable[this.hashFunction(object)].insert(object)) {
            this.currentSize++;
            this.checkThreshold();
        }
    }

    public void delete(T object) {
        if (this.hashtable[this.hashFunction(object)] != null) {
            if (this.hashtable[this.hashFunction(object)].delete(object)) {
                this.currentSize--;
                this.checkThreshold();
            }
        }
    }

    private void checkThreshold() {
        double loadFactor = (double) this.currentSize / this.hashtable.length;
        if (loadFactor > this.HIGH_THRESHOLD) {
            grow();
        } else if (loadFactor < this.LOW_THRESHOLD) {
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
        if (this.index >= 0) {
            reHash(this.middlePrimes[this.index]);
        }
    }

    private void reHash(int newSize) {
        DoublyLinkedMemberList<T>[] newTable = new DoublyLinkedMemberList[newSize];
        int newCurrSize = 0;

        for (int i = 0; i < this.hashtable.length; i++) {
            if (this.hashtable[i] != null) {
                ListMember member = this.hashtable[i].getHead();
                while (member != null) {
                    int hash = (member.getObject().hashCode() & 0x7fffffff) % newSize;
                    if (newTable[hash] == null) {
                        newTable[hash] = new DoublyLinkedMemberList<>();
                    }

                    newTable[hash].insert((T) member.getObject());
                    newCurrSize++;
                    member = member.next;
                }
            }
        }

        this.hashtable = newTable;
        this.currentSize = newCurrSize;
    }
}
