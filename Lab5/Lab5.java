/**
 * <h1>Lab 5: Arrays</h1>
 * 
 * @author Luis & Abdalla
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
            continue;
        }
      } else {
        System.err.println("Invalid option. Try again");
        /** 
         * Advances the scanner to the next line, essentially flushing the scanner so invalid inputs do not cause an infinite loop.
         * See https://stackoverflow.com/questions/10604125/how-can-i-clear-the-scanner-buffer-in-java
         */
        in.nextLine();
      }

    } while (run);

  }

  /** */
  static void problem1() {
    final int freezing = 32;
    int temperature;

    if(in.hasNextInt())
      temperature = in.nextInt();

    else
      System.err.println("Invalid input. Try again");

  }

  static void problem2() {


  }

  static void problem3() {

  }

  static void problem4() {

  }

  /** 
   * Generates a string menu based on the number of programs to choose from. Prepends the index (offset by 1) to the program name
   * @param String Array of program names
   * @return String Program names to run
   * */ 
  public static String getMenu(String[] progNames) {
    String menu = "";
    for (int x = 0; x < progNames.length; x++)
      menu += Integer.toString(x + 1) + ". " + progNames[x] + '\n';

    return "Choose a program to run\n" +
        menu +
        "0. Exit";
  }

  /**
   *  
   * @param grade Numerical grade
   * @return char Capitalized letter grade
   */
  static char returnLetterGrade(int grade) {
    return 'A';
  }

}