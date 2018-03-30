import HashTable.*;

public class Main {
    public static void main(String[] args) {

        MyHashTable<Integer, String> myHashTable1 = new MyHashTable_OA<>();
        for (int i = 30; i < 70; i++)
            myHashTable1.put(i, "ala");

        myHashTable1.show();

        myHashTable1.put(34,"rekin");
        myHashTable1.put(87, "ewew");
        myHashTable1.remove(30);
        System.out.println(myHashTable1.get(87));
        myHashTable1.put(144,"gra");
        myHashTable1.show();
    }
}
