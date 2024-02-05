/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/23/2024
Data Structures HW 2: Stacks and Queues
File Name: Stacked_Array.java
Sources: Geeks for Geeks webpage and Deitel, Deitel Book, as well as algorithm Design Manual
*/
import java.util.NoSuchElementException;

public class Stacked_Array<E> {
    private E[] stackArray;
    private int topOfStack;
    @SuppressWarnings("unchecked")
    public Stacked_Array(int size) {
        stackArray = (E[]) new Object[size];
        topOfStack = -1;
    }

    public void pushOntoStack(E item) {
        if (topOfStack == stackArray.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        stackArray[++topOfStack] = item;
    }

    public E popOffStack() {
        if (isStackEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stackArray[topOfStack--];
    }

    public boolean isStackEmpty() {
        return topOfStack == -1;
    }
    
    public boolean isStackFull() {
        return topOfStack == stackArray.length - 1;
    }
    
    public E peekAtStack() {
        if(isStackEmpty()){
            throw new NoSuchElementException("There is nothing is in the Stack ");
        }
        return stackArray[topOfStack];
    }

    public void printStackedArray() {
        if(isStackEmpty()) {
            System.out.printf("empty Stack%n");
            return;
        }
        System.out.printf("The Stack has :");
        for (int i = topOfStack; i >= 0; i--) {
            System.out.printf("( %s )-> ", stackArray[i]);
        }
        System.out.println();
    }
}
