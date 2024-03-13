import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
    private ArrayList<EdgeNode>[] edges; // Array of adjacency lists
    private int[] degree; // Degree of each vertex
    private int n_Vertices; // Number of vertices
    private int n_Edges; // Number of edges
    private boolean directed; // Whether the graph is directed

    @SuppressWarnings("unchecked")
    public Graph(int max_Vertices, boolean isDirected) {
        edges = (ArrayList<EdgeNode>[]) new ArrayList[max_Vertices + 1];

        for (int i = 0; i <= max_Vertices; i++) {
            edges[i] = new ArrayList<>();
        }

        degree = new int[max_Vertices + 1];
        this.n_Vertices = 0;
        this.n_Edges = 0;
        this.directed = isDirected;
    }
    
    public void add_Edge(int x, int y, int weight, boolean directed) {
        EdgeNode edge = new EdgeNode(y, weight);
        edges[x].add(edge); // Add to the adjacency list of vertex x
        degree[x]++;

        if (!directed) {
            add_Edge(y, x, weight, true); // Add an edge in the opposite direction for undirected graphs
        } else {
            n_Edges++;
        }
    }

    public void printGraph() {
        for (int i = 0; i < edges.length; i++) { // Iterate over each vertex
            System.out.print("Vertex " + i + " has edges to: ");
            for (EdgeNode edge : edges[i]) { // Iterate over each edge for vertex i
                System.out.print(edge.end_Point + " (Weight: " + edge.weight_Edge + "), ");
            }
            System.out.println(); // New line for the next vertex
        }
    }
    
    public int primsAlgorithm(int startVertex) {
        int nVertices = this.edges.length - 1; // Assuming the first index is 1 based on your C code
        boolean[] inGraph = new boolean[nVertices + 1];
        int[] distance = new int[nVertices + 1];
        int[] parent = new int[nVertices + 1];
        int weight = 0;

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        distance[startVertex] = 0;

        for (int i = 1; i <= nVertices; i++) {
            int currentVertex = -1;
            // Find the vertex with the minimum distance
            for (int j = 1; j <= nVertices; j++) {
                if (!inGraph[j] && (currentVertex == -1 || distance[j] < distance[currentVertex])) {
                    currentVertex = j;
                }
            }
            inGraph[currentVertex] = true;
            weight += distance[currentVertex];

            if (currentVertex != startVertex) {
                System.out.printf("Edge (%d,%d) in graph\n", parent[currentVertex], currentVertex);
            }

            // Update the distances
            for (EdgeNode edge : edges[currentVertex]) {
                if (!inGraph[edge.end_Point] && edge.weight_Edge < distance[edge.end_Point]) {
                    distance[edge.end_Point] = edge.weight_Edge;
                    parent[edge.end_Point] = currentVertex;
                }
            }
        }

        return weight;
    }

    public void dijkstrasAlgorithm(int startVertex) {
        int nVertices = this.edges.length - 1; // Assuming the first index is 1
        int[] distance = new int[nVertices + 1]; // Distance from startVertex to i
        boolean[] visited = new boolean[nVertices + 1]; // Track visited vertices
        int[] parent = new int[nVertices + 1]; // To store the path

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        distance[startVertex] = 0;

        PriorityQueue<VertexDistancePair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new VertexDistancePair(startVertex, 0));

        while (!pq.isEmpty()) {
            VertexDistancePair currentPair = pq.poll();
            int currentVertex = currentPair.vertex;

            if (visited[currentVertex]) {
                continue;
            }
            visited[currentVertex] = true;

            for (EdgeNode edge : edges[currentVertex]) {
                if (!visited[edge.end_Point] && distance[currentVertex] + edge.weight_Edge < distance[edge.end_Point]) {
                    distance[edge.end_Point] = distance[currentVertex] + edge.weight_Edge;
                    parent[edge.end_Point] = currentVertex;
                    pq.offer(new VertexDistancePair(edge.end_Point, distance[edge.end_Point]));
                }
            }
        }

        // Printing the results
        for (int i = 1; i <= nVertices; i++) {
            if (distance[i] < Integer.MAX_VALUE) {
                System.out.printf("Distance from %d to %d is %d\n", startVertex, i, distance[i]);
            } else {
                System.out.printf("There is no path from %d to %d\n", startVertex, i);
            }
        }
    }

    private static class VertexDistancePair {
        int vertex;
        int distance;

        VertexDistancePair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public List<Integer> findPath(int startVertex, int endVertex) {
    // Assuming `edges` is your adjacency list, `nVertices` is the number of vertices.
    int nVertices = this.edges.length; // Or however you determine the number of vertices
    int[] distance = new int[nVertices];
    int[] parent = new int[nVertices];
    boolean[] visited = new boolean[nVertices];
    
    // Initialize distances and parent indices
    for (int i = 0; i < nVertices; i++) {
        distance[i] = Integer.MAX_VALUE;
        parent[i] = -1; // -1 indicates that a vertex's predecessor is unknown
        visited[i] = false;
    }
    
    distance[startVertex] = 0;
    PriorityQueue<VertexDistancePair> pq = new PriorityQueue<>((v1, v2) -> v1.distance - v2.distance);
    pq.add(new VertexDistancePair(startVertex, 0));
    
    while (!pq.isEmpty()) {
        VertexDistancePair currentPair = pq.poll();
        int currentVertex = currentPair.vertex;
        
        if (visited[currentVertex]) continue;
        visited[currentVertex] = true;
        
        // If we reach the end vertex, we can stop the loop
        if (currentVertex == endVertex) break;
        
        for (EdgeNode edge : edges[currentVertex]) {
            if (!visited[edge.end_Point] && distance[currentVertex] + edge.weight_Edge < distance[edge.end_Point]) {
                distance[edge.end_Point] = distance[currentVertex] + edge.weight_Edge;
                parent[edge.end_Point] = currentVertex;
                pq.add(new VertexDistancePair(edge.end_Point, distance[edge.end_Point]));
            }
        }
    }

    // Reconstruct the path from endVertex back to startVertex
    List<Integer> path = new ArrayList<>();
    for (int at = endVertex; at != -1; at = parent[at]) {
        path.add(at);
    }
    Collections.reverse(path);
    
    // If the path starts with the startVertex, it's valid; otherwise, it's unreachable.
    if (path.get(0) == startVertex) {
        return path;
    } else {
        throw new RuntimeException("Path does not exist");
    }
}
}
