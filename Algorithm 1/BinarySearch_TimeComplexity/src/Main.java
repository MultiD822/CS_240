/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/9/2024
Algorithm 1: Binary Search, Time Complexity
File Name: Main
Sources: Bro Code on YouTube and Geeks for Geeks webpage
*/
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            long startTimer = System.nanoTime();
            File inputFile = new File("src/numbers.txt");
            Scanner fileScanner = new Scanner(inputFile);
            System.out.println("This is a program that use a Binary Search that look though a .txt file that has 2000 entries of numbers");
            /*This "amount_Of_Entries" var is set to zero because we do not know the amount of numbers that are in the
            .txt file*/
            int amount_Of_Entries = 0;
            /*While loop to check how many number Strings there are in the given file, & update amount_Of_Entries by 1*/
            while (fileScanner.hasNextLine()){
                fileScanner.nextLine();
                amount_Of_Entries++;
            }
            /*This array will hold all the numbers from the .txt file and is a length of the value amount_Of_Entries*/
            int[] numList = new int[amount_Of_Entries];
            //Close the scanner to prevent memory leaks
            fileScanner.close();


            //reset the scanner to go back thorough the text file
            fileScanner = new Scanner(inputFile);

            int numIndex = 0;
            /*This while loop will go for as long as the .txt file as a number String, after we find a number String we
            then cast it to an Integer to then be put into the numList array and then increases the index number*/
            while (fileScanner.hasNextLine()) {
                String numLineValue = fileScanner.nextLine();
                //This will cast the string values into Integer values
                int toIntegerValue = Integer.parseInt(numLineValue);
                numList[numIndex] = toIntegerValue;
                numIndex++;
            }
            //Close the scanner to prevent memory leaks
            fileScanner.close();

            //New scanner to grab int value
            Scanner terminalScanner = new Scanner(System.in);

            System.out.println("You can Enter a value to find the index of it in the array");
            //The target value is set by user to find the target value in the array
            int targetNumber = terminalScanner.nextInt();
            //Close the scanner
            terminalScanner.close();
            /*This checks if the number is in the array, if findIndex is equal to -1 that
            target value was not in the array*/
            int findIndex = binarySearch(numList, targetNumber);
            if (findIndex == -1) {
                System.out.println(targetNumber + " Target number Not found");
            } else {
                System.out.println("Target number found at array index " + findIndex);
                System.out.println("The number is found in the .txt file on line 1 + " + findIndex);
            }
            //Another time read - the start time and then dived by 1M to get the time in ms
            long timeTaken = (System.nanoTime() - startTimer)/1000000;
            System.out.println("Time it took to complete is ms:  " + timeTaken);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int binarySearch(int[] numList, int targetNumber) {
        int leftNum = 0;
        int rightNum = numList.length - 1;
        int stepCounter = 0;

        while(leftNum <= rightNum){
            stepCounter++;
            int middleNum = leftNum + (rightNum - leftNum) / 2;
            int value_At_M_Index = numList[middleNum];

            System.out.println("Check: " + stepCounter + " Current Index Value: " + value_At_M_Index);
            if(value_At_M_Index < targetNumber) {
                leftNum = middleNum + 1;
            } else if (value_At_M_Index > targetNumber) {
                rightNum = middleNum - 1;
            } else {return middleNum;}

        }
        return -1; //This will mean that the target is not found within the array
    }
}