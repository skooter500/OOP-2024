package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {
    
    boolean[][] board;

    int rows;
    int cols;

    float cellWidth;
    float cellHeight;
    PApplet p;

    public LifeBoard(int rows, int cols, PApplet p)
    {
        this.rows = rows;
        this.cols = cols;
        this.p = p; 
        board = new boolean[rows][cols];
        cellWidth = p.width / (float) cols;
        cellHeight = p.height / (float) rows;
    }

    public void update()
    {

    }

    public void render()
    {
        
    }



}
