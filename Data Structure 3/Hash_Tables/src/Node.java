/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/16/2024
File Name: Node.java
Sources: Geeks for Geeks webpage and Deitel, Deitel Book from Data Structures HW 1: Linked Lists
*/
public class Node<K, V> {
    K key;
    V value;
    Node<K, V> pointerNode;
    
    
    Node(K key, V value){
        this.key = key;
        this.value = value;   
    }
    
    Node(K key, V value, Node<K, V> addressNode) {
        this.key = key;
        this.value = value;
        pointerNode = addressNode;
    }

    public Node<K, V> nextNode(){
        return this.pointerNode;
    }
    
    public K get_Key() {
        return key;
    }

    public V get_Value() {
        return value;
    }  

    public Node<K, V> getPointerNode() {
        return pointerNode;
    }
    
    public void set_Key(K key) {
        this.key = key;
    }

    public void set_Value(V value) {
        this.value = value;
    }

}