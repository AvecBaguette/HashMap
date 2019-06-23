public class HashMapNode<K, V> {
    private final K key;
    private V value;
    protected HashMapNode next;

    public HashMapNode(K key, V value, HashMapNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public int index() {
        return hashCode() % 10;
    }

    public int hashCode() {
        String s = "" + key;
        return s.charAt(0) * s.charAt(s.length() - 1);
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "{"+ this.key + "=" + this.value + "}";
    }
}
