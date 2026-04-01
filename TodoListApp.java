import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TodoListApp extends JFrame implements ActionListener {

    JTextField txtTask;
    JButton btnAdd, btnDelete;
    JList<String> taskList;
    DefaultListModel<String> model;

    public TodoListApp() {

        setTitle("To-Do List");
        setSize(400, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input field
        txtTask = new JTextField();
        txtTask.setBounds(50, 30, 200, 30);
        add(txtTask);

        // Add button
        btnAdd = new JButton("Add");
        btnAdd.setBounds(270, 30, 80, 30);
        btnAdd.addActionListener(this);
        add(btnAdd);

        // List model
        model = new DefaultListModel<>();

        // JList
        taskList = new JList<>(model);
        JScrollPane scroll = new JScrollPane(taskList);
        scroll.setBounds(50, 80, 300, 200);
        add(scroll);

        // Delete button
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(140, 300, 100, 30);
        btnDelete.addActionListener(this);
        add(btnDelete);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        // Add Task
        if (e.getSource() == btnAdd) {
            String task = txtTask.getText();

            if (!task.isEmpty()) {
                model.addElement(task);
                txtTask.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Enter a task!");
            }
        }

        // Delete Task
        if (e.getSource() == btnDelete) {
            int index = taskList.getSelectedIndex();

            if (index != -1) {
                model.remove(index);
            } else {
                JOptionPane.showMessageDialog(this, "Select a task to delete!");
            }
        }
    }

    public static void main(String[] args) {
        new TodoListApp();
    }
}