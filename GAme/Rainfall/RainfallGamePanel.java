import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class RainfallGamePanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private ArrayList<Raindrop> raindrops;
    private Bucket bucket;
    private int score;
    private final int panelWidth = 800;
    private final int panelHeight = 600;
    private final Random random;

    public RainfallGamePanel() {
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        setBackground(Color.BLACK);
        raindrops = new ArrayList<>();
        bucket = new Bucket(panelWidth / 2 - 50, panelHeight - 50, 100, 20);
        timer = new Timer(30, this);
        timer.start();
        random = new Random();
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        bucket.draw(g);
        for (Raindrop raindrop : raindrops) {
            raindrop.draw(g);
        }
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (random.nextInt(10) < 2) {
            raindrops.add(new Raindrop(random.nextInt(panelWidth), 0));
        }

        Iterator<Raindrop> iterator = raindrops.iterator();
        while (iterator.hasNext()) {
            Raindrop raindrop = iterator.next();
            raindrop.fall();
            if (raindrop.getY() > panelHeight) {
                iterator.remove();
            } else if (raindrop.getY() + raindrop.getDiameter() >= bucket.getY()
                    && raindrop.getX() + raindrop.getDiameter() >= bucket.getX()
                    && raindrop.getX() <= bucket.getX() + bucket.getWidth()) {
                iterator.remove();
                score++;
            }
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            bucket.move(-15);
        } else if (key == KeyEvent.VK_RIGHT) {
            bucket.move(15);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

