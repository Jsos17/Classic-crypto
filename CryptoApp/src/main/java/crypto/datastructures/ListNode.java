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
public class ListNode {
    
    private Object obj;
    public ListNode next;
    public ListNode prev;
    
    public ListNode(Object obj, ListNode next, ListNode prev) {
        this.obj = obj;
        this.next = next;
        this.prev = prev;
    }

    public Object getObj() {
        return obj;
    }
}
