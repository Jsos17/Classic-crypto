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
