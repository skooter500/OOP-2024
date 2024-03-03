package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {
    
    boolean[][] board;
    boolean[][] next;

    int rows;
    int cols;

    float cellWidth;
    float cellHeight;
    PApplet p;

    public LifeBoard(int rows, int cols, PApplet p) {
        this.rows = rows;
        this.cols = cols;
        this.p = p; 
        board = new boolean[rows][cols];
        next = new boolean[rows][cols]; // Initialize next array here if opting for memory efficiency
        cellWidth = p.width / (float) cols;
        cellHeight = p.height / (float) rows;
    }

    void randomize() {
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                board[row][col] = p.random(1.0f) < 0.5f;                
            }
        }
    }

    public void update() {
        // Consider moving next array initialization here if not done in the constructor
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int aliveNeighbours = countCells(row, col);
                if (board[row][col]) {
                    next[row][col] = (aliveNeighbours == 2 || aliveNeighbours == 3);
                } else {
                    next[row][col] = (aliveNeighbours == 3);
                }
            }
        }
        boolean[][] temp = board;
        board = next;
        next = temp;
    }

    public void setCell(int row, int col, boolean value) {
        if (row >= 0 && col >= 0 && row < rows && col < cols) { // Adjusted boundary check
            board[row][col] = value;
        }
    }

    public boolean getCell(int row, int col) {
        if (row >= 0 && col >= 0 && row < rows && col < cols) { // Adjusted boundary check
            return board[row][col];
        }
        return false;
    }

    public int countCells(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    if (board[r][c]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void render() {
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                float x = col * cellWidth;
                float y = row * cellHeight;
                p.stroke(200, 255, 255);
                if (board[row][col]) {
                    p.fill(100, 255, 255);
                } else {
                    p.noFill();
                }
                p.rect(x, y, cellWidth, cellHeight);
            }
        }
    }
}

