import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdvancedCalculator extends JFrame implements ActionListener {

    JTextField display;
    String operator = "";
    double num1 = 0, num2 = 0;

    AdvancedCalculator() {
        setTitle("Advanced Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());

        // Display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Buttons Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "C", "", "", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "=", ""
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Numbers & decimal
        if (command.matches("[0-9.]")) {
            display.setText(display.getText() + command);
        }

        // Clear
        else if (command.equals("C")) {
            display.setText("");
            num1 = num2 = 0;
            operator = "";
        }

        // Operators
        else if (command.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(display.getText());
            operator = command;
            display.setText("");
        }

        // Equals
        else if (command.equals("=")) {
            num2 = Double.parseDouble(display.getText());

            double result = 0;

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/":
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            display.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new AdvancedCalculator();
    }
}