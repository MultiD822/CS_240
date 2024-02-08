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
        if (arrayData.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        sortArray(arrayData, 0, arrayData.length - 1);
    }

    private void sortArray(int[] data, int lowIndex, int highIndex) {
        if (lowIndex < highIndex){
            int middleValue1 = (lowIndex + highIndex) / 2;
            int middleValue2 = middleValue1 + 1;

            sortArray(data, lowIndex, middleValue1);
            sortArray(data, middleValue2, highIndex);

            mergeArrays(data, lowIndex, middleValue1, middleValue2, highIndex);
        }   
    }

    private void mergeArrays(int[] arrayData, int lowIndex, int middleValue1, int middleValue2, int highIndex) {
        int leftIndex = lowIndex;
        int rightIndex = middleValue2;
        int temporaryIndex = 0;
        int [] combinedArrays = new int[highIndex - lowIndex + 1];

        //Merge the arrays until reaching the end of either array
        while (leftIndex <= middleValue1 && rightIndex <= highIndex) {
            /*We ask the computer to place the smaller of the two current elements,
             into the result and move to the next space in the array*/
            if (arrayData[leftIndex] <= arrayData[rightIndex]) {
                combinedArrays[temporaryIndex++] = arrayData[leftIndex++];
            } else {
                combinedArrays[temporaryIndex++] = arrayData[rightIndex++]; 
            }
        }

        while (leftIndex <= middleValue1) {
            combinedArrays[temporaryIndex++] = arrayData[leftIndex++];
        }

        while (rightIndex <= highIndex) {
            combinedArrays[temporaryIndex++] = arrayData[rightIndex++];  
        }

        System.arraycopy(combinedArrays, 0, arrayData, lowIndex, combinedArrays.length);
    }
    
}
