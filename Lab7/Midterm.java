import java.util.*;

public class Midterm {
    static Scanner in = new Scanner(System.in);

public static void main(String[] args) {
    boolean run = true;
    do {
      int choice = 0;

      // List of languages to choose from
      final String[] languages = {
          "English",
          "French",
          "Spanish"
      };

      System.out.println(getMenu(languages));
      if (in.hasNextInt()) {
        choice = in.nextInt();
        switch (choice) {
          case 1:
            System.out.println("Hello");
            break;
          case 2:
            System.out.println("Bonjour");
            break;
          case 3:
            System.out.println("Hola");
            break;
          case 4:
            System.out.println("Thanks for using our program!");
            run = false;
            break;
          default:
            System.err.println("Invalid option. Try again");
            break;
        }
      } else {
        System.err.println("Invalid option. Try again");

        in.nextLine();
      }

    } while (run);
    in.close();
  }
      

   
  

public static String getMenu(String[] languages) {
    String menu = "";
    for (int x = 0; x < languages.length; x++)
      menu += Integer.toString(x + 1) + ". " + languages[x] + '\n';

    return 
      "Choose a program to run\n" +
      menu +
      "4. Exit";
  }
}
