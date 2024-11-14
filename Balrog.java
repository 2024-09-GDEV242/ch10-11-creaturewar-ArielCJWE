/**
 * The Balrog class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [100/50]
 * Implements a maximum/minimum hitpoint total for the creature type [200/50]
 * 
 * @author Ariel Wong-Edwin
 * @version 11/12/24
 */
public class Balrog extends Demon
{
    // instance variables - replace the example below with your own
    private static final int MAX_BALROG_HP = 200;
    private static final int MIN_BALROG_HP = 80;
    private static final int MAX_BALROG_STR = 100;
    private static final int MIN_BALROG_STR = 50;
    
    /**
     * Constructor for objects of class Demon -
     * Note that the calling class does not need to know anything about the 
     * requirements of balrog minimum and maximum values
     * 
     * The instantiating class asks for a Creature and the demon class is responsible for
     * return a balrog object with values in the appropriate range
     * 
     */
    public Balrog()
    {
        // note how the class uses the static randomizer class to
        // generate the values. This localizes the need to know 
        // max and min values to this class only
        // max-min is range of values
        // range + min ensures that the values don't start at one.
        super(    
            Randomizer.nextInt(MAX_BALROG_STR-MIN_BALROG_STR)+MIN_BALROG_STR,
            Randomizer.nextInt(MAX_BALROG_HP-MIN_BALROG_HP)+MIN_BALROG_HP
            );
          
    }
    /**
     * Overriding the original attack method to add the two attack 
     * chances where they can have magical increased strength.
     * @return two attacks at one turn.
     */
    public int attack() {
        int attackNumberOne = super.attack();
        if(Math.random() < 0.05){
            attackNumberOne += 50; //magical bonus if needed
        }
        int attackNumberTwo = super.attack();
        if(Math.random() < 0.05){
            attackNumberTwo += 50; //magical bonus if needed
        }
        return attackNumberOne + attackNumberTwo;
    }
    
}
