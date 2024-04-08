package ie.tudublin;

import processing.core.PVector;

public class Bullet extends GameObject{

    public Bullet(YASC yasc, float x, float y, float rotation, int col) {
        super(yasc, x, y, rotation, col);
    }    

    public void render()
    {
        forward.x = yasc.sin(rotation);
        forward.y = - yasc.cos(rotation);

        yasc.pushMatrix();
        yasc.translate(pos.x, pos.y);
        yasc.rotate(rotation);
        yasc.line(0, -5, 0, 5);
        yasc.popMatrix();

        pos.add(PVector.mult(forward, speed));

        if (pos.x < 0 || pos.x > yasc.width || pos.y < 0 || pos.y > yasc.height)
        {
            yasc.gameObjects.remove(this);
        }

    }
    
    
}
