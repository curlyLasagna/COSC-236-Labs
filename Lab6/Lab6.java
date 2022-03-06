import java.util.*;

public class Lab6 {
  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    boolean run = true;
    int badInputCount = 0;
    do {
      int choice = 0;

      // List of program names to choose from
      final String[] progNames = {
          "Calculator",
          "Print 2D array",
          "Traverse board"
      };

      if(badInputCount > 2) {
        System.out.println("\n\nSTOP IT! (ノಠ益ಠ)ノ彡┻━┻ \n\n");
        badInputCount = 0;
      }

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
            System.err.println("Option does not exist. Try again");
            badInputCount++;
            break;
        }
      } else {
        System.err.println("Invalid option. Try again");
        badInputCount++;
        in.nextLine();
      }

    } while (run);

    in.close();
  }

  static void problem1() {
    // Probably a little over engineered
    in.nextLine();
    boolean run = true;
    double result = 0;
    System.out.println("This calculator takes simple calculations from a user");

    do {
      double lhs, rhs;
      lhs = rhs = 0;
      char op = ' ';
      char [] opArr = {'+', '-', '/', '*'};

      /* Regex patterns
       * pattern = expression pattern
       * delimOp = Sets arithmetic operations as a delimiter
       */
      String 
        pattern = "\\d+\\s*[+-/\\*]\\s*\\d+",
        delimOp = "[+-/\\*]+";

      String expression = in.nextLine();
  
      // Stores the two values to be evaluated
      String [] splitExpression = expression.split(delimOp);

      // Check if pattern is correct (lhs op rhs)
      if(!expression.matches(pattern)) {
        System.err.println("Incorrect expression pattern");
        continue;
      }

      lhs = Double.parseDouble(splitExpression[0]);
      rhs = Double.parseDouble(splitExpression[1]);

      // Sets the operation of the expression
      for(int x = 0; x < opArr.length; x++)
        if(expression.indexOf(opArr[x]) > 1)
          op = expression.charAt(expression.indexOf(opArr[x]));

      switch (op) {
        case '+':
          result = lhs + rhs;
          run = false;
          break;
        case '-':
          result = lhs - rhs;
          run = false;
          break;
        case '*':
          result = lhs * rhs;
          run = false;
          break;
        case '/':
          if (rhs == 0) {
            System.err.println("Cannot divide by zero. Try again");
            continue;
          }

          else {
            result = lhs / rhs;
            run = false;
          }
          break;
      }

    } while (run);

    // Only prints decimals if result contains decimals
    if(result % 1 == 0)
      System.out.printf("Result: %.0f%n%n", result);
    else
      System.out.printf("Result: %.2f%n%n", result);

  }

  static void problem2() {
    for (int i = 1; i < 6; i++) {
      for (int k = i; k <= i + 4; k++)
        System.out.print(k + " ");
      System.out.println("");
    }
  }

  static void problem3() {
    final int
      ROW_SIZE = 9,
      COL_SIZE = 9;
    
    boolean quit = false;
    char [][] board = new char [ROW_SIZE][COL_SIZE];
    char point = 254;
    int xPos, yPos, movDist = 0;
    xPos = yPos = 5;

    // Fill board with dashes
    for (char [] b : board)
      Arrays.fill(b, '-');
      
     printBoard(board);
     while (!quit) {
      char input = ' ';
     
      System.out.println("Enter the direction you would like to move? (N S E W)\nType 'quit' to end");
      input = in.next().charAt(0);
      Character.toUpperCase(input);
      System.out.printf("Enter the number of spaces you would like to move %c%n", input);
      movDist = in.nextInt();
      
      switch (input){
        case 'N': 
          board[xPos][yPos] = '-';
          yPos++;
          board[xPos][yPos] = point;
          break;
        case 'S':
          board[xPos][yPos] = '-';
          yPos--;
          board[xPos][yPos] = point;
          break;
        case 'E':
          board[xPos][yPos] = '-';
          xPos++;
          board[xPos][yPos] = point;
          break;
          case 'W':
          board[xPos][yPos] = '-';
          xPos--;
          board[xPos][yPos] = point;
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

    return "Choose a program to run\n" +
        menu +
        "0. Exit";
  }

  // public static int wrapRows(int pos) {
  // //Wraps from Top Edge to Bottom Edge
  // if(pos < 0)
  // return MAX_ROWS-1;
  // //Wraps from Bottom Edge to Top Edge
  // else if(pos == MAX_ROWS || pos > MAX_ROWS) {
  // return 0;
  // }
  // else
  // return pos;
  // }

  // public static int wrapCols(int pos) {
  // if(pos < 0)
  // return MAX_COLS-1;
  // //Wraps from Left Edge to Right Edge
  // else if(pos == MAX_COLS || pos > MAX_COLS)
  // return 0;
  // //Wraps from Right Edge to Left Edge
  // else
  // return pos;
  // }
  //
  
  public static void printBoard(char[][] board) {
    for (int x = 0; x < 9; x++) {
      for (int y = 0; y < 9; y++) {
        System.out.print(board[x][y] + ' ');
      }
      System.out.println("");
    }
  }
}
