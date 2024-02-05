/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/23/2024
Data Structures HW 2: Stacks and Queues
File Name: Queued_Array.java
Sources: Geeks for Geeks webpage and Deitel, Deitel Book, as well as algorithm Design Manual
*/
import java.util.NoSuchElementException;

public class Queued_Array<E> {
    private E[] queueArray;
    private int front;
    private int rear;

    @SuppressWarnings("unchecked")
    public Queued_Array(int size) {
        queueArray = (E[]) new Object[size];
        front = 0;
        rear = -1;
    }

    public void enQueue(E item) {
        if (rear == queueArray.length - 1) {
            throw new IllegalStateException("Queue is full");
        }
        queueArray[++rear] = item;
    }

    public E dequeue() {
        if (isQueueEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E item = queueArray[front];
        queueArray[front] = null;
        front++;
        if (front > rear) { // If no elements left in the queue reset pointers
            front = 0;
            rear = -1;
        }
        return item;
    }

    public boolean isQueueEmpty() {
        return (front > rear);
    }

    public boolean isQueueFull() {
        return (rear == queueArray.length - 1);
    }

    public E peekAtQueue() {
        if(isQueueEmpty()){
            throw new NoSuchElementException("There is nothing is in the Queue ");
        }
        return queueArray[front];
    }

    public void printArrayQueue() {
        if(isQueueEmpty()) {
            System.out.printf("empty Queue%n");
            return;
        }
        System.out.printf("The Queue has :");
        for (int i = front; i <= rear; i++) {
            System.out.printf("( %s )-> ", queueArray[i]);
        }
        System.out.println();
    }
}
