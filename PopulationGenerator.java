import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class PopulationGenerator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PopulationGenerator
{
    private ArrayList<Animal> animals;

    /**
     * Constructor for objects of class PopulationGenerator
     */
    public PopulationGenerator()
    {
        animals = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimalsList(){
        return animals;
    }
    
    public int getNumberOfAnimals(){
        int i = animals.size();
        return i;
    }
    
    /**
     * Creates the animals
     */
    public ArrayList<Animal> createAnimals(){
        Animal dog, bunny, cat, bird, fish;
        //lage nye dyr
        animals.add(dog = new Mammal("Daisy", "Dog", "11.02.2015", 1000, 6, 6, "Bark"));
        animals.add(dog = new Mammal("Hope", "Dog", "23.06.2020", 750, 6, 8, "Bark"));
        animals.add(dog = new Mammal("Rubi", "Dog", "01.10.2019", 1500, 7, 12, "Bark"));
        animals.add(bunny = new Mammal("Hoppe", "Bunny", "16.02.2017", 500, 5, 6, "Snap"));
        animals.add(cat = new Mammal("Nelly", "Cat", "30.05.2018", 450, 6, 8, "Mjau"));
        
        animals.add(bird = new Bird("Gel", "Bird", "30.05.2018", 450, 5, "magenta", "Peep"));
        animals.add(bird = new Bird("Nelly", "Bird", "30.05.2018", 450, 3, "blue", "Peep"));
        animals.add(bird = new Bird("Nelly", "Bird", "30.05.2018", 450, 4, "cyan", "Peep"));
        
        animals.add(fish = new Fish("Nemo", "Fish", "30.05.2018", 450, 5, 15, "Blob"));
        animals.add(fish = new Fish("Nelly", "Fish", "30.05.2018", 450, 5, 10, "Blob"));
        animals.add(fish = new Fish("Nelly", "Fish", "30.05.2018", 450, 3, 20, "Blob"));
        return animals;
    }
}
