package Lab9;
import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class Creature {
  private String 
    name,
    description,
    fileName;
      
  private int 
    endurance, 
    phraseIndex = 0;

  private String [] creaturePhrase;

  /**
   * When constructing an object, user is prompt to enter appropriate field values
   */
  public Creature() {
    try (Scanner in = new Scanner(System.in)) {
      System.out.println("Set creature attributes");

      System.out.print("Name: ");
      setName(in.nextLine());

      System.out.print("Description: ");
      setDescription(in.nextLine());

      System.out.print("Endurance: ");
      setEndurance(in.nextInt());

      in.nextLine();
    }
  }

  void saveCreatureData() {
    
  }

  // Methods
  void saveCreatureData(String fileName) {
    this.fileName = fileName;
  }
  // Setters
  void setName(String name) {
    this.name = name;
  }

  void setDescription(String description) {
    this.description = description;
  }

  /**
   * Sets the endurance of the creature.
   * If endurance is less than zero, endurance is set to zero
   * If endurance is zero, then the creature is said to be dead
   * Else, creature is said to be alive and well
   * @param endurance
   */
  public void setEndurance(int endurance) {
    this.endurance = (endurance < 0) ? 0 : endurance;
    Random r = new Random(System.currentTimeMillis());

    if (this.endurance == 0) {
      String [] causeOfDeath = {
        "cholera", "mutilation", "asphyxiation",
        "diabetes", "heart attack"
      };

      System.out.println(this.name + " died from " + causeOfDeath[r.nextInt(causeOfDeath.length)]);
    }

    else if (this.endurance > 0) {
      String [] healthy = {
        " can clap with one hand", " can divide by zero",
        " can bench press 300lbs.", " can make an onion cry",
        " can sneeze with his eyes open"
      };

      System.out.println(this.name + healthy[r.nextInt(healthy.length)]);
    }
  }

  // Getters
  public String getName()         { return name; }
  public int getEndurance()       { return endurance; }
  public String getDescription()  { return description; }

  boolean isDead() {
    return (this.endurance <= 0) ? true : false;
  }

  //
  String getRandomPhrase() {
    return "";
  }

  @Override
  public String toString() {
    return String.format(
      """
      Creature statistics
      Name: %11s
      Description: %5s  
      Endurance: %3d
      """, 
      getName(), getDescription(), getEndurance());
  }

}
