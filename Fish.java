
/**
 * Write a description of class Fish here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fish extends Animal implements Sounds
{
    private int depth;
    private int waterTemp;
    private String sound;

    /**
     * Constructor for objects of class Fish
     */
    public Fish(String name, String species, String birthdate, int price, int depth, int waterTemp, String sound){
        super(name, species, birthdate, price);
        this.depth = depth;
        this.waterTemp = waterTemp;
        this.sound = sound;
    }

    public int getDepth(){
        return depth;
    }
    
    public int getWaterTemp(){
        return waterTemp;
    }
    
    public String sound(){
        return sound;
    }
    
    public Animal add(String name, String species, String birthdate, int price, int depth, int waterTemp, String sound){
        return new Fish(name, species, birthdate, price, depth, waterTemp, sound);
    }
    
    @Override public String printInfo(){
        return super.printInfo() + ",\t Depth: "+depth+",\t WaterTemp: "+waterTemp+".";
    }
}
