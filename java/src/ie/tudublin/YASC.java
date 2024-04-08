package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class YASC extends PApplet
{

    ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    public void setup()
    {
        Player player = new Player(this, width/2, height /2, 0, 0, 100);

        Player p1 = new Player(this, 100, 100, 0, 67, 200);

        gameObjects.add(player);
        gameObjects.add(p1);
    }

    public void settings()
    {
        size(500, 500);
    }

    public void draw()
    {
        background(0);
        
        for(int i = 0 ; i < gameObjects.size() ; i++)
        {
            GameObject go = gameObjects.get(i);
            go.render();
            
        }

        text("Game Objects: " + gameObjects.size(), 10, 10);
    }
}
