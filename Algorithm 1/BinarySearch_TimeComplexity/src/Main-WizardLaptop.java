/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/4/2024
Algorithm 1: Binary Search, Time Complexity
File Name: Main
Sources: Bro Code on YouTube and Geeks for Geeks webpage
*/
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //String path_toFile = "C:\\Users\\kaisc\\OneDrive\\Documents\\Year 2024 School work\\CS240 Data Struture\\Algorithm 1\\BinarySearch_TimeComplexity\\src\\numbers.txt";
        try {
            File inputFile = new File("BinarySearch_TimeComplexity/src/numbers.txt");
            Scanner fileScanner = new Scanner(inputFile);
            System.out.println("This is a program that use a Binary Search that look though a .txt file that has 2000 entries of numbers");
            int amount_Of_Entries = 0;
            while (fileScanner.hasNextLine()){
                fileScanner.nextLine();
                amount_Of_Entries++;
            }
            int[] numList = new int[amount_Of_Entries];
            fileScanner.close();


            //reset the scanner to store the data
            fileScanner = new Scanner(inputFile);

            int numIndex = 0;
            while (fileScanner.hasNextLine()) {
                String numLineValue = fileScanner.nextLine();
                //need to cast the char and string values into int values
                int toIntegerValue = Integer.parseInt(numLineValue);
                numList[numIndex] = toIntegerValue;
                numIndex++;
            }
            fileScanner.close();
            Scanner terminalScanner = new Scanner(System.in);
            
            System.out.println("You can Enter a value to find the index of it in the array");
            int targetNumber = terminalScanner.nextInt();
            terminalScanner.close();

            //We want a numberChecker to make sure that the number is at lest in the array before we start the search
            //Otherwise we will get an infinity loop

            int findIndex = binarySearch(numList, targetNumber);
            if (findIndex == -1) {
                System.out.println(targetNumber + " Target number Not found");
            } else {
                System.out.println("Target number found at index " + findIndex);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int binarySearch(int[] numList, int targetNumber) {
        int lessNum = 0;
        int moreNum = numList.length - 1;
        int stepCounter = 0;

        while(lessNum <= moreNum){
            stepCounter++;
            int middleNum = lessNum + (moreNum - lessNum) / 2;
            int value_At_Index = numList[middleNum];

            System.out.println("Check: " + stepCounter + " Current Index Value: " + value_At_Index);
            if(value_At_Index < targetNumber) {
                lessNum = middleNum;
            } else if (value_At_Index > targetNumber) {
                moreNum = middleNum;
            } else return middleNum + 1;
        }
        return -1; //This will mean that the target is not found within the array
    }
}