import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.function.Consumer;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements MouseListener {
  /**
   * I haveno idea what this is
   */
  // lags outside <640/600>
  private static final long serialVersionUID = 1L;
  private int verticalPadding = 22;
  private int horizontalPadding = 0;
  private int width = 800;
  private int height = 800;
  // These need to be moved to CalcBroker
  private double vertRange = 4.;
  private double horzRange = 4.;
  private double leftStart = 2.;
  private double rightStart = 2.;
  //
  public Consumer<Color> cSupplier = (a) -> redraw(a);
  public Consumer<double[]> rangeSupplier = (a) -> setComps(a[0], a[1], a[2]); // zoom, horizontal pan, vertical pan
  private BufferedImage img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
  private Mandy[][] comps = new Mandy[this.width][this.height];

  public static void main(String[] args) {
    new MainFrame();
  }

  MainFrame() {
    if (System.getProperty("os.name").startsWith("Windows")) {
      verticalPadding = 30; // TODO verify this
      horizontalPadding = 8;
    }
    setComps();

    setDefaults();

    new ControlFrame(cSupplier, rangeSupplier);

    setVisible(true);
    System.out.println(getSize() + " : " + getContentPane().getSize());

    repaint();

  }

  private void setComps() {
    comps = new Mandy[this.width][this.height];
    for (int x = 0; x < comps.length; x++) {
      for (int y = 0; y < comps[0].length; y++) {
        double reel = -horzRange / leftStart + (horzRange / (double) this.width) * (double) x;
        double imag = -vertRange / rightStart + (vertRange / (double) this.height) * (double) y;
        comps[x][y] = new Mandy(reel, imag);
      }
    }
    img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
  }

  private void setComps(double horzRange, double leftStart, double rightStart) {
    this.horzRange = horzRange;
    this.vertRange = horzRange;
    this.leftStart = leftStart;
    this.rightStart = rightStart;
    comps = new Mandy[this.width][this.height];
    for (int x = 0; x < comps.length; x++) {
      for (int y = 0; y < comps[0].length; y++) {
        double reel = -horzRange / leftStart + (horzRange / (double) this.width) * (double) x;
        double imag = -vertRange / rightStart + (vertRange / (double) this.height) * (double) y;
        comps[x][y] = new Mandy(reel, imag);
      }
    }
    img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
  }

  public void redraw(Color c) {
    getContentPane().setBackground(c);
    setBackground(c); // this is for the top bar lol gotta do getcontentpane() to get default jpanel
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
    float[] hsb = new float[3];
    Color current = getBackground();
    Color.RGBtoHSB(current.getRed(), current.getGreen(), current.getBlue(), hsb);
    for (int x = 0; x < comps.length; x++) {
      for (int y = 0; y < comps[0].length; y++) {
        float i = 1f - ((float) comps[x][y].calculate() / 40f);
        Color c = Color.getHSBColor(hsb[0], hsb[1], i);
        img.setRGB(x, y, c.getRGB());
      }
    }
    g.drawImage(img, horizontalPadding, verticalPadding, null);
    repaint();
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