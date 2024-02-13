/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/16/2024
Data Structures HW 1: Linked Lists
File Name: Link_List.java
Sources: Geeks for Geeks webpage and Deitel, Deitel Book
*/

import java.util.NoSuchElementException;

public class Link_List<E extends Comparable<E>> {

/*We need to have a head node that tells the computer here is the starting address that then
 * points to the data node.
*/
    public Node<E> headNode;

    private Node<E> lastNode;

    private String listName;
    
    

    public Link_List(){this("list");}

    //This method is a Constructor to make the link list 
    public Link_List(String name_Of_List) {
        listName = name_Of_List;
        headNode = lastNode = null;
    }

    /*This method will check if the linked list is empty*/
    public boolean isListEmpty() {return headNode == null;}

    /*This method adds a node to the frount of the list and pushes the reast of the node to the right*/
    public void addNode_toFront(E insertedItem){
        /*If the list is empty we will have have the computer set some space for a header node and make a last node that eqauls null,
            then take */
        if(isListEmpty()){
            headNode = lastNode = new Node<E>(insertedItem);
        } else {
            headNode = new Node<E>(insertedItem, headNode);
        }
    }
    /*This method adds a node to the end of the list and pushing the null node to the right one space*/
    public void addNode_atBack(E insertedItem){
        /*If the list is empty we will have have the computer set some space for a header node and make a last node that eqauls null,
            then take */
        if(isListEmpty()){
            headNode = lastNode = new Node<E>(insertedItem);
        } else { 
            /*With this we have our lastNode will equal the pointerNode of the class and then,
             * make a new node with the inserted Item  */
            lastNode = lastNode.pointerNode = new Node<E>(insertedItem);
            lastNode = lastNode.pointerNode;
        }
    }

    public E removeNode_fromFront() throws NoSuchElementException{
        if(isListEmpty()){
            throw new NoSuchElementException(listName + "There is nothing is in the list ");
        }
        E removedData = headNode.data;

        if (headNode == lastNode){
            headNode = lastNode = null;
        } else {
            headNode = headNode.pointerNode;
        }
        return removedData;
    }

    public E removeNode_fromBack() throws NoSuchElementException{
        if(isListEmpty()){
            throw new NoSuchElementException(listName + "There is nothing is in the list ");
        }
        E removedData = lastNode.data;

        if (headNode == lastNode){
            headNode = lastNode = null;
        } else {
            Node<E> currentNode = headNode;
            while (currentNode.pointerNode != lastNode) {
                currentNode = currentNode.pointerNode;
            }
            lastNode = currentNode;
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
        Node<E> currentNode = headNode;

        while (currentNode != null) {
            System.out.printf("( %s )-> ", currentNode.data);
            currentNode = currentNode.pointerNode;
        }
        System.out.println();
    }

    /*This method will be for grabing the size of the list that is made with this class*/
    public int getListSize(){
        int size = 0;
        Node<E> currentNode = headNode;
        
        while (currentNode != null) {
            size++;
            currentNode = currentNode.pointerNode;
        }
        return size;
    }

    public void insertNode_AtIndex(int nodeIndex, E data){
        if(nodeIndex < 0 || nodeIndex > getListSize()){
            throw new IllegalArgumentException("Invalid index");
        }

        Node<E> addNode = new Node<E>(data);
        if(nodeIndex == 0){
            addNode.pointerNode = headNode;
            headNode = addNode;
        } else {
            Node<E> currentNode = headNode;
            for (int i = 0; i < nodeIndex - 1; i++) {
                currentNode = currentNode.pointerNode;
            }

            addNode.pointerNode = currentNode.pointerNode;
            currentNode.pointerNode = addNode;
        }
    }

    public int linearSearch(E target){
        int nodePosition = 0;
        Node<E> currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.data.equals(target)) {
                return nodePosition;
            }
            currentNode = currentNode.pointerNode;
            nodePosition++;
        }
        return -1;
    }

    public void selectionSort(){
        Node<E> currentNode = headNode;
        while (currentNode != null) {
            Node<E> smallestNode = findSmallestNode(currentNode);
            swapNodes_Data(currentNode, smallestNode);
            currentNode = currentNode.pointerNode;
        }
    }

    private Node<E> findSmallestNode(Node<E> startNode) {
        Node<E> smallestNode = startNode;
        Node<E> currentNode = startNode.pointerNode;

        while (currentNode != null) {
          if(((Comparable<E>) currentNode.data).compareTo(smallestNode.data) < 0){
                smallestNode = currentNode;
          }  
          currentNode = currentNode.pointerNode;
        }

        return smallestNode;
    }

    private void swapNodes_Data(Node<E> node1, Node<E> node2) {
        E tempNode = node1.data;
        node1.data = node2.data;
        node2.data = tempNode;
     }

     
}
