/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.datastructures;

/**
 * All the methods follow closely the pseudo-code found in the lecture material
 * of the course Data structures and algorithms (University of Helsinki).
 *
 * @author jpssilve
 */
public class DoublyLinkedMemberList<T> {

    private ListMember head;
    private int size;

    public DoublyLinkedMemberList() {
        this.head = null;
        this.size = 0;
    }

    public boolean contains(T obj) {
        ListMember member = this.search(obj);
        return member != null;
    }

    private ListMember search(T obj) {
        ListMember member = this.head;
        while (member != null) {
            if (obj.equals(member.getObject())) {
                return member;
            }

            member = member.next;
        }

        return null;
    }

    /**
     * This method inserts an object to the list if it does not already contain
     * it. Thus this list can not contain duplicate objects.
     *
     * @param obj The object to be added
     * @return True if an object was added, and false if the object already
     * existed in the list (and thus it was not added)
     */
    public boolean insert(T obj) {
        if (!this.contains(obj)) {
            ListMember x = new ListMember(obj, null, null);
            x.next = this.head;
            x.prev = null;

            if (this.head != null) {
                ListMember succ = x.next;
                succ.prev = x;
            }

            this.head = x;
            this.size++;
            return true;
        }

        return false;
    }

    /**
     * A method for deleting objects from the list. The method first searches
     * the object from the list and if found deletes it.
     *
     * @param obj The object to be deleted
     * @return True, if the object was found and thus deleted, false otherwise
     */
    public boolean delete(T obj) {
        ListMember member = this.search(obj);
        if (member != null) {
            this.delete(member);
            return true;
        }

        return false;
    }

    private void delete(ListMember member) {
        ListMember pred = member.prev;
        ListMember succ = member.next;

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

    public ListMember getHead() {
        return head;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int getSize() {
        return this.size;
    }
}
