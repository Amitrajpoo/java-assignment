import javax.swing.*;
import java.awt.event.*;

public class FoodBilling extends JFrame implements ActionListener {

    JCheckBox pizza, burger, coffee;
    JTextField qtyPizza, qtyBurger, qtyCoffee;
    JButton totalBtn;
    JLabel result;

    FoodBilling() {
        setTitle("Food Billing System");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Pizza
        pizza = new JCheckBox("Pizza (₹200)");
        pizza.setBounds(30, 30, 150, 30);
        add(pizza);

        qtyPizza = new JTextField();
        qtyPizza.setBounds(200, 30, 50, 30);
        add(qtyPizza);

        // Burger
        burger = new JCheckBox("Burger (₹100)");
        burger.setBounds(30, 70, 150, 30);
        add(burger);

        qtyBurger = new JTextField();
        qtyBurger.setBounds(200, 70, 50, 30);
        add(qtyBurger);

        // Coffee
        coffee = new JCheckBox("Coffee (₹50)");
        coffee.setBounds(30, 110, 150, 30);
        add(coffee);

        qtyCoffee = new JTextField();
        qtyCoffee.setBounds(200, 110, 50, 30);
        add(qtyCoffee);

        // Button
        totalBtn = new JButton("Calculate Total");
        totalBtn.setBounds(30, 160, 200, 30);
        totalBtn.addActionListener(this);
        add(totalBtn);

        // Result
        result = new JLabel("Total: ₹0");
        result.setBounds(30, 200, 200, 30);
        add(result);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        int total = 0;

        try {
            if (pizza.isSelected()) {
                int qty = Integer.parseInt(qtyPizza.getText());
                total += qty * 200;
            }

            if (burger.isSelected()) {
                int qty = Integer.parseInt(qtyBurger.getText());
                total += qty * 100;
            }

            if (coffee.isSelected()) {
                int qty = Integer.parseInt(qtyCoffee.getText());
                total += qty * 50;
            }

            result.setText("Total: ₹" + total);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid quantity!");
        }
    }

    public static void main(String[] args) {
        new FoodBilling();
    }
}