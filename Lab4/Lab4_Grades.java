/**
 * Coder: Luis
 * Driver: Abdalla
 * Store student data
 * Input:
 * Student name - String (String array values)
 * Student grade - char (char array values)
 * 
 * Logic:
 * Create a 2 ararys
 * 1st array: Name list
 * 2nd array: Grades
 * Set size to the number of student records user enters
 * Output:
 * A table of student records
 * Student count
 * Name, grade
 */
import java.util.*;

class Lab4_Grades {
  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("How many student records would you like to enter? (Max: 5) ");
    int studentCount = 0;
    if (in.hasNextInt() || in.nextInt() < 5 || in.nextInt() > 0) {
      studentCount = in.nextInt();
      String[] studentNames = new String[studentCount];
      char[] studentGrades = new char[studentCount];
      int curIndex = 0;
      switch (studentCount) {
        case 5:
          System.out.print("Enter student name: ");
          studentNames[curIndex] = in.next();
          studentGrades[curIndex] = setGrade(studentNames[curIndex]);
          curIndex++;
        case 4:
          System.out.print("Enter student name: ");
          studentNames[curIndex] = in.next();
          studentGrades[curIndex] = setGrade(studentNames[curIndex]);
          curIndex++;
        case 3:
          System.out.print("Enter student name: ");
          studentNames[curIndex] = in.next();
          studentGrades[curIndex] = setGrade(studentNames[curIndex]);
          curIndex++;
        case 2:
          System.out.print("Enter student name: ");
          studentNames[curIndex] = in.next();
          studentGrades[curIndex] = setGrade(studentNames[curIndex]);
          curIndex++;
        case 1:
          System.out.print("Enter student name: ");
          studentNames[curIndex] = in.next();
          studentGrades[curIndex] = setGrade(studentNames[curIndex]);
          break;
      }
      printRecord(studentNames, studentGrades, studentCount);
    } else {
      System.err.print("Invalid input\nTry again");
      System.exit(0);
    }
  }

  /**
   * Prints out the student records with entries based on the number of students,
   * their names, and their respective grades
   * 
   * @param studentNames
   * @param studentGrades
   * @param studentCount
   */
  static void printRecord(String[] studentNames, char[] studentGrades, int studentCount) {
    System.out.println("Records: " + studentCount);
    int curIndex = 0;
    switch (studentCount) {
      case 5:
        System.out.printf(
            "%-10s%5c%n",
            studentNames[curIndex], studentGrades[curIndex]);
        curIndex++;
      case 4:
        System.out.printf(
            "%-10s%5c%n",
            studentNames[curIndex], studentGrades[curIndex]);
        curIndex++;
      case 3:
        System.out.printf(
            "%-10s%5c%n",
            studentNames[curIndex], studentGrades[curIndex]);
        curIndex++;
      case 2:
        System.out.printf(
            "%-10s%5c%n",
            studentNames[curIndex], studentGrades[curIndex]);
        curIndex++;
      case 1:
        System.out.printf(
            "%-10s%5c%n",
            studentNames[curIndex], studentGrades[curIndex]);
        break;
    }
  }

  /**
   * Inputs and validates grade to return it uppercased if input was lowercase
   * @param studentName
   * @return Uppercased character variable grade
   */
  static char setGrade(String studentName) {
    System.out.printf("Enter %s's grade: ", studentName);
    char grade = Character.toUpperCase(in.next().charAt(0));

    if (grade < 'A' || grade > 'F') {
      System.err.println("Grade out of range");
      System.exit(0);
    }

    return grade;
  }
}