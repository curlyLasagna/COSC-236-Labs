import java.util.*;
import java.io.*;

public class Lab7 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    final String [] progNames = {
      "Read and Sum",
      "Print student information",
      "Read student data"
    };

    while(runProg(in, progNames));

  }

  /* Reads from "input.txt" to calculate the sum of the numbers in the file
   * Identify the maximum value and the average 
   *
   * @return double array containing the sum, max and average 
   * */
  static void read_from_file() {
    Scanner rf = new Scanner(new File("input.txt"));
  }

  /* Output sum, max, and average
   *
   * @param arr double array from read_from_file
   * */
  static void write_to_file(double [] arr) {
    PrintStream out = new PrintStream(new File("output.txt"));
  }

  static void write_StudentRec() {

  }

  static void read_StudentRec() {

  }

  static boolean runProg(Scanner in, String [] progNames) {
    boolean run = true;

    System.out.println(miscFunc.getMenu(progNames));

    if(in.hasNextInt()) {
      int choice = 0;
      System.out.print("> ");
      switch(choice) {
        case 1 -> read_from_file()
        case 2 -> write_StudentRec()
        case 3 -> read_StudentRec()
      }
    }
    return run;
  }
}
