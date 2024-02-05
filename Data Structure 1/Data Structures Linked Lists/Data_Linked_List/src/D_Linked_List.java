/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/16/2024
Data Structures HW 1: Linked Lists
File Name: D_Linked_List.java
Sources: Geeks for Geeks webpage and Deitel, Deitel Book
*/

import java.util.NoSuchElementException;

public class D_Linked_List<E extends Comparable<E>> {
    public D_Node<E> headNode;

    public D_Node<E> tailNode;

    
    public String listName;

    public D_Linked_List(){this("D Linked List");}

    public D_Linked_List(String name_Of_List) {
        listName = name_Of_List;
        this.headNode = null;
        this.tailNode = null;
    }

    /*This method will check if the linked list is empty*/
    public boolean isListEmpty() {return headNode == null;}

    /*This method adds a node to the frount of the list and pushes the reast of the node to the right*/
    public void addNode_toFront(E insertedItem){
        /*If the list is empty we will have have the computer set some space for a header node and make a last node that eqauls null,
            then take */
            D_Node<E> tempNode = new D_Node<E>(insertedItem);
        if(isListEmpty()){
            headNode = tempNode;
            tailNode = tempNode;
        } else {
            tempNode.pointerNode = headNode;
            headNode.back_Pointer_Node = tempNode;
            headNode = tempNode;
        }
    }

    public void insertNode_AtIndex(int nodeIndex, E data){
        if(nodeIndex < 0 || nodeIndex > getListSize()){
            throw new IllegalArgumentException("Invalid index");
        }

        D_Node<E> addNode = new D_Node<E>(data);
        if(nodeIndex == 0){
            addNode.pointerNode = headNode;
            headNode = addNode;
        } else {
            D_Node<E> currentNode = headNode;
            for (int i = 0; i < nodeIndex - 1; i++) {
                currentNode = currentNode.pointerNode;
            }

            addNode.pointerNode = currentNode.pointerNode;
            currentNode.pointerNode = addNode;
        }
    }

    public E removeNode_fromFront() throws NoSuchElementException{
        if(isListEmpty()){
            throw new NoSuchElementException(listName + "There is nothing is in the list ");
        }
        E removedData = headNode.data;

        if (headNode == tailNode){
            headNode = tailNode = null;
        } else {
            headNode = headNode.pointerNode;
        }
        return removedData;
    }

    public E removeNode_fromBack() throws NoSuchElementException{
        if(isListEmpty()){
            throw new NoSuchElementException(listName + "There is nothing is in the list ");
        }
        E removedData = tailNode.data;

        if (headNode == tailNode){
            headNode = tailNode = null;
        } else {
            D_Node<E> currentNode = headNode;
            while (currentNode.pointerNode != tailNode) {
                currentNode = currentNode.pointerNode;
            }
            tailNode = currentNode;
            currentNode.pointerNode = null;
        }
        return removedData;
    }


    /*This method is meant to print out the linked list using a while loop and going in till the computer finds the null node*/
    public void printList() {
        if(isListEmpty()) {
            System.out.printf("empty %s%n", listName);
            return;
        }
        System.out.printf("The %s has :", listName);
        D_Node<E> currentNode = headNode;

        while (currentNode != null) {
            System.out.printf("( %s )", currentNode.data);
            currentNode = currentNode.pointerNode;
        }
        System.out.println();
    }

    public int getListSize(){
        int size = 0;
        D_Node<E> currentNode = headNode;
        
        while (currentNode != null) {
            size++;
            currentNode = currentNode.pointerNode;
        }
        return size;
    }

    public int linearSearch(E target){
        int nodePosition = 0;
        D_Node<E> currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.data.equals(target)) {
                return nodePosition;
            }
            currentNode = currentNode.pointerNode;
            nodePosition++;
        }
        return -1;
    }

    public void InsertionSort() {
        D_Node<E> currentNode = headNode;
        while (currentNode != null) {
            D_Node<E> nextNode = currentNode.pointerNode;
            D_Node<E> prevNode = currentNode.back_Pointer_Node;
            
            while (prevNode != null && ((Comparable<E>) prevNode.data).compareTo(currentNode.data) > 0) {
                E tempData = prevNode.data;
                prevNode.data = currentNode.data;
                currentNode.data = tempData;

                prevNode = prevNode.back_Pointer_Node;
                currentNode = currentNode.back_Pointer_Node;
            }
            currentNode = nextNode;
        }
    }
}
