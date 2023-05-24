import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    private int timer = 0;
    private int spawnInterval = 60; // 60  = 1 second
    private int points;
    private static final int GROUND_HEIGHT = 5;
    
    public MyWorld()
    {    
        super(612, 408, 1); 
        Player richKid = new Player();
        addObject(richKid, 200, 330);
        prepare();
        Greenfoot.setSpeed(50);
        createGround();
        
        addObject(new Ground(), getWidth() / 2, getHeight() - 5); // Adjust the y-coordinate as needed
    }

    public void act()
    {
        spawnMoney();
        
        while (getScore() <= 0)
        {
            
        }
    }
    
    public void spawnMoney()
    {
        if (timer >= spawnInterval)
        {
            Money money = new Money(this);
            addObject(money, Greenfoot.getRandomNumber(getWidth()), 0);
            timer = 0;
        }
        else
        {
            timer++;
        }
        
        if (timer == 30)
        {
            TwoDollar twoDollar = new TwoDollar(this);
            addObject(twoDollar, Greenfoot.getRandomNumber(getWidth()), 0);
        }
    }
    
    public int getScore()
    {
        Counter counter = (Counter) getObjects(Counter.class).get(0);
        return counter.getValue();
    }

    public void increaseScore(int increment)
    {
        Counter counter = (Counter) getObjects(Counter.class).get(0);
        counter.add(increment);
    }
    
    private void createGround()
    {
        for (int x = 0; x < getWidth(); x += GROUND_HEIGHT)
        {
            addObject(new Ground(), x, getHeight() - GROUND_HEIGHT / 2);
        }
    }

    private void prepare()
    {
        Counter counter = new Counter();
        addObject(counter, 530, 21);
    }
}
