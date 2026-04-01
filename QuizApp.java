import javax.swing.*;
import java.awt.event.*;

public class QuizApp extends JFrame implements ActionListener {

    JLabel questionLabel;
    JRadioButton opt1, opt2, opt3, opt4;
    JButton nextBtn, prevBtn, submitBtn;
    ButtonGroup bg;

    int current = 0, score = 0;

    String questions[][] = {
        {"Which language is used for Java GUI?", "Python", "C++", "Swing", "HTML"},
        {"Which keyword is used for inheritance?", "this", "super", "extends", "implements"},
        {"Which method is entry point?", "start()", "main()", "run()", "init()"},
        {"Which package is used for GUI?", "java.io", "java.util", "javax.swing", "java.net"},
        {"Which is not OOP concept?", "Encapsulation", "Polymorphism", "Compilation", "Inheritance"}
    };

    int answers[] = {3, 3, 2, 3, 3}; // Correct options (1-based index)

    QuizApp() {
        setTitle("Quiz Application");
        setSize(500, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        questionLabel = new JLabel();
        questionLabel.setBounds(50, 30, 400, 30);
        add(questionLabel);

        opt1 = new JRadioButton();
        opt1.setBounds(50, 70, 200, 30);
        opt2 = new JRadioButton();
        opt2.setBounds(50, 100, 200, 30);
        opt3 = new JRadioButton();
        opt3.setBounds(50, 130, 200, 30);
        opt4 = new JRadioButton();
        opt4.setBounds(50, 160, 200, 30);

        bg = new ButtonGroup();
        bg.add(opt1);
        bg.add(opt2);
        bg.add(opt3);
        bg.add(opt4);

        add(opt1); add(opt2); add(opt3); add(opt4);

        prevBtn = new JButton("Previous");
        prevBtn.setBounds(50, 210, 100, 30);
        prevBtn.addActionListener(this);
        add(prevBtn);

        nextBtn = new JButton("Next");
        nextBtn.setBounds(160, 210, 100, 30);
        nextBtn.addActionListener(this);
        add(nextBtn);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(270, 210, 100, 30);
        submitBtn.addActionListener(this);
        add(submitBtn);

        loadQuestion();
        setVisible(true);
    }

    void loadQuestion() {
        bg.clearSelection();
        questionLabel.setText("Q" + (current + 1) + ": " + questions[current][0]);

        opt1.setText(questions[current][1]);
        opt2.setText(questions[current][2]);
        opt3.setText(questions[current][3]);
        opt4.setText(questions[current][4]);
    }

    int getSelectedOption() {
        if (opt1.isSelected()) return 1;
        if (opt2.isSelected()) return 2;
        if (opt3.isSelected()) return 3;
        if (opt4.isSelected()) return 4;
        return 0;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == nextBtn) {
            if (getSelectedOption() == answers[current]) {
                score++;
            }
            current++;
            if (current < questions.length) {
                loadQuestion();
            } else {
                current--;
            }
        }

        if (e.getSource() == prevBtn) {
            if (current > 0) {
                current--;
                loadQuestion();
            }
        }

        if (e.getSource() == submitBtn) {
            if (getSelectedOption() == answers[current]) {
                score++;
            }
            JOptionPane.showMessageDialog(this, "Your Score: " + score);
        }
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}