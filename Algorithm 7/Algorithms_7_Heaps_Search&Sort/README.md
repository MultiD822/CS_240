# Algorithms HW 7 : Heaps - Search and Sort

## Overview
This README explores the concept of heaps, emphasizing their role in efficient searching and sorting operations. It includes explanations of heap properties, heap creation, and the heap sort algorithm, along with an implementation guide for building a heap capable of performing both searching and sorting tasks.

## Introduction
A heap is a specialized tree-based data structure that satisfies the heap property: in a max heap, for any given node, the key (value) is greater than its children's keys, while in a min heap, the key is less than its children's keys. Heaps are primarily used for efficient data management, including the implementation of priority queues and the heap sort algorithm.

## Heaps and Their Operations
Heaps support a variety of operations, crucial for managing and accessing data efficiently:

- **Heap Creation**: Building a heap from an unsorted array.
- **Insertion**: Adding a new element to the heap while maintaining the heap property.
- **Deletion**: Removing the root element from the heap and reorganizing the heap to preserve its properties.
- **Heap Sort**: An efficient sorting algorithm that utilizes a heap to sort elements in ascending or descending order.
- **Search**: Although heaps are not optimized for search operations like binary search trees, finding the maximum or minimum element is very efficient.

## Heap Sort Algorithm
The heap sort algorithm involves building a heap from the given data and then repeatedly removing the root element (the maximum or minimum, depending on the heap type) and reorganizing the heap until all elements are sorted. This process is efficient and operates in O(n log n) time complexity for sorting n elements.

## Usage
To use the provided heap implementation for sorting and (limited) searching, follow these steps:

```java
Heap<Integer> heap = new Heap<>(Heap.Type.MAX); // Create a max heap
heap.insert(10);
heap.insert(20);
heap.insert(5);
heap.insert(3);
heap.insert(15);

heap.heapSort(); // Perform heap sort
System.out.println(heap); // Print sorted elements

// Example usage for searching (finding max or min)
Integer max = heap.peek(); // Get the maximum element (for max heap)
System.out.println("Maximum element: " + max);