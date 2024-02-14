public class Open_Hash_Table {
    private Entry[] table;
    private KS_Hash_Functions hash_Functions;
    private int capacity_Of_Table;
    private int baseValue;

    public Open_Hash_Table(int capacity) {
        this.capacity_Of_Table = capacity;
        table = new Entry[capacity];
        this.baseValue = 31;
        this.hash_Functions = new KS_Hash_Functions();
    }

    public void insert_Item(String key, int value) {
        int index = hash_Functions.hashFactory(key, baseValue, capacity_Of_Table);
        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + 1) % capacity_Of_Table;
        }
        table[index] = new Entry(key, value);
    }

    public void delete_Item(String key) {
        int index = hash_Functions.hashFactory(key, baseValue, capacity_Of_Table);
        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + 1) % capacity_Of_Table;
        }
        if (table[index] != null) {
            table[index] = null;
        }
    }

    public Integer get_Hash_Value(String key) {
        int index = hash_Functions.hashFactory(key, baseValue, capacity_Of_Table);
        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + 1) % capacity_Of_Table;
        }
        return table[index] != null ? table[index].value : null;
    }

    private static class Entry {
        String key;
        int value;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
