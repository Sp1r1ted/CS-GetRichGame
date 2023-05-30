import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends World
{
    private int timer = 0;
    private static final int LOOP_DELAY = 100; // What it's supposed to count up to.
    
    /**
     * Constructor for objects of class GameOver.
     */
    public GameOver()
    {    
        super(600, 400, 1); 
        
        GreenfootImage bg = getBackground();
        setBackground(bg);
    }
    
    public void act()
    {
        if (timer == LOOP_DELAY)
        {
            Greenfoot.setWorld(new LoadScreen());
        }
        else
        {
            timer++;
        }
    }
}