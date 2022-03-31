import java.io.File;
class Creature {
  public Creature() {
    String 
      name,
      description,
      fileName,
      phraseIndex = 0;
    int endurance;
    String [] creaturePhrase;
  }

  saveCreatureData() {
    
  }

  // Methods
  saveCreatureData(String fileName) {
    this.fileName = fileName;
  }

  // Setters 
  void setName(String name) {
    this.name = name;
  }

  void setDescription(String description) {
    this.description = description;
  }

  void setEndurance(int endurance) {
    this.endurance = endurance;
    if (this.endurance == 0)
      System.out.println(this.name + " dies in exhaustion");
    else if (this.endurance < 0)
      this.endurance = 0;
    else if()
  }

  // Getters
  String getName() {
    return "";
  } 

  String getDescription() {
    return "";
  } 

  int getEndurance() {
    return 0;
  }

  boolean isDead() {
    return false;
  }

  String getRandomPhrase() {
    return "";
  }

}