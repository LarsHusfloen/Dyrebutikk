import java.util.Arrays;
import java.util.InputMismatchException;
/**
 * Write a description of class StoreInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StoreInterface
{
    // instance variables - replace the example below with your own
    private PetStore store;
    private Parser parser;
    private static final String validAnimals[] = {
            "fish", "bird", "mammal"
        };

    /**
     * Constructor for objects of class StoreInterface
     */
    public StoreInterface(PetStore store)
    {
        this.store = store;
        parser = new Parser();
    }

    /**
     * Read a series of commands from the user to interact
     * with the address book. Stop when the user types 'quit'.
     */
    public void run()
    {

        System.out.println("Type 'help' for a list of commands.");

        String command;
        do{
            command = parser.getCommand();
            if(command.equals("add")){ 
                add();
            }
            else if(command.equals("lists")){
                lists();
            }
            else if(command.equals("help")){
                help();
            } 
            else if(command.equals("fill")){
                fill();
            } 
            else if(command.equals("sound")){
                sound();
            }
            else{
                // Do nothing.
            }
        } while(!(command.equals("quit")));

        System.out.println("Goodbye.");
    }

    /**
     * Add a new entry.
     */
    private void add()
    {
        try{
            System.out.print("What animal do you want to add?\n" + Arrays.toString(validAnimals)+ "\n");
            String animal = parser.readLineString().trim().toLowerCase();
            while(!(animal.equals("mammal")) && !(animal.equals("fish")) && !(animal.equals("bird"))){
                System.out.println(animal + " do not correspont with any of the available animals. Try again.");
                animal = parser.readLineString();
            }

            System.out.print("Name: ");
            String name = parser.readLineString().trim();

            System.out.print("Species: ");
            String species = parser.readLineString().trim();

            System.out.print("Birthdate: ");
            String birthdate = parser.readLineString().trim();

            System.out.print("Price: ");
            int price = toInt();

            System.out.print("Sound: ");
            String sound = parser.readLineString().trim();

            System.out.println("Spesification for " +animal+ ".");
            switch(animal){
                case "mammal":
                System.out.print("Gestation: ");
                int gestation = toInt();

                System.out.print("Litter: ");
                int litter = toInt();;

                store.addAnimal(new Mammal(name, species, birthdate, price, gestation, litter, sound));
                break;

                case "fish":
                System.out.print("Depth: ");
                int depth = toInt();

                System.out.print("WaterTemp: ");
                int waterTemp = toInt();

                store.addAnimal(new Fish(name, species, birthdate, price, depth, waterTemp, sound));
                break;

                case "bird":
                System.out.print("Wingspan: ");
                int wingspan = toInt();
                parser.readLineString();

                System.out.print("Color: ");
                String color = parser.readLineString().trim(); 

                store.addAnimal(new Bird(name, species, birthdate, price, wingspan, color, sound));
                break;

                default:
                System.out.println(animal +" is not a valid animal.");
            }
        } /*catch (InputMismatchException e){
        System.out.println("Incorrect type of input. Plese try again.");
        }*/ catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }catch(NumberFormatException e){
            System.out.println("Input cannot be empty.");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * List the available commands.
     */
    private void help()
    {
        parser.showCommands();
    }

    private void fill(){
        store.fillStore();
    }

    private void sound(){
        try{
            System.out.print("Do you want to hear all or a spesific kind?\n All.\t\tSpesific.\n");
            String choice = parser.readLineString();
            switch(choice){
                case "all":
                allSound();
                break;
                case "spesific":
                sounds();
                break;
                default:
                System.out.println("Please specify either 'all' or 'spesific'\n");
            }
        } catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }

    private void allSound(){
        store.allSound();
    }

    private void sounds(){
        System.out.print("What animal sound do you want to know?\n" + Arrays.toString(validAnimals)+ "\n");
        String animal = parser.readLineString();
        store.sounds(animal);
    }

    private void lists(){
        try{
            System.out.print("What type of list do you want? Standard, under a price or a spesific species?\nStandard.\t\tPrice?\t\tSpecies.\n");
            String choice = parser.readLineString();
            switch(choice){
                case "standard":
                list();
                break;
                case "price":
                listPrice();
                break;
                case "species":
                listSpecies();
                break;
                default:
                System.out.println("Please specify either 'standard', 'price' or 'species'\n");
            }
        } catch(IllegalStateException e){
            System.out.println(e.getMessage());
        } catch(NumberFormatException e){
            System.out.println("Input cannot be empty.");
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    /**
     * List the address book's contents.
     */
    private void list()
    {
        store.animalList();
    }

    private void listPrice(){
        System.out.print("Please note your maximum price and we will list available animals under your price.\n");
        int price = toInt();
        store.listOfPrice(price);
    }

    private void listSpecies(){
        System.out.print("Please tell the species you want to list.\n" + Arrays.toString(validAnimals)+ "\n");
        String species = parser.readLineString();
        store.listOfSpecies(species);
    }

    private boolean isNumber(String s){
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i)) == false)
                return false;
        }
        return true;
    }

    private int toInt(){
        String input = parser.readLineString();
        while(!isNumber(input)){
            System.out.println("The input must be a integer.");
            input = parser.readLineString();
        }
        int output = Integer.valueOf(input);
        return output;
    }
}
