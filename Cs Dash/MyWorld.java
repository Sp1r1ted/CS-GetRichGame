import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        //Player
        Dasher player1 = new Dasher();
        addObject(player1, getWidth() / 2, getHeight() / 2);
        //
        
        //Ground
        Ground ground = new Ground();
        int groundHeight = ground.getImage().getHeight();
        int worldHeight = getHeight();
        int groundY = worldHeight - groundHeight / 2;
        addObject(ground, getWidth() / 2, groundY);
    }
}
