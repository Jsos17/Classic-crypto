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
    private int size;
    private DoublyLinkedList[] hashtable;
    private final double THRESHOLD;
    
    

    public HashTable() {
        this.middlePrimes = new int[]{11, 23, 47, 97, 193, 389, 769, 1543, 3079, 6143,
            12_289, 24_571, 49_157, 98_317, 196_613, 393_209,
            786_433, 1_572_869, 3_145_721, 6_291_469, 12_582_917, 25_165_813,
            50_331_653, 100_663_291, 201_326_611, 402_653_189, 805_306_357, 1_610_612_741};
        this.index = 2;
        this.size = this.middlePrimes[this.index];
        this.hashtable = new DoublyLinkedList[this.size];
        this.THRESHOLD = 0.75;
 
//        for (int i = 0; i < this.middlePrimes.length - 1; i++) {
//            System.out.println((double) this.middlePrimes[i+1] / this.middlePrimes[i]);
//        }
    }
    
    public HashTable(int size) {
        this.middlePrimes = new int[]{11, 23, 47, 97, 193, 389, 769, 1543, 3079, 6143,
            12_289, 24_571, 49_157, 98_317, 196_613, 393_209,
            786_433, 1_572_869, 3_145_721, 6_291_469, 12_582_917, 25_165_813,
            50_331_653, 100_663_291, 201_326_611, 402_653_189, 805_306_357, 1_610_612_741};
        
        if (size > 0) {
            int i = 0;
            while (i < this.middlePrimes.length && size >= this.middlePrimes[i]) {
                i++;
            }
            this.index = i;
        } else {
            this.index = 2;
        }
        
        this.size = this.middlePrimes[this.index];
        this.hashtable = new DoublyLinkedList[this.size];
        this.THRESHOLD = 0.75;
    }
}
