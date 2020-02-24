
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.util.function.Consumer;

public class ControlFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static JPanel panel;
    private static JSlider slider;
    private Consumer<Color> colorConsumer;

    ControlFrame(Consumer<Color> colorConsumer) {
        this.colorConsumer = colorConsumer;

        setColorPanel();

        setDefaults();
        pack();
    }

    private void setColorPanel() {
        panel = new JPanel();
        panel.setBackground(Color.red);
        slider = new JSlider(0, 360, 0);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                int value = slider.getValue();
                recolor(value);
            }
        });
        panel.add(slider, BorderLayout.CENTER);
        add(panel);
    }

    private void recolor(int value) {
        panel.setBackground(new Color(Color.HSBtoRGB((float) value / 360f, 1, 1)));
        colorConsumer.accept(panel.getBackground());
    }

    private void setDefaults() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        repaint();
        setSize(600, 600);
        setBackground(Color.WHITE);
        setTitle("Settings");
    }
}
