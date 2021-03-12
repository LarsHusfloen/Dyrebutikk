
/**
 * Write a description of class Mammals here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mammal extends Animal
{
    // instance variables - replace the example below with your own
    private int gestation;
    private int litter;

    /**
     * Constructor for objects of class Mammals
     */
    public Mammal(String name, String species, String bdate, int price, int gestation, int litter){
        super(name, species, bdate, price);
        this.gestation = gestation;
        this.litter = litter;
    }
    
    public int getGestation(){
        return gestation;
    }
    
    public int getLitter(){
        return litter;
    }
    
    public void getMammalDescription(){
        System.out.println("Species: " +getSpecies()+ ",\t Name: " +getName()+",\t Birthdate: "
        +bdate+",\n Price: " +getPrice()+ ",\t Gestation: "+gestation+",\t Litter: "+litter+".");
    }
}
