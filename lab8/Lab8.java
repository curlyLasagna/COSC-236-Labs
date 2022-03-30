    11	import java.util.Scanner;
    12	
    13	public class IR4 {
    14	   //Putting the Scanner object here makes it global so it does not have to be passed to modules.
    15	   static Scanner keyboard = new Scanner(System.in);
    16	   
    17	   public static void main(String[] args) {
		System.out.println("Yo");

    47	   }
    48	   
    49	   public static void displayGoodbye(){
    50	       System.out.println("Goodbye!");
    51	   }
    52	   
    57	   /** Gets an integer greater than and less than the supplied parameters. 
    58	     * Rejects null entries, any number of spaces, and non-numbers.
    59	     * @param msg is the text that will be displayed the user to ask them to enter a value.
    60	     * @param low is the lowest acceptable input value.
    61	     * @param high is the highest acceptable input value.
    62	     * @return Returns an int from the keyboard. 
    63	     */
    64	   public static int getIntegerBetweenLowAndHigh (Scanner keyboard, String msg, int low, int high) {
    65	      int number = getInteger(msg);
    66	      while (number < low || number > high) {
    67	         System.err.println(errorMsg);
    68	         number = getInteger(msg);
    69	      }
    70	      return number;
    71	   }

    64	   public static double getDoubleBetweenLowAndHigh (Scanner keyboard, String msg, double low, double high) {
    65	      double number = getDouble(msg);
    66	      while (number < low || number > high) {
    67	         System.err.println(errorMsg);
    68	         number = getDouble(msg);
    69	      }
    70	      return number;
    71	   }
    72	   
   106	   /** Gets a String from the keyboard. Rejects null entry or any number of spaces.
   107	     * @param msg is the text that will be displayed the user to ask them to enter a value.
   108	     * @return Returns a String from the keyboard. 
   109	     */ 
   110	   public static String getString(Scanner keyboard, String msg) {
   111	      String answer = "";
   112	      System.out.println(msg);
   113	      try {
   114	         answer = keyboard.nextLine(); 
   115	      }
   116	      catch (Exception e) {
   117	         System.err.println("Error reading input from user. Ending program.");
   118	         System.exit(-1);
   119	      } 
   120	      
   121	      while (answer.replace(" ", "").equals("")) {
   122	         System.err.println("Error: Missing input.");
   123	         try {
   124	            System.out.println(msg);
   125	            answer = keyboard.nextLine(); 
   126	         }
   127	         catch (Exception e) {
   128	            System.err.println("Error reading input from user. Ending program.");
   129	            System.exit(-1);
   130	         } 
   131	      }
   132	      return answer;            
   133	   }
   134	   
   135	   //------------------------------------------------------------------------------------------------------------------
   136	   /** Gets an Integer from the keyboard. Rejects null, spaces and non-integers.
   137	     * @param msg is the text that will be displayed the user to ask them to enter a number.
   138	     * @return Returns an int from the keyboard. 
   139	     */  
   140	   public static int getInteger(Scanner keyboard, String msg) {
   141	      System.out.println(msg);
   142	      while (!keyboard.hasNextInt()) {
   143	         keyboard.nextLine();
   144	         System.err.println("Invalid integer. Try again.");
   145	      }
   146	      int number = keyboard.nextInt();
   147	      keyboard.nextLine(); //flushes the buffer
   148	      return number;
   149	   }
   150	   
   151	   //------------------------------------------------------------------------------------------------------------------
   152	   /** Gets a Double from the keyboard. Rejects null, spaces and non-numbers.
   153	     * @param msg is the text that will be displayed the user to ask them to enter a number.
   154	     * @return Returns a double from the keyboard. 
   155	     */ 
   156	   public static double getDouble(Scanner keyboard, String msg) {
   157	      System.out.println(msg);
   158	      while (!keyboard.hasNextDouble()) {
   159	         keyboard.nextLine();
   160	         System.err.println("Invalid number. Try again.");
   161	      }
   162	      double number = keyboard.nextDouble();
   163	      keyboard.nextLine(); //flushes the buffer
   164	      return number;
   165	   }
   166	   
   202	   //------------------------------------------------------------------------------------------------------------------
   203	   /** Closes the scanner.
   204	     */ 
   205	   public static void closeScanner() {
   206	      try { 
   207	         if(keyboard != null) {
   208	            keyboard.close(); 
   209	         }
   210	      } 
   211	      catch (Exception e) { // (Exception) catches all errors java might throw here
   212	         System.err.println("Error closing reader.");
   213	      }
   214	   }
   225	}
