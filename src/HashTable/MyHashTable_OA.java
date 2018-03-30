package HashTable;

import java.util.*;

public class MyHashTable_OA<K,V> extends MyHashTable<K,V> {
    private Pair<K,V>[] table;

    public MyHashTable_OA(){
        super();
    }

    public MyHashTable_OA(Map<? extends K, ? extends V> map){
        super(map);
    }

    @Override
    public synchronized boolean containsValue(Object value) {
        if (value == null) throw new NullPointerException();
        for(Pair pair:table)
            if (pair != null)
                if (pair.getValue() == value)
                    return true;
        return false;
    }

    @Override
    public synchronized V get(Object key) {
        if (key == null) throw new NullPointerException();
        int hash = key.hashCode() % table.length;
        int j = 1;
        while (table[hash] != null){
            if (table[hash].getKey() == (K) key)
                return table[hash].getValue();
            hash = (key.hashCode() + j++) % table.length;
        }
        return null;
    }

    @Override
    public synchronized V put(K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
        rehash();
        int hash = key.hashCode() % table.length;
        int j = 1;
        while (table[hash] != null){
            if (table[hash].getKey() == key){
                V tempValue = table[hash].getValue();
                table[hash].setValue(value);
                return tempValue;
            }
            if (table[hash].getKey() == null) {
                V tempValue = table[hash].getValue();
                table[hash].setKey(key);
                table[hash].setValue(value);
                return tempValue;
            }
            hash = (key.hashCode() + j++) % table.length;
        }
        table[hash] = new Pair<>(key, value);
        size++;
        return null;
    }

    @Override
    public synchronized V remove(Object key) {
        if (key == null) throw new NullPointerException();
        int hash = key.hashCode() % table.length;
        int j = 1;
        V value = null;
        while (table[hash] != null){
            if (table[hash].getKey() == key)
                break;
            hash = (key.hashCode() + j++) % table.length;
        }
        if (table[hash] != null){
            value = table[hash].getValue();
            table[hash].setValue(null);
            table[hash].setKey(null);
            size--;
        }
        return value;
    }

    @Override
    public synchronized void clear() {
        size = 0;
        table = new Pair[11];
        for (int i = 0; i < table.length; i++)
            table[i] = null;
    }

    @Override
    public synchronized Set<K> keySet() {
        if (isEmpty()) return null;
        Set<K> set = new HashSet<>();
        for (Pair pair: table)
            if (pair != null)
                if (pair.getKey() != null)
                    set.add((K)pair.getKey());
        return set;
    }

    @Override
    public synchronized Collection<V> values() {
        if (isEmpty()) return null;
        Collection<V> collection = new ArrayList<>();
        for (Pair pair: table)
            if (pair != null)
                if (pair.getValue() != null)
                    collection.add((V)pair.getValue());
        return collection;
    }

    @Override
    public synchronized Set<Entry<K, V>> entrySet() {
        if (isEmpty()) return null;
        Set<Entry<K,V>> set = new HashSet();
        for (Pair pair: table)
            if (pair != null)
                if (pair.getKey() != null)
                    set.add(pair);
        return set;
    }

    private synchronized void rehash(){
        if (size >= 0.75*table.length) {
            Pair<K, V>[] tempTable = table;
            int newSize = (int) Math.ceil(table.length * 1.1);
            table = new Pair[newSize];
            for (int i = 0; i < tempTable.length; i++) {
                if (tempTable[i] != null) {
                    K key = tempTable[i].getKey();
                    V value = tempTable[i].getValue();
                    int hash = key.hashCode() % newSize;
                    int j = 1;
                    while (table[hash] != null)
                        hash = (key.hashCode() + j++) % newSize;
                    table[hash] = new Pair<>(key, value);
                }
            }
        }
    }

//    public void show(){
//        for (int i = 0; i < table.length; i++){
//            if (table[i] == null)
//                System.out.println("[" + i + "] null");
//            else
//                System.out.println("[" + i + "] " + table[i].getKey() + " = " + table[i].getValue());
//        }
//    }
}
