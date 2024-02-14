public class KL_Hash_Functions {
    
    public static int hashFunction(String input, int base, int capacity){
        int hash = 0;
        int length = input.length();
        for (int i = 0; i < length; i++) {
            hash = (base * hash + input.charAt(i)) % capacity;
        }
        return hash;
    }
}
