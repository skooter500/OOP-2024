package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {
    
    LifeBoard lifeBoard;
    

    public void setup()
    {
        lifeBoard = new LifeBoard(50, 50, this);
        lifeBoard.randomize();
        colorMode(HSB);
    }

    public void settings()
    {
        size(500, 500);
    }

    public void draw()
    {
        background(0);
        lifeBoard.update();
        lifeBoard.render();
    }
    
}
