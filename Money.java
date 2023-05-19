import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Money extends Actor
{
    public static final int GRAVITY = 1;
    private int velocity;
    private int points;
    private MyWorld world;

    public Money(MyWorld world)
    {
        this.world = world;
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 420, image.getHeight() - 420);
        setImage(image);
    }

    public void act()
    {
        fall();
        remove();
    }

    public void remove()
    {
        if (!getObjectsAtOffset(1, 1, Player.class).isEmpty())
        {
            world.increaseScore(1); // Increase the score by 1
            world.removeObject(this);
        }
    }

    public void fall()
    {
        velocity += GRAVITY;
        setLocation(getX(), getY() + velocity);
        if (!getObjectsAtOffset(1, 1, Player.class).isEmpty())
        {
            velocity = 0;
        }
    }
}
