package com.mandelbrot;

import com.mandelbrot.ControlThread;

import javax.swing.*;
public class MainFrame extends JFrame{
  public static void main(String [] args){
    System.out.println("Hi");
  }
  MainFrame(){
    setDefaults();
    ControlThread Controller = new ControlThread();
  }
  private void setDefaults(){
    //set frame defaults
  }
}