/*
Programmer: Kai Schenkel
Class: CS 240
Data: 3/5/2024
Algorithms 8: BFS / DFS
File Name: DFS.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing
*/
package BFS_DFS;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    private List<List<Integer>> adjList;
    private boolean[] visited;
    private int[] parent;
    private int nodes;

    public DFS(int nodes) {
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

    private void dfsUtil(int node) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                parent[neighbor] = node;
                dfsUtil(neighbor);
            }
        }
    }

    public void dfs(int source) {
        for (int i = 0; i < nodes; i++) {
            visited[i] = false;
            parent[i] = -1;
        }
        dfsUtil(source);
    }

    public void printPath(int destination) {
        if (!visited[destination]) {
            System.out.println("No path to node " + destination);
            return;
        }

        Stack<Integer> path = new Stack<>();
        for (int at = destination; at != -1; at = parent[at]) {
            path.push(at);
        }

        System.out.print("Path: ");
        while (!path.isEmpty()) {
            System.out.print(path.pop());
            if (!path.isEmpty()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}
