/*
Programmer: Kai Schenkel
Class: CS 240
Data: 3/5/2024
Data Strutures 4: Breadth First Search and Depth First Search Trees and Heaps
File Name: BFS.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing and Geeks for geeks 
*/


import java.util.*;

public class BFS<T> {
    private Set<T> visited = new HashSet<>();
    MapGraph<T> map;

    // Constructor initializes BFS with a graph and a start vertex
    public BFS(MapGraph<T> graph, T start) {
        this.map = graph;
        bfs(start);
    }

    // The bfs method performs breadth-first search from the start vertex
    private void bfs(T start) {
        Queue<T> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        // While the queue is not empty, visit each vertex and its neighbors
        while (!queue.isEmpty()) {
            T vertex = queue.poll();
            System.out.println("Visited: " + vertex);

            // For each adjacent vertex, if not visited, add to the queue
            for (T adjVertex : map.getAdjacentVertices(vertex)) {
                if (!visited.contains(adjVertex)) {
                    visited.add(adjVertex);
                    queue.add(adjVertex);
                }
            }
        }
    }
}

