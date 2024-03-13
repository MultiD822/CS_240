/*
Programmer: Kai Schenkel
Class: CS 240
Data: 3/12/2024
Algorithms 9: Dijkstra's vs Prim's Algorithm
File Name: The_Gird.java
Sources: Deitel, Deitel Java Book, Steven S. Skiena The Algorithm Design, and small bit of chatGPT for error handleing
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;

public class The_Gird extends JFrame {
    //Golble private vars that set the grid 
    private int grid_Size_X;
    private int grid_Size_Y;
    private Graph theGraph;
    
    private Cell_Factory[][] cell_Grid;

    public The_Gird(int x_Size, int y_Size){
        this.grid_Size_X = x_Size;
        this.grid_Size_Y = y_Size;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Grid of Cells");
        setSize(500, 500);
        cell_Grid = new Cell_Factory[grid_Size_Y][grid_Size_X];
        setLayout(new GridLayout(grid_Size_Y, grid_Size_X));

        for (int y = 0; y < grid_Size_Y; y++) {
            for (int x = 0; x < grid_Size_X; x++) {
                Cell_Factory cell = new Cell_Factory();
                cell.setPreferredSize(new Dimension(20,20));
                cell_Grid[y][x] = cell;
                add(cell);
            }
        }
        initializeGraph();
    }

    private void initializeGraph() {
        theGraph = new Graph(grid_Size_X * grid_Size_Y, false);
    }

    public void update_Cell(int x, int y, Color newState){
        if (x >= 0 && x < grid_Size_X && y >= 0 && y < grid_Size_Y) {
            cell_Grid[y][x].change_Cell_State(newState);
        }
    }

    public void set_Start_Cell(int x, int y, Color newState){
        if (x >= 0 && x < grid_Size_X && y >= 0 && y < grid_Size_Y) {
            cell_Grid[y][x].change_Cell_State(newState);
        }
    }

    public void set_End_Cell(int x, int y, Color newState){
        if (x >= 0 && x < grid_Size_X && y >= 0 && y < grid_Size_Y) {
            cell_Grid[y][x].change_Cell_State(newState);
        }
    }

    public void visualizePath(List<Integer> pathVertices) {
        // Convert graph vertices back to grid coordinates and update cells
        for (int vertex : pathVertices) {
            int x = vertex % grid_Size_X;
            int y = vertex / grid_Size_X;
            update_Cell(x, y, Color.GREEN); // Or another color to indicate the path
        }
    }
}
