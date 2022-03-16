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
}
