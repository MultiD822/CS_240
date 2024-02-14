/*
Programmer: Kai Schenkel
Class: CS 240
Data: 2/13/2024
Data Strutures 3: Hash functions
File Name: Hash_Table.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing, plus the file from Algorithms 5 Hash functions
    the class file is called KS_Hash_Functions
*/
public class Hash_Table {
    private Link_List<String, Integer>[] table;
    private KS_Hash_Functions hash_Functions;
    private int capacity_Of_Table;
    private int baseValue;

    public Hash_Table (int capacity_Of_Table, int baseValue) {
        this.capacity_Of_Table = capacity_Of_Table;
        this.baseValue = baseValue;
        this.table = new Link_List[capacity_Of_Table];
        for (int i = 0; i < capacity_Of_Table; i++) {//Start of for loop
            table[i] = new Link_List<>();
        }//End of for loop
        this.hash_Functions = new KS_Hash_Functions();
    }

    public void insert_Item (String key, Integer index) {
        int hashValue = hash_Functions.hashFactory(key, baseValue, capacity_Of_Table);
        table[index].addNode_toFront(key, hashValue);
        System.out.printf("The key as been hashed and added to index %d\n", index);
    }

    public void delete_Item (String key) {
        int hashValue = hash_Functions.hashFactory(key, baseValue, capacity_Of_Table);
        table[hashValue].remove_Value();
        System.out.printf("The key %s has been removed from the hash table\n", key);
    }

    public int get_Hash_Value (String key) {
        int hashValue = hash_Functions.hashFactory(key, baseValue, capacity_Of_Table);
        return table[hashValue].headNode.value;
    }

    public void printTable() {
        for (int i = 0; i < capacity_Of_Table; i++) {
            System.out.println("Bucket " + i + ": ");
            if (table[i] != null) {
                table[i].printList();
            } else {
                System.out.println("Empty");
            }
        }
    }

    public void printHashValue(int index) {
        if (index >= 0 && index < capacity_Of_Table) {
            if (table[index] != null && table[index].headNode != null) {
                int hashValue = table[index].headNode.get_Value();
                System.out.println("The hash value at index " + index + " is: " + hashValue);
            } else {
                System.out.println("No elements at index " + index);
            }
        } else {
            System.out.println("Index out of range");
        }
    }

    public boolean isTableEmpty() {
        for (int i = 0; i < capacity_Of_Table; i++) {
            if (table[i] != null && table[i].headNode != null) {
                return false;
            }
        }
        return true;
    }

    public boolean isBucketEmpty(int index) {
        if (index >= 0 && index < capacity_Of_Table) {
            if (table[index] != null && table[index].headNode != null) {
                return false;
            }
        }
        return true;
    }
}
