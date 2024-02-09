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
                fill(80,255,i*25);
                rect(100*i, 0, 105, 800 );
                }
                break;
            case 2:
                for(int i = 0; i<10; i++){
                stroke(i*25,255,255);
                fill(i*25,255,255);
                rect(100*i, 0, 105, 800 );
                }       
                break ;      
            case 3 : 
                for (int i =0 ; i < 10; i++) {
                    fill (i*100+30,100,100) ; //fix coloring 
                    square (i*80,i*80,80) ;
                    square(i*80,height-(i+1)*80, 80);
                }
                break ; 
            case 4 : 
                for (int i = 0 ; i < 10 ; i ++) 
                {   
                    fill (60 + i*30 , 100,100);
                    ellipse (width/2 , height/2, (10 - i) * (width / 10), (10 - i) * (height / 10));
                }
                break ;
            case 5 :  
            background (255) ; 
            for (int i = 0 ; i < 10 ; i ++){
                fill (i*20,255,255);
                stroke (i*20,255,255);
                circle (i*65+50, 50, 60); 
            }
            break ;

            case 6 :
                for (int i =0 ; i <10 ; i ++){
                    for (int k = 0; k <10 ; k ++) {
                        fill (k*20,255,255);
                        ellipse(k * 80 + 40, i * 80 + 40, 80, 80);
                    }
                }
            
            break ; 
        }
                //default goes here
        }
    

    public void keyPressed()
    {
        
        if (key >= '0' && key <= '9')
        {
            mode = key - '0';
        }
    }
    
}
