import javax.swing.*;

public class RainfallGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rainfall Game");
        RainfallGamePanel gamePanel = new RainfallGamePanel();
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

