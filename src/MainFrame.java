import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Consumer;

public class MainFrame extends JFrame implements MouseListener {
  /**
   * I haveno idea what this is
   */
  // lags outside <640/600>
  private static final long serialVersionUID = 1L;
  private int width = 800;
  private int height = 800;
  private double zoom = 4.;
  private double leftStart = 2.;
  private double rightStart = 2.;
  private BufferedImage img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
  private Mandy[][] comps = new Mandy[this.width][this.height];
  private CalcBroker broker;
  int a, b;

  private void setComps() {
    comps = new Mandy[this.width][this.height];
    for (int x = 0; x < comps.length; x++) {
      for (int y = 0; y < comps[0].length; y++) {
        double reel = -zoom / leftStart + (zoom / (double) this.width) * (double) x;
        double imag = -zoom / rightStart + (zoom / (double) this.height) * (double) y;
        comps[x][y] = new Mandy(reel, imag);
      }
    }
    img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
  }

  MainFrame() {
    setComps();

    setDefaults();

    broker = new CalcBroker((a) -> redraw(a), () -> height, () -> width);
    ControlFrame control = new ControlFrame((Color a) -> recolor(a), (double[] a) -> broker.rePlot(a));

    setVisible(true);
    repaint();

  }

  public void recolor(Color c) {
    getContentPane().setBackground(c);
    setBackground(c); // this is for the top bar lol gotta do getcontentpane() to get default jpanel
  }

  public void redraw(int[][] outs) {
    System.out.println("drawing");
    float[] hsb = new float[3];
    Color current = getContentPane().getBackground();
    Color.RGBtoHSB(current.getRed(), current.getGreen(), current.getBlue(), hsb);
    for (int x = 0; x < outs.length; x++) {
      for (int y = 0; y < outs[0].length; y++) {
        float i = 1f - ((float) outs[x][y] / 80f);
        Color c = Color.getHSBColor(hsb[0], hsb[1], i);
        img.setRGB(x, y, c.getRGB());
      }
    }
    repaint();
  }

  private void setDefaults() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(width, height);
    setTitle("Mandy");
    addComponentListener(new ComponentListener() {
      @Override
      public void componentHidden(ComponentEvent event) {
      }

      @Override
      public void componentMoved(ComponentEvent event) {
      }

      @Override
      public void componentResized(ComponentEvent event) {
        width = getContentPane().getWidth();
        height = getContentPane().getHeight();
        setComps();
      }

      @Override
      public void componentShown(ComponentEvent event) {
      }
    });
  }

  public void paint(Graphics g) {
    try {
      broker.run();
    } catch (Exception e) {

    }
    g.drawImage(img, 0, 0, null);
  } // note that 22 px on mac are lost to heading size

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