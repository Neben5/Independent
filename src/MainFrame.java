import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Consumer;

public class MainFrame extends JFrame implements MouseListener {
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private int width  = 1235;
  private int height = 630;
  public Consumer<Color> cSupplier = (a) -> redraw(a);
  private BufferedImage img;
  private int[][] outs;

  public static void main(String[] args) {
    new MainFrame();
  }

  MainFrame() {
    setDefaults();

    new ControlFrame(cSupplier);
    new CalcBroker();
    img = new BufferedImage(this.width, this.height,
        BufferedImage.TYPE_INT_RGB);
    outs = new int[this.width][this.height];

    setVisible(true);
    repaint();

  }

  public void redraw(Color c) {
    setBackground(c); // this is for the top bar lol gotta do getcontentpane() to get default jpanel
  }

  private void setDefaults() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(width, height);
    setTitle("Mandy");
  }

  public void paint(Graphics g) {
    float[] hsb = new float[3];
    Color current = getBackground();
    Color.RGBtoHSB(current.getRed(), current.getGreen(), current.getBlue(), hsb);

    for (int x = 0; x < this.width; x++) {
      for (int y = 0; y < this.height; y++) {
        img.setRGB(x, y, Color.getHSBColor(hsb[0], hsb[1], 1f - (outs[x][y] * 0.001f)).getRGB());
      }
    }
    g.drawImage(img, 0, 0, null);
  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }
}