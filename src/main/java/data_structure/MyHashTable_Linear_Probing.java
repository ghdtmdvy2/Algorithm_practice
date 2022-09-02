package data_structure;

public class MyHashTable_Linear_Probing {
    public Slot[] hashTable;

    public MyHashTable_Linear_Probing(Integer size) {
        this.hashTable = new Slot[size];
    }
    public class Slot {
        String value;
        String key;
        Slot(String key, String value) {
            this.value = value;
            this.key = key;
        }
    }

    public Integer hashKey(String key){
        return (int)key.charAt(0) % hashTable.length;
    }

    public boolean addSlot(String key, String value){
        Integer hashkey = hashKey(key);
        if (hashTable[hashkey] != null){
            if(hashTable[hashkey].key == key){
                hashTable[hashkey].value = value;
                return true;
            } else {

                int curaddress = hashkey + 1;
                while(hashTable[curaddress] != null){
                    curaddress++;
                    if (hashTable.length <= curaddress){
                        return false;
                    }
                }
                hashTable[curaddress] = new Slot(key, value);
                return true;
            }

        } else {
            hashTable[hashkey] = new Slot(key,value);
            return true;
        }
    }

    public String getSlot(String key){
        Integer hashkey = hashKey(key);
        if (hashTable[hashkey] != null){
            if(hashTable[hashkey].key == key){
                return hashTable[hashkey].value;
            } else {
                int curaddress = hashkey;
                while(hashTable[curaddress] != null){
                    if(hashTable[curaddress].key == key){
                        return hashTable[curaddress].value;
                    }
                    else {
                        curaddress++;
                        if (hashTable.length <= curaddress) {
                            return null;
                        }
                    }
                }
                return null;
            }

        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHashTable_Linear_Probing mainObject = new MyHashTable_Linear_Probing(20);
        mainObject.addSlot("DaveLee", "01022223333");
        System.out.println(mainObject.getSlot("Dave"));
    }
}
