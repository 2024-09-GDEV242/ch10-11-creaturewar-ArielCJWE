import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class War here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class War
{
    // instance variables - replace the example below with your own
    private ArrayList<Creature> goodArmy;
    private ArrayList<Creature> evilArmy;

    /**
     * Constructor for objects of class War
     */
    public War()
    {
        // initialise instance variables
        this.goodArmy = new ArrayList<>();
        this.evilArmy = new ArrayList<>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void armySetUp()
    {
        for (int g = 0; g < 100; g++) {
            int ran = Randomizer.nextInt(10);
            if (ran <= 6) {
                goodArmy.add(new Human());
            }
            else {
                goodArmy.add(new Elf());
            }
        }
        
        for (int e = 0; e < 50; e++) {
            int ran = Randomizer.nextInt(25);
            if (ran <= 18) {
                evilArmy.add(new Cyberdemon());
            }
            else if (ran <= 24){
                evilArmy.add(new Balrog());
            }
            else{
                evilArmy.add(new Lucifer());
            }
        }
    }
    
    public void startingTheBattle() {
        int indexGood = 0;
        int indexEvil = 0;
        
        while (indexGood < goodArmy.size() && indexEvil < evilArmy.size()) {
            Creature creaturesGood = goodArmy.get(indexGood);
            Creature creaturesEvil = evilArmy.get(indexEvil);
            
            while (creaturesGood.isAlive() && creaturesEvil.isAlive()){
                int damToEvil = creaturesGood.attack();
                int damToGood = creaturesEvil.attack();
                
                creaturesEvil.takeDamage(damToGood);
                creaturesGood.takeDamage(damToEvil);
            }
            
            if (!creaturesGood.isAlive()) {
            System.out.println(indexGood + "Soldies has fallen from the good side!");
            indexGood++;
            }
            
            if (!creaturesEvil.isAlive()) {
            System.out.println(indexGood + "Soldies has fallen from the evil side!");
            indexEvil++;
            }
        }
        
        if (indexGood < goodArmy.size()) {
            System.out.println("The good side has prevailed! HUZAH!"); 
        }
        else if (indexEvil < evilArmy.size()) {
            System.out.println("I bet Lucifer wiped out the goodside, BOOHOO!");
        }
        else {
            System.out.println("Woah! What are the odds that both sides are tied like this!?");
        }
        
    }
}
