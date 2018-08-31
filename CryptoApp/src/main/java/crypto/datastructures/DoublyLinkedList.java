/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.datastructures;

/**
 * All the methods follow closely the pseudo-code found in the lecture material
 * of the course Data structures and algorithms (University of Helsinki)
 *
 * @author jpssilve
 */
public class DoublyLinkedList<K, V> {

    private ListNode head;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public ListNode search(K key) {
        ListNode p = this.head;
        while (p != null && !key.equals(p.getKey())) {
            p = p.next;
        }

        return p;
    }

    public void insert(K key, V value) {
        ListNode x = new ListNode(key, value, null, null);
        x.next = this.head;
        x.prev = null;

        if (this.head != null) {
            ListNode succ = x.next;
            succ.prev = x;
        }

        this.head = x;
        this.size++;

    }

    public void delete(ListNode x) {
        ListNode pred = x.prev;
        ListNode succ = x.next;

        if (pred != null) {
            pred.next = succ;
        } else {
            this.head = succ;
        }

        if (succ != null) {
            succ.prev = pred;
        }

        this.size--;
    }

    public ListNode getHead() {
        return head;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int getSize() {
        return this.size;
    }
}
