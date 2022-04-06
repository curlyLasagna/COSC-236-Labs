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
<<<<<<< HEAD
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
  static void read_from_file() 
    throws FileNotFoundException, IOException {
    try {
      Scanner rf 
        = new Scanner(
            new File(INPUT_FILE));

      int countNum = 0;

      double 
        sum = 0,
        max = 0,
        currentNum = 0;
=======
  final static String INPUT_FILE = "input.txt",
      OUTPUT_FILE = "output.txt",
      STUDENT_FILE = "student.dat";

  final static String[] progNames = {
      "Text file arithmetic",
      "Write student information",
      "Read student data"
  };

  static Scanner in = new Scanner(System.in);

  public static void main(String[] arg)
      throws FileNotFoundException, IOException {

    while (menu())
      ;

  }

  /*
   * Reads from "input.txt" to calculate the sum of the numbers in the file
   * Identifies the sum, maximum and the average of the values read from file
   * Prints values to OUTPUT_FILE
   */
  static void read_from_file()
      throws FileNotFoundException, IOException {
    try {
      Scanner rf = new Scanner(
          new File(INPUT_FILE));

      int countNum = 0;

      double sum = 0,
          max = 0,
          currentNum = 0;
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d

      while (rf.hasNext()) {
        max = currentNum;
        currentNum = rf.nextDouble();

<<<<<<< HEAD
        if(max < currentNum)
=======
        if (max < currentNum)
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d
          max = currentNum;

        sum += currentNum;
        countNum++;
      }

      rf.close();
      write_to_file(sum, max, sum / countNum);
<<<<<<< HEAD
    } 
    catch (FileNotFoundException err) {
=======
    } catch (FileNotFoundException err) {
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d
      System.err.println("Cannot find " + INPUT_FILE);
      menu();
    }
  }

<<<<<<< HEAD
  /* 
   * Output sum, max, and average to output.txt
   * @param 3 double values: sum, max, avg 
   * */
  static void write_to_file(double sum, double max, double avg) 
    throws FileNotFoundException, IOException {
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
        menu();
    }
    catch (IOException err) {
        System.err.println("Cannot write to " + OUTPUT_FILE);
        menu();
=======
  /*
   * Output sum, max, and average to output.txt
   * 
   * @param 3 double values: sum, max, avg
   */
  static void write_to_file(double sum, double max, double avg)
      throws FileNotFoundException, IOException {
    try (PrintStream out = new PrintStream(
        new File(OUTPUT_FILE))) {

      out.printf(
          """
              Sum: %.2f%n
              Max: %.2f%n
              Avg: %.2f%n
              """,
          sum, max, avg);

      menu();
    } catch (FileNotFoundException err) {
      System.err.println("File does not exist");
      menu();
    } catch (IOException err) {
      System.err.println("Cannot write to " + OUTPUT_FILE);
      menu();
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d
    }
  }

  /**
<<<<<<< HEAD
   * Get user input to write 
   * student information to student.dat 
   * */
  static void write_StudentRec() 
    throws FileNotFoundException, IOException {
      int studentCount = 0;

      String studentData = "";

      System.out.println("Enter the number of student records to enter");
      studentCount = in.nextInt();

      try (DataOutputStream ds = 
        new DataOutputStream (
          new FileOutputStream(STUDENT_FILE))) {

        ds.writeInt(studentCount);

        String [] inputPrompt = {
=======
   * Get user input to write
   * student information to student.dat
   */
  static void write_StudentRec()
      throws FileNotFoundException, IOException {
    int studentCount = 0;

    String studentData = "";

    System.out.println("Enter the number of student records to enter");
    studentCount = in.nextInt();

    try (DataOutputStream ds = new DataOutputStream(
        new FileOutputStream(STUDENT_FILE))) {

      ds.writeInt(studentCount);

      String[] inputPrompt = {
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d
          "Enter student first name",
          "Enter student last name",
          "Enter student's grade",
          "What year did the student take this course?"
<<<<<<< HEAD
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
        menu();
      }

      catch (IOException e) {
        System.err.println("Unable to write to " + STUDENT_FILE);
        menu();
      }
=======
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

    catch (FileNotFoundException e) {
      System.err.println("Cannot find file: " + STUDENT_FILE);
      menu();
    }

    catch (IOException e) {
      System.err.println("Unable to write to " + STUDENT_FILE);
      menu();
    }
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d
  }

  /**
   * Reads data from student.dat
<<<<<<< HEAD
   * @throws FileNotFoundException
   * @throws IOException
   */
  static void read_StudentRec() 
=======
   * 
   * @throws FileNotFoundException
   * @throws IOException
   */
  static void read_StudentRec()
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d
      throws FileNotFoundException, IOException {

    int studentCount = 0;

<<<<<<< HEAD
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
=======
    try (DataInputStream dataIn = new DataInputStream(
        new FileInputStream(STUDENT_FILE))) {

      studentCount = dataIn.readInt();
      String[] studentNames = new String[studentCount];
      String[] studentGrades = new String[studentCount];
      String[] yearCourseTaken = new String[studentCount];

      String test = "";
      while (dataIn.available() > 0)
        test = dataIn.readUTF();

      String[] splitData = new String[studentCount];

      splitData = test.split(",");

      // Not my proudest moment -LG
      // Get student names
      for (int i = 0, k = 0; i < splitData.length; i += 4, k++)
        studentNames[k] = splitData[i] + ' ' + splitData[i + 1];

      // Get grades
      for (int i = 2, k = 0; i < splitData.length; i += 4, k++)
        studentGrades[k] = splitData[i];

      // Get year
      for (int i = 3, k = 0; i < splitData.length; i += 4, k++)
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d
        yearCourseTaken[k] = splitData[i];

      student_menu(studentNames, studentGrades, yearCourseTaken);
      menu();
<<<<<<< HEAD
    } 
=======
    }
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d

    catch (FileNotFoundException err) {
      System.err.println("Cannot find file: " + STUDENT_FILE);
      menu();
    }

    catch (IOException err) {
      System.err.println("Unable to read " + STUDENT_FILE);
      menu();
    }
  }

<<<<<<< HEAD
  static void student_menu (
    String [] studentNames,
    String [] studentGrades,
    String [] yearCourseTaken) {

      boolean run = true;
      int choice = 0;
      while (run){
      miscFunc.clearScreen();
      System.out.println("Choose student to view full record. Enter 0 to stop");
      for(int i = 0; i < studentNames.length; i++) 
        System.out.printf("%d. %s%n", i + 1, studentNames[i]);
      
      System.out.print("> ");
      if (in.hasNextInt() && choice < 0){
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
      } else if (choice < 0){
        miscFunc.clearScreen();    
        in.nextLine();
        run = true;
       } else {
         System.out.println("Invalid input. Please try again");
         run = true;
       }
      }
=======
  /**
   * Prints a menu for user to choose to print detailed student information 
   * @param studentNames
   * @param studentGrades
   * @param yearCourseTaken
   */
  static void student_menu(
      String[] studentNames,
      String[] studentGrades,
      String[] yearCourseTaken) {

    boolean run = true;
    int choice = 0;
    while (run) {
      System.out.println("Choose student to view full record");
      for (int i = 0; i < studentNames.length; i++)
        System.out.printf("%d. %s%n", i + 1, studentNames[i]);
      System.out.println("0. Exit");

      System.out.print("> ");
      if (in.hasNextInt()) {
        choice = in.nextInt() - 1;

        if (choice == -1) {
          run = false;
          break;
        }

        if (choice >= studentNames.length || choice < -1) {
          System.err.println("Input out of range. Try again");
          in.nextLine();
          continue;
        }

        System.out.printf(
            """
                %nFull name: %s
                Grade: %s
                Year course taken: %s%n
                """,
            studentNames[choice],
            studentGrades[choice],
            yearCourseTaken[choice]);

      } else {
        in.nextLine();
        System.err.println("Invalid input. Please try again");
        continue;
      }
    }
    in.nextLine();
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d
  }

  /**
   * Menu
<<<<<<< HEAD
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
=======
   * 
   * @return boolean whether to continue running the program
   * @throws FileNotFoundException IOException
   */
  static boolean menu()
      throws FileNotFoundException, IOException {

    System.out.println(miscFunc.getMenu(progNames));
    System.out.print("> ");

    if (in.hasNextInt()) {
      int choice = 0;
      choice = in.nextInt();
      switch (choice) {
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d
        case 1 -> read_from_file();
        case 2 -> write_StudentRec();
        case 3 -> read_StudentRec();
        case 0 -> System.out.println("Thanks for using our program");
        default -> {
<<<<<<< HEAD
          miscFunc.clearScreen();    
          System.err.println("Invalid option. Try again"); 
=======
          miscFunc.clearScreen();
          System.err.println("Invalid option. Try again");
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d
          in.nextLine();
          return true;
        }
      }
    }

    else {
<<<<<<< HEAD
      miscFunc.clearScreen();    
=======
      miscFunc.clearScreen();
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d
      System.err.println("Invalid option. Try again");
      in.nextLine();
      return true;
    }

    // Exit program
    return false;
  }
<<<<<<< HEAD
}
=======
}
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d
