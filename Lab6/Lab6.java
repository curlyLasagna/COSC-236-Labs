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
    final int
      ROW_SIZE = 9,
      COL_SIZE = 9;
    
    boolean quit = false;
    char [][] board = new char [ROW_SIZE][COL_SIZE];
    char pos = 254;
    // Fill board with dashes
    Arrays.stream(board).forEach(a -> Arrays.fill(a, '-'));
      
    for(int x = 0;x < 9; x++) {
      for(int y = 0; y < 9; y++) {
        System.out.print(board[x][y] + ' ');
      }
      System.out.println("");
    }

   while (!quit) {
     char input = ' ';
     
     System.out.println("Which direction would you like to move? (N S E W) Type 'quit' to quit");
     input = in.next().charAt(0);
     Character.toUpperCase(input);
     
     switch (input){
       case 'N': 
         // Wrap to bottom
         if (pos < 0)
           pos = ROW_SIZE - 1;
         else if (pos == ROW_SIZE || pos > ROW_SIZE)
           pos = 0;
         
         board[-1][1];
         break;
       case 'S':
         board[+1][];
         break;
       case 'E':
         board[][+1];
         break;
       case 'W':
         board[][-1];
         break;
       }
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
  
  public static int wrapRows(int pos) {
      //Wraps from Top Edge to Bottom Edge
      if(pos < 0) 
        return MAX_ROWS-1;
      //Wraps from Bottom Edge to Top Edge
      else if(pos == MAX_ROWS || pos > MAX_ROWS) {
        return 0;
          }
      else
        return pos;
  }
  
  public static int wrapCols(int pos) {
      if(pos < 0)
        return MAX_COLS-1;
        //Wraps from Left Edge to Right Edge
      else if(pos == MAX_COLS || pos > MAX_COLS)
        return 0;
        //Wraps from Right Edge to Left Edge
      else
        return pos;
  }
}
