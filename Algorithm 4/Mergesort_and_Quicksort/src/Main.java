/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/30/2024
Algorithms HW 4 : Mergesort & Quicksort
File Name: Main.java + number-1.txt
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing and Geeks for Geeks webpage
*/
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.security.SecureRandom;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner terminalScanner = new Scanner(System.in);
        Mergesort_KS sortFunction = new Mergesort_KS();
        Quicksort_KS quickSortFunction = new Quicksort_KS();
        boolean programmeIsRunning = true;
        try {
            File inputFile = new File("src/numbers-4.txt");
            Scanner fileScanner = new Scanner(inputFile);
            
            int spaceForArray = 0;

            while (fileScanner.hasNextInt()) {
                fileScanner.nextInt();
                spaceForArray++;
                
            }
            fileScanner.close();

            int [] numberFromFile = new int[spaceForArray];

            fileScanner = new Scanner(inputFile);
            int index = 0;
            while (fileScanner.hasNextLine()) {
                String numLineValue = fileScanner.nextLine();
                
                int toIntegerValue = Integer.parseInt(numLineValue);

                numberFromFile[index] = toIntegerValue;
                index++;
            }
            fileScanner.close();
            System.out.printf("Unsorted array: %s%n%n", Arrays.toString(numberFromFile));

           //This is the interface for the user to interact with the program
            while (programmeIsRunning) {
                Scanner inputScanner = new Scanner(System.in);
                printMenu();
                String inputFromTerminal = terminalScanner.nextLine();
               
                switch (inputFromTerminal.charAt(0)) {
                    case 'p':
                        System.out.printf("Here is the array Printed: %s%n%n", Arrays.toString(numberFromFile));
                        break;
                        
                    case 's':
                        System.out.println("[]=============================================[]");
                        System.out.println("[] Sorting the array using Quick sort...       []");
                        quickSortFunction.quickSort(numberFromFile, 0, numberFromFile.length - 1);
                        System.out.println("[] The array has been sorted using Quick sort! []");
                        System.out.println("[]=============================================[]");
                        break;

                    case 'm':
                        System.out.println("[]=============================================[]");
                        System.out.println("Sorting the array using Merge sort...          []");
                        sortFunction.mergeSort(numberFromFile);
                        System.out.println("The array has been sorted using Merge sort!    []");
                        System.out.println("[]=============================================[]");
                        break;

                    case 'f':
                        System.out.println("[]==============================================================[]");
                        System.out.println("[] Enter a value to find in the array and will return the index []");
                        System.out.printf("[] Enter your choice -> ");
                        int valueToFind = inputScanner.nextInt(); 
                        int valueAtIndex = indexReturn(numberFromFile, valueToFind);
                        if(valueAtIndex == -1){
                            System.out.printf("[] The value %d was not found in the array                 []\n", valueToFind);
                            System.out.println("[]==============================================================[]");
                        } else {
                            System.out.printf("[] The value %d was found at index %d                      []\n", valueToFind, valueAtIndex);
                            System.out.println("[]==============================================================[]");
                        }
                        break;
                    case 'q':
                        System.out.println("Shutting down... Goodbye world");
                        programmeIsRunning = false;
                        inputScanner.close();
                        break;
                
                    default:
                        break;
                }
                
            }
            terminalScanner.close();
        } catch (Exception e) {
            System.out.println("An error occured: " + e);
            programmeIsRunning = false;
        }
    }

    private static int indexReturn(int[] numList, int targetValue) {
        //Just a simple binary search algorithm beacuse we know that the array will be sorted in ascending order
        int leftIndex = 0;
        int rightIndex = numList.length - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (numList[middleIndex] == targetValue) {
                return middleIndex;
            } else if (numList[middleIndex] < targetValue) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        //If the value is not found in the array we return -1
        return -1;
    }
    private static void printMenu() {
        //Per print statement only have two choices in each statement 
        System.out.printf("[]==========================================================[]\n");
        System.out.printf("[] Enter 'p' to print the array                             []\n");
        System.out.printf("[] Enter 's' to sort the array using Quick sort             []\n");
        System.out.printf("[] Enter 'm' to sort the array using Merge sort             []\n");
        System.out.printf("[] Enter 'f' to find a index of a Value                     []\n");   
        System.out.printf("[] Enter 'q' to quit                                        []\n");
        System.out.printf("[]==========================================================[]\n");
        System.out.printf("[] Enter your choice -> ");  
    }

    
}
