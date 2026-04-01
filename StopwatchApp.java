import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopwatchApp extends JFrame implements ActionListener {

    JLabel timeLabel;
    JButton btnStart, btnStop, btnReset, btnLap;

    int seconds = 0;
    int minutes = 0;
    int hours = 0;

    Timer timer;

    DefaultListModel<String> lapModel;
    JList<String> lapList;

    public StopwatchApp() {

        setTitle("Stopwatch");
        setSize(400, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Time Label
        timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        timeLabel.setBounds(120, 30, 200, 50);
        add(timeLabel);

        // Buttons
        btnStart = new JButton("Start");
        btnStart.setBounds(30, 100, 80, 30);
        btnStart.addActionListener(this);
        add(btnStart);

        btnStop = new JButton("Stop");
        btnStop.setBounds(120, 100, 80, 30);
        btnStop.addActionListener(this);
        add(btnStop);

        btnReset = new JButton("Reset");
        btnReset.setBounds(210, 100, 80, 30);
        btnReset.addActionListener(this);
        add(btnReset);

        btnLap = new JButton("Lap");
        btnLap.setBounds(300, 100, 70, 30);
        btnLap.addActionListener(this);
        add(btnLap);

        // Timer (runs every 1 second)
        timer = new Timer(1000, e -> updateTime());

        // Lap list
        lapModel = new DefaultListModel<>();
        lapList = new JList<>(lapModel);

        JScrollPane scroll = new JScrollPane(lapList);
        scroll.setBounds(50, 150, 300, 180);
        add(scroll);

        setVisible(true);
    }

    public void updateTime() {

        seconds++;

        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }

        if (minutes == 60) {
            minutes = 0;
            hours++;
        }

        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        timeLabel.setText(time);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnStart) {
            timer.start();
        }

        else if (e.getSource() == btnStop) {
            timer.stop();
        }

        else if (e.getSource() == btnReset) {
            timer.stop();
            seconds = minutes = hours = 0;
            timeLabel.setText("00:00:00");
            lapModel.clear();
        }

        else if (e.getSource() == btnLap) {
            lapModel.addElement(timeLabel.getText());
        }
    }

    public static void main(String[] args) {
        new StopwatchApp();
    }
}