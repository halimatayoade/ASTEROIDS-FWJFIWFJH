


import greenfoot.*;

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key. 'z' releases a proton wave.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 1.1
 */
public class Rocket extends SmoothMover
{
    //TODO (91): Declare a static integer instance constant called GUN_RELOAD_TIME initialized to 10
    private static final int GUN_RELOAD_TIME = 10;         // The minimum delay between firing the gun.

    //TODO (92): Declare a static integer instance constant called WAVE_RELOAD_TIME initialized to 500
    private static final int WAVE_RELOAD_TIME = 500;      // The minimum delay between firing the wave.

    //TODO (93): Declare an integer instance variable called reloadDelayCount
    private int reloadDelayCount;               // How long ago we fired the gun the last time.

    //TODO (94): Declare an integer instance variable called waveDelayCount
    private int waveDelayCount;                 // How long ago we fired the wave the last time.

    /**
     * Rocket is the constructor for objects of type Rocket
     * 
     * @param None There are not parameters
     * @return Nothing is returned
     */
    public Rocket()
    {

        Vector startMotion = new Vector(getRotation(), 0.7);
        addToVelocity(startMotion);

        //TODO (95): Initialize reloadDelayCount to 10
        reloadDelayCount = 5;

        //TODO (96): Initialize waveDelayCount to 500
        waveDelayCount = 500;
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        //TODO (113): Remove the two slashes in front of this line of code
        checkWin();

        move();

        //TODO (25): Make a call to the method that checks if the user has pressed keys
        checkKeys();

        //TODO (77): Make a call to the method that checks if the user has collided with an asteroid
        checkCollision();

        //TODO (97): Increase reloadDelayCount and waveDelayCount by 1 each
        reloadDelayCount++;
        waveDelayCount++;
    }

    /**
     * checkWin checks to see if there are no more asteroids in the world,
     * which means that the game has been won
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void checkWin()
    {
        Space world = (Space)getWorld();

        if( getWorld().getObjects(Asteroid.class).size() == 0 )
        {
            world.gameWon();
        }
    }

    /**
     * TODO (11): Declare a method called checkKeys that does not
     *          return anything and has not parameters
     *          
     * TODO (109): If the user presses the space key...
     * 
     *      TODO (110): Fire bullets
     *      
     * TODO (12): If the user presses the left key...
     * 
     *      TODO (13): Turn left 5 degrees
     *      
     * TODO (14): If the user presses the right key...
     * 
     *      TODO (15): Turn right 5 degrees
     *      
     * TODO (111): If the user presses the z key...
     * 
     *      TODO (112): Start a proton wave
     *      
     * TODO (24): Make a method call to ignite using Greenfoot.isKeyDown("up") as a parameter
     */

    /**
     * checkKeys checks whether there are any keys pressed and react to them.
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    //TODO 11
    private void checkKeys() 
    {
        //TODO 109
        if (Greenfoot.isKeyDown("space")) 
        {
            //TODO 110
            fire();
        }

        //TODO 12
        if(Greenfoot.isKeyDown("left"))
        {
            //TODO 13
            turn(-5);
        }

        //TODO 14
        if(Greenfoot.isKeyDown("right"))
        {
            //TODO 15
            turn(5);
        }

        //TODO 111
        if(Greenfoot.isKeyDown("z"))
        {
            //TODO 112
            startProtonWave();
        }

        //TODO 24
        ignite( Greenfoot.isKeyDown("up") );
    }

    /**
     * TODO (98): Declare a method called fire that does not
     *            return anything and has no parameters
     * 
     * TODO (99): Declare a local Bullet variable called bullet that
     *            is initialized to a new Bullet object that uses
     *            getVelocity() and getRotation() as parameters
     * 
     * TODO (100): If reloadDelayCount is greater than or equal to GUN_RELOAD_TIME...
     * 
     *      TODO (101): Add the bullet object at the current X location and the current Y location
     *      
     *      TODO (102): Access the move method of bullet
     *      
     *      TODO (103): Set the reloadDelayCount equal to 0
     */

    /**
     * fire fires a bullet if the gun is ready.
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    //TODO 98
    private void fire() 
    {
        //TODO 99
        Bullet bullet = new Bullet (getVelocity(), getRotation());

        //TODO 100
        if (reloadDelayCount >= GUN_RELOAD_TIME) 
        {
            //TODO 101
            getWorld().addObject (bullet, getX(), getY());

            //TODO 102
            bullet.move ();

            //TODO 103
            reloadDelayCount = 0;
        }
    }

    /**
     * TODO (104): Declare a method called startProtonWave that does not
     *            return anything and has no parameters
     *          
     * TODO (105): Declare a local ProtonWave variable called wave that is
     *            initialized to a new ProtonWave object
     *          
     * TODO (106): If waveDelayCount is greater than or equal to WAVE_RELOAD_TIME...
     * 
     *      TODO (107): Add wave to the current X location and the current Y location
     *      
     *      TODO (108): Set the waveDelayCount equal to 0
     */

    /**
     * startProtonWave fires a proton wave if the proton wave is ready
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    //TODO 114
    private void startProtonWave()
    {
        //TODO 105
        ProtonWave wave = new ProtonWave();

        //TODO 106
        if(waveDelayCount >= WAVE_RELOAD_TIME)
        {
            //TODO 107
            getWorld().addObject( wave, getX(), getY() );

            //TODO 108
            waveDelayCount = 0;
        }
    }

    /**
     * TODO (16): Declare a method called ignite that does not
     *            return anything and has a boolean parameter
     *            called boosterOn
     *          
     * TODO (17): Declare a local GreenfootImage variable called
     *            rocket that is initialized to a new GreenfootImage
     *            object using the rocket.png file
     *          
     * TODO (18): Declare a local GreenfootImage variable called
     *            rocketWithThrust that is initialized to a new
     *            GreenfootImage object using the rocketWithThrust.png file
     *          
     * TODO (19): If boosterOn is true...
     * 
     *      TODO (20): Set the image to rocketWithThrust
     *      
     *      TODO (21): Make a method call to addToVelocity using a new
     *                 Vector object with parameters getRotation() and 0.3
     *               
     * TODO (22): Otherwise...
     * 
     *      TODO (23): Set the image to rocket
     */

    /**
     * ignite is a method that allows the rocket to move forward and changes
     * the image of the rocket to show it's booster
     * 
     * @param boosterOn represents whether the rocket should be adding thrust
     * @return Nothing is returned
     */
    //TODO 16
    private void ignite(boolean boosterOn)
    {
        //TODO 17
        GreenfootImage rocket = new GreenfootImage("rocket.png");    

        //TODO 18
        GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");

        //TODO 19
        if(boosterOn == true)
        {
            //TODO 20
            setImage(rocketWithThrust);

            //TODO 21
            addToVelocity( new Vector( getRotation(), 0.3 ) );
        }
        //TODO 22
        else 
        {
            //TODO 23
            setImage(rocket);
        }
    }

    /**
     * TODO (70): Declare a method called checkCollision that does not
     *          return anything and has no parameters
     *          
     * TODO (71): Declare a local Space variable called space that
     *          stores a reference to the world
     *          
     * TODO (72): Declare a local Actor variable called currentAsteroid
     *          that is initialized to get one intersectinf object of
     *          class Asteroid
     *          
     * TODO (73): If currentAsteroid is not nothing...
     * 
     *      TODO (74): Add a new Explosion object at the current X location and the current Y location
     *      
     *      TODO (75): Remove this object
     *      
     *      TODO (76): Make a method call to space's game over method
     */

    /**
     * checkCollision checks whether an asteroid has hit the rocket
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    //TODO 70
    private void checkCollision()
    {
        //TODO 71
        Space space = (Space)getWorld();

        //TODO 72
        Asteroid currentAsteroid = (Asteroid)getOneIntersectingObject(Asteroid.class);

        //TODO 73
        if( currentAsteroid != null )
        {
            //TODO 74
            space.addObject( new Explosion(), getX(), getY() );

            //TODO 75
            space.removeObject(this);

            //TODO 76
            space.gameOver();
        }
    }
}