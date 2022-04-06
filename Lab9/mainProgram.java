package Lab9;

import java.io.*;
import Lab9.Creature;

class mainProgram {

  final static String CREATURE_FILE = "creature.dat";

  public static void main(String [] args) {
    Creature x = new Creature();

    // Prints creature name, description, and endurance
    System.out.println(x.toString());

    // Print out 3 phrases
    for (int i = 0; i < 3; i++){
      System.out.println(getPhrase[i]);
    }

    // Get 3 new phrases
    for (int k = 0; k < 3; k++){
      System.out.println("Enter a phrase please");
      getPhrase[k] = in.next;
    }

    // Print out 4 phrases
    for (int l = 0; l < 4; l++){
      System.out.println(getPhrase[l]);
    }

     // Reduce creature's endurance by 1 until it is tired
     while (!x.isDead()){
      
      if (endurance > 0){
        endurance--;
      } else {
        x.isDead();
      }
    }

    // Set creature endurance to 20
    int endurance = 20;

    // Print out any behavior reaction
    System.out.println(x.feed());

    // Set creature name to new name
    System.out.println("Enter new creature name");
    x.setName(in.next);

    // Save creature object to a file called "Creature.dat"
    try (DataOutputStream ds = new DataOutputStream(
        new FileOutputStream(CREATURE_FILE))) {

      ds.writeUTF(x.toString());
    }
  }
}
