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
public class ListNode<K, V> {

    private K key;
    private V value;
    protected ListNode next;
    protected ListNode prev;

    public ListNode(K key, V value, ListNode next, ListNode prev) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return value;
    }
}
