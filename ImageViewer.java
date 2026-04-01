import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ImageViewer extends JFrame implements ActionListener {

    JLabel imageLabel;
    JButton loadBtn, nextBtn, prevBtn;

    File[] imageFiles;
    int currentIndex = 0;

    ImageViewer() {
        setTitle("Image Viewer");
        setSize(600, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Image display label
        imageLabel = new JLabel();
        imageLabel.setBounds(50, 30, 500, 300);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(imageLabel);

        // Buttons
        loadBtn = new JButton("Load Images");
        loadBtn.setBounds(50, 350, 130, 30);
        loadBtn.addActionListener(this);
        add(loadBtn);

        prevBtn = new JButton("Previous");
        prevBtn.setBounds(200, 350, 100, 30);
        prevBtn.addActionListener(this);
        add(prevBtn);

        nextBtn = new JButton("Next");
        nextBtn.setBounds(320, 350, 100, 30);
        nextBtn.addActionListener(this);
        add(nextBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        // Load Images
        if (e.getSource() == loadBtn) {
            JFileChooser fc = new JFileChooser();
            fc.setMultiSelectionEnabled(true);

            int result = fc.showOpenDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                imageFiles = fc.getSelectedFiles();
                currentIndex = 0;
                showImage();
            }
        }

        // Next
        if (e.getSource() == nextBtn) {
            if (imageFiles != null && currentIndex < imageFiles.length - 1) {
                currentIndex++;
                showImage();
            }
        }

        // Previous
        if (e.getSource() == prevBtn) {
            if (imageFiles != null && currentIndex > 0) {
                currentIndex--;
                showImage();
            }
        }
    }

    void showImage() {
        if (imageFiles == null || imageFiles.length == 0) return;

        ImageIcon icon = new ImageIcon(imageFiles[currentIndex].getAbsolutePath());

        // Resize image to fit label
        Image img = icon.getImage().getScaledInstance(
                imageLabel.getWidth(),
                imageLabel.getHeight(),
                Image.SCALE_SMOOTH
        );

        imageLabel.setIcon(new ImageIcon(img));
    }

    public static void main(String[] args) {
        new ImageViewer();
    }
}