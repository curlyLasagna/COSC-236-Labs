/**
 * <h1>Lab 5: Arrays</h1>
 * This lab implements different loops to be used for arrays 
 * @author Driver: Luis G. Coder: Abdalla A.
 * 
 */
import java.util.*;

public class Lab5 {
  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {

    boolean run = true;
    do {
      int choice = 0;

      // List of program names to choose from
      final String[] progNames = {
          "Temperature check",
          "Test score loop",
          "Do all the loops",
          "Get 3 random destinations"
      };

      System.out.println(getMenu(progNames));
      if (in.hasNextInt()) {
        choice = in.nextInt();
        switch (choice) {
          case 1:
            problem1();
            break;
          case 2:
            problem2();
            break;
          case 3:
            problem3();
            break;
          case 4:
            problem4();
            break;
          case 0:
            System.out.println("Thanks for using our program!");
            run = false;
            break;
          default:
            System.err.println("Invalid option. Try again");
            break;
        }
      } else {
        System.err.println("Invalid option. Try again");

        /**
         * Advances the scanner to the next line, essentially flushing the scanner so
         * invalid inputs do not cause an infinite loop.
         * See https://stackoverflow.com/questions/10604125/how-can-i-clear-the-scanner-buffer-in-java
         */

        in.nextLine();
      }

    } while (run);
    in.close();
  }

  /**
   * Input temperature
   * print if below or above freezing
   * count total number of temperatures above and below freezing
   * print average of all temperatures
   */
  static void problem1() {
    final int FREEZE = 32;
    int 
      belowFreezingCount = 0,
      aboveFreezingCount = 0;

    double 
      temperature = 0,
      tempSum = 0;

    boolean run = true;
    double tempAvg = 0;

    System.out.println("Input temperatures. Input any character to stop");
      do {
        if (in.hasNextDouble()) {
          temperature = in.nextDouble();
          tempSum += temperature;

          if (temperature > FREEZE) 
            aboveFreezingCount++;
          else 
            belowFreezingCount++;

        } else {
          run = false;
          in.nextLine();
        }
      } while (run);

      tempAvg = tempSum / (double) (aboveFreezingCount + belowFreezingCount);
      System.out.printf("\nAverage temperature: %.2f˚C%n", tempAvg);

      System.out.println("");
      in.nextLine();
  }

  /**
   * Inputs test scores repeatedly until the user stops
   * Print the total count of letter grades and average score
   */
  static void problem2() {
    in.nextLine();
    double 
      sumGrade = 0,
      testScoreAvg = 0,
      testScore;
    boolean run = true;
    /**
     * Grade        Index
     * A      =      0
     * B      =      1
     * ..     .
     * F      =      5
     */
    int [] letterGradeCount = new int[5];
    char [] letterGrade = { 'A', 'B', 'C', 'D', 'F', };

    Arrays.fill(letterGradeCount, 0);

    System.out.println("Input test scores. Input any character to stop");
      do {

        if (in.hasNextDouble()) {
          testScore = in.nextDouble();
          sumGrade += testScore;

          // F
          if(testScore < 60) 
            letterGradeCount[letterGradeCount.length - 1]++;
          
          // D
          else if (testScore < 70) 
            letterGradeCount[letterGradeCount.length - 2]++;
          
          // C
          else if (testScore < 80) 
            letterGradeCount[letterGradeCount.length - 3]++;
          
          // B
          else if (testScore < 90) 
            letterGradeCount[letterGradeCount.length - 4]++;
          
          // A
          else
            letterGradeCount[letterGradeCount.length - 5]++;
          }  

          else {
            run = false;
            in.nextLine();
          }
        } while (run);

          int totalGradeCount = 0;

          // Sum the number of grades entered
          for (int i : letterGradeCount)
            totalGradeCount += i;

          // Set the test scored averages
          testScoreAvg = sumGrade / (double) totalGradeCount; 
          System.out.printf("%nAverage test score: %.2f%n" , testScoreAvg);

          for (int x = 0; x < 5; x++)
            System.out.printf("%c:%5d%n", 
                letterGrade[x], letterGradeCount[x]);

          System.out.println("");
          in.nextLine();
    } 

  /**
   * Use "while", "do-while", & "for" loops
   * print for each loops
   * 1 -> 10
   * 10 -> 1
   * 2 -> 20. Evens only
   */
  static void problem3() {
    // For loop
    System.out.println("For loop from 1 -> 10");

    for (int x = 1; x <= 10; x++)
      System.out.println(x);

    System.out.println("\nFor loop from 10 -> 1");
    for (int x = 10; x > 0; x--)
      System.out.println(x);

    System.out.println("\nFor loop from 2 -> 20. Even numbers only");

    for (int x = 2; x <= 20; x++)
      if (x % 2 == 0)
        System.out.println(x);

    // do-while loop
    int x = 1;
    System.out.println("\nDo-while from 1 -> 10");
    do {
      System.out.println(x);
      x++;
    } while (x <= 10);

    System.out.println("\nDo-while from 10 -> 1");
    x = 10;
    do {
      System.out.println(x);
      x--;
    } while (x > 0);

    System.out.println("\nDo-while from 2 -> 20. Even numbers only");
    x = 2;
    do {
      if (x % 2 == 0)
        System.out.println(x);
      x++;
    } while (x <= 20);

    x = 0;
    // While loop
    System.out.println("\nWhile loop from 1 -> 10");
    while(x < 10)
      System.out.println(++x);

    x = 10;
    System.out.println("\nWhile loop from 10 -> 1");
    while(x > 0)
      System.out.println(x--);

    x = 2;
    System.out.println("\nWhile loop from 2 -> 20. Even numbers only");
    while(x <= 20) {
      if (x % 2 == 0)
        System.out.println(x);
      x++;
    }
    System.out.println("");

  }

  /**
   * This program prompts the user for 5 destinations
   * Print 3 unique random destinations out of the 5 entered
   */
  static void problem4() {
    in.nextLine();
    final int MAX_DESTINATION = 5;
    // Use Random class to return a random number
    Random rand = new Random();
    String[] destination = new String[MAX_DESTINATION];
    System.out.println("Enter 5 destinations");

    // visited [] holds the indecis that that have been visited
    boolean [] visited = new boolean [MAX_DESTINATION];
    // Initialize as all false
    Arrays.fill(visited, false);

    // Input destinations
    for (int x = 0; x < 5; x++)  {
      destination[x] = in.next();
    }

    // Output
    System.out.println("\nYour 3 random destinations");
    int randIndex = rand.nextInt(destination.length);
    int index = 0;
    while(index < 3) {
      if(!visited[randIndex]) {
        System.out.println(destination[randIndex]);
        // Set the index as visited
        visited[randIndex] = true;
        index++;
      }
      else
        randIndex = rand.nextInt(destination.length);
    }
    System.out.println("");
  }

  /**
   * Generates a string menu based on the number of programs to choose from.
   * Prepends the index (offset by +1) by the program name
   * 
   * @param String Array of program names
   * @return String Program names to run
   */
  public static String getMenu(String[] progNames) {
    String menu = "";
    for (int x = 0; x < progNames.length; x++)
      menu += Integer.toString(x + 1) + ". " + progNames[x] + '\n';

    return 
      "Choose a program to run\n" +
      menu +
      "0. Exit";
  }
}
