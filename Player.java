import greenfoot.*;
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() // Calls on keys repeatedly
    {
        keys();
    }
    
    public void keys() // Movement
    {
        if (Greenfoot.isKeyDown("d" ) || Greenfoot.isKeyDown("right"))
        {
            move(15);
        }
        
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))
        {
            move(-15);
        }
    }
}
