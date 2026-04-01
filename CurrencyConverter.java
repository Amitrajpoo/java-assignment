import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame implements ActionListener {

    JTextField txtAmount, txtResult;
    JComboBox<String> fromCurrency, toCurrency;
    JButton btnConvert;

    public CurrencyConverter() {

        setTitle("Currency Converter");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Amount
        JLabel lblAmount = new JLabel("Enter Amount:");
        lblAmount.setBounds(50, 30, 120, 25);
        add(lblAmount);

        txtAmount = new JTextField();
        txtAmount.setBounds(180, 30, 150, 25);
        add(txtAmount);

        // From Currency
        JLabel lblFrom = new JLabel("From:");
        lblFrom.setBounds(50, 70, 100, 25);
        add(lblFrom);

        String[] currencies = {"INR", "USD", "EUR"};
        fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setBounds(180, 70, 150, 25);
        add(fromCurrency);

        // To Currency
        JLabel lblTo = new JLabel("To:");
        lblTo.setBounds(50, 110, 100, 25);
        add(lblTo);

        toCurrency = new JComboBox<>(currencies);
        toCurrency.setBounds(180, 110, 150, 25);
        add(toCurrency);

        // Result
        JLabel lblResult = new JLabel("Result:");
        lblResult.setBounds(50, 150, 100, 25);
        add(lblResult);

        txtResult = new JTextField();
        txtResult.setBounds(180, 150, 150, 25);
        txtResult.setEditable(false);
        add(txtResult);

        // Button
        btnConvert = new JButton("Convert");
        btnConvert.setBounds(120, 200, 120, 30);
        btnConvert.addActionListener(this);
        add(btnConvert);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            double amount = Double.parseDouble(txtAmount.getText());

            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();

            double result = 0;

            // Fixed conversion rates
            if (from.equals("INR") && to.equals("USD")) result = amount / 83;
            else if (from.equals("USD") && to.equals("INR")) result = amount * 83;

            else if (from.equals("INR") && to.equals("EUR")) result = amount / 90;
            else if (from.equals("EUR") && to.equals("INR")) result = amount * 90;

            else if (from.equals("USD") && to.equals("EUR")) result = amount * 0.92;
            else if (from.equals("EUR") && to.equals("USD")) result = amount / 0.92;

            else result = amount; // same currency

            txtResult.setText(String.format("%.2f", result));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid amount!");
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}