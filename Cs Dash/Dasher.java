import greenfoot.*;

public class Dasher extends Actor {
    public static final int GRAVITY = 1;
    private int velocity;
    
    public void act() {
        keys();
        fall();
        jump();
        checkGroundCollision(); // Check for collision with the ground
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
        if (Greenfoot.isKeyDown("space") && onGround()) 
        {
            velocity = -15;
            setLocation(getX(), getY() + velocity);
        }
    }
    
    public boolean onGround() {
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, Ground.class);
        return ground != null;
    }
    
    public void checkGroundCollision() 
    {
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, Ground.class);
        if (ground != null) 
        {
            int groundHeight = ground.getImage().getHeight();
            int groundTop = ground.getY() - groundHeight / 2;
            int dasherBottom = getY() + getImage().getHeight() / 2;
            
            if (dasherBottom >= groundTop) {
                setLocation(getX(), groundTop - getImage().getHeight() / 2);
            }
        }
    }
    
    public void keys() {
        if (Greenfoot.isKeyDown("d")) {
            move(5);
        }
        
        if (Greenfoot.isKeyDown("a")) {
            move(-5);
        }
    }
}
