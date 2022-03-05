import java.util.*;

public class Lab6 {
  static Scanner in = new Scanner(System.in);
  public static void main(String [] args) {
    boolean run = true;
    do {
      int choice = 0;

      // List of program names to choose from
      final String[] progNames = {
        "Calcultor",
        "Print 2D array",
        "Traverse board"
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

        in.nextLine();
      }

    } while (run);

    in.close();
  }

  static void problem1() {
    boolean run = true;
    System.out.println(
    """
    This calculator takes simple calculations from a user 
    """
        );

    do {
      in.nextLine();
    } while(run);
  }

  static void problem2() {

  }

  static void problem3() {

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

