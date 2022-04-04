package Lab9;
import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class Creature {
  private String 
    name,
    description,
    fileName;
      
  private int endurance, phraseIndex = 0;
  private String [] creaturePhrase;
  public Creature() {
    Scanner in = new Scanner(System.in);
    System.out.println("Set creature attributes");

    System.out.print("Name: ");
    setName(in.nextLine());

    System.out.print("Description: ");
    setDescription(in.nextLine());

    System.out.print("Endurance: ");
    setEndurance(in.nextInt());

    in.nextLine();
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

  public void setEndurance(int endurance) {
    this.endurance = (endurance < 0) ? 0 : endurance;
    Random r = new Random();

    if (this.endurance == 0) {
      String [] causeOfDeath = {
        "cholera", "mutilation", "asphyxiation",
        "diabetes", "heart attack"
      };

      System.out.println(this.name + " died from " + causeOfDeath[r.nextInt(5)]);
    }

    else if (this.endurance > 0) {
      String [] goodStuff = {
        " can clap with one hand", " is an alpha",
        " can bench press 300lbs.", " is better than ever",
        " can sneeze with his eyes open"
      };

      System.out.println(this.name + goodStuff[r.nextInt(5)]);
    }
  }

  // Getters
  public String getName() { return this.name; }
  public String getDescription() { return this.description; }
  public int getEndurance() { return this.endurance; }

  boolean isDead() {
    return (this.endurance > 0) ? false : true;
  }

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
        this.name, this.description, this.endurance);
  }

  // This method already exists by default?
  // String toString () {
  //   System.out.printf(
  //    """
  //     Name: %s
  //     Description: %s
  //     Endurance: %d 
  //        """; 
  //   , )
  // }

}