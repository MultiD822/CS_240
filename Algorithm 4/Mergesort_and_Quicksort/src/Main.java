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
        try {
            File inputFile = new File("numbers-4.txt");
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
            
            quickSortFunction.quickSort(numberFromFile, 0, numberFromFile.length - 1);
            System.out.printf("Sorted array using Quick sort: %s%n%n", Arrays.toString(numberFromFile));
            int value1 = indexReturn(numberFromFile, 90262);
            int value2 = indexReturn(numberFromFile, 11559);
            //Check if the first asked position is in the array  
            if(value1 == -1){
                System.out.println("The value 90262 was not found in the array");
            } else {
                System.out.println("The value 90262 was found at index " + value1);
            }
            //Check if the second asked position is in the array
            if(value2 == -1){
                System.out.println("The value 11559 was not found in the array");
            } else {
                System.out.println("The value 11559 was found at index " + value2);
            }
        } catch (Exception e) {
            System.out.println("An error occured: " + e);
        }
    }

    private static int indexReturn(int[] numList, int targetIndex) {
        //Just a simple binary search algorithm beacuse we know that the array will be sorted in ascending order
        int leftIndex = 0;
        int rightIndex = numList.length - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (numList[middleIndex] == targetIndex) {
                return middleIndex;
            } else if (numList[middleIndex] < targetIndex) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        //If the value is not found in the array we return -1
        return -1;
    }
}
