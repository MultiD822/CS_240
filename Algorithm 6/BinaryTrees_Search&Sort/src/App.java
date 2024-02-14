/*
Programmer: Kai Schenkel
Class: CS 240
Data: 2/13/2024
Algorithms 6: Binary Trees - Search & Sort
File Name: Main.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing, plus the file from Algorithms 5 Hash functions
    the class file is called KL_
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean programStillRunning = true; // Main loop control
        Binary_Tree Binary_Tree = new Binary_Tree(null);
        Scanner tremminalScanner = new Scanner(System.in);
        System.out.println("Welcome to the Binary Tree Program!");
        while (programStillRunning) {
            printOptions();
            String userInput = tremminalScanner.nextLine();
            switch (userInput.charAt(0)) {
                
                case 'a':
                    System.out.println("Please enter the value of the node you would like to add to the tree");
                    int value = tremminalScanner.nextInt();
                    Node newNode = new Node(value);
                    Binary_Tree.add(newNode);
                    break;
                
                case 'r':
                    System.out.println("Please enter the value of the root node");
                    int rootValue = tremminalScanner.nextInt();
                    Node newRoot = new Node(rootValue);
                    Binary_Tree.rootNode = newRoot;
                    break;

                case 'd':
                    System.out.println("Please enter the value of the node you would like to delete from the tree");
                    int deleteValue = tremminalScanner.nextInt();
                    Binary_Tree.deleteNode(newRoot, deleteValue);
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
        System.out.println("[] 'a' Add element to the tree                    []");
        System.out.println("[] 'r' Set the root of the Binary Tree            []");
        System.out.println("[] 'd' Delete a element from the Binary Tree      []");
        System.out.println("[] 's' Search for a element in the Binary Tree    []");
        System.out.println("[] 'p' Pre-order traversal                         []");
        System.out.println("[] 'i' in-order traversal                         []");
        System.out.println("[] 'o' Post-order traversal                       []");
        System.out.println("[] 'l' Print the Binary Tree                      []");
        System.out.println("[] 'q' Exit the program                           []");
        System.out.println("[]================================================[]");
    }
}
