/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/16/2024
Data Structures HW 1: Linked Lists
File Name: Node.java
Sources: Geeks for Geeks webpage and Deitel, Deitel Book
*/
public class Node<E> {
    E data;
    Node<E> pointerNode;
    
    
    Node(E newData){
        this(newData, null);   
    }
    
    Node(E newData, Node<E> addressNode) {
        this.data = newData;
        pointerNode = addressNode;
    }

    public Node<E> nextNode(){
        return this.pointerNode;
    }
    
    public E getData() {
        return data;
    }

    public Node<E> getPointerNode() {
        return pointerNode;
    }
    
    public void setData(E data) {
        this.data = data;
    }

}
