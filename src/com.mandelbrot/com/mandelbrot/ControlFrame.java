package com.mandelbrot;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static JPanel panel;
    private static JSlider slider;

    ControlFrame() {
        setBackground(Color.white);
        setPanel();
        setDefaults();
        pack();
    }

    private void setPanel(){
        panel = new JPanel();
        slider = new JSlider(0,360);
        // TODO, use color static method to convert hsv to rgb, get color from it.
        panel.add(new JSlider(0, 360));

    }

    private void setDefaults() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        repaint();
        setSize(600, 600);
        setBackground(Color.white);
        setTitle("Settings");
    }
}
