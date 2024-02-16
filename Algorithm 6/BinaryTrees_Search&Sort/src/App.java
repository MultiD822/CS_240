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
    static final int DEPTH = 10;
    public static void main(String[] args) throws Exception {
        
        boolean programStillRunning = true; // Main loop control
        Binary_Tree Binary_Tree = new Binary_Tree(null);
        
        Scanner tremminalScanner = new Scanner(System.in);
        System.out.println("Welcome to the Binary Tree Program!");

        // Set the root node
        System.out.println("Please enter the value of the root node");
        int rootValue = tremminalScanner.nextInt();
        Binary_Tree.rootNode = new Tree_Node<Integer>(rootValue);
        tremminalScanner.nextLine();
        
        

        while (programStillRunning) {
            printOptions();
            String userInput = tremminalScanner.nextLine();
            if (userInput.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
                continue;
            }
            switch (userInput.charAt(0)) {
                
                case 'a':
                    System.out.println("Please enter the value of the node you would like to add to the tree");
                    int value = tremminalScanner.nextInt();
                    
                    Binary_Tree.addNode(value);
                    break;
                
                case 'r':
                    System.out.println("Please enter the value of the root node");
                    int newRootValue = tremminalScanner.nextInt();
                    Binary_Tree.rootNode.data_OR_Value = newRootValue;
                    break;

                case 'd':
                    System.out.println("Please enter the value of the node you would like to delete from the tree");
                    int deleteValue = tremminalScanner.nextInt();
                    Binary_Tree.removeNode(Binary_Tree.rootNode, deleteValue);
                    break;
                
                case 's':                 
                    System.out.println("Please enter the value of the node you would like to search for in the tree");
                    int searchValue = tremminalScanner.nextInt();
                    Binary_Tree.search(Binary_Tree.rootNode, searchValue);
                    break;
                
                case 'p':
                    Binary_Tree.inOrder(Binary_Tree.rootNode);
                    break;
                
                case 'i':
                    Binary_Tree.inOrder(Binary_Tree.rootNode);
                    break;
                
                case 'o':
                    Binary_Tree.postOrder(Binary_Tree.rootNode);
                    break;
                
                case 'l':
                    printTree2D(Binary_Tree.rootNode);
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
        System.out.println("[] 'p' Pre-order traversal                        []");
        System.out.println("[] 'i' in-order traversal                         []");
        System.out.println("[] 'o' Post-order traversal                       []");
        System.out.println("[] 'l' Print the Binary Tree                      []");
        System.out.println("[] 'q' Exit the program                           []");
        System.out.println("[]================================================[]");
    }

    public static void printTree2D(Tree_Node<Integer> rootNode) {
        print_in2DHelper(rootNode, 0);
    }

    public static void print_in2DHelper(Tree_Node<Integer> rootNode, int depthLevel) {
        
        System.out.println("The tree is: ");
        if (rootNode == null) {return;}
        
        depthLevel += DEPTH;

        print_in2DHelper(rootNode.rightNode, depthLevel);
        System.out.println();

        for (int i = DEPTH; i < depthLevel; i++) {
            System.out.print(" ");
        }
        System.out.println(rootNode.data_OR_Value + "\n");

        print_in2DHelper(rootNode.leftNode, depthLevel);
    }
}
