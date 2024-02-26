package ie.tudublin;

import processing.core.PApplet;



public class Arrays extends PApplet
{
	String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

	float[] rainfall = {200, 260, 300, 150, 100, 50, 10, 40, 67, 160, 400, 420};


	int mode = 0;

	int minIndex = 0;
    int maxIndex  = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}

	public float map1(float a, float b, float c, float d, float e)
	{
		float r1 = c -b;
		float r2 = e - d;

		float howFar = a - b;
		return d + (howFar / r1) * r2;
	}

	void randomize()
	{
		for (int i = 0; i < rainfall.length; i++) {
			rainfall[i] = random(500);
		}
	}

	public void settings()
	{
		size(500, 500);

		String[] m1 = months;
		months[0] = "XXX";
		print(m1[0]);
		for(int i = 0; i < months.length; i ++)
		{
			println("Month: " + months[i] + "\t" + rainfall[i]);
		}
		for (String s : m1) {
			println(s);
		}

		int minIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] < rainfall[minIndex])
			{
				minIndex = i;
			}
		}
		
		int maxIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] > rainfall[maxIndex])
			{
				maxIndex = i;
			}
		}

		println("The month with the minimum rainfall was " + months[minIndex] + " with " + rainfall[minIndex] + "rain");
		println("The month with the max rainfall was " + months[maxIndex] + " with " + rainfall[maxIndex] + "rain");
		
		
		float tot = 0;
		for(float f:rainfall)
		{
			tot += f;
		}

		float avg = tot / (float) rainfall.length;

		// a b-c d-e;
		println(map1(5, 0, 10, 0, 100));
		// 50

		println(map1(25, 20, 30, 200, 300));
		// 250

		println(map1(26, 25, 35, 0, 100));
		// 10 


	}

	public void setup() {
		colorMode(HSB);
		background(0);
		randomize();
		
		
	}

	
	public void draw()
	{
	switch (mode) {
		case 0:
		{
			background(0);
			colorMode(HSB);
			float w = width / (float)rainfall.length;
			noStroke();
			for(int i = 0 ; i < rainfall.length ; i ++)
			{
				float x = map(i, 0, rainfall.length, 0, width);
				int c = (int)map(i, 0, rainfall.length, 0, 255);
				fill(c, 255, 255);
				float h = map(rainfall[i], 0, rainfall[maxIndex], 0, -height);
				rect(x, height, w, h);
				fill(255);
				textAlign(CENTER, CENTER);
				text(months[i], x + (w / 2), height - 50);
			}
			break;
		}
		case 1:
		{
			background(0);
			float border = width * 0.1f;
			// Draw the axis
			stroke(255);
			line(border, border, border, height - border);
			line(border, height - border, width - border, height - border);
			for(int i = 0 ; i <= 120; i += 10)
			{
				float y = map(i, 0, 120, height - border, border);
				line(border - 5, y, border, y);
				fill(255);
				textAlign(CENTER, CENTER);
				text(i, border / 2, y);
			}
			float w = (width - (border * 2.0f)) / (float)rainfall.length;
			
			for(int i = 0 ; i < rainfall.length; i ++)
			{
				float x = map(i, 0, rainfall.length, border, width-border);
				float c = map(i, 0, rainfall.length, 0, 255);
				stroke(255);
				fill(c, 255, 255);
				float h = map(rainfall[i], 0, 120, 0, -height + (border * 2.0f)); 
				rect(x, height-border, w, h);
				fill(255);
				text(months[i], x + (w / 2), height - (border / 2));

			}
			break;
		}
		case 2:
			background(0);
			float r = mouseX;
			float cx = width / 2;
			float cy = height / 2;
			stroke(255);
			noFill();
			//circle(cx, cy, r * 2.0f);
			float tot = 0;
			for(float f:rainfall)
			{
				tot += f;
			}
			float start = 0;
			for(int i = 0 ; i < rainfall.length ; i ++)
			{
				float val = map(rainfall[i], 0, tot, 0, TWO_PI);
				float c = map(i, 0, rainfall.length, 0, 255);
				noStroke();
				fill(c, 255, 255);
				arc(cx, cy, r * 2, r * 2, start, start + val, PIE);
				
				float theta = start + (val * 0.5f);
				float x = cx + cos(theta) * (r * 1.2f);
				float y = cy + sin(theta) * (r * 1.2f);
				fill(255);
				text(months[i], x, y);
				start = start + val;
				
			}

			break;
		}   
	}
}
