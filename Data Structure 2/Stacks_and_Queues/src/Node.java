/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/23/2024
Data Structures HW 2: Stacks and Queues
File Name: Node.java
Sources: Geeks for Geeks webpage and Deitel, Deitel Book, as well as algorithm Design Manual
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
