import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {

    JButton[] buttons = new JButton[9];
    boolean playerX = true; // true = X, false = O

    public TicTacToe() {

        setTitle("Tic Tac Toe");
        setSize(400, 450);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel for grid
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        // Create buttons
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        add(panel, BorderLayout.CENTER);

        // Reset button
        JButton reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.BOLD, 16));
        reset.addActionListener(e -> resetGame());
        add(reset, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        JButton btn = (JButton) e.getSource();

        if (!btn.getText().equals("")) return;

        if (playerX) {
            btn.setText("X");
        } else {
            btn.setText("O");
        }

        playerX = !playerX;

        checkWinner();
    }

    void checkWinner() {

        int[][] winPositions = {
            {0,1,2}, {3,4,5}, {6,7,8}, // rows
            {0,3,6}, {1,4,7}, {2,5,8}, // cols
            {0,4,8}, {2,4,6}           // diagonals
        };

        for (int[] pos : winPositions) {

            String b1 = buttons[pos[0]].getText();
            String b2 = buttons[pos[1]].getText();
            String b3 = buttons[pos[2]].getText();

            if (!b1.equals("") && b1.equals(b2) && b2.equals(b3)) {
                JOptionPane.showMessageDialog(this, b1 + " Wins 🎉");
                resetGame();
                return;
            }
        }

        // Check draw
        boolean draw = true;
        for (JButton btn : buttons) {
            if (btn.getText().equals("")) {
                draw = false;
                break;
            }
        }

        if (draw) {
            JOptionPane.showMessageDialog(this, "Match Draw 🤝");
            resetGame();
        }
    }

    void resetGame() {
        for (JButton btn : buttons) {
            btn.setText("");
        }
        playerX = true;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}