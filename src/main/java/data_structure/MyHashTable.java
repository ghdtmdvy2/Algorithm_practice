package data_structure;

public class MyHashTable {
    Slot MyHashTable[];
    MyHashTable(int size){
        MyHashTable = new Slot[size];
    }
    public class Slot{
        String key;
        String value;
        Slot next;
        Slot(String key,String value){
            this.value = value;
            this.key = key;
            this.next = null;
        }
    }
    public Integer hashFun(String key){
        return (int)key.charAt(0) % this.MyHashTable.length;
    }
    public boolean saveValue(String key, String value){
        Integer address = hashFun(key);
        if (this.MyHashTable[address] != null){
            Slot findSlot = this.MyHashTable[address];
            Slot PrevSlot = this.MyHashTable[address];
            while(findSlot != null){
                if (findSlot.key == key){
                    findSlot.value = value;
                    return true;
                }
                else{
                    PrevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            PrevSlot.next = new Slot(key,value);
        }
        else {
            this.MyHashTable[address] = new Slot(key,value);
        }
        return true;
    }
    public String printHash(String key){
        Integer address = hashFun(key);
        if (this.MyHashTable[address] != null){
            Slot findSlot = this.MyHashTable[address];
            while(findSlot != null){
                if (findSlot.key == key){
                    return findSlot.value;
                }
                else{
                    findSlot = findSlot.next;
                }
            }
            return null;
        }
        else{
            return null;
        }
    }

    public static void main(String[] args) {
        MyHashTable myHashTable;
        myHashTable = new MyHashTable(20);
        myHashTable.saveValue("Hong","01029771985");
        myHashTable.saveValue("yong","01012341234");
        myHashTable.saveValue("Hviasadas","010595495459");
        System.out.println(myHashTable.printHash("Hong"));
        System.out.println(myHashTable.printHash("yong"));
        System.out.println(myHashTable.printHash("Hviasadas"));
    }
}
