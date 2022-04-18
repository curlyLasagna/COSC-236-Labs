package Lab9;

import Lab9.IR4;
import java.util.Random;
import java.io.File;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Creature {
  private String name,
      description,
      fileName = "creature.dat";

  private int 
    phraseIndex = 0,
    endurance;

  private String[] creaturePhrase = {
      "Meow",
      "Nyan Nyan",
      "Rawr",
      "Cho cho"
  };

  /**
   * No arg constructor.
   * User is prompted to enter the appropriate field values.
   */
  Creature() {
    name = IR4.getString("Enter creature name");
    description = IR4.getString("Enter creature description");
    endurance = IR4.getInteger("Enter creature endurance");
  }

  /**
   * Creates a creature object with the values defined from an existing .dat file
   * @param String filename file to be saved to
   */
  Creature(String filename) {
    this.fileName = filename;
    try (DataInputStream dis = 
      new DataInputStream(
        new FileInputStream(fileName))) {
          String[] fileContent = dis.readUTF().split(",");
          name = fileContent[0];
          description = fileContent[1];
          endurance = Integer.parseInt(fileContent[2]);
    } catch (FileNotFoundException e) {
        System.err.println(e.getMessage());
    } catch (IOException e) {
        System.err.println(e.getMessage());
    }
  }

  /** 
   * Saves the creature fields to a .dat file 
  */
  void saveCreatureData() {
    try (DataOutputStream dos = 
      new DataOutputStream(
        new FileOutputStream(fileName))) {
          dos.writeUTF (
            String.join(",", name, description, Integer.toString(endurance)));
      dos.flush();
    } catch (FileNotFoundException e) {
      System.err.println(e.getMessage());
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  /**
   * @param String fileName to to be saved to
   */
  void saveCreatureData(String fileName) {
    this.fileName = fileName;
    saveCreatureData();
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
  void setEndurance(int endurance) {
    Random r = new Random(System.currentTimeMillis());
    if (this.endurance > 0 && endurance <= 0) {
      String[] causeOfDeath = {
          "cholera", "mutilation", "asphyxiation",
          "diabetes", "heart attack"
      };
      System.out.println(name + " died from " + causeOfDeath[r.nextInt(causeOfDeath.length)]);
    }

    else if (this.endurance <= 0 && endurance > 0) {
      String[] healthy = {
          "can now clap with one hand", "can now divide by zero",
          "can now bench press 300lbs.", "can now make an onion cry",
          "can now sneeze with his eyes open"
      };
      System.out.println(name + ' ' + healthy[r.nextInt(healthy.length)]);
    }
    this.endurance = (endurance < 0) ? 0 : endurance;
  }

  // Getters
  String getName()         { return name; }
  int getEndurance()       { return endurance; }
  String getDescription()  { return description; }
  boolean isAlive()        { return (this.endurance > 0) ? true : false; }

  /**
   * Increments phrase index and warps back to 0
   * @return String phrase from creaturePhrase array
   */
  String getPhrase() {
    if (phraseIndex >= creaturePhrase.length) {
      phraseIndex = 0;
      return creaturePhrase[phraseIndex++];
    }
    else
      return creaturePhrase[phraseIndex++];
  }

  /**
   * Overwrites a phrase incrementally
   * @param String phrase that overwrites createPhrase incrementally
   */
  void setNewPhrase(String phrase) {
    if (phraseIndex >= creaturePhrase.length) {
      phraseIndex = 0;
      creaturePhrase[phraseIndex++] = phrase;
    }
    else 
      creaturePhrase[phraseIndex++] = phrase;
  }

  /**
   * Decreases a creatures endurance by 1 when fed
   * @param food
   * @return A string saying what happens 
   */
  String feed(String food) {
    endurance--;
    return String.format(
        """
            You fed %s with %s
            %s is very allergic to %s. Good job!
            Current endurance: %d
            """,
        name, food, name, food, endurance);
  }

  @Override
  public String toString() {
    return String.format(
        """
            Creature statistics
            Name: %s
            Description: %s
            Endurance: %d
            """,
        name, description, endurance);
  }
}
