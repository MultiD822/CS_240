# Binary Trees - Search and Sort

## Overview
This README overviews binary trees, focusing on search and sort operations. It includes explanations of pre-order, in-order, and post-order search methods and an AVL tree implementation for height reordering of the Binary Search Tree (BST).

## Introduction
A binary tree is a hierarchical data structure composed of nodes, where each node has at most two children, referred to as the left child and the correct child. Binary trees are commonly used for various applications, including efficiently searching, sorting, and organizing data.

## Binary Search Tree (BST)
A Binary Search Tree is a specific type of binary tree in which the left child of a node contains a value smaller than the node's value, and the correct child contains a value greater than the node's value. This property facilitates efficient searching and sorting operations.

## Operations
1. Pre-order Search: Visit the root node, then traverse the left and right subtree recursively.
2. In-order Search: Recursively traverse the left subtree, visit the root node, and traverse the right subtree. In a BST, this yields elements in sorted order.
3. Post-order Search: Recursively traverse the left subtree, then the right subtree, and finally visit the root node.

## AVL Tree
An AVL (Adelson-Velsky and Landis) tree is a self-balancing binary search tree where the height difference between any node's left and right subtrees is at most one. This balancing property ensures that the tree remains balanced and maintains an optimal height, which improves the efficiency of search, insert, and delete operations.
AVL Tree Operations
1. Insertion: When a new node is inserted, the AVL tree automatically adjusts its structure to maintain the balancing property.
2. Deletion: Similarly, when a node is deleted, the AVL tree rebalances itself to satisfy the height difference constraint.
3. Rebalancing: Rotation operations such as left-rotation, right-rotation, left-right rotation, and right-left rotation are employed to restore balance in the tree.

## Usage
To utilize the provided implementations, follow these steps:
Pre-order, In-order, and Post-order Search: Utilize the methods provided in the binary tree class to perform the desired search operation.
AVL Tree: Instantiate an AVL tree object and use its insertion, deletion, and other operations methods. The AVL tree will automatically maintain balance during these operations.
```
// Example usage of AVL tree
AVLTree<Integer> avlTree = new AVLTree<>();
avlTree.insert(5);
avlTree.insert(3);
avlTree.insert(7);
// Perform other operations as needed
```
## Conclusion
Understanding binary trees and their search and sort operations is fundamental in computer science and software development. By leveraging pre-order, in-order, and post-order traversal techniques, along with AVL tree balancing, developers can efficiently manage and manipulate data structures to optimize performance and maintain data integrity.
