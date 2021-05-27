
/**
 * Write a description of class StoreDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StoreRun
{
    // instance variables - replace the example below with your own
    private PetStore store;
    private StoreInterface ept;

    /**
     * Constructor for objects of class StoreDemo
     */
    public StoreRun()
    {
        store = new PetStore();
        ept = new StoreInterface(store);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void show()
    {
        ept.run();
    }
}
