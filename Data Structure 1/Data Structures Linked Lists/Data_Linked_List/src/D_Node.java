/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/16/2024
Data Structures HW 1: Linked Lists
File Name: D_Node.java
Sources: Geeks for Geeks webpage and Deitel, Deitel Book
*/
public class D_Node<E> {
    E data;
    D_Node<E> pointerNode;
    D_Node<E> back_Pointer_Node;
    


    D_Node(E newData){
        this(newData, null);   
    }
    
    D_Node(E newData, D_Node<E> addressNode) {
        this.data = newData;
        this.pointerNode = null;
        this.back_Pointer_Node = null;
    }

    
    public E getData() {
        return data;
    }

    public D_Node<E> getPointerNode() {
        return pointerNode;
    }
    
    public void setData(E data) {
        this.data = data;
    }
}
