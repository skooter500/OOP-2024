
// Packages must match the folder structure
package ie.tudublin;

public class Main
{

	public void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MultiSensoryFoLoopExperience());
    }



	
	public static void main(String[] args)
	{
		System.out.println("Hello world");
		
		
		Main m = new Main();

		m.helloProcessing();
	}
	
}