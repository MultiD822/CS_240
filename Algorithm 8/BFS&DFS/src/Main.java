/*
Programmer: Kai Schenkel
Class: CS 240
Data: 3/5/2024
Algorithms 8: BFS / DFS
File Name: Main.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing
*/

import java.util.Scanner;
import BFS_DFS.*;

public class Main {
    private static Graph<Integer> graph;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;

        while (!quit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add vertex");
            System.out.println("2. Add edge");
            System.out.println("3. Show number of vertices");
            System.out.println("4. Show number of edges");
            System.out.println("5. Check if a vertex exists");
            System.out.println("6. Check if an edge exists");
            System.out.println("7. Print graph");
            System.out.println("8. Quit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter vertex value: ");
                    int vertex = scanner.nextInt();
                    if (graph == null) graph = new Graph<>();
                    graph.addVertex(vertex);
                    System.out.println("Vertex " + vertex + " added.");
                    break;
                case 2:
                    System.out.print("Enter source vertex: ");
                    int source = scanner.nextInt();
                    System.out.print("Enter destination vertex: ");
                    int dest = scanner.nextInt();
                    System.out.print("Is it bidirectional (true/false)? ");
                    boolean isBidirectional = scanner.nextBoolean();
                    if (graph == null) graph = new Graph<>();
                    graph.addEdge(source, dest, isBidirectional);
                    System.out.println("Edge added from " + source + " to " + dest + (isBidirectional ? " (Bidirectional)" : ""));
                    break;
                case 3:
                    if (graph != null) graph.getVertexCount();
                    else System.out.println("Graph is empty.");
                    break;
                case 4:
                    if (graph != null) {
                        System.out.print("Consider bidirectional (true/false)? ");
                        boolean bidirection = scanner.nextBoolean();
                        graph.getEdgesCount(bidirection);
                    } else System.out.println("Graph is empty.");
                    break;
                case 5:
                    System.out.print("Enter vertex value to check: ");
                    int checkVertex = scanner.nextInt();
                    if (graph != null) graph.hasVertex(checkVertex);
                    else System.out.println("Graph is empty.");
                    break;
                case 6:
                    System.out.print("Enter first node: ");
                    int firstNode = scanner.nextInt();
                    System.out.print("Enter second node: ");
                    int secondNode = scanner.nextInt();
                    if (graph != null) graph.hasEdge(firstNode, secondNode);
                    else System.out.println("Graph is empty.");
                    break;
                case 7:
                    if (graph != null) System.out.println(graph);
                    else System.out.println("Graph is empty.");
                    break;
                case 8:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}