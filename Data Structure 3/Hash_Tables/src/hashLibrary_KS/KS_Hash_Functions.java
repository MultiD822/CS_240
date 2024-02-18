/*
Programmer: Kai Schenkel
Class: CS 240
Data: 2/13/2024
Data Strutures 3: Hash functions
File Name: Ks_Hash_Functions.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing, GeekforGeeks website
*/

package hashLibrary_KS;

public class KS_Hash_Functions {
    //
    public int hashFactory(String input, int base, int capacity){
        if (input.isEmpty()){
            return 0;
        }
        int hash = 0;
        int length = input.length();
        for (int i = 0; i < length; i++) {
            hash = (base * hash + input.charAt(i)) % capacity;
        }
        return hash;
    }

    public boolean isHashPrime(int hashValue){
        if (hashValue <= 1) return false;
        if (hashValue <= 3) return true;
        if (hashValue % 2 == 0 || hashValue % 3 == 0) return false;
        for (int i = 5; i * i <= hashValue; i += 6){
            if (hashValue % i == 0 || hashValue % (i + 2) == 0) return false;
        }
        return true;
    }

    public int nearestBigPrime (int hashValue) {
        hashValue = hashValue % 2 == 0 ? hashValue + 1 : hashValue + 2; //Sets hash value to the next odd number
        while (!isHashPrime(hashValue)) {
            hashValue += 2; // Only checks odd numbers
        }
        return hashValue;
    }
}
