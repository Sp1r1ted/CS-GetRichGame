import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Dasher extends Actor
{   
    public static final int GRAVITY = 1;
    private int velocity;
    public void act()
    {
        // Add your action code here.
        keys();
        fall();
        jump();
    }    
    
    public void fall()
    {
        if (!Greenfoot.isKeyDown("space"))
        {
           velocity += GRAVITY;
           setLocation(getX(), getY() + velocity); 
        }
        else
        {
            velocity = 0;
        }
    }
    
    public void jump()
    {
        if (getY() < getWorld().getHeight() && Greenfoot.isKeyDown("space"))
        {
            setLocation(getX(), getY() - 5);
        }
    }
    
    public void keys()
    {
        if (Greenfoot.isKeyDown("d"))
        {
            move(5);
        }
        
        if (Greenfoot.isKeyDown("a"))
        {
            move(-5);
        }
    }
}
