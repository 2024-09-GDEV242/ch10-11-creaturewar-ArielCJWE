
/**
 * The Elf class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [20/5]
 * Implements a maximum/minimum hitpoint total for the creature type [25/5]
 * 
 * @author Ariel Wong-Edwin
 * @version 11/12/24
 */
public class Elf extends Creature
{
    // instance variables - replace the example below with your own
    private static final int MAX_ELF_HP = 25;
    private static final int MIN_ELF_HP = 8;
    private static final int MAX_ELF_STR = 18;
    private static final int MIN_ELF_STR = 5;
    //Adding in that the Elf has a 10% chance of doing magic.
    private static final double MAGIC_MAYBE = 0.10;
    // Adding in that the Elf has a 2 times damage multiplier.
    private static final int MAGIC_DAM_MULTI = 2;

    /**
     * Constructor for objects of class Elf -
     * Note that the calling class does not need to know anything about the 
     * requirements of elf minimum and maximum values
     * 
     * The instantiating class asks for a Human and the human class is responsible for
     * return a Elf object with values in the appropriate range
     * 
     */
    public Elf()
    {
        // note how the class uses the static randomizer class to
        // generate the values. This localizes the need to know 
        // max and min values to this class only
        // max-min is range of values
        // range + min ensures that the values don't start at one.
        super(    
            Randomizer.nextInt(MAX_ELF_STR-MIN_ELF_STR)+MIN_ELF_STR,
            Randomizer.nextInt(MAX_ELF_HP-MIN_ELF_HP)+MIN_ELF_HP
            );
          
    }
    /**
     * Overriding the original attack method to add the possibility
     * of magical damage and increased attack strength.
     * @return the total damage * 2 is the magical attack was successful
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