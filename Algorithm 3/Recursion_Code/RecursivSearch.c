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

int findValueAtIndex(int targetValue, int* numberArray, int arrayLength, int currentIndex);
int binarySearchRecursive(int numberArray[], int targetNumber, int leftNum, int rightNum);
void selectionSort(int numberArray[], int arrayLength);

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
    int* numberArray = (int*)malloc(indexCounter * sizeof(int));
    int arrayLength = indexCounter; // Correct calculation of array length
    if (numberArray == NULL) {
        printf("Memory allocation didn't work\n");
        fclose(inputFile);
        return 1;
    }

    //Adding the numbers from the file to the array
    for (int i = 0; i < indexCounter; i++){
        fscanf(inputFile, "%d", &number);
        numberArray[i] = number;
    }
    
    
    int targetNumber = 8128705;
    int targetNumber2 = 5842193;

    fclose(inputFile);// Close the file after you're done using it
    
    int foundIndex = findValueAtIndex(targetNumber, numberArray, arrayLength, 0);
    int foundIndex2 = findValueAtIndex(targetNumber2, numberArray, arrayLength, 0);
    selectionSort(numberArray, arrayLength);
    int binaryFind = binarySearchRecursive(numberArray, targetNumber, 0, arrayLength - 1);
    int binaryFind2 = binarySearchRecursive(numberArray, targetNumber2, 0, arrayLength - 1);
    free(numberArray); // Free memory after you're done using it
    
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
    printf("[] The second value of %d is at Index %d      []\n", targetNumber, binaryFind);
    printf("[]==================================================[]\n");
    if (binaryFind == -1 || binaryFind2 == -1) {
        printf("[]==================================================[]\n");
        printf("[] Values not found in the array so we get a -1     []\n");
        printf("[] The index of %d is %d                       []\n", targetNumber2, binaryFind2);
        printf("[]==================================================[]\n");
    }
    return 0;
}

int findValueAtIndex(int targetValue, int numberArray[], int arrayLength, int currentIndex){
    if(currentIndex == arrayLength) {
        return -1;
    }

    if (numberArray[currentIndex] == targetValue){
        return currentIndex;
    } 

    return findValueAtIndex(targetValue, numberArray, arrayLength, currentIndex + 1);
}

int binarySearchRecursive(int* numberArray, int targetNumber, int leftNum, int rightNum) {
    if (rightNum >= leftNum) {
        int middleNum = leftNum + (rightNum - leftNum) / 2;
        int value_At_M_Index = numberArray[middleNum];

        if (value_At_M_Index == targetNumber) {
            return middleNum;
        }

        if (value_At_M_Index > targetNumber) {
            return binarySearchRecursive(numberArray, targetNumber, leftNum, middleNum - 1);
        }

        return binarySearchRecursive(numberArray, targetNumber, middleNum + 1, rightNum);
    }

    return -1; // This will mean that the target is not found within the array
}

void selectionSort(int numberArray[], int arrayLength){
    for (int i = 0; i < arrayLength - 1; i++){
        int minIndex = i;
        for (int j = i + 1; j < arrayLength; j++){
            if (numberArray[j] < numberArray[minIndex]){
                minIndex = j;
            }
        }
        int temp = numberArray[minIndex];
        numberArray[minIndex] = numberArray[i];
        numberArray[i] = temp;
    }
}