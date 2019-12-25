package stickgameapp;
import java.util.Scanner;

/**
 *
 * @author kaichong
 */
public class StickGameApp {

    public static void main(String[] args) {
        
        // Display welcome message
        System.out.println("Welcome to the game of sticks!");
        
        Scanner sc = new Scanner(System.in); // create Scanner object to accept user's inputs
        
        // Request from user the number of sticks they would like to begin with
        System.out.println("Please enter the number of sticks you'd like to begin with in the stick bag (minimum of 15 sticks): ");
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a number!");
            sc.next();
        }
        int sticksNum = sc.nextInt();
        sc.nextLine();
        
            // if user enters a value that is 25 or less, request for them to enter again
            while (sticksNum<15) {
                System.out.println("Enter again the number of sticks you'd like to begin with (enter an int that is more than 15): ");
                while (!sc.hasNextInt()) {
                    System.out.println("Please enter a number!");
                    sc.next();
                }
                sticksNum = sc.nextInt();
                sc.nextLine();
            }
        
        // Request from the user the number of players wanted between 2 and 5 inclusive only
        System.out.println("Please enter the number of computer players you'd like (between 2 to 5 inclusive only): ");
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a number!");
            sc.next();
        }
        int playersWanted = sc.nextInt();
        sc.nextLine();
        
            // if user enters less than 2 or more than 5 as the number of computer players wanted, ask them to re-enter
            while (playersWanted<2 || playersWanted>5) {
                System.out.println("Enter again, the number of computer players wanted (only 2, 3, 4 or 5 players are allowed): ");
                while (!sc.hasNextInt()) {
                    System.out.println("Please enter a number!");
                    sc.next();
                }
                playersWanted = sc.nextInt();
                sc.nextLine();
            }
            
        
        
        StickBag gameBag = new StickBag(sticksNum); // create StickBag object
        
        // Inform the user the number of sticks that is currently in the bag
        System.out.println("\nThere are initially " + gameBag.getNumOfSticks() + " sticks on the board.");
        
        // Decide which player should go first
        int currentPlayer = randomStartingPlayer(playersWanted);
        
        // Inform the user which player is starting first
        System.out.println("The user that is starting first for this round is Player " + currentPlayer + "!\n");
        
        // Game statistics
        int playerThatLost=0; // this variable stores the player that lost once he is known
        boolean loserNotFound=true;
        
            // While the player that loses is not found, each player gets a turn
            while (loserNotFound!=false)
            {
                int num = randomNumOfSticks(); // player picks random number of sticks
                System.out.println("Computer Player " + currentPlayer + " chooses " + num + " sticks. \n(" + gameBag.getNumOfSticks() + " sticks is left)");
                loserNotFound = gameBag.removeNumOfSticks(num); // player removes n sticks from the bag

                if (loserNotFound==false) // checks if the loser has been found
                    playerThatLost = currentPlayer;
                else // otherwise, it's another player's turn
                    currentPlayer = rotatePlayers(playersWanted, currentPlayer);   
            }
        
        // As we have found the player that lost, display the player that lost
        System.out.println("\nPlayer " + playerThatLost + " has lost the game!");
        System.out.println("The game has ended. Thank you.");
        
    }
    
    public static int randomStartingPlayer(int noOfPlayers)
    {    
        double rand = (double)(Math.random()*100.0)+1; // generate between 1.0 to 100.0 percent
        if (noOfPlayers==2) {
            if (rand > (1/2)*100)
                return 1; // returns 1 if rand is above 50%
            else
                return 2; // else returns 2
        }
        if (noOfPlayers==3) {
            if (rand > 66.66)
                return 1; // returns 1 if rand is above 66.66%
            if (rand > 33.33)
                return 2; // returns 2 if rand is above 33.33%
            else
                return 3; // else returns 3
        }
        if (noOfPlayers==4) {
            if (rand > 75.0)
                return 1; // returns 1 if rand is above 75%
            if (rand > 50.0)
                return 2; // returns 2 if rand is above 50%
            if (rand > 25.0)
                return 3; // returns 3 if rand is above 25%
            else
                return 4; // else returns 4
        }
        if (noOfPlayers==5) {
            if (rand > 80.0) // returns 1 if rand is above 80%
                return 1;
            if (rand > 60.0) // returns 2 if rand is above 60%
                return 2;
            if (rand > 40.0) // returns 3 if rand is above 40%
                return 3;
            if (rand > 20.0) // returns 4 if rand is above 20%
                return 4;
            else        
                return 5; // else returns 5
        }
        return -1;
    }
    
    public static int rotatePlayers(int noOfPlayers, int currentPlayer)
    {
        // switch for 2 players only
        if (noOfPlayers == 2) {
            if (currentPlayer==1)
                return 2;
            else 
                return 1;
        }
        
        // switch for 3 players only
        if (noOfPlayers == 3) {
            if (currentPlayer==1)
                return 2;
            if (currentPlayer==2)
                return 3;
            else
                return 1;
        }
        
        // switch for 4 players only
        if (noOfPlayers == 4) {
            if (currentPlayer==1)
                return 2;
            if (currentPlayer==2)
                return 3;
            if (currentPlayer==3)
                return 4;
            else
                return 1;
        }
        
        // switch for 5 players only
        if (noOfPlayers == 5) {
            if (currentPlayer==1)
                return 2;
            if (currentPlayer==2)
                return 3;
            if (currentPlayer==3)
                return 4;
            if (currentPlayer==4)
                return 5;
            else
                return 1;
        }
        return -1;
    }
    
    public static int randomNumOfSticks()
    {
        return (int)(Math.random()*10)+1;
    }
    
}
