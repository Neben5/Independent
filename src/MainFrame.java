import javax.swing.*;
import java.awt.image.BufferedImage;
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
  private int width = 800;
  private int height = 800;
  public Consumer<Color> cSupplier = (a) -> redraw(a);
  private BufferedImage img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);;
  private Mandy[][] comps = new Mandy[this.width][this.height];
  int a, b;

  public static void main(String[] args) {
    new MainFrame();
  }

  MainFrame() {
    for (int x = 0; x < this.width; x++) {
      for (int y = 0; y < this.height; y++) {
        double reel = -2. + (4. / (double) this.width) * (double) x;
        double imag = -2. + (4. / (double) this.height) * (double) y;
        comps[x][y] = new Mandy(reel, imag);
        // System.out.println("("+reel+", "+imag+")");
      }
    }

    setDefaults();

    new ControlFrame(cSupplier);
    new CalcBroker();

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
        float i = 1f - ((float) comps[x][y].calculate() / 255f);
        Color c = Color.getHSBColor(hsb[0], hsb[1], i);
        img.setRGB(x, y, c.getRGB());
      }
    }
    g.drawImage(img, 0, 0, null);
    repaint();
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