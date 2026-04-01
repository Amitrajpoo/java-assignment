import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class AddressBook extends JFrame implements ActionListener {

    JTextField nameField, phoneField;
    JButton addBtn, updateBtn, deleteBtn;

    JTable table;
    DefaultTableModel model;

    int selectedRow = -1;

    AddressBook() {
        setTitle("Contact / Address Book");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Labels
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 80, 30);
        add(nameLabel);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 70, 80, 30);
        add(phoneLabel);

        // Text Fields
        nameField = new JTextField();
        nameField.setBounds(100, 30, 150, 30);
        add(nameField);

        phoneField = new JTextField();
        phoneField.setBounds(100, 70, 150, 30);
        add(phoneField);

        // Buttons
        addBtn = new JButton("Add");
        addBtn.setBounds(280, 30, 100, 30);
        addBtn.addActionListener(this);
        add(addBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(280, 70, 100, 30);
        updateBtn.addActionListener(this);
        add(updateBtn);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(400, 50, 100, 30);
        deleteBtn.addActionListener(this);
        add(deleteBtn);

        // Table
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Phone");

        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(30, 120, 520, 200);
        add(sp);

        // Table click event
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                selectedRow = table.getSelectedRow();
                nameField.setText(model.getValueAt(selectedRow, 0).toString());
                phoneField.setText(model.getValueAt(selectedRow, 1).toString());
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        // Add
        if (e.getSource() == addBtn) {
            String name = nameField.getText();
            String phone = phoneField.getText();

            if (name.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter all fields!");
                return;
            }

            model.addRow(new Object[]{name, phone});
            clearFields();
        }

        // Update
        if (e.getSource() == updateBtn) {
            if (selectedRow >= 0) {
                model.setValueAt(nameField.getText(), selectedRow, 0);
                model.setValueAt(phoneField.getText(), selectedRow, 1);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Select a row to update!");
            }
        }

        // Delete
        if (e.getSource() == deleteBtn) {
            if (selectedRow >= 0) {
                model.removeRow(selectedRow);
                clearFields();
                selectedRow = -1;
            } else {
                JOptionPane.showMessageDialog(this, "Select a row to delete!");
            }
        }
    }

    void clearFields() {
        nameField.setText("");
        phoneField.setText("");
    }

    public static void main(String[] args) {
        new AddressBook();
    }
}