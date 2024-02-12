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
        Scanner tremminalScanner = new Scanner(System.in);
        while(programStillRunning){ // Menu While loop
            String userInput = tremminalScanner.nextLine();
            switch (userInput.charAt(0)) {
                case 'h':
                    System.out.println("Hello, World!");
                    break;
                
                case 'q':
                    programStillRunning = false;
                    break;

                default:
                    break;
            }
        }
        tremminalScanner.close();
    }
    
}
