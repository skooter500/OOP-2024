package ie.tudublin;

import ddf.minim.AudioOutput;
import ddf.minim.Minim;
import processing.core.PApplet;

public class MultiSensoryFoLoopExperience extends PApplet {

    int mode = 0;

    Minim minim;
    AudioOutput out;

    public void settings()
    {
        size(800, 800);
    }

    public void setup()
    {
        colorMode(HSB);
    }

    public void draw()
    {
        background(0);
        stroke(255);
        switch(mode)
        {
            case 0:
                line(0, 0, width, height);
                // Code goes here
                break;
            case 1:
                for (int i = 0 ; i < 10 ; i ++)
                {
                    // Code goes here

                }
                break;
            default:
                // Code goes here
                break;
        }
    }

    public void keyPressed()
    {
        
        if (key >= '0' && key <= '9')
        {
            mode = key - '0';
        }
    }
    
}
