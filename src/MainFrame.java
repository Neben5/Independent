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
  private int width = 1235;
  private int height = 630;
  public Consumer<Color> cSupplier = (a) -> redraw(a);
  private BufferedImage img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);;
  private int[][] outs = new int[this.width][this.height];
  private Mandy[][] comps = new Mandy[this.width][this.height];

  public static void main(String[] args) {
    new MainFrame();
  }

  public void calc() {
    for(int x = 0; x < this.width; x++){
      for(int y = 0; y < this.height; y++){
        outs[x][y] = comps[x][y].calculate();
      }
    }
    System.out.println("done");
  }

  MainFrame() {
    for(int x = 0; x < this.width; x++){
      for(int y = 0; y < this.height; y++){
        comps[x][y] = new Mandy(-2.+(2./(double)this.width)*(double)x,-2.+(2./(double)this.height)*(double)y);
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
    calc();
    for (int x = 0; x < this.width; x++) {
      for (int y = 0; y < this.height; y++) {
        try{
        img.setRGB(x,y, new Color(1f-((float)outs[x][y]/255f),1f-((float)outs[x][y]/255f),1f-((float)outs[x][y]/255f)).getRGB());
        }catch(Exception e){
          System.out.println(outs[x][y]);
        }
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