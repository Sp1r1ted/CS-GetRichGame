import greenfoot.*;  
public class MyWorld extends World
{
    private int timer = 8; // Everytime money is spawned.
    private int spawnInterval = 80; // Max Time
    private int points; // Points that appear on scoreboard
    private static final int GROUND_HEIGHT = 5; // Final ground height for ground class.
    GreenfootSound bg = new GreenfootSound("backgroundMusic.wav"); // Background Music
    public MyWorld() // basic setup for MyWorld()
    {    
        super(612, 408, 1); // Constructs world
        Player richKid = new Player(); // Spawns in Player Object
        addObject(richKid, 200, 330); // Spawns in Player
        prepare(); // Calls prepare which adds the counter class.
        Greenfoot.setSpeed(50); // Speed game is meant to be played at.
        createGround(); // Creates ground object.
        bgMusic();
        
        addObject(new Ground(), getWidth() / 2, getHeight() - 5); // Location of ground
    }

    public void act()
    {
        spawnMoney();
        checkGameOver();
    }
    
    public void spawnMoney() // Spawns Money Object
    {
        if (timer >= spawnInterval) // Money 
        {
            Money money = new Money(this);
            addObject(money, Greenfoot.getRandomNumber(getWidth()), 0);
            timer = 0;
        }
        else // Adds to the timer
        {
            timer++;
        }
        
        if (timer == 30) // Spawns TwoDollar Object
        {
            TwoDollar twoDollar = new TwoDollar(this);
            addObject(twoDollar, Greenfoot.getRandomNumber(getWidth()), 0);
        }
        
        if (timer == 70) // Spawns badDollar Object
        {
            BadDollar badDollar = new BadDollar(this);
            addObject(badDollar, Greenfoot.getRandomNumber(getWidth()), 0);
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
    
    private void checkGameOver() 
    {
        if (getScore() <= -1) 
        {
            Greenfoot.setWorld(new GameOver());
            bgStop();
        }
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
    
    private void bgMusic()
    {
        bg.setVolume(30);
        bg.play();
    }
    private void bgStop()
    {
        bg.stop();
    }
}
