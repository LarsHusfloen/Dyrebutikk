
/**
 * Write a description of class Birds here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bird extends Animal implements Sounds
{
    private int wingspan;
    private String color;
    private String sound;

    /**
     * Constructor for objects of class Birds
     */
    public Bird(String name, String species, String birthdate, int price, int wingspan, String color, String sound){
        super(name, species, birthdate, price);
        this.color = color;
        this.wingspan = wingspan;
        this.sound = sound;
    }
    
    public int getWingspan(){
        return wingspan;
    }
    
    public String getColor(){
        return color;
    }
    
    public String sound(){
        return sound;
    }
    
    public Animal add(String name, String species, String birthdate, int price, int wingspan, String color, String sound){
        return new Bird(name, species, birthdate, price, wingspan, color, sound);
    }
    
    @Override public String printInfo(){
        return super.printInfo() + ",\t Wingspan: "+wingspan+",\t Color: "+color+".";
    }
}
