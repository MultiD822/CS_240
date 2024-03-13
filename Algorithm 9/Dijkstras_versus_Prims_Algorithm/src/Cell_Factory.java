/*
Programmer: Kai Schenkel
Class: CS 240
Data: 3/12/2024
Algorithms 9: Dijkstra's vs Prim's Algorithm
File Name: CellFactory.java
Sources: Deitel, Deitel Java Book, Steven S. Skiena The Algorithm Design, and small bit of chatGPT for error handleing
*/

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Color;


public class Cell_Factory extends JPanel{
    private Color undiscovered_Color = Color.white;
    private Color discovered_Color = Color.LIGHT_GRAY;
    private Border black_Border = BorderFactory.createLineBorder(Color.black);
    private boolean cell_Checked;
    //Make the cell
    public Cell_Factory() {
        this.setBackground(undiscovered_Color);
        this.cell_Checked = false;
        this.setBorder(black_Border);
    }

    //Give a way to change the state by passing a color 
    public void change_Cell_State(Color new_State){
        this.setBackground(new_State);
        this.repaint();
    }

    public void set_Check(boolean checked){
        this.cell_Checked = checked;
        if (cell_Checked == true){
            change_Cell_State(discovered_Color);
        } 
    }
}
