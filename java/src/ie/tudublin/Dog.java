package ie.tudublin;

public class Dog
{
	String name;
	
	public void setName(String name)
	{
		this.name = name;
	}

	// A constructor. Same name as the file. 
	// No return value
	// Member of the Dog class
	public Dog()
	{
	}
	
	// A constructor that takes name
	public Dog(String name)
	{
	}

	// A method
	public void speak()
	{
		System.out.println("Woof");
	}
}