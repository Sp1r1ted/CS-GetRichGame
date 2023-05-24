import greenfoot.*;

public class Ground extends Actor 
{
    public Ground()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 1919, image.getHeight() - 1079);
        setImage(image);
    }
    
    public void act() 
    {
        removeMoney();
    }
    
    private void removeMoney() 
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
