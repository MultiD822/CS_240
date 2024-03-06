/*
Programmer: Kai Schenkel
Class: CS 240
Data: 3/5/2024
Data Strutures 4: Breadth First Search and Depth First Search Trees and Heaps
File Name: DFS.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing and Geeks for geeks 
*/


import java.util.*;

public class DFS<T> {
    private Set<T> visited = new HashSet<>();
    private MapGraph<T> map;

    public DFS(MapGraph<T> graph, T start) {
        this.map = graph;
        dfsUtil(start);
    }

    private void dfsUtil(T vertex) {
        visited.add(vertex);
        System.out.println("Visited: " + vertex);

        for (T adjVertex : map.getAdjacentVertices(vertex)) {
            if (!visited.contains(adjVertex)) {
                dfsUtil(adjVertex);
            }
        }
    }
}
