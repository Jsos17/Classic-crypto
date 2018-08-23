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
public class ListMember<T> {

    private final T object;
    protected ListMember next;
    protected ListMember prev;

    public ListMember(T object, ListMember next, ListMember prev) {
        this.object = object;
        this.next = next;
        this.prev = prev;
    }

    public T getObject() {
        return object;
    }
}
