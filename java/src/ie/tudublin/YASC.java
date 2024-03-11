package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet
{
    Player player;

    public void setup()
    {
        player = new Player(this, width / 2, height / 2, 0, 0, 100);
    }

    public void settings()
    {
        size(500, 500);
    }

    public void draw()
    {
        background(0);
        player.render();
    }
}
