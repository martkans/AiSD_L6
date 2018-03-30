import HashTable.*;

public class Main {
    public static void main(String[] args) {

        MyHashTable<Integer, String> hashtable = new MyHashTable_SC<>();
        for (int i = 23; i < 50; i++)
            hashtable.put(i,"ala");

        System.out.println(hashtable.entrySet());
    }
}
