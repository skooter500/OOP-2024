package ie.tudublin;

import processing.core.PApplet;

public class MyFirstProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		
		
	}
	
	public void draw()
	{
		background(255, 0xFF, 0); 
		stroke(0, 255, 0);
		line(10, 10, 100, 100); // x1, y1, x2, y2
		fill(90, 0, 0);
		ellipse(200, 90, 80, 200); // cx, cy
		circle(200, 300, 80);
		fill(90, 78, 88);
		rect(400, 380, 50, 100); // x, y, w, h
		triangle(10, 200, 200, 200, 300, 400);
	
	}
}
