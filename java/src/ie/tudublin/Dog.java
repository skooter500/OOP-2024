package ie.tudublin;



public class Dog extends Animal
{
	

	// A constructor. Same name as the file. 
	// No return value
	// Member of the Dog class
	public Dog()
	{
		this.name = "rescue puppy";
	}
	
	// A constructor that takes name
	public Dog(String name)
	{
		this();
		this.name = name;
	}

	// A method
	public void speak()
	{
		System.out.println("Woof. I am " + name);
	}
}