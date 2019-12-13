package com.mandelbrot;

import com.mandelbrot.ControlThread;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame extends JFrame implements MouseListener {
  public static void main(String [] args){
    System.out.println("Hi");
  }
  MainFrame(){
    setDefaults();
    ControlThread Controller = new ControlThread();
    CalcBroker BrokerComponent = new CalcBroker();
  }
  private void setDefaults(){
    //set frame defaults
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