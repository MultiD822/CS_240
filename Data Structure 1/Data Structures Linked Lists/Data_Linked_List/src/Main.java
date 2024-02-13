/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/16/2024
Data Structures HW 1: Linked Lists
File Name: Main.java
Sources: Geeks for Geeks webpage and Deitel, Deitel Book
*/
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            File inputFile = new File("numbers-2.txt");
            Scanner fileScanner = new Scanner(inputFile);
            Link_List<Integer> singlyList = new Link_List<>();
            D_Linked_List<Integer> doubleLinked_List = new D_Linked_List<>();
            
            while (fileScanner.hasNextLine()) {
                
                String numLineValue = fileScanner.nextLine();
                //This will cast the string values into Integer values
                int toIntegerValue = Integer.parseInt(numLineValue);
                singlyList.addNode_toFront(toIntegerValue);
                doubleLinked_List.addNode_toFront(toIntegerValue);
                
            }
            fileScanner.close();

            textBox();
    

            boolean programStillRunning = true;

            while (programStillRunning){
                Scanner terminalScanner = new Scanner(System.in);
                System.out.println("[]=============================================================================[]");
                System.out.println("[] Enter (a) to add a Node to either linked list                               []");     
                System.out.println("[] Enter (r) to remove a Node from either linked list                          []");
                System.out.println("[] Enter (p) to print either linked list                                       []");
                System.out.println("[] Enter (s) to sort either linked list                                        []");
                System.out.println("[] Enter (l) for Linear Search                                                 []");
                System.out.println("[] Enter (q) to quit program                                                   []");
                System.out.println("[]=============================================================================[]");
                String input = terminalScanner.nextLine();
    
                switch (input.toLowerCase().charAt(0)) {
                    case 'a':
                    System.out.print("What list would you like to sort? (1) for Singly linked list and (2) for Doubly linked list\t");
                        int choise1 = numSelect();
                        if (choise1 == 1){
                            System.out.println("Enter a Index number to add node");
                            int numIndex1 = numSelect();
                            System.out.println("Enter a Data number to add node");
                            int dataNum1 = numSelect();
                            singlyList.insertNode_AtIndex(numIndex1, dataNum1);
                            System.out.println("Node add to Singly linked list");
                        } 

                        if(choise1 == 2){
                            System.out.println("Enter a Index number to add node");
                            int numIndex2 = numSelect();
                            System.out.println("Enter a Data number to add node");
                            int dataNum2 = numSelect();
                            singlyList.insertNode_AtIndex(numIndex2, dataNum2);
                            System.out.println("Node add to Doubly linked list");
                        }
                        break;
                    
                        case 'r':   
                        System.out.print("What list would you like to remove a node? (1) for Singly linked list and (2) for Doubly linked list\t");
                        int choise2 = numSelect();
                        if (choise2 == 1){
                            singlyList.removeNode_fromBack();
                            System.out.println("Node remove from the back of the list");
                        } 

                        if(choise2 == 2){
                            doubleLinked_List.removeNode_fromBack();
                            System.out.println("Node remove from the back of the list");
                        }
                            break;

                    case 's':
                    System.out.print("What list would you like to sort? (1) for Singly linked list and (2) for Doubly linked list\t");
                        int choise3 = numSelect();
                        if (choise3 == 1){
                            singlyList.selectionSort();
                            System.out.println("The list is now sorted");
                        } 

                        if(choise3 == 2){
                            doubleLinked_List.InsertionSort(); 
                            System.out.println("The list is now sorted");
                        }
                    
                        break;

                    case 'p':   
                        System.out.print("What list would you like to see? (1) for Singly linked list and (2) for Doubly linked list\t");
                        int choise4 = numSelect();
                        if (choise4 == 1){
                            singlyList.printList();
                        } 

                        if(choise4 == 2){
                            doubleLinked_List.printList();
                        }
                            break;

                        case 'l':   
                        System.out.print("What list would you like to Search though? (1) for Singly linked list and (2) for Doubly linked list\t");
                        int choise5 = numSelect();
                        if (choise5 == 1){
                            System.out.println("Enter Target value you are looking for");
                            int targetNum = numSelect();
                            int nodePosition = singlyList.linearSearch(targetNum);
                            System.out.println("The value you entered is at index " + nodePosition);
                        } 
    
                        if(choise5 == 2){
                            System.out.println("Enter Target value you are looking for");
                            int targetNum = numSelect();
                            int nodePosition = doubleLinked_List.linearSearch(targetNum);
                            System.out.println("The value you entered is at index " + nodePosition);
                        }
                            break;
                    case 'q':
                    terminalScanner.close();
                    programStillRunning = false;
                    break;
                    default:
                        break;
    
                }
                
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
    } 
    public static void textBox(){
        System.out.println("[]=============================================================================[]");
        System.out.println("[] This program allows you to viwe types of linked list the frist list will be []");
        System.out.println("[] Singly linked list and the second one will be Doubly linked list,           []");
        System.out.println("[] these list are sorted with selection and insertion sort                     []");
        System.out.println("[]=============================================================================[]");
    }

    public static int numSelect(){
        Scanner terminalScanner = new Scanner(System.in);
        int numchooise = terminalScanner.nextInt();
        terminalScanner.close();
        return numchooise;
    }
    
}
