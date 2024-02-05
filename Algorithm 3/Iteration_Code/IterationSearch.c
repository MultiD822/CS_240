/*
- Programmer: Kai Schenkel
- Class: CS-240 Computer Architecture
- Data: 1/23/2024
- Algorithms HW 3 : Recursion vs Iteration 
- Sources: 
- Objective: 
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int inputValues_getIndex(int targetValue, int* nubmerArray, int arryLength);
void insertionSort(int* numberArray, int n);

int main(){
    FILE* inputFile;
    int number;
    int indexCounter = 0;

    inputFile = fopen("numbers-3.txt","r");
    if (inputFile == NULL) {
        printf("File could not be opened\n");
        return 1;
    }

    while(fscanf(inputFile, "%d", &number) == 1) {
        //This will count how many lines of numbers there are in the file 
        indexCounter++;
    }
    
    fseek(inputFile, 0 , SEEK_SET);

    /*Telling the computer to allocate a block of memory so we can store the values from the file and then sort the array*/
    int* nubmerArray = (int*)malloc(indexCounter * sizeof(int));
    int arrayLength = indexCounter; // Correct calculation of array length
    if (nubmerArray == NULL) {
        printf("Memory allocation didn't work\n");
        fclose(inputFile);
        return 1;
    }

    //Adding the numbers from the file to the array
    for (int i = 0; i < indexCounter; i++){
        fscanf(inputFile, "%d", &number);
        nubmerArray[i] = number;
    }
    
    
    int targetNumber = 8128705;
    int targetNumber2 = 5842193;
    fclose(inputFile);
    int foundIndex = inputValues_getIndex(targetNumber, nubmerArray, arrayLength);
    int foundIndex2 = inputValues_getIndex(targetNumber2, nubmerArray, arrayLength);
    insertionSort(nubmerArray, arrayLength);
    int binaryFind = binarySearchRecursive(nubmerArray, targetNumber, 0, arrayLength - 1);
    int binaryFind2 = binarySearchRecursive(nubmerArray, targetNumber2, 0, arrayLength - 1);
    free(nubmerArray); // Free memory after you're done using it
    printf("[]============================================================[]\n");
    printf("[] The values below are sorted but have no liner search yet   []\n");
    printf("[]============================================================[]\n");
    printf("[] The first value of %d is at Index %d                []\n", targetNumber, foundIndex);
    printf("[]============================================================[]\n");
    if (foundIndex2 == -1) {
        printf("[]============================================================[]\n");
        printf("[] The second Value was not found in the array so we get a -1 []\n");
        printf("[] The index of %d is %d                                 []\n", targetNumber2, foundIndex2);
        printf("[]============================================================[]\n");
    }
    printf("[]==================================================[]\n");
    printf("[]The values below are sorted and have binary search[]\n");
    printf("[]==================================================[]\n");
    printf("[] The second value of %d is at Index %d     []\n", targetNumber, binaryFind);
    printf("[]==================================================[]\n");
    if (binaryFind == -1 || binaryFind2 == -1) {
        printf("[]==================================================[]\n");
        printf("[] Values not found in the array so we get a -1     []\n");
        printf("[] The index of %d is %d                       []\n", targetNumber2, binaryFind2);
        printf("[]==================================================[]\n");
    }
    return 0;
}

int inputValues_getIndex(int targetValue, int* nubmerArray, int arryLength){
    for(int i = 0; i < arryLength; i++){
        if(nubmerArray[i] == targetValue){
            return i + 1;
        }
    }
    return -1;
}

int binarySearchRecursive(int nubmerArray[], int targetNumber, int leftNum, int rightNum) {
    if (rightNum >= leftNum) {
        int middleNum = leftNum + (rightNum - leftNum) / 2;
        int value_At_M_Index = nubmerArray[middleNum];

        if (value_At_M_Index == targetNumber) {
            return middleNum;
        }

        if (value_At_M_Index > targetNumber) {
            return binarySearchRecursive(nubmerArray, targetNumber, leftNum, middleNum - 1);
        }

        return binarySearchRecursive(nubmerArray, targetNumber, middleNum + 1, rightNum);
    }

    return -1; // This will mean that the target is not found within the array
}

void insertionSort(int* numberArray, int n) {
    for (int i = 1; i < n; i++) {
        int key = numberArray[i];
        /*This will move the elements that are greater than the key value to one index ahead of their current index*/
        int j = i - 1;
        while (j >= 0 && numberArray[j] > key) {
            numberArray[j + 1] = numberArray[j];
            j--;
        }
        /*this will add key at its correct index in sorted subarray*/
        numberArray[j + 1] = key;
    }
}