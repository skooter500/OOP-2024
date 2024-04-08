package ie.tudublin;

import processing.core.PVector;

public class Player extends GameObject {
    private float width;
    private float halfW;

    
    public float getWidth() {
        return width;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    public float getHalfW() {
        return halfW;
    }
    public void setHalfW(float halfW) {
        this.halfW = halfW;
    }




    public Player(YASC yasc, float x, float y, float rotation, int col, float width) {
        super(yasc, x, y, rotation, col);
        this.width = width;
        this.halfW = width * 0.5f;
        forward = new PVector(0, -1);
    }    


    public void render()
    {

        forward.x = yasc.sin(rotation);
        forward.y = - yasc.cos(rotation);
        if (yasc.keyPressed)
        {
            
            if (yasc.keyCode == yasc.LEFT)
            {
                this.rotation -= 0.1f;
            }

            if (yasc.keyCode == yasc.RIGHT)
            {
                rotation += 0.1f;
            }

            if (yasc.keyCode == yasc.UP)
            {
                pos.x = pos.x + forward.x * speed;
                pos.y = pos.y + forward.y * speed;
            }

            if (yasc.keyCode == yasc.DOWN)
            {
                pos.y = pos.y + 1;
            }

            if (yasc.key == ' ')
            {

                Bullet b = new Bullet(yasc, pos.x, pos.y, rotation, col);
                yasc.gameObjects.add(b);

            }

            
        }
        // yasc.circle(pos.x, pos.y, width);
        yasc.pushMatrix();
        yasc.stroke(255);
        yasc.translate(pos.x, pos.y);
        yasc.rotate(rotation);        
        yasc.line(- halfW, halfW, 0, - halfW);
        yasc.line(0, - halfW, halfW, halfW);
        yasc.line(halfW, halfW, 0, 0);
        yasc.line(0, 0, - halfW, halfW);
        yasc.popMatrix();
           
    }
    
}
