import java.util.*;
import java.io.*;

public class Lab7 {
  final static String 
    INPUT_FILE = "input.txt",   
    OUTPUT_FILE = "output.txt",
    STUDENT_FILE = "student.dat";

  static Scanner in = new Scanner(System.in);
  public static void main(String[] arg) throws FileNotFoundException, IOException {

    while(menu());
  
  }

  /* 
   * Reads from "input.txt" to calculate the sum of the numbers in the file
   * Identifies the sum, maximum and the average of the values read from file
   * */
  static void read_from_file() {
    try {
      Scanner rf 
        = new Scanner(
            new File(INPUT_FILE));

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
    } catch (FileNotFoundException err) {
        System.err.println(INPUT_FILE + " does not exist.");
    }
  }

  /* 
   * Output sum, max, and average to output.txt
   * @param 3 double values: sum, max, avg 
   * */
  static void write_to_file(double sum, double max, double avg) {
    try {
      PrintStream out = 
        new PrintStream(
            new File(OUTPUT_FILE));

      out.printf(
        """
        Sum: %.2f%n
        Max: %.2f%n
        Avg: %.2f%n
        """,
        sum, max, avg);

      menu();
    } 
    catch (FileNotFoundException err) {
        System.err.println("File does not exist");
    }
    catch (IOException err) {
        System.err.println("Cannot write to file");
    }

  }

  static void write_StudentRec() {
    int studentCount = 0;

    String studentData = "";

    System.out.println("Enter the number of students to enter");
    studentCount = in.nextInt();

    try {
      DataOutputStream ds 
        = new DataOutputStream(
            new FileOutputStream(STUDENT_FILE));

      ds.writeInt(studentCount);

      String [] inputPrompt = {
        "Enter student first name",
        "Enter student last name",
        "Enter student's grade",
        "What year did the student take this course?"
      };

      for (int x = 1; x <= studentCount; x++) {
        for (String prompt : inputPrompt) {
          System.out.println(prompt);
          studentData += in.next() + " ";
        }

        in.nextLine();
        ds.writeUTF(studentData + '\n');
      }

      ds.flush();
      ds.close();

      menu();

      }

    catch(FileNotFoundException e) {
      System.err.println("Cannot find file: " + STUDENT_FILE);
    }
    catch (IOException e) {
      System.err.println("I/O error");
      e.printStackTrace();
    }
  }

  static void read_StudentRec() throws FileNotFoundException, IOException{
    DataInputStream dataIn 
      = new DataInputStream(
          new FileInputStream(STUDENT_FILE));

    int studentCount = 0;

    try {
      while(dataIn.available() > 0) {
        System.out.println(dataIn.readUTF());
      }
    
    dataIn.close();
    menu();
    } 

    catch (FileNotFoundException err) {
      System.err.println("Cannot find file: " + STUDENT_FILE);
    }

    catch (IOException err) {
      System.err.println("I/O error");
    }
    // while(dataIn.available() > 0) {
    //   studentCount = dataIn.readInt();
    //   String [] studentNames = new String [studentCount];
    //   String [] studentGrades = new String [studentCount];
    //   String [] yearCourseTaken = new String [studentCount];
    //   studentNames[0] = dataIn.readUTF();
    // }

  }

  static void student_menu (
      int studentCount,
      String [] studentNames,
      String [] studentGrades,
      String [] yearCourseTaken) {

  }

  /**
   * Menu
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
        case 1 -> read_from_file();
        case 2 -> write_StudentRec();
        case 3 -> read_StudentRec();
        case 0 -> System.out.println("Thanks for using our program");
        default -> {
          System.err.println("Invalid option. Try again"); 
          in.nextLine();
          return true;
        }
      }
    }

    else {
      System.err.println("Invalid option. Try again");
      in.nextLine();
      return true;
    }

    // Exit program
    return false;
  }
}
