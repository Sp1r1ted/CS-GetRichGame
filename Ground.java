import greenfoot.*;
public class Ground extends Actor 
{
    public Ground() // Basic Setup for the ground image
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 1919, image.getHeight() - 1079);
        setImage(image);
    }
    
    public void act() // calls methods repeatedly 
    {
        removeMoney();
    }
    
    private void removeMoney() // remove's money on ground
    {
        if (isTouching(Money.class)) 
        {
            Money money = (Money) getOneIntersectingObject(Money.class);
            MyWorld world = (MyWorld) getWorld();
            
            if (money instanceof TwoDollar) 
            {
                world.increaseScore(-2); // Subtract 2 points for TwoDollar
            } 
            else 
            {
                world.increaseScore(-1); // Subtract 1 point for other Money objects
            }
            
            world.removeObject(money);
        }
    }
}
