import javax.swing.*;
import java.awt.*;

public class GodOfWarImage {
    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("God of War Image");

        // Set the default close operation to exit the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JPanel with a custom background image
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the image
                ImageIcon icon = new ImageIcon("god_of_war.jpg");
                Image img = icon.getImage();
                // Draw the image on the panel
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Set the preferred size of the panel
        panel.setPreferredSize(new Dimension(800, 600));

        // Add the panel to the frame
        frame.add(panel);

        // Pack the frame to fit the panel's preferred size
        frame.pack();

        // Set the frame's location to the center of the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}

