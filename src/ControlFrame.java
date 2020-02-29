
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class ControlFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel colorPanel;
    private Consumer<Color> colorConsumer;
    private Consumer<double[]> rangeConsumer;

    ControlFrame(Consumer<Color> colorConsumer, Consumer<double[]> rangeConsumer) {
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.colorConsumer = colorConsumer;
        this.rangeConsumer = rangeConsumer;
        setColorPanel();
        setRangePanel(); // this has big issues. it completely overwrites colorpanel, doesn't pass
                         // correct arguments

        setDefaults();
        pack();
    }

    private void setRangePanel() {
        JPanel rangePanel = new JPanel();
        JSlider zoomSlider = new JSlider(1, 800, 400); // add tickmarks
        JSlider rangeStart = new JSlider(0, 400, 200);
        JSlider domainStart = new JSlider(0, 400, 200);
        JButton dButton = new JButton("resize");
        dButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rangeConsumer.accept(new double[] { (double) zoomSlider.getValue() / 100.,
                        (double) domainStart.getValue() / 100., (double) rangeStart.getValue() / 100. });

            }
        });
        rangePanel.add(zoomSlider);
        rangePanel.add(new JLabel("zoom"));
        rangePanel.add(rangeStart);
        rangePanel.add(new JLabel("vert start"));
        rangePanel.add(domainStart);
        rangePanel.add(new JLabel("horz start"));
        rangePanel.add(dButton);
        add(rangePanel);

    }

    private void setColorPanel() {
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.red);
        JSlider colorSlider = new JSlider(0, 360, 0);
        colorSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                int value = colorSlider.getValue();
                recolor(value);
            }
        });
        colorPanel.add(colorSlider, BorderLayout.CENTER);
        colorPanel.add(new JLabel("Color"));
        add(colorPanel);
    }

    private void recolor(int value) {
        colorPanel.setBackground(new Color(Color.HSBtoRGB((float) value / 360f, 1, 1)));
        setBackground(new Color(Color.HSBtoRGB((float) value / 360f, 1, 1)));
        colorConsumer.accept(colorPanel.getBackground());
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
