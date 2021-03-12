
/**
 * Animal.
 * Representing the animals in this project.
 *
 */
public class Animal
{
    protected int price;
    protected String species;
    protected String name;
    protected final String bdate;

    /**
     * Creates the animal with name, species and price
     * @param name, species, price
     */
    public Animal(String name, String species, String bdate, int price)
    {
        this.name = name;
        this.species = species;
        this.bdate = bdate;
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSpecies(){
        return species;
    }
    
    public Integer getPrice(){
        return price;
    }
    
    public String getBDate(){
        return bdate;
    }
    
    /**
     * prints a description of the animal
     */
    public void printAnimalInfo(){
        System.out.println("Species: " + getSpecies() + ",\t Name: " + getName() +
        ",\t Birthdate: " + bdate +",\t Price: " + getPrice() + ".");
    }
}
