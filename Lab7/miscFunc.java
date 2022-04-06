public class miscFunc {

  public static String getMenu(String[] progNames) {
    String menu = "";
    for (int x = 0; x < progNames.length; x++)
      menu += Integer.toString(x + 1) + ". " + progNames[x] + '\n';

    return 
      "Choose a program to run\n" +
      menu +
      "0. Exit";
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
<<<<<<< HEAD
}
=======
}
>>>>>>> e4e77d8ab8d25c06a70031e70336c1e33a74873d
