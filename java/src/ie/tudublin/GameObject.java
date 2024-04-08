package ie.tudublin;

import processing.core.PVector;

public abstract class GameObject
{
    protected PVector pos;
    protected float rotation;
    protected int col;

    PVector forward;
    float speed = 10;

    YASC yasc;

    public GameObject(YASC yasc, float x, float y, float rotation, int col)
    {
        this.yasc = yasc;
        this.pos = new PVector(x, y);
        this.rotation = rotation;
        this.col = col;
        this.forward = new PVector(0, -1);
        
    }

    public PVector getPos() {
        return pos;
    }
    public void setPos(PVector pos) {
        this.pos = pos;
    }
    public float getRotation() {
        return rotation;
    }
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }

    public abstract void render();
    
}