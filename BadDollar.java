import greenfoot.*;
public class BadDollar extends Money
{
    /**
     * Act - do whatever the BadDollar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public BadDollar(MyWorld world) // Basic BadDollar Setup
    {
        super(world);
        GreenfootImage image = getImage();
        setImage(image);
    }
    
    public void act() // Uses same act as in Money class.
    {
        super.act();
    }
}
