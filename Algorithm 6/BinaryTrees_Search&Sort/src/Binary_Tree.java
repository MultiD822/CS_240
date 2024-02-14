/*
Programmer: Kai Schenkel
Class: CS 240
Data: 2/13/2024
Algorithms 6: Binary Trees - Search & Sort
File Name: Binary_Tree.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing, plus the file from Algorithms 5 Hash functions
    the class file is called KL_
*/


//This is the Binary Tree class
public class Binary_Tree {
     Node rootNode;

    public Binary_Tree(Node root) {
        this.rootNode = root;
    }

    public void add(Node node) {
        if (this.rootNode == null) {
            this.rootNode = node;
        } else {
            this.addExisting(node, this.rootNode);
        }
    }

    private void addExisting(Node node, Node current) {
        if (node.value > current.value) {
            if (current.right == null) {
                current.right = node;
            } else {
                addExisting(node, current.right);
            }
        } else if (node.value < current.value) {
            if (current.left == null) {
                current.left = node;
            } else {
                addExisting(node, current.left);
            }
        }
    }
    //Delete a node
    public void delete(int value) {
        this.rootNode = deleteNode(this.rootNode, value);
    }
    //In-order traversal
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }
    //Post-order traversal
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }
    //Pre-order traversal
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}    
//My own Node class
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

