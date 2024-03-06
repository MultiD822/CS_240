/*
Programmer: Kai Schenkel
Class: CS 240
Data: 3/5/2024
Algorithms 8: BFS / DFS
File Name: BFS.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing
*/
package BFS_DFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private List<List<Integer>> adjList;
    private boolean[] visited;
    private int[] parent;
    private int nodes;

    public BFS(int nodes) {
        this.nodes = nodes;
        this.adjList = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++) {
            this.adjList.add(new ArrayList<>());
        }
        this.visited = new boolean[nodes];
        this.parent = new int[nodes];
    }

    public void addEdge(int source, int dest) {
        this.adjList.get(source).add(dest);
    }

    public void bfs(int source) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nodes; i++) {
            visited[i] = false;
            parent[i] = -1;
        }

        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : adjList.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = currentNode;
                    queue.add(neighbor);
                }
            }
        }
    }

    public void printPath(int destination) {
        if (!visited[destination]) {
            System.out.println("No path to node " + destination);
            return;
        }

        LinkedList<Integer> path = new LinkedList<>();
        for (int at = destination; at != -1; at = parent[at]) {
            path.addFirst(at);
        }

        System.out.print("Path: ");
        while (!path.isEmpty()) {
            System.out.print(path.poll());
            if (!path.isEmpty()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
    // Example usage:
    // BFS bfs = new BFS(numberOfNodes);
    // bfs.runBFS(adjacencyList, startingNode);
    // bfs.printPath(destinationNode);
}
