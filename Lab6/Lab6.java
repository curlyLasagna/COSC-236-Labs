import java.util.*;

public class Lab6 {
  static Scanner in = new Scanner(System.in);
  public static void main(String [] args) {
    boolean run = true;
    do {
      int choice = 0;

      // List of program names to choose from
      final String[] progNames = {
        "Calculator",
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
    in.nextLine();
    boolean run = true;
    System.out.println("This calculator takes simple calculations from a user");
    System.out.println("Enter any character to quit");
    do {
      String computation = "";
      computation = in.nextLine();
      Double.parseDouble(computation);
    } while(run);
  }

  
  static void problem2() {
    System.out.println("This is where problem 2 starts");
    
    for (int i=1; i<6; i++){
      for (int k=i; k<=i+4; k++){
        System.out.print(k + " ");
      }
      System.out.println("");
    }
  }

  static void problem3() {
    char [][] board = new char [9][9];
    char pos = 254;
    // Fill board with dashes
    // Arrays.stream(board).forEach(a -> Arrays.fill(a, "-"));
    for(int x = 0;x < 9; x++) 
      for(int y = 0; y < 9; y++) 
        board[x][y] = '-';
      
    // for (char [] row: board)
    //     Arrays.fill(row, 'F');

    for(int x = 0;x < 9; x++) {
      for(int y = 0; y < 9; y++) {
        System.out.print(board[x][y] + ' ');
      }
      System.out.println("");
    }
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

