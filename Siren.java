/**
 * The Siren class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [25/10]
 * Implements a maximum/minimum hitpoint total for the creature type [50/10]
 * 
 * @author Ariel Wong-Edwin
 * @version 11/12/24
 */
public class Siren extends Creature
{
    // instance variables - replace the example below with your own
    private static final int MAX_SIREN_HP = 50;
    private static final int MIN_SIREN_HP = 10;
    private static final int MAX_SIREN_STR = 25;
    private static final int MIN_SIREN_STR = 10;
    //Adding in that the Elf has a 10% chance of doing magic.
    private static final double MAGIC_MAYBE = 0.05;
    // Adding in that the Elf has a 2 times damage multiplier.
    private static final int MAGIC_DAM_MULTI = 6;

    /**
     * Constructor for objects of class Siren -
     * Note that the calling class does not need to know anything about the 
     * requirements of siren minimum and maximum values
     * 
     * The instantiating class asks for a creature and the siren class is responsible for
     * return a siren object with values in the appropriate range
     * 
     */
    public Siren()
    {
        // note how the class uses the static randomizer class to
        // generate the values. This localizes the need to know 
        // max and min values to this class only
        // max-min is range of values
        // range + min ensures that the values don't start at one.
        super(    
            Randomizer.nextInt(MAX_SIREN_STR-MIN_SIREN_STR)+MIN_SIREN_STR,
            Randomizer.nextInt(MAX_SIREN_HP-MIN_SIREN_HP)+MIN_SIREN_HP
            );
          
    }
    /**
     * Overriding the original attack method to add the possibility
     * of magical damage and increased attack strength.
     * @return the total damage * 6 is the magical attack was successful
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