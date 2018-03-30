import HashTable.*;

public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer, String> myHashTable = new MyHashTable_SC<>();
        myHashTable.put(43, "ania");
        System.out.println(myHashTable.isEmpty());
        System.out.println(myHashTable.size());
        System.out.println(myHashTable.containsKey(43));
        System.out.println(myHashTable.containsKey(433));
        System.out.println(myHashTable.containsValue("ania"));
        System.out.println(myHashTable.containsValue("aniasd"));
        System.out.println(myHashTable.get(43));
        System.out.println(myHashTable.get(434));
        System.out.println(myHashTable.remove(323));
        System.out.println(myHashTable.remove(43));
    }
}
