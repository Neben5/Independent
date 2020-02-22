package com.mandelbrot;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
        add(panel);
        setDefaults();
        pack();
    }

    private void setPanel() {
        panel = new JPanel();
        slider = new JSlider(0, 360, 0);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                int value = slider.getValue();
                recolor(value);
            }
        });
        // TODO, use color static method to convert hsv to rgb, get color from it.
        panel.add(slider);
    }

    private void recolor(int value) {
        panel.setBackground(new Color(Color.HSBtoRGB((float)value/360f, 1, 1)));
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
