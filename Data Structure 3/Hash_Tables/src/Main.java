/*
Programmer: Kai Schenkel
Class: CS 240
Data: 2/13/2024
Data Strutures 3: Hash functions
File Name: Main.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing, plus the file from Algorithms 5 Hash functions
    the class file is called KL_
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean programStillRunning = true; // Main loop control
        Scanner tremminalScanner = new Scanner(System.in);
        System.out.println("Welcome to the Hash Table program!");
        System.out.println("Please enter the capacity of the hash table: ");
        int capacity = tremminalScanner.nextInt();
        System.out.println("Please enter the base value for the hash function: ");
        int base = tremminalScanner.nextInt();
        Hash_Table hashTable = new Hash_Table(capacity, base);
        tremminalScanner.nextLine(); // Clear the buffer
        while (programStillRunning) {
            printOptions();
            String userInput = tremminalScanner.nextLine();
            switch (userInput.charAt(0)) {
                case 'i':
                    System.out.println("Please enter the key you would like to add: ");
                    String key = tremminalScanner.nextLine();
                    System.out.println("Please enter the Index of the bucket you would like to add the key to: ");
                    int index = tremminalScanner.nextInt();
                    tremminalScanner.nextLine(); // Clear the buffer
                    if (!hashTable.isBucketEmpty(index)) {
                        System.out.println("The bucket is not empty, would you like to overwrite the value? (y/n)");
                        String overwrite = tremminalScanner.nextLine();
                        if (overwrite.charAt(0) == 'n') {
                            break;
                        } else if (overwrite.charAt(0) != 'y') {
                            System.out.println("Invalid input, please try again");
                            break;
                        }
                    }
                    hashTable.insert_Item(key, index);
                    break;
                
                case 'd':
                    System.out.println("Please enter the key you would like to delete: ");
                    String deleteKey = tremminalScanner.nextLine();
                    tremminalScanner.nextLine(); // Clear the buffer
                    hashTable.delete_Item(deleteKey);
                    break;

                case 'g':
                    System.out.println("Please enter the key you would like to get the hash value of: ");
                    String getKey = tremminalScanner.nextLine();
                    tremminalScanner.nextLine(); // Clear the buffer
                    System.out.println("The hash value of " + getKey + " is: " + hashTable.get_Hash_Value(getKey));
                    break;
                
                case 'p':
                    hashTable.printTable();
                    break;
                
                case 'f':
                    System.out.println("Please enter the index of the hash value you would like to print: ");
                    int printIndex = tremminalScanner.nextInt();
                    tremminalScanner.nextLine(); // Clear the buffer
                    hashTable.printHashValue(printIndex);
                    break;
                
                case 'q':
                    programStillRunning = false;
                    break;
                
                default:
                    System.out.printf("[]======================================[]\n");
                    System.out.printf("[]That Seems to do Nothing... Weird     []\n");
                    System.out.printf("[]======================================[]\n");
                    break;
            }
        }
        tremminalScanner.close();
    }
    public static void printOptions() {
        System.out.println("[]================================================[]");
        System.out.println("[] 'i' Insert a key and value into the hash table []");
        System.out.println("[] 'd' Delete a key and value from the hash table []");
        System.out.println("[] 'g' Get the hash value of a key                []");
        System.out.println("[] 'p' Print the hash table                       []");
        System.out.println("[] 'f' Print the hash value at a specific index   []");
        System.out.println("[] 'q' Exit the program                           []");
        System.out.println("[]================================================[]");
    }
}
