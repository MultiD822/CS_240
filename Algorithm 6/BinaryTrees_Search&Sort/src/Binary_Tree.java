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



public class Binary_Tree<E> {
     Tree_Node<Integer> rootNode;

    public Binary_Tree(Tree_Node<Integer> root) {
        this.rootNode = root;
    }

    //Add a node to the tree
    public void addNode(int value) {
        if (rootNode == null) {
            rootNode = new Tree_Node<Integer>(value);
        } else {
            rootNode.addNode(value);
        }
    }

    //Delete from the tree  
    public Tree_Node<Integer> removeNode(Tree_Node<Integer> root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.data_OR_Value) {
            root.leftNode = removeNode(root.leftNode, value);
        } else if (value > root.data_OR_Value) {
            root.rightNode = removeNode(root.rightNode, value);
        } else {
            if (root.leftNode == null) {
                return root.rightNode;
            } else if (root.rightNode == null) {
                return root.leftNode;
            }
            root.data_OR_Value = minValue(root.rightNode).data_OR_Value;
            root.rightNode = removeNode(root.rightNode, root.data_OR_Value);
        }
        return root;
    }
    //In-order traversal
    public void inOrder(Tree_Node<Integer> node) {
        if (node != null) {
            inOrder(node.leftNode);
            System.out.printf(" ( %d )->",node.data_OR_Value);
            inOrder(node.rightNode);
        }
        
    }
    //Post-order traversal
    public void postOrder(Tree_Node<Integer> node) {
        if (node != null) {
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.printf(" ( %d )->",node.data_OR_Value);
        }
        if (node == null){System.out.println();}
    }
    //Pre-order traversal
    public void preOrder(Tree_Node<Integer> node) {
        if (node != null) {
            System.out.printf(" ( %d )->", node.data_OR_Value);
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
        if (node == null){System.out.println();}
    }
    //search for a node
    public void search(Tree_Node<Integer> node, int value) {
        if (node == null) {
            System.out.println("The value " + value + " was not found in the tree");
        } else if (node.data_OR_Value == value) {
            System.out.println("The value " + value + " was found in the tree");
        } else if (value < node.data_OR_Value) {
            search(node.leftNode, value);
        } else {
            search(node.rightNode, value);
        }
    }

    private Tree_Node<Integer> minValue(Tree_Node<Integer> root) {
        while (root.leftNode != null) {
            root = root.leftNode;
        }
        return root;
    }


}    


