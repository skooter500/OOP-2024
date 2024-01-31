package ie.tudublin;

public class Cat extends Animal {
    public void speak()
    {
        System.out.println("Meaow: " + getName());
    }

    public Cat(String name)
    {
        setName(name);
    }
    
}
