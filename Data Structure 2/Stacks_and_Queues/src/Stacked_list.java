/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/16/2024
Data Structures HW 2: Stacks and Queues
File Name: Stacked_list.java
Sources: Geeks for Geeks webpage and Deitel, Deitel Book, as well as algorithm Design Manual
*/
import java.util.NoSuchElementException;

public class Stacked_list<E extends Comparable<E>> {
    private Link_List<E> stackedList;

    public Stacked_list() {
        stackedList = new Link_List<E>("Stacked List");
    }

    public E popOffStack() throws NoSuchElementException {
        return stackedList.removeNode_fromFront();
    }

    public void pushOntoStack(E insertedItem) {
        stackedList.addNode_toFront(insertedItem);
    }
    
    public boolean isStackEmpty() {
        return stackedList.isListEmpty();
    }

    public boolean isStackFull() {
        return false;
    }
    public E peekAtStack() throws NoSuchElementException {
        if(isStackEmpty()){
            throw new NoSuchElementException("There is nothing is in the Stack ");
        }
        return stackedList.headNode.getData();
    }

    public void printStackedList() {
        stackedList.printList();
    }
}
