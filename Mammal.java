
/**
 * Write a description of class Mammals here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mammal extends Animal implements Sounds
{
    private int gestation;
    private int litter;
    private String sound;

    /**
     * Constructor for objects of class Mammals
     */
    public Mammal(String name, String species, String birthdate, int price, int gestation, int litter, String sound){
        super(name, species, birthdate, price);
        this.gestation = gestation;
        this.litter = litter;
        this.sound = sound;
    }
    
    public int getGestation(){
        return gestation;
    }
    
    public int getLitter(){
        return litter;
    }
    
    public String sound(){
        return sound;
    }
    
    public Animal add(String name, String species, String birthdate, int price, int gestation, int litter, String sound){
        return new Mammal(name, species, birthdate, price, gestation, litter, sound);
    }
    
    @Override public String printInfo(){
        return super.printInfo() + ",\t Gestation: "+ gestation+",\t Litter: "+ litter+".";
    }
}
