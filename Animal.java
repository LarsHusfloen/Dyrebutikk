
/**
 * Animal.
 * Representing the animals in this project.
 *
 */
public abstract class Animal 
{
    private int price;
    private String species;
    private String name;
    private final String birthdate;

    /**
     * Creates the animal with name, species and price
     * @param name, species, price
     */
    public Animal(String name, String species, String birthdate, int price)
    {
        this.name = name;
        this.species = species;
        this.birthdate = birthdate;
        this.price = price;
        if(name.isEmpty() && species.isEmpty()){
            throw new IllegalStateException("Must have a name and a species.");
        }
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
    
    public String getBirthDate(){
        return birthdate;
    }
    
    abstract public String sound();
    
    public Animal add(String name, String species, String birthdate, int price){
        return null;
    }
    
    /**
     * prints a description of the animal
     */
    public String printInfo(){
        return "Species: " + getSpecies() + ",\t Name: " + getName() +
        ",\t Birthdate: " + birthdate +",\t Price: " + getPrice();
    }
}
