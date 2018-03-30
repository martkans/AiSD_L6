package HashTable;

import LinkedList.MyLinkedList;

import java.util.*;

public class MyHashTable_SC<K,V> extends MyHashTable<K,V> {

    private MyLinkedList<Pair>[] table;


    public MyHashTable_SC(){
        super();
    }

    public MyHashTable_SC(Map<? extends K, ? extends V> map){
        super(map);
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) throw new NullPointerException();
        V v = (V) value;
        for (MyLinkedList linkedList : table) {
            for (Object temp : linkedList) {
                Pair pair = (Pair) temp;
                if (pair.getValue() == v)
                    return true;
            }
        }
        return false;
    }

    @Override
    public synchronized V get(Object key) {
        if (key == null) throw new NullPointerException();
        K k = (K) key;
        int hash = k.hashCode() % table.length;
        for (Pair pair:table[hash])
            if (pair.getKey() == k)
                return (V)pair.getValue();
        return null;
    }

    @Override
    public synchronized V put(K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
        Pair<K, V> temp = new Pair<>(key,value);
        int hash = key.hashCode() % table.length;
        V previousValue = get(key);
        int i = 0;
        if (previousValue != null){
            while (table[hash].get(i).getKey() != key)
                i++;
            table[hash].set(i, temp);
        } else {
            table[hash].add(temp);
            size++;
        }
        return previousValue;
    }


    @Override
    public synchronized V remove(Object key) {
        if (key == null) throw new NullPointerException();
        K k = (K) key;
        int hash = k.hashCode() % table.length;
        int i = 0;
        V removeValue = null;
        for (Pair pair:table[hash]) {
            if (pair.getKey() == k){
                removeValue = (V)pair.getValue();
                break;
            }
            i++;
        }
        if (i != table[hash].size()){
            table[hash].remove(i);
            size--;
            return removeValue;
        }
        return null;
    }

    @Override
    public synchronized void clear() {
        size = 0;
        table = new MyLinkedList[11];
        for(int i = 0; i < table.length; i++)
            table[i] = new MyLinkedList<>();
    }

    @Override
    public synchronized Set<K> keySet() {
        if (isEmpty()) return null;
        Set<K> set = new HashSet<>();
        for (MyLinkedList linkedList : table) {
            for (Object temp : linkedList) {
                Pair pair = (Pair) temp;
                set.add((K)pair.getKey());
            }
        }
        return set;
    }

    @Override
    public synchronized Collection<V> values() {
        if (isEmpty()) return null;
        Collection<V> collection = new ArrayList<>();
        for (MyLinkedList linkedList : table) {
            for (Object temp : linkedList) {
                Pair pair = (Pair) temp;
                collection.add((V) pair.getValue());
            }
        }
        return collection;
    }

    @Override
    public Set<Entry<K,V>> entrySet() {
        if (isEmpty()) return null;
        Set<Entry<K, V>> set = new HashSet();
        for (MyLinkedList linkedList : table)
            for (Object temp : linkedList) {
                Pair pair = (Pair) temp;
                set.add(pair);
            }
        return set;
    }

//    @Override
//    public void show() { }
}
