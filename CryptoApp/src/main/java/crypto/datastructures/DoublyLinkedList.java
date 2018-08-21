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
public class DoublyLinkedList {

    private ListNode head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public ListNode search(Object obj) {
        ListNode p = this.head;
        while (p != null && !obj.equals(p.getObj())) {
            p = p.next;
        }

        return p;
    }

    public void insert(Object obj) {
        ListNode x = new ListNode(obj, null, null);
        x.next = this.head;
        x.prev = null;

        if (this.head != null) {
            ListNode succ = x.next;
            succ.prev = x;
        }

        this.head = x;
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
    }

    public ListNode getHead() {
        return head;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}
