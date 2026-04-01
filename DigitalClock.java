import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {

    JLabel timeLabel, dateLabel;

    DigitalClock() {
        setTitle("Digital Clock");
        setSize(400, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Time Label
        timeLabel = new JLabel();
        timeLabel.setBounds(50, 30, 300, 50);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        timeLabel.setForeground(Color.BLUE);
        add(timeLabel);

        // Date Label
        dateLabel = new JLabel();
        dateLabel.setBounds(50, 90, 300, 30);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(dateLabel);

        // Timer to update every second
        Timer t = new Timer(1000, e -> updateTime());
        t.start();

        updateTime();
        setVisible(true);
    }

    void updateTime() {
        Date now = new Date();

        // Time format
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
        String time = timeFormat.format(now);

        // Date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        String date = dateFormat.format(now);

        timeLabel.setText(time);
        dateLabel.setText(date);
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}