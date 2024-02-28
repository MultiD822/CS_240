/*
Programmer: Kai Schenkel
Class: CS 240
Data: 2/27/2024
Algorithms 7: Heaps - Search & Sort
File Name: Main.java
Sources: Deitel, Deitel Book, small bit of chatGPT 
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap_Builder heap = new Heap_Builder(20);
        
        Scanner terminalScanner = new Scanner(System.in);
        

        while (true) {
            
            printMeun();

            String input = terminalScanner.nextLine(); // Read user input
            if (input.isEmpty()) continue; // If input is empty, prompt again
            
            char choice = Character.toUpperCase(input.charAt(0)); // Get the first char and uppercase it
            
            switch (choice) {
                case 'I':
                    System.out.print("Enter an element to insert: ");
                    int element = terminalScanner.nextInt();
                    terminalScanner.nextLine(); // Consume newline left-over
                    heap.insert_Element(element);
                    System.out.println(element + " inserted.");
                    break;
                case 'E':
                    int max = heap.extractMaxValue();
                    System.out.println("Extracted Max: " + max);
                    break;
                case 'P':
                    heap.printHeap();
                    break;
                case 'S':
                    System.out.print("Enter an element to insert: ");
                    int inputElement = terminalScanner.nextInt();
                    terminalScanner.nextLine(); // Consume newline left-over
                    boolean lookingFor = heap.searchForElement(inputElement);
                    if (lookingFor) {
                        System.out.println("Element found in heap");
                    } else {
                        System.out.println("Element not found in heap");
                    }
                case 'Q':
                    System.out.println("Exiting...");
                    terminalScanner.close(); // Close the scanner
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    public static void printMeun(){
        System.out.println("\nMenu:");
        System.out.println("1. Insert Element (I)");
        System.out.println("2. Extract Max (E)");
        System.out.println("3. Print Heap (P)");
        System.out.println("4. Quit (Q)");
        System.out.print("Select an option: ");
    }
}
