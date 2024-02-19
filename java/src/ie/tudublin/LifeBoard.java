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

    void randomize()
    {
        for(int row = 0 ; row < rows ; row ++)
        {
            for(int col = 0 ; col < cols ; col ++)
            {
                float dice = p.random(1.0f);
                board[row][col] = (dice < 0.5f);                
            }
        }
    }


    public void update()
    {

    }

    public void render()
    {

    }



}
