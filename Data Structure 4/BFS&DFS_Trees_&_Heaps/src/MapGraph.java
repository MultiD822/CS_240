/*
Programmer: Kai Schenkel
Class: CS 240
Data: 3/5/2024
Data Strutures 4: Breadth First Search and Depth First Search Trees and Heaps
File Name: Main.java
Sources: Deitel, Deitel Book, small bit of chatGPT for error handleing and Geeks for geeks 
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class MapGraph<T> {
    private Map<T, List<T> > mapGraph = new HashMap<>();
    

    public void addVertex(T vertex){
        mapGraph.put(vertex, new LinkedList<T>());
    }

    public void addEdge(T source, T destination, boolean bidirectional){
        if (!mapGraph.containsKey(source)) {
            addVertex(source);
        }

        if (!mapGraph.containsKey(destination)) {
            addVertex(destination);
        }

        mapGraph.get(source).add(destination);

        if (bidirectional == true) {
            mapGraph.get(destination).add(source);
        }
    }

    public void getVertexCount()
    {
        System.out.println("The graph has " + mapGraph.keySet().size() + " vertex");
    }

    public void getEdgesCount(boolean bidirection) {
        int count = 0;
        for (T vertex : mapGraph.keySet()) {
            count += mapGraph.get(vertex).size();
        }

        if (bidirection == true) {
            count = count / 2;
        }
        System.out.printf("The graph has %d edges.\n", count);
    }

    public void hasVertex(T isVertex){
        if (mapGraph.containsKey(isVertex)) {
            System.out.printf("The graph contains %d as a vertex.\n", isVertex);
        } else {
            System.out.printf("The graph dose not contains %d as a vertex.\n", isVertex);
        }
    }

    public void hasEdge(T firstNode, T secondNode) {
        if (mapGraph.get(firstNode).contains(secondNode)) {
            System.out.printf("The graph has an edge between %d and %d .\n",firstNode, secondNode);
        } else {
            System.out.printf("The graph has no edge between %d and %d .\n",firstNode, secondNode);
        }
    }

    @Override
    public String toString(){
        StringBuilder stringFactory = new StringBuilder();
        for(T vertex : mapGraph.keySet()){
            stringFactory.append(vertex.toString() + ": ");
            for (T walk : mapGraph.get(vertex)){
                stringFactory.append(walk.toString() + " ");
            }
            stringFactory.append("\n");
        }
        return (stringFactory.toString());
    }

    public List<T> getAdjacentVertices(T vertex) {
        return mapGraph.getOrDefault(vertex, new LinkedList<>());
    }

}