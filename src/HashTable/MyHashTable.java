package HashTable;

import java.util.*;

abstract public class MyHashTable<K,V> implements Map<K, V> {
    protected int size;

    public MyHashTable(){
        clear();
    }

    public MyHashTable(Map<? extends K, ? extends V> map){
        clear();
        putAll(map);
    }

    @Override
    abstract public boolean containsValue(Object value);

    @Override
    abstract public V get(Object key);

    @Override
    abstract public V put(K key, V value);

    @Override
    abstract public V remove(Object key);

    @Override
    abstract public void clear();

    @Override
    abstract public Set<K> keySet();

    @Override
    abstract public Collection<V> values();

    @Override
    abstract public Set<Entry<K, V>> entrySet();

    abstract public void show();

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized boolean isEmpty() {
        return size == 0;
    }

    @Override
    public synchronized boolean containsKey(Object key) {
        if (key == null) throw new NullPointerException();
        if (get(key) == null)
            return false;
        return true;
    }

    @Override
    public synchronized void putAll(Map<? extends K, ? extends V> map) {
        if (map == null) throw new NullPointerException();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public synchronized V getOrDefault(Object key, V defaultValue) {
        if (key == null || defaultValue == null) throw new NullPointerException();
        V value = get(key);
        if (value == null)
            return defaultValue;
        return value;
    }

    @Override
    public synchronized V putIfAbsent(K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
        V previousValue = get(key);
        if(previousValue == null)
            put(key, value);
        return previousValue;
    }

    @Override
    public synchronized boolean remove(Object key, Object value) {
        if (key == null || value == null) throw new NullPointerException();
        if (get(key) == value){
            remove(key);
            return true;
        }
        return false;
    }

    @Override
    public synchronized boolean replace(K key, V oldValue, V newValue) {
        if (key == null || newValue == null || oldValue == null) throw new NullPointerException();
        if (get(key) == oldValue){
            put(key, newValue);
            return true;
        }
        return false;
    }

    @Override
    public synchronized V replace(K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
        V previousValue = get(key);
        if (previousValue != null){
            put(key, value);
        }
        return previousValue;
    }
}
