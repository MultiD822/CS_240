/*
Programmer: Kai Schenkel
Class: CS 240
Data: 2/27/2024
Algorithms 7: Heaps - Search & Sort
File Name: Heap_Builder.java
Sources: Deitel, Deitel Book, small bit of chatGPT 
*/

public class Heap_Builder {
    private int[] heap;
    private int size;
    private int space;

    public Heap_Builder(int spaceForArray){
        this.space = spaceForArray;
        this.size = 0;
        this.heap = new int[space + 1];
    }

    private boolean isLastNode(int arrayIndex) {return arrayIndex > (space / 2) && arrayIndex <= size;}
    private int parent(int arrayIndex){ return arrayIndex / 2; }
    private int leftChild(int arrayIndex){return (2 * arrayIndex); }
    private int rightChild(int arrayIndex){return (2 * arrayIndex) + 1; }

    private void swapValues(int firstIndex, int secondIndex){
        int tempIndex;
        tempIndex = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = tempIndex; 
    }

    public void insert_Element(int element){
        if (size >= space){return;}
        heap[++size] = element;
        int currentSize = size;

        while (heap[currentSize] > heap[parent(currentSize)]) {
            swapValues(currentSize, parent(currentSize));
            currentSize = parent(currentSize);
        }
    }

    public int extractMaxValue() {
        int popped = heap[1];
        heap[1] = heap[size--];
        maxHeapify_Factory(1);
        return popped;
    }

    private void maxHeapify_Factory(int arrayIndex){
        if (isLastNode(arrayIndex)) {return;}

        if (heap[arrayIndex] < heap[leftChild(arrayIndex)] || heap[arrayIndex] < heap[rightChild(arrayIndex)]) {
            if(heap[leftChild(arrayIndex)] > heap[rightChild(arrayIndex)]){
                swapValues(arrayIndex, leftChild(arrayIndex));
                maxHeapify_Factory(leftChild(arrayIndex));
            } else {
                swapValues(arrayIndex, rightChild(arrayIndex));
                maxHeapify_Factory(rightChild(arrayIndex));
            }
        }
    }

    public void printHeap() {
        System.out.print("Heap = ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    
    public boolean searchForElement(int element) {
        for (int i = 1; i <= size; i++) {
            if (heap[i] == element) {
                return true; // Element found
            }
        }
        return false; // Element not found
    }
    

}
