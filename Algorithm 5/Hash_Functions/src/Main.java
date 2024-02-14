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
                    System.out.printf("[]=============================================[]\n");
                    System.out.printf("[] Please enter a the hash value: ");
                    System.out.printf("[]=============================================[]\n");
                    int findPrime = tremminalScanner.nextInt();
                    int primeFound = hashFunctions.nearestBigPrime(findPrime);
                    tremminalScanner.nextLine();
                    System.out.printf("[]=============================================[]\n");
                    System.out.printf("[] The next biggest Prime is %d\n", primeFound);
                    System.out.printf("[]=============================================[]\n");
                    break;
                
                case 'h':
                    System.out.printf("[]=============================================[]\n");
                    System.out.printf("[] Please enter a string to hash: ");
                    String input = tremminalScanner.nextLine();
                    System.out.printf("[]=============================================[]\n");
                    int hash = hashFunctions.hashFactory(input, base, capacity);
                    System.out.printf("[]=============================================[]\n");
                    System.out.printf("[]The hash of %s is eqaul to %d\n", input, hash);
                    System.out.printf("[]=============================================[]\n");
                    break; 
                
                case 'p':
                System.out.printf("[]==============================================[]\n");
                System.out.printf("[] Please enter a value to see if it is Prime: ");
                int primeInput = tremminalScanner.nextInt();
                System.out.printf("[]==============================================[]\n");
                boolean testedPrime = hashFunctions.isHashPrime(primeInput);
                tremminalScanner.nextLine();
                    if (testedPrime == true){
                        System.out.printf("[]==================================[]\n");
                        System.out.printf("[] The hash value is a Prime number []\n");
                        System.out.printf("[]==================================[]\n");
                    } else {
                        System.out.printf("[]======================================[]\n");
                        System.out.printf("[] The hash value is not a Prime number []\n");
                        System.out.printf("[]======================================[]\n");
                    }
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
    
    public static void printMenu(){
        System.out.printf("[]==========================================[]\n");
        System.out.printf("[] The Base is set to 63                    []\n");
        System.out.printf("[] The Capacity is set to Integer.MAX_VALUE []\n");
        System.out.printf("[] Please enter a command:                  []\n");
        System.out.printf("[] n: Nerst Big Prime                       []\n");
        System.out.printf("[] h: Test Hash Function                    []\n");
        System.out.printf("[] p: Check if Prime                        []\n");
        System.out.printf("[] q: Quit                                  []\n");
        System.out.printf("[]==========================================[]\n");
    }
}
