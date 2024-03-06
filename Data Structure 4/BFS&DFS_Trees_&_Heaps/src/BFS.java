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
    MapGraph<T> map = new MapGraph<T>();

    public BFS(MapGraph<T> graph, T start) {
        this.map = graph;
        bfs(start);
    }

    private void bfs(T start) {
        Queue<T> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            T vertex = queue.poll();
            System.out.println("Visited: " + vertex);

            for (T adjVertex : map.getAdjacentVertices(vertex)) {
                if (!visited.contains(adjVertex)) {
                    visited.add(adjVertex);
                    queue.add(adjVertex);
                }
            }
        }
    }
}

