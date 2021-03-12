import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/**
 * PetStore.
 * A store containing animals.
 *
 * @author Lars Husfloen
 * @version 11.03.2021
 */
public class PetStore
{
    private String name;
    private String address;
    private ArrayList<Animal> animals;

    /**
     * Makes an arraylist for animals
     * calls to methodes when starting
     */
    public PetStore()
    {
        animals = new ArrayList<>();
        createAnimals();
        info();
    }

    /**
     * Creates the animals
     */
    private  void createAnimals(){
        Animal dog, bunny, cat, bird, fish;
        //lage nye dyr
        animals.add(dog = new Mammal("Daisy", "Dog", "11.02.2015", 1000, 6, 6));
        animals.add(dog = new Mammal("Hope", "Dog", "23.06.2020", 750, 6, 8));
        animals.add(dog = new Mammal("Rubi", "Dog", "01.10.2019", 1500, 7, 12));
        animals.add(bunny = new Mammal("Hoppe", "Bunny", "16.02.2017", 500, 5, 6));
        animals.add(cat = new Mammal("Nelly", "Cat", "30.05.2018", 450, 6, 8));
        
        animals.add(bird = new Bird("Gel", "Bird", "30.05.2018", 450, 5, "magenta"));
        animals.add(bird = new Bird("Nelly", "Bird", "30.05.2018", 450, 3, "blue"));
        animals.add(bird = new Bird("Nelly", "Bird", "30.05.2018", 450, 4, "cyan"));
        
        animals.add(fish = new Fish("Nemo", "Fish", "30.05.2018", 450, 5, 15));
        animals.add(fish = new Fish("Nelly", "Fish", "30.05.2018", 450, 5, 10));
        animals.add(fish = new Fish("Nelly", "Fish", "30.05.2018", 450, 3, 20));
    }

    /**
     * Prints all animals and the amount
     */
    public void animalList(){
        if(!(animals.size() == 0)){
            sortSpecies(animals);
            System.out.print("The animals currently avalible in the store is;\n");
            for(Animal animal : animals){
                animal.printAnimalInfo();
            }
            numOfAnimals();
        } else {
            System.out.println("There are currently no animals in the store.\n");
        }
    }

    /**
     * prints description of the store
     */
    private void info(){
        name = "Buster's zoo";
        address = "Sysselsveien 25";
        System.out.println(name + ", located at " + address + ".\n");
    }
    
    /**
     * prints the number of animals in each species and total in the store
     */
    public void numOfAnimals(){
        HashMap<String, Integer> numAnimals = new HashMap<>();
        System.out.println("\nThe store contains:");
        for(Animal animal : animals){
            String numbAnimals = animal.getSpecies();
            numAnimals.put(numbAnimals, (numAnimals.getOrDefault(numbAnimals, 0))+ 1);
        }
        numAnimals.forEach((k,v) -> System.out.println(k + ": " + v));
        System.out.println("\nfor a total of " + animals.size() + " animals.\n");
    }

    /**
     * prints a list of animals with a price higher than input
     * @param lower limit for price range
     */
    public void listOfPrice(int price){
        System.out.println("Animals with a price under: " + price + ".\n");
        int size = 0;
        sortPrice(animals);
        for(Animal animal : animals){
            if(animal.getPrice() <= price){
                animal.printAnimalInfo();
                size += 1;
            }
        }
        if(size == 0){
            System.out.println("There are no results for your search.\n");
        } else {
            System.out.println("Number of animals within your search is: " + size + ".\n");
        }
    }

    /**
     * prints a list of animals which species contains the letters
     * @param species or letters to search with
     */
    public void listOfSpecies(String species){
        System.out.println("Animals with the species: " + species + ".\n");
        int size = 0;
        sortSpecies(animals);
        for(Animal animal : animals){
            if(animal.getSpecies().toLowerCase().contains(species.toLowerCase())){
                animal.printAnimalInfo();
                size += 1;
            }
        }
        if(size == 0){
            System.out.println("There are no results for your search.\n");
        } else {
            System.out.println("Number of animals within your search is: " + size + ".\n");
        }
    }
    
   /*public void printAnimalInfo(Animal animal){
        switch (animal.getSpecies()) {
            case ("Mammal"):
            animal.getMammalDescription();
            break;
            
            case ("Bird"):
            animal.getBirdDescription();
            break;
            
            case ("Fish"):
            animal.getFishDescription();
            break;
        }
    }*/

    private void sortName(ArrayList<Animal> animals){
        animals.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    private void sortPrice(ArrayList<Animal> animals){
        animals.sort((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()));
        Collections.reverse(animals);
    }

    private void sortSpecies(ArrayList<Animal> animals){
        animals.sort((o1, o2) -> o1.getSpecies().compareTo(o2.getSpecies()));
    }
}
