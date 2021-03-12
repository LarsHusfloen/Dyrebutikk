
/**
 * Write a description of class Birds here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bird extends Animal
{
    // instance variables - replace the example below with your own
    private int wingspan;
    private String color;

    /**
     * Constructor for objects of class Birds
     */
    public Bird(String name, String species, String bdate, int price, int wingspan, String color){
        super(name, species, bdate, price);
        this.color = color;
        this.wingspan = wingspan;
    }
    
    public int getWingspan(){
        return wingspan;
    }
    
    public String getColor(){
        return color;
    }
    
    public void getBirdDescription(){
        System.out.println("Species: " +getSpecies()+ ",\t Name: " +getName()+",\t Birthdate: "
        +bdate+",\n Price: " +getPrice()+ ",\t Wingspan: "+wingspan+",\t Color: "+color+".");
    }
}
