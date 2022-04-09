package Lab9;

import Lab9.Creature;
import Lab9.IR4;

class mainProgram {
  public static void main(String [] args) {
    createCreature();
  }

  static void createCreature() {
    Creature x = new Creature();
    int i = 0;

    while(i < 3) {
      System.out.println(x.getPhrase());
      i++;
    }

    i = 0;
    while(i < 3) {
      x.setNewPhrase(IR4.getString("Enter a phrase please"));
      i++;
    }

    i = 0;
    while(i < 4) {
      System.out.println(x.getPhrase());
      i++;
    }

    while (x.isAlive()) 
      x.setEndurance(x.getEndurance() - 1);

    x.setEndurance(20);

    System.out.println(
      x.feed(
        IR4.getString(
          "What would you like to feed " + x.getName() + " with?"
        )
      )
    );

    x.setName(IR4.getString("Enter " + x.getName() + "'s new name"));
    x.saveCreatureData("creature.dat");
    
    Creature y = new Creature("creature.dat");
    System.out.println(y);

    IR4.closeScanner();
  }
}