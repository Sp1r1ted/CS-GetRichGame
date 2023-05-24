import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Money extends Actor
{
    public static final int GRAVITY = 1;
    private int velocity;
    private int points;
    private MyWorld world;
    
    public Money(MyWorld world) // Basic Setup for money in world
    {
        this.world = world;
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 420, image.getHeight() - 420);
        setImage(image);
    }

    public void act() // Where the methods are used
    {
        fall(); // Money fall system
        remove(); // Remove Dollar when it touches player
        
    }

    public void remove()
    {
        if (!getObjectsAtOffset(1, 1, Player.class).isEmpty())
        {
            if (this instanceof TwoDollar)
            {
                world.increaseScore(2); // Increase the score by 2 for TwoDollar
            }
            else 
            {
                world.increaseScore(1); // Increase the score by 1 for other Money objects
            }
            
            world.removeObject(this);
        }
    }

    // public void addPoints(int points)
    // {
        // world.increaseScore(points);
    // }
    
    
    public void fall() // gravity for money
    {
        // velocity += GRAVITY;
        // setLocation(getX(), getY() + velocity);
        setLocation(getX(), getY() + 2);
        if (!getObjectsAtOffset(1, 1, Player.class).isEmpty())
        {
            velocity = 0;
        }
    }
    
    
    
}
