package stickgameapp;

/**
 *
 * @author kaichong
 */
public class StickBag {
    
    private int numOfSticks; // to store the number of sticks
    
    public StickBag(int numOfSticks) // this constructor creates an instance of a StickBag object from this class and takes in an int as its parameter.
    {
        this.numOfSticks = numOfSticks;
    }
    
    public boolean removeNumOfSticks(int sticksToRemove)
    {
        // this method removes n number of sticks based on its parameter n.
        // if it is unable to remove the number of sticks due to there not being enough sticks to begin with,
        // the method returns false
        if (numOfSticks>sticksToRemove)
        {
            numOfSticks-=sticksToRemove;
            return true;
        } else {
            return false;
        }
    }
    
    public int getNumOfSticks() // this method returns the number of sticks this object has.
    {
        return numOfSticks;
    }
    
}
