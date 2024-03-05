# Data Structures HW 4 : Breadth First Search and Depth First Search Trees and Heaps
In this project, you will implement key data structures and algorithms related to trees and graphs in the programming language of your choice. This includes the Breadth First Search (BFS) and Depth First Search (DFS) algorithms for traversing graphs or trees, as well as implementing binary trees and heaps.

## Objective

- Implement BFS and DFS algorithms for graph traversal.
- Build and manipulate Binary Trees.
- Implement a Heap data structure, including both min-heap and max-heap.

### Trees

Trees are hierarchical data structures consisting of nodes, with each node containing a value and a list of references to its children. The tree with no parent is called the root of the tree, and nodes with no children are called leaves.

### Binary Tree

A special case of a tree where each node has at most two children, referred to as the left child and the right child. It is a powerful data structure for modeling data that has a hierarchical relationship which branches off in two directions at most.

### Heap

A Heap is a specialized tree-based data structure that satisfies the heap property: in a max heap, for any given node C, if P is a parent node of C, then the key (the value) of P is greater than or equal to the key of C. In a min heap, the key of P is less than or equal to the key of C. The heap is one efficient way to implement a priority queue.

### Breadth First Search (BFS)

An algorithm for traversing or searching tree or graph data structures. It starts at a selected node (the 'root' in a tree, or any arbitrary node in a graph) and explores the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level.

### Depth First Search (DFS)

An algorithm for traversing or searching tree or graph data structures. The algorithm starts at the root node (selecting some arbitrary node as the root in the case of a graph) and explores as far as possible along each branch before backtracking.

### Collision Handling in Trees and Graphs

While trees and graphs do not have collisions in the same manner as hash tables, managing the data structure when it becomes too dense or too sparse is crucial for maintaining performance. Balancing operations in trees, like rotations in AVL or Red-Black Trees, are techniques to handle "collisions" or imbalances.

### Time Complexity
- The time complexity of BFS and DFS is O(V+E) for a graph represented using an adjacency list, where V is the number of vertices and E is the number of edges.
- The time complexity for inserting into, deleting from, and finding an element in a binary heap is O(log n), where n is the number of elements in the heap.

### Challenge
- Ensure that my BFS and DFS implementations can handle both trees and general graphs.
- Implement a Binary Tree and demonstrate basic operations like insertion, deletion, and traversal.
- Create both a Min Heap and a Max Heap and demonstrate priority queue operations.
- Implement auto-balancing in your Binary Tree.