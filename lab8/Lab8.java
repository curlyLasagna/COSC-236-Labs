import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Lab8 {
   
   public static void main(String[] args) {
      userPrompt();
   }

   /** Method 1 
     * Gets a String from the keyboard. 
     * @param msg is the text that will be displayed the user to ask them to enter a value.
     * @return Returns a String from the keyboard. 
     */ 
   public static String getString(Scanner keyboard, String msg) {
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

   /** Method 2
     * Gets an Int from the keyboard. Only positive numbers are allowed
     * @param msg is the text that will be displayed the user to ask them to enter a number.
     * @return Returns an int from the keyboard. 
     */  
   public static int getInt(Scanner keyboard, String msg) {
      System.out.println(msg);

      while (!keyboard.hasNextInt()) {
         keyboard.nextLine();
         System.err.println("Invalid integer. Try again.");
      }

      int number = getPositiveVal(keyboard);
      keyboard.nextLine();
      return number;
   }

   /** Method 3 
     * Gets an integer greater than and less than the supplied parameters. Only positive numbers are allowed 
     * @param msg is the text that will be displayed the user to ask them to enter a value.
     * @param low is the lowest acceptable input value.
     * @param high is the highest acceptable input value.
     * @return Returns an int from the keyboard. 
     */
   public static int getIntBetweenLowAndHigh (
      Scanner keyboard, 
      String msg, 
      String errorMsg, 
      int low, int high) {
         int number = getInt(keyboard, msg);
         while (number < low || number > high) {
            System.err.println(errorMsg);
            number = getInt(keyboard, msg);
      }
         return number;
   }

   /** Method 4
     * Gets a Double from the keyboard. 
     * @param msg is the text that will be displayed the user to ask them to enter a number.
     * @return Returns a double from the keyboard. 
     */ 
   public static double getDouble(Scanner keyboard, String msg) {
      System.out.println(msg);
      while (!keyboard.hasNextDouble()) {
         keyboard.nextLine();
         System.err.println("Invalid number. Try again.");
      }
      double number = getValidDouble(keyboard);
      keyboard.nextLine();
      return number;
   }

   /** Method 5 
     * Gets a double greater than and less than the supplied parameters. 
     * @param msg is the text that will be displayed the user to ask them to enter a value.
     * @param low is the lowest acceptable input value.
     * @param high is the highest acceptable input value.
     * @return Returns an int from the keyboard. 
     */
   public static double getDoubleBetweenLowAndHigh (
      Scanner keyboard, 
      String msg, 
      String errorMsg, 
      double low, double high) {
         double number = getDouble(keyboard, msg);
         while (number < low || number > high) {
            System.err.println(errorMsg);
            number = getDouble(keyboard, msg);
      }
         return number;
   }

   static int getPositiveVal(Scanner keyboard) {
      int val = keyboard.nextInt();
      while(val < 0) {
         keyboard.nextLine();
         System.err.println("Input must be postiive");
         val = keyboard.nextInt();
      }
      return val;
   }
   
   static double getPositiveDouble(Scanner keyboard) {
      double val = keyboard.nextDouble();
      while(val < 0) {
         keyboard.nextLine();
         System.err.println("Input must be postiive");
         val = keyboard.nextInt();
      }
      return val;
   }

   /**
    * Ensures double input contains a decimal point
    * @param Scanner object keyboard
    * @return double containing a decimal point
    */
   static double getValidDouble(Scanner keyboard) {
      double input = keyboard.nextDouble();
      while(!Double.toString(input).matches("^\\d+\\.\\d+")) {
         System.err.println(input + " is not a vlid double. Please enter a double");
         keyboard.nextLine();
         input = keyboard.nextDouble();
      }
      return input;
   }

   /** 
    * User prompt
    */
   static void userPrompt() {
      Random rand = new Random(System.currentTimeMillis());
      Scanner keyboard = new Scanner(System.in);
      String [] colors = new String [2];

      String itemName = getString(keyboard, "Please give me the name of any item");

      colors[0] = getString(keyboard, "Enter a color name");
      colors[1] = getString(keyboard, "Please enter the name of a different color");

      while(colors[0].equalsIgnoreCase(colors[1])) {
         System.err.println("Must be a different color");
         colors[1] = getString(keyboard, "Please enter the name of a different color");
      }

      int maxCount = getInt(keyboard, "What is the maximum number of " + itemName + " can someone have?");
      int minCount = getInt(keyboard, "What is the minimum number of " + itemName + " can someone have?");

      double maxPrice = getDouble(keyboard, "What is the maximum price someone might pay for a " + itemName);
      double minPrice = getDouble(keyboard, "What is the minimum price someone might pay for a " + itemName);

      int itemStock = rand.nextInt(maxCount);
      String colorChoice = colors [rand.nextInt(colors.length)];

      int buyCount = getIntBetweenLowAndHigh(
         keyboard, 
         String.format("We have %s %s %s. How many would you like to buy?", 
            itemStock, colorChoice, itemName), 
         String.format("Number must be between %d & %d", 
            minCount, maxCount), 
         minCount, itemStock);

      double goodPrice = getDoubleBetweenLowAndHigh(
         keyboard, 
         String.format("How much are you willing to pay for each %s %s", 
            colorChoice, itemName), 
         String.format("Input must be between %.2f & %.2f", 
            minPrice, maxPrice), 
         minPrice, maxPrice);

      double finalPrice = buyCount * goodPrice;

      System.out.printf(
         "The total cost for %d %s %s at $%.2f each is $%.2f", 
            buyCount, colorChoice, itemName, goodPrice, finalPrice);

      keyboard.close();
   }
}