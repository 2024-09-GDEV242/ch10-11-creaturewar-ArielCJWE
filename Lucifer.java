/**
 * The Demon class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [200/99]
 * Implements a maximum/minimum hitpoint total for the creature type [500/100]
 * 
 * @author Ariel Wong-Edwin
 * @version 11/12/24
 */
public class Lucifer extends Demon
{
    // instance variables - replace the example below with your own
    private static final int MAX_LUCIFER_HP = 500;
    private static final int MIN_LUCIFER_HP = 100;
    private static final int MAX_LUCIFER_STR = 200;
    private static final int MIN_LUCIFER_STR = 99;
    //Adding in that the Elf has a 0.01% chance of doing magic.
    private static final double MAGIC_MAYBE = 0.001;
    // Adding in that the Elf has a 2 times damage multiplier.
    private static final int MAGIC_DAM_MULTI = 10;
    /**
     * Constructor for objects of class Demon -
     * Note that the calling class does not need to know anything about the 
     * requirements of Lucifer minimum and maximum values
     * 
     * The instantiating class asks for a demon and the lucifer class is responsible for
     * return a demon object with values in the appropriate range
     * 
     */
    public Lucifer()
    {
        // note how the class uses the static randomizer class to
        // generate the values. This localizes the need to know 
        // max and min values to this class only
        // max-min is range of values
        // range + min ensures that the values don't start at one.
        super(    
            Randomizer.nextInt(MAX_LUCIFER_STR-MIN_LUCIFER_STR)+MIN_LUCIFER_STR,
            Randomizer.nextInt(MAX_LUCIFER_HP-MIN_LUCIFER_HP)+MIN_LUCIFER_HP
            );
          
    }
    /**
     * Overriding the original attack method to add the possibility
     * of magical damage and increased attack strength.
     * @return the total damage * 10 is the magical attack was successful
     */
    public int attack() {
        int regDamage = super.attack();
        if(Math.random() < MAGIC_MAYBE){
            return regDamage * MAGIC_DAM_MULTI;
        }
        else {
            return regDamage;
        }
    }
    
}