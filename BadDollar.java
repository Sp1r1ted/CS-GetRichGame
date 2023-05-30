import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Meant to be the BadDollar Class to remove points.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BadDollar extends Money
{
    /**
     * Act - do whatever the BadDollar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public BadDollar(MyWorld world)
    {
        super(world);
        GreenfootImage image = getImage();
        setImage(image);
    }
    
    public void act()
    {
        super.act();
    }
}
