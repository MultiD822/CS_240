/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/23/2024
Data Structures HW 2: Stacks and Queues
File Name: Queued_List.java
Sources: Geeks for Geeks webpage and Deitel, Deitel Book, as well as algorithm Design Manual
*/
import java.util.NoSuchElementException;


public class Queued_List<E extends Comparable<E>> {
    private D_Linked_List<E> queuedList;

    public Queued_List() {
        queuedList = new D_Linked_List<E>();
    }

    public void enQueue(E insertedItem) {
        queuedList.addNode_toFront(insertedItem);
    }
    public E deQueue() throws NoSuchElementException {
        return queuedList.removeNode_fromBack();
    }

    public boolean isQueueEmpty() {
        return queuedList.isListEmpty();
    }

    public boolean isQueueFull() {
        return false;
    }

    public E peekAtQueue() throws NoSuchElementException {
        if(isQueueEmpty()){
            throw new NoSuchElementException("There is nothing is in the Queue ");
        }
        return queuedList.headNode.getData();
    }

    public void printQueuedList() {
        queuedList.printList();
    }
}
