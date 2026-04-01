import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;

public class GuessingGame extends JFrame implements ActionListener {

    JTextField txtGuess;
    JLabel lblHint, lblAttempts;
    JButton btnCheck, btnReset;

    int randomNumber;
    int attempts;

    public GuessingGame() {

        setTitle("Number Guessing Game");
        setSize(350, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Generate random number (1–100)
        randomNumber = (int)(Math.random() * 100) + 1;
        attempts = 0;

        // Label
        JLabel lblTitle = new JLabel("Guess Number (1-100):");
        lblTitle.setBounds(80, 20, 200, 25);
        add(lblTitle);

        // TextField
        txtGuess = new JTextField();
        txtGuess.setBounds(100, 50, 120, 30);
        add(txtGuess);

        // Button
        btnCheck = new JButton("Check");
        btnCheck.setBounds(60, 100, 100, 30);
        btnCheck.addActionListener(this);
        add(btnCheck);

        btnReset = new JButton("Reset");
        btnReset.setBounds(180, 100, 100, 30);
        btnReset.addActionListener(this);
        add(btnReset);

        // Hint Label
        lblHint = new JLabel("Enter a number!");
        lblHint.setBounds(90, 140, 200, 25);
        add(lblHint);

        // Attempts Label
        lblAttempts = new JLabel("Attempts: 0");
        lblAttempts.setBounds(120, 170, 120, 25);
        add(lblAttempts);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        // Check button
        if (e.getSource() == btnCheck) {
            try {
                int guess = Integer.parseInt(txtGuess.getText());
                attempts++;

                if (guess < randomNumber) {
                    lblHint.setText("Too Low ⬇");
                } else if (guess > randomNumber) {
                    lblHint.setText("Too High ⬆");
                } else {
                    lblHint.setText("Correct 🎉");
                    JOptionPane.showMessageDialog(this,
                        "You guessed it in " + attempts + " attempts!");
                }

                lblAttempts.setText("Attempts: " + attempts);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid number!");
            }
        }

        // Reset button
        if (e.getSource() == btnReset) {
            randomNumber = (int)(Math.random() * 100) + 1;
            attempts = 0;
            txtGuess.setText("");
            lblHint.setText("Game Reset! Try again.");
            lblAttempts.setText("Attempts: 0");
        }
    }

    public static void main(String[] args) {
        new GuessingGame();
    }
}