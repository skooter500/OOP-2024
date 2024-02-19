package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {
    
    LifeBoard lifeBoard;
    

    public void setup()
    {
        lifeBoard = new LifeBoard(100, 100, this);
    }

    public void settings()
    {
        size(500, 500);
    }

    public void draw()
    {
        lifeBoard.update();
        lifeBoard.render();
    }
    
}
