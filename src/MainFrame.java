

import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame extends JFrame implements MouseListener {
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  public static int width;
  public static int height;
  public static boolean click = false;

  public static void main(String[] args) {
    new MainFrame();
  }

  MainFrame() {
    setDefaults();
    ControlFrame Controller = new ControlFrame();
    CalcBroker BrokerComponent = new CalcBroker();
  }

  private void setDefaults() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
    repaint();
    setSize(1235, 630);
    setBackground(Color.white);
    setTitle("Mandy");
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