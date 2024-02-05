/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/30/2024
Algorithms HW 4 : Mergesort & Quicksort
File Name: Quicksort.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing and Geeks for Geeks webpage
*/

public class Quicksort_KS {
    public void quickSort(int[] arrayData, int startingIndex, int endIndex) {
        if (endIndex <= startingIndex) return;
        int pivotIndex = partitionSort(arrayData, startingIndex, endIndex);
        quickSort(arrayData, startingIndex, pivotIndex - 1);
        quickSort(arrayData, pivotIndex + 1, endIndex);
    }

    private int partitionSort(int[] arrayData, int startingIndex, int endIndex) {
        int pivot = arrayData[endIndex];
        int i = (startingIndex - 1);

        for (int j = startingIndex; j <= endIndex - 1; j++) {
            if (arrayData[j] < pivot) {
                i++;
                int temp = arrayData[i];
                arrayData[i] = arrayData[j];
                arrayData[j] = temp;
            }
        }
        i++;

        int temp = arrayData[i];
        arrayData[i] = arrayData[endIndex];
        arrayData[endIndex] = temp;

        return i;
    }
}
