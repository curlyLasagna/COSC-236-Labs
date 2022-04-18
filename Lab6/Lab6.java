import java.util.*;

public class Lab6 {
  static Scanner in = new Scanner(System.in);
  static int badInputCount = 0;
  public static void main(String[] args) throws InterruptedException {
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
      System.out.print("> ");

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
            badUser();
            in.nextLine();
            break;
        }
      } else {
        System.err.println("Invalid option. Try again");
        badUser();
        in.nextLine();
      }

    } while (run);

    in.close();
  }

  /**
   * Problem 1. Calculator
   * @author Luis
   * Inputs a space separated math expression
   * Arithmetic operations and 2 values only 
   * */
  static void problem1() throws InterruptedException {
    clearScreen();
    in.nextLine();
    boolean run = true;
    double result = 0;
    boolean singleDigit = false;
    final String pattern = "-?\\.*\\d+\\.*\\d*\\s+[+-/\\*]\\s+-?\\.*\\d+\\.*\\d*";

    System.out.println(
        "This calculator takes simple calculations from a user\n" + 
        "Values must be space separated");

    String [] splitExpression = {""};

    do {
      double lhs, rhs;
      lhs = rhs = 0;
      char op = ' ';
      System.out.print("> ");
      String expression = in.nextLine();

      // Check if pattern is correct (lhs op rhs)
      if (!expression.matches(pattern)) {
        System.err.println("Syntax Error");
        badUser();
        continue;
      }

      splitExpression = expression.split(" ");
      
      lhs = Double.valueOf(splitExpression[0]);
      op = splitExpression[1].charAt(0);
      rhs = Double.valueOf(splitExpression[2]);

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
            badInputCount++;
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
    if (result % 1 == 0)
      System.out.printf("Result: %.0f%n%n", result);
    else
      System.out.printf("Result: %.2f%n%n", result);
  }

  /**
   * Problem 2. Print incrementing 2D array
   * @author Abdalla
   * Prints a 5 x 5 matrix with incrementing numbers
   * */
  static void problem2() {
    clearScreen();
    for (int i = 1; i <= 5; i++) {
      for (int k = 0; k < 5; k++)
        System.out.print((k + i) + " ");
      System.out.println("");
    }
    System.out.println("");
  }

  /**
   * Problem 3. Traverse Board
   * @author Luis & Abdalla
   * Prints a 9x9 board that allows user to 
   * navigate with the given inputs.
   * Wraps when the point goes over the edge
   * */
  static void problem3() throws InterruptedException {
    final int 
      ROW_SIZE = 9,
      COL_SIZE = 9;

    final char 
      point = '∆',
      unPoint = '-';

    boolean quit = false;

    char[][] board = new char[ROW_SIZE][COL_SIZE];

    int xPos, yPos, movDist = 0;
    // Default starting position
    xPos = yPos = 4;

    // Fill board with dashes
    for (char[] b : board)
      Arrays.fill(b, unPoint);

    // Initial position
    board[xPos][yPos] = point;

    clearScreen();

    printBoard(board);
    while (!quit) {
      String input = "";

      System.out.println(
              "Enter the direction you would like to move? (N S E W)" +
              "\nType 'Quit' to end");

      System.out.print("> ");
      input = in.next();
      
      if(!input.equalsIgnoreCase("Quit")) { 
        input = input.substring(0, 1).toUpperCase();
      
      if (input.matches("^[NSEW]")) {

        System.out.printf("Enter the number of spaces you would like to move %s%n", input);

        System.out.print("> ");
        in.nextLine();

        while (!in.hasNextInt()) {
          in.nextLine();
          System.err.println("Invalid input. Try again");
          badUser();
          System.out.print("> ");
        }

        System.out.print("> ");
        movDist = in.nextInt();
        while(movDist > 0) {
          System.err.println("Currently doesn't support negative values. Try again");
        }

        switch (input) {
          case "E":
            board[xPos][yPos] = unPoint;
            yPos = wrap(yPos, movDist, COL_SIZE, true);
            board[xPos][yPos] = point;
            break;
          case "W":
            board[xPos][yPos] = unPoint;
            yPos = wrap(yPos, movDist, COL_SIZE, false);
            board[xPos][yPos] = point;
            break;
          case "S":
            board[xPos][yPos] = unPoint;
            // movDist = (xPos + movDist) % (ROW_SIZE - 1);
            xPos = wrap(xPos, movDist, ROW_SIZE, true);
            board[xPos][yPos] = point;
            break;
          case "N":
            board[xPos][yPos] = unPoint;
            xPos = wrap(xPos, movDist, ROW_SIZE, false);
            board[xPos][yPos] = point;
            break;
        }
        clearScreen();
        printBoard(board);
      }

      else {
        System.out.println("Invalid input. Please try again");
        badUser();
        }

      }

      else 
        quit = true;

    }
  }

  /**
   * Generates a string menu based on the number of programs to choose from.
   * Prepends the index (offset by +1) by the program name
   * @author Luis
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

  /**
   * Wraps an integer position to 0 or maxLength
   * 
   * @param pos Current position
   * @param distance Addend to pos
   * @param maxLength Edge of the world
   * @param op true = plus, false = minus
   * @return position
   */
  public static int wrap(int pos, int distance, int maxLength, boolean op) {
    int destination = (op) ? pos + distance : pos - distance;

    if (destination < 0)
      return Math.abs(destination + maxLength) % maxLength;

    else if (destination == maxLength || destination > maxLength)
      return ((pos - maxLength) + distance) % (maxLength - 1);
    
    return destination;
  }

  public static void printBoard(char[][] board) {
    for (int x = 0; x < 9; x++) {
      for (int y = 0; y < 9; y++) {
        System.out.printf("%c ", board[x][y]);
      }
      System.out.println("");
    }
  }

  // Unecessary methods
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static void badUser() throws InterruptedException {
    badInputCount++;
    if (badInputCount % 3 == 0) {
      System.out.println("\n\nSTOP IT! (ノಠ益ಠ)ノ彡┻━┻ \n\n");
      Thread.sleep(2000);
    }
  }
}
