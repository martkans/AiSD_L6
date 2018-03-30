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
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.containsKey(null));

        assertEquals(false, integerStringMyHashTable_SC.containsKey(34));
        assertEquals(false, integerStringMyHashTable_SC.containsKey("ds"));
        assertEquals(false, integerStringMyHashTable_OA.containsKey(34));
        assertEquals(false, integerStringMyHashTable_OA.containsKey("ds"));

        integerStringMyHashTable_SC.put(34,"ala");
        integerStringMyHashTable_OA.put(34,"ala");

        assertEquals(true, integerStringMyHashTable_SC.containsKey(34));
        assertEquals(true, integerStringMyHashTable_OA.containsKey(34));
}

    @Test
    void containsValue() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.containsValue(null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.containsValue(null));

        assertEquals(false, integerStringMyHashTable_SC.containsValue(34));
        assertEquals(false, integerStringMyHashTable_SC.containsValue("ds"));
        assertEquals(false, integerStringMyHashTable_OA.containsValue(34));
        assertEquals(false, integerStringMyHashTable_OA.containsValue("ds"));

        integerStringMyHashTable_SC.put(34,"ala");
        integerStringMyHashTable_OA.put(34,"ala");

        assertEquals(true, integerStringMyHashTable_SC.containsValue("ala"));
        assertEquals(true, integerStringMyHashTable_OA.containsValue("ala"));
    }

    @Test
    void get() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.get(null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.get(null));

        assertEquals(null, integerStringMyHashTable_SC.get(323));
        assertEquals(null, integerStringMyHashTable_OA.get(323));

        integerStringMyHashTable_SC.put(34,"ala");
        integerStringMyHashTable_OA.put(34,"ala");

        assertEquals("ala", integerStringMyHashTable_SC.get(34));
        assertEquals("ala", integerStringMyHashTable_OA.get(34));
    }

    @Test
    void put() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.put(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.put(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.put(null, "ala"));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.put(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.put(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.put(null, "ala"));

        assertEquals(null, integerStringMyHashTable_SC.put(34,"ala"));
        assertEquals("ala", integerStringMyHashTable_SC.put(34, "grzegorz"));
        assertEquals(null, integerStringMyHashTable_OA.put(34,"ala"));
        assertEquals("ala", integerStringMyHashTable_OA.put(34, "grzegorz"));
        for (int i = 0; i < 30; i++){
            integerStringMyHashTable_OA.put(i,"ala");
        }

        assertEquals(31, integerStringMyHashTable_OA.size());
    }

    @Test
    void remove() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.remove(null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.remove(null));

        assertEquals(null, integerStringMyHashTable_SC.remove(34));
        assertEquals(null, integerStringMyHashTable_SC.remove("ala"));
        assertEquals(null, integerStringMyHashTable_OA.remove(34));
        assertEquals(null, integerStringMyHashTable_OA.remove("ala"));

        integerStringMyHashTable_SC.put(34,"ala");
        integerStringMyHashTable_OA.put(34,"ala");

        assertEquals("ala", integerStringMyHashTable_SC.remove(34));
        assertEquals("ala", integerStringMyHashTable_OA.remove(34));
    }

    @Test
    void keySet() {
        assertEquals(null, integerStringMyHashTable_SC.keySet());
        assertEquals(null, integerStringMyHashTable_OA.keySet());

        integerStringMyHashTable_SC.put(1, "ala");
        integerStringMyHashTable_SC.put(2, "ma");
        integerStringMyHashTable_SC.put(3, "kota");
        integerStringMyHashTable_OA.put(1, "ala");
        integerStringMyHashTable_OA.put(2, "ma");
        integerStringMyHashTable_OA.put(3, "kota");

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        Set<Integer> set = integerStringMyHashTable_SC.keySet();
        assertEquals(hashSet, set);

        set = integerStringMyHashTable_OA.keySet();
        assertEquals(hashSet, set);
    }

    @Test
    void values() {
        assertEquals(null, integerStringMyHashTable_SC.values());
        assertEquals(null, integerStringMyHashTable_OA.values());

        integerStringMyHashTable_SC.put(1, "ala");
        integerStringMyHashTable_SC.put(2, "ma");
        integerStringMyHashTable_SC.put(3, "kota");
        integerStringMyHashTable_OA.put(1, "ala");
        integerStringMyHashTable_OA.put(2, "ma");
        integerStringMyHashTable_OA.put(3, "kota");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ala");
        arrayList.add("ma");
        arrayList.add("kota");

        Collection<String> collection = integerStringMyHashTable_SC.values();
        assertEquals(arrayList, collection);

        collection = integerStringMyHashTable_OA.values();
        assertEquals(arrayList, collection);
    }

    @Test
    void entrySet() {
    }

    @Test
    void putAll() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.putAll(null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.putAll(null));
    }

    @Test
    void getOrDefault() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.getOrDefault(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.getOrDefault(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.getOrDefault(null, "ala"));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.getOrDefault(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.getOrDefault(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.getOrDefault(null, "ala"));

        assertEquals("ala", integerStringMyHashTable_SC.getOrDefault(34, "ala"));
        integerStringMyHashTable_SC.put(34, "ala");
        assertEquals("ala", integerStringMyHashTable_SC.getOrDefault(34, "ffff"));

        assertEquals("ala", integerStringMyHashTable_OA.getOrDefault(34, "ala"));
        integerStringMyHashTable_OA.put(34, "ala");
        assertEquals("ala", integerStringMyHashTable_OA.getOrDefault(34, "ffff"));
    }

    @Test
    void putIfAbsent() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.putIfAbsent(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.putIfAbsent(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.putIfAbsent(null, "ala"));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.putIfAbsent(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.putIfAbsent(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.putIfAbsent(null, "ala"));

        assertEquals(null, integerStringMyHashTable_SC.putIfAbsent(34, "ala"));
        assertEquals("ala", integerStringMyHashTable_SC.putIfAbsent(34, "ffff"));
        assertEquals(null, integerStringMyHashTable_OA.putIfAbsent(34, "ala"));
        assertEquals("ala", integerStringMyHashTable_OA.putIfAbsent(34, "ffff"));
    }

    @Test
    void remove1() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.remove(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.remove(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.remove(null, "ala"));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.remove(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.remove(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.remove(null, "ala"));

        assertEquals(false, integerStringMyHashTable_SC.remove(34, "ala"));
        integerStringMyHashTable_SC.put(34, "ala");
        assertEquals(false, integerStringMyHashTable_SC.remove(34, "g"));
        assertEquals(false, integerStringMyHashTable_SC.remove(2, "ala"));
        assertEquals(1, integerStringMyHashTable_SC.size());
        assertEquals(true, integerStringMyHashTable_SC.remove(34, "ala"));
        assertEquals(0, integerStringMyHashTable_SC.size());

        assertEquals(false, integerStringMyHashTable_OA.remove(34, "ala"));
        integerStringMyHashTable_OA.put(34, "ala");
        assertEquals(false, integerStringMyHashTable_OA.remove(34, "g"));
        assertEquals(false, integerStringMyHashTable_OA.remove(2, "ala"));
        assertEquals(1, integerStringMyHashTable_OA.size());
        assertEquals(true, integerStringMyHashTable_OA.remove(34, "ala"));
        assertEquals(0, integerStringMyHashTable_OA.size());
    }

    @Test
    void replace() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.replace(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.replace(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.replace(null, "ala"));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.replace(null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.replace(34, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.replace(null, "ala"));

        assertEquals(null, integerStringMyHashTable_SC.replace(34, "ala"));
        integerStringMyHashTable_SC.put(34, "ala");
        assertEquals("ala", integerStringMyHashTable_SC.replace(34, "dom"));

        assertEquals(null, integerStringMyHashTable_OA.replace(34, "ala"));
        integerStringMyHashTable_OA.put(34, "ala");
        assertEquals("ala", integerStringMyHashTable_OA.replace(34, "dom"));
    }

    @Test
    void replace1() {
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_SC.replace(null, null, null));
        assertThrows(NullPointerException.class, () -> integerStringMyHashTable_OA.replace(null, null, null));

        assertEquals(false, integerStringMyHashTable_SC.replace(34, "ala", "as"));
        integerStringMyHashTable_SC.put(34, "ala");
        assertEquals(false, integerStringMyHashTable_SC.replace(34, "a", "as"));
        assertEquals(false, integerStringMyHashTable_SC.replace(33, "ala", "as"));
        assertEquals(true, integerStringMyHashTable_SC.replace(34, "ala", "a"));
        assertEquals("a", integerStringMyHashTable_SC.get(34));

        assertEquals(false, integerStringMyHashTable_OA.replace(34, "ala", "as"));
        integerStringMyHashTable_OA.put(34, "ala");
        assertEquals(false, integerStringMyHashTable_OA.replace(34, "a", "as"));
        assertEquals(false, integerStringMyHashTable_OA.replace(33, "ala", "as"));
        assertEquals(true, integerStringMyHashTable_OA.replace(34, "ala", "a"));
        assertEquals("a", integerStringMyHashTable_OA.get(34));
    }
}