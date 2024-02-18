/*
Programmer: Kai Schenkel
Class: CS 240
Data: 1/16/2024
File Name: Link_List.java
Sources: Geeks for Geeks webpage and Deitel, Deitel Book from Data Structures HW 1: Linked Lists
*/
package hashLibrary_KS; 
import java.util.NoSuchElementException;

public class Link_List<K, V> {

/*We need to have a head node that tells the computer here is the starting address that then
 * points to the data node.
*/
    public Node<K, V> headNode;

    private Node<K, V> lastNode;

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
    public void addNode_toFront(K key, V value){
        /*If the list is empty we will have have the computer set some space for a header node and make a last node that eqauls null,
            then take */
        if(isListEmpty()){
            headNode = lastNode = new Node<K, V>(key, value);
        } else {
            headNode = new Node<K, V>(key, value);
        }
    }
    /*This method adds a node to the end of the list and pushing the null node to the right one space*/
    public void addNode_atBack(K key, V value){
        /*If the list is empty we will have have the computer set some space for a header node and make a last node that eqauls null,
            then take */
        if(isListEmpty()){
            headNode = lastNode = new Node<K, V>(key, value);
        } else { 
            /*With this we have our lastNode will equal the pointerNode of the class and then,
             * make a new node with the inserted Item  */
            lastNode = lastNode.pointerNode = new Node<K, V>(key, value);
            lastNode = lastNode.pointerNode;
        }
    }

    public V remove_Value() throws NoSuchElementException{
        if(isListEmpty()){
            throw new NoSuchElementException(listName + "There is nothing is in the list ");
        }
        V removedValue = headNode.get_Value();

        if (headNode == lastNode){
            headNode = lastNode = null;
        } else {
            headNode = headNode.pointerNode;
        }
        return removedValue;
    }

    public K remove_Key() throws NoSuchElementException{
        if(isListEmpty()){
            throw new NoSuchElementException(listName + "There is nothing is in the list ");
        }
        K removedKey = headNode.get_Key();

        if (headNode == lastNode){
            headNode = lastNode = null;
        } else {
            headNode = headNode.pointerNode;
        }
        return removedKey;
    }

    public K remove_Key_fromBack() throws NoSuchElementException{
        if(isListEmpty()){
            throw new NoSuchElementException(listName + "There is nothing is in the list ");
        }
        K removedData = lastNode.get_Key();

        if (headNode == lastNode){
            headNode = lastNode = null;
        } else {
            Node<K, V> currentNode = headNode;
            while (currentNode.pointerNode != lastNode) {
                currentNode = currentNode.pointerNode;
            }
            lastNode = currentNode;
            currentNode.pointerNode = null;
        }
        return removedData;
    }

    public V remove_Value_fromBack() throws NoSuchElementException{
        if(isListEmpty()){
            throw new NoSuchElementException(listName + "There is nothing is in the list ");
        }
        V removedData = lastNode.get_Value();

        if (headNode == lastNode){
            headNode = lastNode = null;
        } else {
            Node<K, V> currentNode = headNode;
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
        Node<K, V> currentNode = headNode;
        while (currentNode != null) {
            System.out.println(currentNode.get_Value());
            currentNode = currentNode.pointerNode;
        }
    }

    /*This method will be for grabing the size of the list that is made with this class*/
    public int getListSize(){
        int size = 0;
        Node<K, V> currentNode = headNode;
        
        while (currentNode != null) {
            size++;
            currentNode = currentNode.pointerNode;
        }
        return size;
    }

    public void insertNode_AtIndex(int nodeIndex, K key, V value){  
        if(nodeIndex < 0 || nodeIndex > getListSize()){
            throw new IllegalArgumentException("Invalid index");
        }

        Node<K, V> addNode = new Node<K, V>(key, value);
        if(nodeIndex == 0){
            addNode.pointerNode = headNode;
            headNode = addNode;
        } else {
            Node<K, V> currentNode = headNode;
            for (int i = 0; i < nodeIndex - 1; i++) {
                currentNode = currentNode.pointerNode;
            }

            addNode.pointerNode = currentNode.pointerNode;
            currentNode.pointerNode = addNode;
        }
    }

    public int linearSearch_ForKey(K targetKey){
        int nodePosition = 0;
        Node<K, V> currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.get_Key().equals(targetKey)) {
                return nodePosition;
            }
            currentNode = currentNode.pointerNode;
            nodePosition++;
        }
        return -1;
    }

    public int linearSearch_ForValue(V targetValue){
        int nodePosition = 0;
        Node<K, V> currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.get_Value().equals(targetValue)) {
                return nodePosition;
            }
            currentNode = currentNode.pointerNode;
            nodePosition++;
        }
        return -1;
    }

    public void swapNodes_Value (Node<K, V> node1, Node<K, V> node2) {
        V tempNode = node1.get_Value();
        node1.set_Value(node2.get_Value());
        node2.set_Value(tempNode);
     }

    //Adding a look at method
    public K looky_At_Key () {
        if (isListEmpty()) {
            return null;
        }
        return headNode.get_Key();
    }
}
