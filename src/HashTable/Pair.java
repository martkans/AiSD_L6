package HashTable;

import java.util.Map;

public class Pair<K, V> implements Map.Entry {
    private K key;
    private V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public Object setValue(Object value) {
        this.value = (V) value;
        return null;
    }

    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return this.key + "=" + this.value;
    }
}
