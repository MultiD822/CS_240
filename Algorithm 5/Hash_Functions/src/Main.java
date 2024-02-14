/*
Programmer: Kai Schenkel
Class: CS 240
Data: 2/13/2024
Algorithms HW 5 : Hash functions
File Name: Main.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing, GeekforGeeks website
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        KL_Hash_Functions hashFunctions = new KL_Hash_Functions();
        boolean programStillRunning = true; // Main loop control
        int base = 63;
        int capacity = Integer.MAX_VALUE;
        Scanner tremminalScanner = new Scanner(System.in);
        while(programStillRunning){ // Menu While loop
            printMenu();
            String userInput = tremminalScanner.nextLine();
            switch (userInput.charAt(0)) {
                case 'n':
                    System.out.printf("Please enter a the hash value: ");
                    int findPrime = tremminalScanner.nextInt();
                    int primeFound = hashFunctions.nearestBigPrime(findPrime);
                    tremminalScanner.nextLine();
                    System.out.printf("The next biggest Prime is %d\n", primeFound);
                    break;
                
                case 'h':
                    System.out.println("Please enter a string to hash: ");
                    String input = tremminalScanner.nextLine();
                    int hash = hashFunctions.hashFactory(input, base, capacity);
                    System.out.println("The hash of " + input + " is " + hash);
                    break; 
                
                case 'p':
                System.out.printf("Please enter a the hash value: ");
                int primeInput = tremminalScanner.nextInt();
                boolean testedPrime = hashFunctions.isHashPrime(primeInput);
                tremminalScanner.nextLine();
                    if (testedPrime == true){
                        System.out.printf("The hash value is a Prime number\n");
                    } else {
                        System.out.printf("The hash value is not a Prime number\n");
                    }
                    break;
                case 'q':
                    programStillRunning = false;
                    break;

                default:
                    System.out.printf("That Seems to do Nothing... Weird\n");
                    break;
            }
        }
        tremminalScanner.close();
    }
    
    public static void printMenu(){
        System.out.println("Please enter a command: ");
        System.out.println("n: Nerst Big Prime");
        System.out.println("h: Test Hash Function");
        System.out.println("p: Check if Prime");
        System.out.println("q: Quit");
    }
}
