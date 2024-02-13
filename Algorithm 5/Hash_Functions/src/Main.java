/*
Programmer: Kai Schenkel
Class: CS 240
Data: 2/12/2024
Algorithms HW 5 : Hash functions
File Name: Main.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean programStillRunning = true; // Main loop control
        int base = 31;
        int capacity = 100;
        Scanner tremminalScanner = new Scanner(System.in);
        while(programStillRunning){ // Menu While loop
            printMenu();
            String userInput = tremminalScanner.nextLine();
            switch (userInput.charAt(0)) {
                case 'h':
                    System.out.println("Hello, World!");
                    break;
                
                case 't':
                    System.out.println("Please enter a string to hash: ");
                    String input = tremminalScanner.nextLine();
                    int hash = hashFunction(input, base, capacity);
                    System.out.println("The hash of " + input + " is " + hash);
                    break; 
                
                case 'p':
                
                case 'q':
                    programStillRunning = false;
                    break;

                default:
                    break;
            }
        }
        tremminalScanner.close();
    }
    
    public static void printMenu(){
        System.out.println("Please enter a command: ");
        System.out.println("h: Hello World");
        System.out.println("t: Test Hash Function");
        System.out.println("p: Print Hash Table");
        System.out.println("q: Quit");
    }

    public static int hashFunction(String input, int base, int capacity){
        int hash = 0;
        int length = input.length();
        for (int i = 0; i < length; i++) {
            hash = (base * hash + input.charAt(i)) % capacity;
        }
        return hash;
    }
}
