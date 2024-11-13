import java.util.Random;
/**
 * Abstract class demon - 
 * The creature is the main class from which all other battling creatures derive.
 * It is the creature's job to maintain current health values in response to 
 * requests to takeDamage. It also must report if
 * the creature is alive or knocked out. The creature is also responsible for calculating
 * damage delivered based on the creature's strength (1 to str) 
 *
 * @author Ariel Wong-Edwin
 * @version 11/12/24
 */
public class Demon extends Creature
{
    //Initializing that demons have a 5% chance of doing magic
    private static final double MAGIC_MAYBE = 0.05;
    //Initializing the +50 damage bonus
    private static final int MAGIC_DAM_BONUS = 50;

    /**
     * Constructor for objects of class Demon
     * the random strengths and hitpoints the various demons have
     */
    public Demon(int str, int hp)
    {
        super(str, hp);
    }

    /**
     * Once again adding in the fact that it gives demons a
     * chance to do extra damage.
     * 
     * @return the total damage + 50 if they are successful 
     */
    public int attack()
    {
        Random ran = new Random();
        int regDamage = super.attack();
        
        if(ran.nextDouble() < MAGIC_MAYBE){
            return regDamage + MAGIC_DAM_BONUS;
        }
        else{
        return regDamage;
    }
    }
}
