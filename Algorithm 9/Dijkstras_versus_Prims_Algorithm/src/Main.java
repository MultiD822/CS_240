/*
Programmer: Kai Schenkel
Class: CS 240
Data: 3/12/2024
Algorithms 9: Dijkstra's vs Prim's Algorithm
File Name: Main.java
Sources: Deitel, Deitel Java Book, Steven S. Skiena The Algorithm Design, and small bit of chatGPT for error handleing
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Hello, World!");

        
        java.awt.EventQueue.invokeLater(() -> {
            The_Gird grid = new The_Gird(10, 10);
            grid.setVisible(true);
            grid.set_Start_Cell(1, 2, Color.GREEN);
            grid.set_End_Cell(9, 9, Color.RED);

            // Create a timer that updates the cells with a delay
            Timer timer = new Timer(100, new ActionListener() {
                private int col = 0;
                private int row = 0;
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    grid.findAndVisualizePath(1, 2, 9, 9);
                    grid.update_Cell(row, col, Color.PINK);
                    
                    col++;
                    if (col == 10) {
                        col = 0;
                        row++;
                    }
                    if (row == 10) {
                        ((Timer)e.getSource()).stop(); // Stop the timer when all cells have been updated
                    }
                }
            });
            timer.setInitialDelay(0);
            timer.start(); // Start the timer
        });
    }

}
