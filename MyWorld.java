import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    private int timer = 0;
    private int spawnInterval = 60; // 60  = 1 second

    public MyWorld()
    {    
        super(600, 400, 1); 
        Player richKid = new Player();
        addObject(richKid, 200, 330);
        prepare();
        Greenfoot.setSpeed(45);
    }

    public void act()
    {
        spawnMoney();
    }

    private void spawnMoney()
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
    }

    public void increaseScore(int increment)
    {
        Counter counter = (Counter) getObjects(Counter.class).get(0);
        counter.add(increment);
    }

    
    private void prepare()
    {
        Counter counter = new Counter();
        addObject(counter, 530, 21);
    }
}
