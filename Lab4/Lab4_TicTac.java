/**
 * Coder: Luis
 * Driver: Abdalla
 */
import java.util.*;

public class Lab4_TicTac {
  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    final int ROW_SIZE = 3;
    int row = 0;
    int column = 0;
    char[] fRow = new char[ROW_SIZE];
    char[] sRow = new char[ROW_SIZE];
    char[] tRow = new char[ROW_SIZE];
    Arrays.fill(fRow, ' ');
    Arrays.fill(sRow, ' ');
    Arrays.fill(tRow, ' ');
    printBoard(fRow, sRow, tRow);
    System.out.print("Pick a row: ");
    if (in.hasNextInt()) {
      row = in.nextInt();
      if (row > 3 || row < 1) {
        System.err.println("Invalid input. Try again");
        System.exit(0);
      }
      switch (row) {
        case 1:
          System.out.printf("Pick a column: ");
          if (in.hasNextInt()) {
            column = in.nextInt();
            if (column > 3 || column < 1) {
              System.err.println("Invalid input. Try again");
              System.exit(0);
            }
            fRow[column - 1] = 'X';
          } else {
            System.err.println("Nope");
            System.exit(0);
          }
          break;
        case 2:
          System.out.printf("Pick a column: ");
          if (in.hasNextInt()) {
            column = in.nextInt();
            if (column > 3 || column < 1) {
              System.err.println("Invalid input. Try again");
              System.exit(0);
            }
            sRow[column - 1] = 'X';
          } else {
            System.err.println("Nope");
            System.exit(0);
          }
          break;
        case 3:
          System.out.printf("Pick a column: ");
          if (in.hasNextInt()) {
            column = in.nextInt();
            if (column > 3 || column < 1) {
              System.err.println("Invalid input. Try again");
              System.exit(0);
            }
            tRow[column - 1] = 'X';
          } else {
            System.err.println("Nope");
            System.exit(0);
          }
          break;
      }
    } else {
      System.err.println("Invalid input. Try again");
      System.exit(0);
    }
    printBoard(fRow, sRow, tRow);
  }

  static void printBoard(char[] fRow, char[] sRow, char[] tRow) {
    System.out.printf(
        """
        %2c \u007C %c \u007C %-2c
        \u23AF\u23AF\u23AF\u23AF\u23AF\u23AF\u23AF\u23AF\u23AF\u23AF
        %2c \u007C %c \u007C %-2c
        \u23AF\u23AF\u23AF\u23AF\u23AF\u23AF\u23AF\u23AF\u23AF\u23AF
        %2c \u007C %c \u007C %-2c%n
        """,
        fRow[0], fRow[1], fRow[2],
        sRow[0], sRow[1], sRow[2],
        tRow[0], tRow[1], tRow[2]);
  }
}