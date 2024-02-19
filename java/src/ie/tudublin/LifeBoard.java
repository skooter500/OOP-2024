package ie.tudublin;

import java.util.Map;

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
        for(int row = 0 ; row < rows ; row ++)
        {
            for(int col = 0 ; col < cols ; col ++)
            {
                float x = p.map(col, 0, cols, 0, p.width);
                float y = row * cellHeight;
                p.stroke(0,255, 255);
                if (board[row][col])
                {
                    p.fill(0, 255, 0);
                }
                else
                {
                    p.noFill();
                }
                p.rect(x, y, cellWidth, cellHeight);
            }
        }
        
    }



}
