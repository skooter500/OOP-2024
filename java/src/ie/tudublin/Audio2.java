package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio2 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    FFT fft;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings()
    {
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
         ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
         ab = ai.mix; 
        //ap = minim.loadFile("heroplanet.mp3", 1024);
        //ap.play();
        ab = ai.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

        fft = new FFT(width, 44100);

        lerpedBuffer = new float[width];
    }

    float off = 0;

    public void draw()
    {
        //background(0);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
        }
        average= sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        
        float cx = width / 2;
        float cy = height / 2;

        

        switch (mode) {
			case 0:
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    line(i, halfH + f, i, halfH - f);                    
                }

                fft.forward(ab);

                int maxFFTIndex = 0;
                for(int i = 0 ; i < fft.specSize() /2  ; i ++)
                {
                    rect(i, 0, 2, fft.getBand(i) * 100);
                    if (fft.getBand(i) > fft.getBand(maxFFTIndex))
                    {
                        maxFFTIndex = i;
                    }
                }
                float freq = fft.indexToFreq(maxFFTIndex);

                textSize(24);
                text("Frequency: " + freq, cx, cy - 100);
                


                break;
        case 1:
            background(0);
            for(int i = 0 ; i < ab.size() ; i ++)
            {
                //float c = map(ab.get(i), -1, 1, 0, 255);
                float c = map(i, 0, ab.size(), 0, 255);
                stroke(c, 255, 255);
                float f = lerpedBuffer[i] * halfH * 4.0f;
                line(i, halfH + f, halfH - f, i);                    
            }
            break;
        case 2:
            {
                
                    float c = map(smoothedAmplitude, 0, 0.5f, 0, 255);
                    background(0, 0, 0, 10);
                    stroke(c, 255, 255);	
                    float radius = map(smoothedAmplitude, 0, 0.1f, 50, 300);		
                    int points = (int)map(mouseX, 0, 255, 3, 10);
                    int sides = points * 2;
                    float px = cx;
                    float py = cy - radius; 
                    for(int i = 0 ; i <= sides ; i ++)
                    {
                        float r = (i % 2 == 0) ? radius : radius / 2; 
                        // float r = radius;
                        float theta = map(i, 0, sides, 0, TWO_PI);
                        float x = cx + sin(theta) * r;
                        float y = cy - cos(theta) * r;
                        
                        //circle(x, y, 20);
                        line(px, py, x, y);
                        px = x;
                        py = y;
                    }
            }
            break;
        case 3:
            background(0);
            strokeWeight(2);
            noFill();
            float r = map(smoothedAmplitude, 0, 0.5f, 100, 2000);
            float c = map(smoothedAmplitude, 0, 0.5f, 0, 255);
            stroke(c, 255, 255);
            circle(cx, cy, r);
        case 4:
        
            background(0);
            strokeWeight(2);
            for(int i = 0 ; i < ab.size() ; i +=10)
            {
                //float c = map(ab.get(i), -1, 1, 0, 255);
                float cc = map(i, 0, ab.size(), 0, 255);
                stroke(cc, 255, 255);
                float f = lerpedBuffer[i] * halfH * 4.0f;
                line(i, halfH + f, i, halfH - f);
                fill(cc);
                circle(i, halfH + f, 5);                    
                circle(i, halfH - f, 5);                    
            }
            break;
        case 5:
        }
        


        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    }        
}
