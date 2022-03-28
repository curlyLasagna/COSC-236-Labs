import java.util.Scanner;
import java.io.File;

// Output stream for storing data to file 
import java.io.FileInputStream;
import java.io.FileOutputStream;

// Read/Write bytes to file
import java.io.DataInputStream;
import java.io.DataOutputStream;

// Writes text file
import java.io.PrintStream;

// Exceptions
import java.io.FileNotFoundException;
import java.io.IOException;

public class Lab7 {
  final static String 
    INPUT_FILE = "input.txt",   
    OUTPUT_FILE = "output.txt",
    STUDENT_FILE = "student.dat";

  final static String [] progNames = {
    "Text file arithmetic",
    "Write student information",
    "Read student data"
  };

  static Scanner in = new Scanner(System.in);
  public static void main(String[] arg) 
    throws FileNotFoundException, IOException {

    while(menu());

  }

  /* 
   * Reads from "input.txt" to calculate the sum of the numbers in the file
   * Identifies the sum, maximum and the average of the values read from file
   * Prints values to OUTPUT_FILE
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
    } 
    catch (FileNotFoundException err) {
        System.err.println("Cannot find " + INPUT_FILE);
    }
  }

  /* 
   * Output sum, max, and average to output.txt
   * @param 3 double values: sum, max, avg 
   * */
  static void write_to_file(double sum, double max, double avg) {
    try (PrintStream out = 
      new PrintStream(
        new File(OUTPUT_FILE))) {

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
        System.err.println("Cannot write to " + OUTPUT_FILE);
    }
  }

  /**
   * Get user input to write 
   * student information to student.dat 
   * */
  static void write_StudentRec() {
    int studentCount = 0;

    String studentData = "";

    System.out.println("Enter the number of student records to enter");
    studentCount = in.nextInt();

    try (DataOutputStream ds = 
      new DataOutputStream (
        new FileOutputStream(STUDENT_FILE))) {

      ds.writeInt(studentCount);

      String [] inputPrompt = {
        "Enter student first name",
        "Enter student last name",
        "Enter student's grade",
        "What year did the student take this course?"
      };

      for (int x = 0; x < studentCount; x++) {
        miscFunc.clearScreen();
        for (String prompt : inputPrompt) {
          System.out.println(prompt);
          studentData += in.next() + ',';
        }
        ds.writeUTF(studentData);
      }
      ds.flush();
      menu();

      }

    catch(FileNotFoundException e) {
      System.err.println("Cannot find file: " + STUDENT_FILE);
    }

    catch (IOException e) {
      System.err.println("Unable to write to " + STUDENT_FILE);
      System.err.println(e.getMessage());
    }
  }

  /**
   * Reads data from student.dat
   * @throws FileNotFoundException
   * @throws IOException
   */
  static void read_StudentRec() 
      throws FileNotFoundException, IOException {

    int studentCount = 0;

    try (DataInputStream dataIn = 
      new DataInputStream(
          new FileInputStream(STUDENT_FILE))) {

      studentCount = dataIn.readInt();
      String [] studentNames = new String [studentCount];
      String [] studentGrades = new String [studentCount];
      String [] yearCourseTaken = new String [studentCount];

      String test = "";
      while(dataIn.available() > 0) 
        test = dataIn.readUTF();

      String [] splitData = new String [studentCount];
      
      splitData = test.split(",");
      
      // Not my proudest moment -LG
      // Get student names
      for (int i = 0, k = 0; i < splitData.length; i+=4, k++)
        studentNames[k] = splitData[i] + ' ' + splitData[i + 1];

      // Get grades
      for (int i = 2, k = 0; i < splitData.length; i+=4, k++)
        studentGrades[k] = splitData[i];

      // Get year
      for (int i = 3, k = 0; i < splitData.length; i+=4, k++)
        yearCourseTaken[k] = splitData[i];

      student_menu(studentNames, studentGrades, yearCourseTaken);
      menu();
    } 

    catch (FileNotFoundException err) {
      System.err.println("Cannot find file: " + STUDENT_FILE);
    }

    catch (IOException err) {
      System.err.println("Unable to read" + STUDENT_FILE);
    }
  }

  static void student_menu (
      String [] studentNames,
      String [] studentGrades,
      String [] yearCourseTaken) {

        int choice = 0;
        miscFunc.clearScreen();
        System.out.println("Choose student to view full record");
        for(int i = 0; i < studentNames.length; i++) 
          System.out.printf("%d. %s%n", i + 1, studentNames[i]);
        
        System.out.print("> ");
        choice = in.nextInt() - 1;

        System.out.printf(
          """
          %nFull name: %s 
          Grade: %s
          Year course taken: %s%n
          """,
          studentNames[choice], 
          studentGrades[choice], 
          yearCourseTaken[choice]);
  }

  /**
   * Menu
   * @return boolean whether to continue running the program
   * @throws FileNotFoundException IOException
   */
  static boolean menu() 
      throws FileNotFoundException, IOException {
    
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
          miscFunc.clearScreen();    
          System.err.println("Invalid option. Try again"); 
          in.nextLine();
          return true;
        }
      }
    }

    else {
      miscFunc.clearScreen();    
      System.err.println("Invalid option. Try again");
      in.nextLine();
      return true;
    }

    // Exit program
    return false;
  }
}