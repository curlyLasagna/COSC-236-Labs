import java.util.*;
import java.io.*;

public class Lab7 {
  static Scanner in = new Scanner(System.in);
  public static void main(String[] pneumonoultramicroscopicsilicovolcanoconiosis) throws FileNotFoundException , IOException{

    while(menu());
  
  }

  /* Reads from "input.txt" to calculate the sum of the numbers in the file
   * Identifies the sum, maximum and the average of the values read from file
   *
   * */
  static void read_from_file() throws FileNotFoundException, IOException {
    Scanner rf = new Scanner(new File("input.txt"));

    int countNum = 0;

    double 
      sum = 0,
      max = 0,
      currentNum = 0;

    while (rf.hasNext()) {
      max = currentNum;
      currentNum = rf.nextDouble();

      if(max < currentNum)
        max = currentNum;

      sum += currentNum;
      countNum++;
    }

    rf.close();
    write_to_file(sum, max, sum / countNum);

  }

  /* Output sum, max, and average to output.txt
   * Not a smart way of using variable args as I only need 3 args
   * but didn't feel like typing out 3 separate arg names on the function header
   * @param 3 double values 
   * */
  static void write_to_file(double ...d) throws FileNotFoundException, IOException{
    PrintStream out = new PrintStream(new File("output.txt"));
    out.printf("Sum: %.2f%nMax: %.2f%nAvg: %.2f%n", d[0], d[1], d[2]);
    menu();
  }

  static void write_StudentRec() throws FileNotFoundException, IOException {
    FileOutputStream fs = new FileOutputStream("students.dat");
    BufferedOutputStream bs = new BufferedOutputStream(fs);
    DataOutputStream ds = new DataOutputStream(bs);
    int studentCount = 0;

    String 
      firstName = "( ͡° ͜ʖ ͡°)",
      lastName = "[̲̅$̲̅(̲̅ ͡° ͜ʖ ͡°̲̅)̲̅$̲̅]",
      year = "¯\\_( ͡° ͜ʖ ͡°)_/¯";

    System.out.println("How many heads");
    studentCount = in.nextInt();

    for (int x = 1; x <= studentCount; x++) {
      System.out.println("Enter student " + x + " first name: ");
      firstName = in.next();
      System.out.println("Enter student " + x + " last name: ");
      lastName = in.next();
      System.out.println("What year did " + firstName + " take this course?");
      year = in.next();

      ds.writeBytes(firstName + '\n' + lastName + '\n' + year);
    }

    fs.close();
    bs.close();
    ds.close();

    menu();
  }

  static void read_StudentRec() throws FileNotFoundException, IOException{

    menu();
  }

  /**
   * @return boolean whether to continue running the program
   * @throws FileNotFoundException IOException
   */
  static boolean menu() throws FileNotFoundException, IOException {

    final String [] progNames = {
      "Get file statistics",
      "Print student information",
      "Read student data"
    };

    System.out.println(miscFunc.getMenu(progNames));
    System.out.print("> ");

    if(in.hasNextInt()) {
      int choice = 0;
      choice = in.nextInt();
      switch(choice) {
        case 1: 
          read_from_file();
          break;
        case 2:  
          write_StudentRec();
          break;
        case 3:  
          read_StudentRec();
          break;
        case 0:  
          System.out.println("Thanks for using our program");
          break;
        default:
          System.err.println("Invalid option. Try again"); 
          in.nextLine();
      }
    }

    else {
      System.err.println("Invalid option. Try again");
      in.nextLine();
    }

    in.nextLine();

    return false;
  }
}
