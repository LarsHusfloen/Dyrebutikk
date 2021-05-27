import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
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
    private PopulationGenerator generator;

    private boolean haveRun = false;

    /**
     * Makes an arraylist for animals
     * calls to methodes when starting
     */
    public PetStore()
    {
        animals = new ArrayList<>();
        generator = new PopulationGenerator();
        info();
    }

    /**
     * Prints all animals and the amount
     */
    public void animalList(){
        if(animals.size() == 0){
            throw new IllegalStateException("The store is currently empty.");
        } 
        sortSpecies(animals);
        System.out.print("The animals currently avalible in the store is;\n");
        animals.forEach(s -> System.out.println(s.printInfo()));
        numOfAnimals();
    }

    /**
     * prints the number of animals in each species and total in the store
     */
    private void numOfAnimals(){
        HashMap<String, Integer> numAnimals = new HashMap<>();
        System.out.println("\n\nThe store contains:");
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
    public void listOfPrice(int price) {
        if(animals.size() == 0){
            throw new IllegalStateException("The store is currently empty.");
        }
        System.out.println("\nAnimals with a price under: " + price + ".\n");
        int size = 0;
        sortPrice(animals);
        for(Animal animal : animals){
            if(animal.getPrice() <= price){
                System.out.println(animal.printInfo());
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
        if(species == null){
            throw new IllegalArgumentException("Null key passed to listOfSpecies.");
        }
        if(animals.size() == 0){
            throw new IllegalStateException("The store is currently empty.");
        }
        System.out.println("\nAnimals with the species: " + species + ".\n");
        int size = 0;
        sortSpecies(animals);
        for(Animal animal : animals){
            if(containsSpecies(animals, species)){
                System.out.println(animal.printInfo());
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
     * prints description of the store
     */
    private void info(){
        name = "\n\nBuster's zoo";
        address = "Sysselsveien 25";
        System.out.println(name + ", located at " + address + ".\n");
    }

    public void fillStore(){
        if(!haveRun){
            animals.addAll(generator.createAnimals());
            System.out.println("You have filled the store with animals.");
            haveRun = true;
        } else {
            System.out.println("You have already filled the store.");
        }
    }

    public void sounds(String species){
        if(species == null){
            throw new IllegalArgumentException("Null key passed to sounds.");
        }
        if(animals.size() == 0){
            throw new IllegalStateException("The store is currently empty.");
        }
        System.out.println("\nSounds for the species: " + species + ".\n");
        sortSpecies(animals);

        if(containsSpecies(animals, species)){
            Animal aSound = animals.stream()
                .filter(o -> o.getSpecies().toLowerCase().contains(species.toLowerCase()))
                .findFirst().get();
            System.out.println(species + " make the sound: " + aSound.sound());
        }
        else {
            System.out.println("There are no results for your search.\n");
        }
    }

    public void allSound(){
        if(animals.size() == 0){
            throw new IllegalStateException("The store is currently empty.");
        } else {
            System.out.println("\nSounds for all the species:\n");
            Set<String> unique1 = new HashSet<String>();
            animals.forEach(s -> {
                    String allSound = s.getSpecies() + ": " +s.sound();
                    unique1.add(allSound);
                });
            Set<String> unique2 = new HashSet<String>(unique1);
            unique2.forEach(s -> System.out.println(s));
        }
    }

    public void addAnimal(Animal animal){
        if(animal == null){
            throw new IllegalArgumentException("Null value passed to addAnimal.");
        }
        animals.add(animal);
        System.out.println("You have added " +animal.printInfo()+ " to the store.");
    }

    private boolean containsSpecies(final ArrayList<Animal> list, final String species){
        return list.stream().filter(o -> o.getSpecies().toLowerCase().equals(species.toLowerCase())).findFirst().isPresent();
    }

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
