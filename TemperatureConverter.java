import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame implements ActionListener {

    JTextField txtInput, txtOutput;
    JButton btnCtoF, btnFtoC;

    public TemperatureConverter() {

        setTitle("Temperature Converter");
        setSize(350, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input Label
        JLabel lblInput = new JLabel("Enter Value:");
        lblInput.setBounds(50, 40, 100, 25);
        add(lblInput);

        // Input Field
        txtInput = new JTextField();
        txtInput.setBounds(150, 40, 120, 25);
        add(txtInput);

        // Output Label
        JLabel lblOutput = new JLabel("Result:");
        lblOutput.setBounds(50, 80, 100, 25);
        add(lblOutput);

        // Output Field
        txtOutput = new JTextField();
        txtOutput.setBounds(150, 80, 120, 25);
        txtOutput.setEditable(false);
        add(txtOutput);

        // Buttons
        btnCtoF = new JButton("C → F");
        btnCtoF.setBounds(50, 130, 100, 30);
        btnCtoF.addActionListener(this);
        add(btnCtoF);

        btnFtoC = new JButton("F → C");
        btnFtoC.setBounds(170, 130, 100, 30);
        btnFtoC.addActionListener(this);
        add(btnFtoC);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            double value = Double.parseDouble(txtInput.getText());
            double result = 0;

            if (e.getSource() == btnCtoF) {
                result = (value * 9 / 5) + 32;
                txtOutput.setText(result + " °F");
            } 
            else if (e.getSource() == btnFtoC) {
                result = (value - 32) * 5 / 9;
                txtOutput.setText(result + " °C");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid number!");
        }
    }

    public static void main(String[] args) {
        new TemperatureConverter();
    }
}