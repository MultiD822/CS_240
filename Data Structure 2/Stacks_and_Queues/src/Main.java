/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/23/2024
Data Structures HW 2: Stacks and Queues
File Name: Main.java
Sources: Geeks for Geeks webpage and Deitel, Deitel Book, as well as algorithm Design Manual
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean programmeStillRinning = true;
        System.out.println("Hello, Here is my code for HW 2: Stacks and Queues there");
        Stacked_list<Integer> stackedList = new Stacked_list<Integer>();
        Stacked_Array<Integer> stackedArray = new Stacked_Array<Integer>(10);
        Queued_List<Integer> queuedList = new Queued_List<Integer>();
        Queued_Array<Integer> queuedArray = new Queued_Array<Integer>(10);
        for(int i = 0; i < 10; i++){
            stackedList.pushOntoStack(i);
            stackedArray.pushOntoStack(i);
            queuedList.enQueue(i);
            queuedArray.enQueue(i);
        }
        System.out.println("Here is the menu for the program: ");
        while (programmeStillRinning) {
            System.out.println("Enter 'v' to view the Stacks and Queues");
            System.out.println("Enter 'e' to see of the Stacks and Queues are empty");
            System.out.println("Enter 'f' to see of the Stacks and Queues are full");
            System.out.println("Enter 'p' to peek at the Stacks and Queues");
            System.out.println("Enter 'a' to add a number to each Stack and Queue");
            System.out.println("Enter 'r' tp remove a number from the Stacks and Queues");
            System.out.println("Enter 'q' to quit the program");
            Scanner terminalScanner = new Scanner(System.in);
            String userInput = terminalScanner.nextLine();
            switch (userInput.charAt(0)) {
                case 'v':
                    stackedList.printStackedList();
                    stackedArray.printStackedArray();
                    queuedList.printQueuedList(); 
                    queuedArray.printArrayQueue();
                    break;

                case 'e':
                    System.out.println("The Stacked List is empty: " + stackedList.isStackEmpty());
                    System.out.println("The Stacked Array is empty: " + stackedArray.isStackEmpty());
                    System.out.println("The Queued List is empty: " + queuedList.isQueueEmpty());
                    System.out.println("The Queued Array is empty: " + queuedArray.isQueueEmpty());
                    break;

                case 'f':
                    System.out.println("The Stacked List is full: " + stackedList.isStackFull());
                    System.out.println("The Stacked Array is full: " + stackedArray.isStackFull());
                    System.out.println("The Queued List is full: " + queuedList.isQueueFull());
                    System.out.println("The Queued Array is full: " + queuedArray.isQueueFull());
                    break;

                case 'p':
                    System.out.println("The Stacked List is empty: " + stackedList.peekAtStack());
                    System.out.println("The Stacked Array is empty: " + stackedArray.peekAtStack());
                    System.out.println("The Queued List is empty: " + queuedList.peekAtQueue());
                    System.out.println("The Queued Array is empty: " + queuedArray.peekAtQueue());
                    break;

                case 'a':
                    System.out.println("Enter the number you want to add to the Stacks and Queues");
                    int numberToAdd = terminalScanner.nextInt();
                    stackedList.pushOntoStack(numberToAdd);
                    stackedArray.pushOntoStack(numberToAdd);
                    queuedList.enQueue(numberToAdd);
                    queuedArray.enQueue(numberToAdd);
                    break;

                case 'r':
                    stackedList.popOffStack();
                    stackedArray.popOffStack();
                    queuedList.deQueue();
                    queuedArray.dequeue();
                    break;

                case 'q':
                    programmeStillRinning = false;
                    terminalScanner.close();  
                    break;
            
                default:
                    break;
            }  
        }
        
    }
}
