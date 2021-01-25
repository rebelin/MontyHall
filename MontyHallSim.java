/*
main
  for 10000 times
    game

# wins when switch
# wins when stay

probabilities
#winswitch/#switches
#winstay/#stays
*/


import java.util.Scanner;
import java.text.DecimalFormat;
public class MontyHallSim
{
  public static void main(String[] args)
  {
    Scanner kboard = new Scanner(System.in);
    System.out.println("How many times would you like to play? ");
    String sim = kboard.nextLine();
    int simNum = Integer.parseInt(sim);

    int winSwitch = 0;
    double switches = 0;
    int winStay = 0;
    double stays = 0;

    for (int count = 1; count <= simNum; count ++)
    {
      int result = game();

      if (result == 1)
      {
        winSwitch ++;
        switches ++;
      }
      else if (result == 2)
      {
        switches ++;
      }
      else if (result == 3)
      {
        winStay ++;
        stays ++;
      }
      else if (result == 4)
      {
        stays ++;
      }
    }
    //Calculate probabalities
    DecimalFormat df = new DecimalFormat("###.##"); //Round the probabalities to the hundredth place
    double switchProb = winSwitch / switches * 100;
    double stayProb = winStay / stays * 100;

    System.out.println("You switched " + switches + " times and won " + winSwitch + " times");
    System.out.println("The probability of winning after switching is " + df.format(switchProb) + "%.");
    System.out.println("The probability of winning after staying is " + df.format(stayProb) + "%.");
  }

  public static int game() // Main game, returns integer
  {
    Scanner kboard = new Scanner(System.in);
    int car = pickRandom(); // Assign the car a door number
    int user = (int) (Math.random() * 3 + 1); //User behaves randomly

    int someDoor = revealDoor(car, user);

    String answer;
    double num = (double) Math.random(); //Switch is random
    if (num > .50)
    {
      answer = "Yes";
    }
    else
    {
      answer = "No";
    }

    int diffDoor = switchDoor(answer, user, someDoor);
    int win = result(diffDoor, car);

    int value = 0;
    //Test all four outcomes
    if (answer.equals("Yes") && win == 1)
    {
      value = 1;
    }
    else if (answer.equals("Yes") && win == 0)
    {
      value = 2;
    }
    else if (answer.equals("No") && win == 1)
    {
      value = 3;
    }
    else if (answer.equals("No") && win == 0)
    {
      value = 4;
    }
    return value;
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
    if (answer.equals("Yes"))
    {
      switchedDoor = revealDoor(door1, door2); //Switches the door to the unrevealed door
    }
    return switchedDoor;
  }
  public static int result(int door1, int door2) //Takes in two ints and returns an int
  {
    if (door1 == door2)
    {
      return 1;
    }
    else
    {
      return 0;
    }
  }
}
