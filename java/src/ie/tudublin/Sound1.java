package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Sound1 extends PApplet {

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    
    AudioBuffer b;

    @Override
    public void settings() {
        // Set the size of the window
        size(800, 600);
    }

    @Override
    public void setup() {
        // Setup code goes here
        m = new Minim(this);
        //ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ap = m.loadFile("tomp3.cc - 08 PsychNerD and Marco G  More Cowbell.mp3");
        ap.play();
        b = ap.mix;
    }


    float y = 400;

    float lerpedAvg = 0;

    @Override
    public void draw() {
        colorMode(HSB);
        background(0);
        stroke(255);

        //float f = lerp(10, 20, 0.2);

        //float a = lerp(a, b, 0.1f);

        float h = height / 2;
        for(int i = 0 ; i < b.size() ; i ++)
        {
            float hue = map(i, 0, b.size() , 0, 256);
            stroke(hue, 255, 255);
            noFill();
            //line(i, h , i , h + b.get(i) * h);
            //rect(i, h , i , h + b.get(i) * h);
            //circle(i, h, b.get(i) * h);
        }

        float tot = 0;
        for(int i = 0 ; i < b.size() ; i ++)
        {
            tot += abs(b.get(i));
        }

        float avg = tot / b.size();

        lerpedAvg = lerp(lerpedAvg, avg, 0.1f);
        
        stroke(250, 255, 255);
        circle(h, h, avg * h * 5);

        stroke(200, 255, 255);
        circle(h * 0.5f, h, lerpedAvg * h * 5);

        circle(h, y, 50);
        y += random(-10, 10);

        lerped = lerp(lerped, y, 0.1f);

        stroke(100, 255, 255);
        circle(h + 200, lerped, 50);




        // Drawing code goes here
    }

    float lerped = 0;
}
