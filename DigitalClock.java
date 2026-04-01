import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {

    JLabel clockLabel;

    public DigitalClock() {
        setTitle("Digital Clock");
        setSize(400, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label for time
        clockLabel = new JLabel();
        clockLabel.setFont(new Font("Arial", Font.BOLD, 40));
        clockLabel.setForeground(Color.BLUE);

        add(clockLabel);

        // Timer (updates every 1 second)
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Get current time
                Date date = new Date();

                // Format time
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

                // Set text to label
                clockLabel.setText(sdf.format(date));
            }
        });

        timer.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}