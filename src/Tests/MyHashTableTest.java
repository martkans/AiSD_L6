import HashTable.MyHashTable;
import HashTable.MyHashTable_OA;
import HashTable.MyHashTable_SC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MyHashTableTest {
    MyHashTable<Integer, String> integerStringMyHashTable_SC;

    MyHashTable<Integer, String> integerStringMyHashTable_OA;
    @BeforeEach
    void prepare(){
        integerStringMyHashTable_SC = new MyHashTable_SC<>();

        integerStringMyHashTable_OA = new MyHashTable_OA<>();
    }

    @Test
    void containsKey() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.containsKey(null));

        assertEquals(false, integerStringMyHashTable_SC.containsKey(34));
        assertEquals(false, integerStringMyHashTable_SC.containsKey("ds"));

        integerStringMyHashTable_SC.put(34,"ala");

        assertEquals(true, integerStringMyHashTable_SC.containsKey(34));
}

    @Test
    void containsValue() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.containsValue(null));

        assertEquals(false, integerStringMyHashTable_SC.containsValue(34));
        assertEquals(false, integerStringMyHashTable_SC.containsValue("ds"));

        integerStringMyHashTable_SC.put(34,"ala");

        assertEquals(true, integerStringMyHashTable_SC.containsValue("ala"));
    }

    @Test
    void get() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.get(null));

        assertEquals(null, integerStringMyHashTable_SC.get(323));

        integerStringMyHashTable_SC.put(34,"ala");

        assertEquals("ala", integerStringMyHashTable_SC.get(34));
    }

    @Test
    void put() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.put(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.put(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.put(null, "ala"));

        assertEquals(null, integerStringMyHashTable_SC.put(34,"ala"));
        assertEquals("ala", integerStringMyHashTable_SC.put(34, "grzegorz"));
    }

    @Test
    void remove() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.remove(null));

        assertEquals(null, integerStringMyHashTable_SC.remove(34));
        assertEquals(null, integerStringMyHashTable_SC.remove("ala"));

        integerStringMyHashTable_SC.put(34,"ala");

        assertEquals("ala", integerStringMyHashTable_SC.remove(34));
    }

    @Test
    void keySet() {
        assertEquals(null, integerStringMyHashTable_SC.keySet());
        integerStringMyHashTable_SC.put(1, "ala");
        integerStringMyHashTable_SC.put(2, "ma");
        integerStringMyHashTable_SC.put(3, "kota");
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        Set<Integer> set = integerStringMyHashTable_SC.keySet();

        assertEquals(hashSet, set);
    }

    @Test
    void values() {
        assertEquals(null, integerStringMyHashTable_SC.values());
        integerStringMyHashTable_SC.put(1, "ala");
        integerStringMyHashTable_SC.put(2, "ma");
        integerStringMyHashTable_SC.put(3, "kota");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ala");
        arrayList.add("ma");
        arrayList.add("kota");

        Collection<String> collection = integerStringMyHashTable_SC.values();

        assertEquals(arrayList, collection);
    }

    @Test
    void entrySet() {
    }

    @Test
    void putAll() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.putAll(null));
    }

    @Test
    void getOrDefault() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.getOrDefault(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.getOrDefault(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.getOrDefault(null, "ala"));

        assertEquals("ala", integerStringMyHashTable_SC.getOrDefault(34, "ala"));
        integerStringMyHashTable_SC.put(34, "ala");
        assertEquals("ala", integerStringMyHashTable_SC.getOrDefault(34, "ffff"));
    }

    @Test
    void putIfAbsent() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.putIfAbsent(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.putIfAbsent(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.putIfAbsent(null, "ala"));

        assertEquals(null, integerStringMyHashTable_SC.putIfAbsent(34, "ala"));
        assertEquals("ala", integerStringMyHashTable_SC.putIfAbsent(34, "ffff"));
    }

    @Test
    void remove1() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.remove(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.remove(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.remove(null, "ala"));

        assertEquals(false, integerStringMyHashTable_SC.remove(34, "ala"));
        integerStringMyHashTable_SC.put(34, "ala");
        assertEquals(false, integerStringMyHashTable_SC.remove(34, "g"));
        assertEquals(false, integerStringMyHashTable_SC.remove(2, "ala"));
        assertEquals(1, integerStringMyHashTable_SC.size());
        assertEquals(true, integerStringMyHashTable_SC.remove(34, "ala"));
        assertEquals(0, integerStringMyHashTable_SC.size());
    }

    @Test
    void replace() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.replace(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.replace(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.replace(null, "ala"));

        assertEquals(null, integerStringMyHashTable_SC.replace(34, "ala"));
        integerStringMyHashTable_SC.put(34, "ala");
        assertEquals("ala", integerStringMyHashTable_SC.replace(34, "dom"));
    }

    @Test
    void replace1() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.replace(null, null, null));

        assertEquals(false, integerStringMyHashTable_SC.replace(34, "ala", "as"));
        integerStringMyHashTable_SC.put(34, "ala");
        assertEquals(false, integerStringMyHashTable_SC.replace(34, "a", "as"));
        assertEquals(false, integerStringMyHashTable_SC.replace(33, "ala", "as"));
        assertEquals(true, integerStringMyHashTable_SC.replace(34, "ala", "a"));
        assertEquals("a", integerStringMyHashTable_SC.get(34));
    }
}