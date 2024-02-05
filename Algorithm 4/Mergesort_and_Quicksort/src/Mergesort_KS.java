/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/30/2024
Algorithms HW 4 : Mergesort & Quicksort
File Name: Mergesort.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing and Geeks for Geeks webpage
*/

public class Mergesort_KS {
    public void mergeSort(int[] arrayData){
        sortArray(arrayData, 0, arrayData.length - 1);
    }

    private void sortArray(int[] data, int lowIndex, int highIndex) {
        if ((highIndex - lowIndex) >= 1) {
            int middleValue1 = (lowIndex + highIndex) / 2;
            int middleValue2 = middleValue1 + 1;

            //output that we are splitting the array up
            System.out.printf("Array split: %s%n", subArrayString(data, lowIndex, highIndex).toString());
            System.out.printf("   %s%n", subArrayString(data, lowIndex, middleValue1));
            System.out.printf("   %s%n%n", subArrayString(data, middleValue2, highIndex));

            sortArray(data, lowIndex, middleValue1);
            sortArray(data, middleValue2, highIndex);

            mergeArrays(data, lowIndex, middleValue1, middleValue2, highIndex);
        }
        
    }

    private String subArrayString(int[] arrayData, int lowValue, int highIndex) {
        StringBuilder temporatyString = new StringBuilder();

        //Output spaces for alignment
        for (int i = 0; i < lowValue; i++) {
            temporatyString.append("   ");
        }
        //Output elements left in array
        for (int i = lowValue; i <= highIndex; i++) {
            temporatyString.append(" " + arrayData[i]);
        }
       return temporatyString.toString();
    }

    private void mergeArrays(int[] arrayData, int lowIndex, int middleValue1, int middleValue2, int highIndex) {
        int leftIndex = lowIndex;
        int rightIndex = middleValue2;
        int combinedIndex = lowIndex;
        int [] combinedArrays = new int[arrayData.length];

        //Print the arrays before the mergeing process
        System.out.printf("merge: %s%n", subArrayString(arrayData, lowIndex, middleValue1));

        System.out.printf("      %s%n", subArrayString(arrayData, middleValue2, highIndex));

        //Merge the arrays until reaching the end of either array
        while (leftIndex <= middleValue1 && rightIndex <= highIndex) {
            /*We ask the computer to place the smaller of the two current elements,
             into the result and move to the next space in the array*/
            if (arrayData[leftIndex] <= arrayData[rightIndex]) {
                combinedArrays[combinedIndex++] = arrayData[leftIndex++];
            } else {
                combinedArrays[combinedIndex++] = arrayData[rightIndex++];
            }
        }

        //If the left array is empty
        if (leftIndex == middleValue2) {
            while (rightIndex <= highIndex) {
                combinedArrays[combinedIndex++] = arrayData[rightIndex++];
            }
        } else {
            while (leftIndex <= middleValue1) {
                combinedArrays[combinedIndex++] = arrayData[leftIndex++];
            }
        }

        //Copy values back into the original array that was passed in
        for (int i =  lowIndex; i <= highIndex; i++) {
            arrayData[i] = combinedArrays[i];
        }

        //Output the merged array
        System.out.printf("   %s%n%n", subArrayString(arrayData, lowIndex, highIndex));

    }
    
}
