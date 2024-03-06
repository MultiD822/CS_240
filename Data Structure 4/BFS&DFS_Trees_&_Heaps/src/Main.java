/*
Programmer: Kai Schenkel
Class: CS 240
Data: 3/5/2024
Data Strutures 4: Breadth First Search and Depth First Search Trees and Heaps
File Name: Main.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing, and Geeks for geeks 
*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        MapGraph<Integer> graph = new MapGraph<Integer>();
        
        Scanner terminalScanner = new Scanner(System.in);

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
            System.out.print("Enter your choice: ");

            int choice = terminalScanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter vertex: ");
                    int vertex = terminalScanner.nextInt();
                    graph.addVertex(vertex);
                    break;
                case 2:
                    System.out.print("Enter source vertex: ");
                    int source = terminalScanner.nextInt();
                    System.out.print("Enter destination vertex: ");
                    int destination = terminalScanner.nextInt();
                    System.out.print("Is it bidirectional (true/false)? ");
                    boolean bidirectional = terminalScanner.nextBoolean();
                    graph.addEdge(source, destination, bidirectional);
                    break;
                case 3:
                    graph.getVertexCount();
                    break;
                case 4:
                    System.out.print("Consider bidirectional (true/false)? ");
                    boolean bidirection = terminalScanner.nextBoolean();
                    graph.getEdgesCount(bidirection);
                    break;
                case 5:
                    System.out.print("Enter vertex to check: ");
                    int vCheck = terminalScanner.nextInt();
                    graph.hasVertex(vCheck);
                    break;
                case 6:
                    System.out.print("Enter first node: ");
                    int firstNode = terminalScanner.nextInt();
                    System.out.print("Enter second node: ");
                    int secondNode = terminalScanner.nextInt();
                    graph.hasEdge(firstNode, secondNode);
                    break;
                case 7:
                    System.out.println(graph);
                    break;
                case 8:
                    terminalScanner.close();
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
