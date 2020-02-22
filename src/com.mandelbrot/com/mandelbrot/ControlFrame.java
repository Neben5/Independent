package com.mandelbrot;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlFrame extends JFrame {
    ControlFrame(){
        MainFrame.click = true;
        setDefaults();
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
}
