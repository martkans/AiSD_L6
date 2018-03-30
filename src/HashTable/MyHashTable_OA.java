package HashTable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashTable_OA<K,V> extends MyHashTable<K,V> {

    public MyHashTable_OA(){
        super();
    }

    public MyHashTable_OA(Map<? extends K, ? extends V> map){
        super(map);
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
