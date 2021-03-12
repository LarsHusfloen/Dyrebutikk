
/**
 * Write a description of class Fish here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fish extends Animal
{
    // instance variables - replace the example below with your own
    private int depth;
    private int waterTemp;

    /**
     * Constructor for objects of class Fish
     */
    public Fish(String name, String species, String bdate, int price, int depth, int waterTemp){
        super(name, species, bdate, price);
        this.depth = depth;
        this.waterTemp = waterTemp;
    }

    public int getDepth(){
        return depth;
    }
    
    public int getWaterTemp(){
        return waterTemp;
    }
    
    public void getFishDescription(){
        System.out.println("Species: " +getSpecies()+ ",\t Name: " +getName()+",\t Birthdate: "
        +bdate+",\n Price: " +getPrice()+ ",\t Depth: "+depth+",\t WaterTemp: "+waterTemp+".");
    }
}
