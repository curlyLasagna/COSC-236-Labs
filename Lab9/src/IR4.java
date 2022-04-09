package Lab9;

import java.util.Scanner;

public class IR4 {
   static Scanner keyboard = new Scanner(System.in);
   
   public static String getString(String msg) {
      String answer = "";
      System.out.println(msg);
      try {
         answer = keyboard.nextLine(); 
      }
      catch (Exception e) {
         System.err.println("Error reading input from user. Ending program.");
         System.exit(-1);
      } 
      
      while (answer.replace(" ", "").equals("")) {
         System.err.println("Error: Missing input.");
         try {
            System.out.println(msg);
            answer = keyboard.nextLine(); 
         }
         catch (Exception e) {
            System.err.println("Error reading input from user. Ending program.");
            System.exit(-1);
         } 
      }
      return answer;            
   }
   
   /** Gets an Integer from the keyboard. Rejects null, spaces and non-integers.
     * @param msg is the text that will be displayed the user to ask them to enter a number.
     * @return Returns an int from the keyboard. 
     */  
   public static int getInteger(String msg) {
      System.out.println(msg);
      while (!keyboard.hasNextInt()) {
         keyboard.nextLine();
         System.err.println("Invalid integer. Try again.");
      }
      int number = keyboard.nextInt();
      keyboard.nextLine(); //flushes the buffer
      return number;
   }
   
   public static void closeScanner() {
      try { 
         if(keyboard != null) {
            keyboard.close(); 
         }
      } 
      catch (Exception e) { 
         System.err.println("Error closing reader.");
      }
   }
}