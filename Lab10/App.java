import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Color;
import java.awt.Font;

class App {
  public static void main(String[] args) {
    try {
      DrawingPanel imagePanel = new DrawingPanel("assets/shiba-inu.jpg"); 
      Graphics shape = imagePanel.getGraphics();
      Graphics text = imagePanel.getGraphics();
      imagePanel.setBackground(Color.magenta);
      printMsg(text, "Much wow, much skill!", 664, 573);
      popConfetti(shape);
    }
    catch (RuntimeException e) {
      System.err.println("Cannot find image");
    }
  }

  // Prints text on the panel
  static void printMsg(Graphics g, String msg, int x, int y) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.CYAN);
    Font text = new Font("Serif", Font.PLAIN, 45);
    g.setFont(text);
    g.drawString(msg, x, y);
  }

  /**
   * Prints confetti around Shiba
   * @param g Graphics object
   */
  static void popConfetti(Graphics g) {
    Random rand = new Random(System.currentTimeMillis());
    Color [] colors = {
      Color.GREEN,
      Color.BLUE,
      Color.CYAN,
      Color.MAGENTA,
      Color.ORANGE,
      Color.RED,
      Color.PINK,
      Color.WHITE,
      Color.YELLOW
    };
    int 
      minHVal, maxHVal, maxYVal = 523,
      xSize = 15, ySize = 20;
    minHVal = maxHVal = 0;
    // Could've used ThreadLocalRandom but meh...
    for(Color c : colors) {
      maxHVal = 482;
      g.setColor(c);
      g.fillRect(rand.nextInt(maxHVal), rand.nextInt(maxYVal), xSize, ySize);
      g.fillOval(rand.nextInt(maxHVal), rand.nextInt(maxYVal), xSize, ySize);
    }

    // To set a min and max, ThreadLocalRandom had to be used
    for(Color c : colors) {
      minHVal = 930;
      maxHVal = 1274;
      int x = ThreadLocalRandom.current().nextInt(minHVal, maxHVal);
      g.setColor(c);
      g.fillRect(x, rand.nextInt(maxYVal), xSize, ySize);
      g.fillOval(x, rand.nextInt(maxYVal), xSize, ySize);
    }
  }
}
