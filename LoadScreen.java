import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LoadScreen extends World {
    private boolean spacebarPressed = false;

    public LoadScreen() {
        super(600, 400, 1);
        prepare();
    }

    private void prepare() 
    {
    }

    public void act() {
        if (!spacebarPressed && Greenfoot.isKeyDown("space")) {
            spacebarPressed = true;
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
