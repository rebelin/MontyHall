/* Monty Hall Problem
  Create a random number - (1, 2, 3) = car
  Ask "Which door?" -  user = (1, 2, 3)
  Reveal door  - door != car && door != user
  Ask "Do you want to switch?"  -  yes (user = new value, user != old user && user != door)/no
  Reveal the door the user picks
  User win? */

import java.util.Scanner;
public class MontyHall
{
  public static void main(String[] args)
  {
    welcome();
    game();
  }
  public static void welcome() // Welcome and instructions
  {
    System.out.println("Welcome to the Monty Hall game!");
    System.out.println("Choose one out of the three doors, a different door will be revealed as a goat, then you will have a option to switch your door. If you get the car, you win!");
  }

  public static void game() // Main game
  {
    Scanner kboard = new Scanner(System.in);
    int car = pickRandom(); // Assign the car a door number
    System.out.println("Choose a door: 1, 2, or 3 "); // User picks door
    String input = kboard.nextLine();
    int user = Integer.parseInt(input);

    int someDoor = revealDoor(car, user);
    System.out.println("Door " + someDoor + " has a goat."); // Reveals a door with a goat

    System.out.println("Would you like to switch? yes or no "); //Option to switch
    String answer = kboard.nextLine();
    int diffDoor = switchDoor(answer, user, someDoor);

    System.out.println("You chose door " + diffDoor + "..."); //Results of the game
    System.out.println(result(diffDoor, car));

  }

  public static int pickRandom() // Generates a random number
  {
    int num = (int) (Math.random() * 3 + 1);
    return num;
  }

  public static int revealDoor(int door1, int door2) // Takes in two ints and returns a different int
  {
    int someDoor = 1;
    while (someDoor == (door1) || someDoor == (door2))
    {
      someDoor ++; // The door will switch if it is either of the other doors
    }
    return someDoor;
  }

  public static int switchDoor(String answer, int door1, int door2) //Takes in a string and two ints and returns an int
  {
    int switchedDoor = door1;
    if (answer.toLowerCase().equals("yes"))
    {
      switchedDoor = revealDoor(door1, door2); //Switches the door to the unrevealed door
    }
    return switchedDoor;
  }

  public static String result(int door1, int door2) //Takes in two ints and returns a String
  {
    if (door1 == door2)
    {
      return "Nice! You win the car!";
    }
    else
    {
      return "Sorry, door " + door2 + " had the car. You lose.";
    }
  }
}
