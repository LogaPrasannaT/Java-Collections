import java.awt.Color;
import java.awt.Graphics;

public class Raindrop {
    private int x, y;
    private final int diameter = 10;
    private final int fallSpeed = 5;

    public Raindrop(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void fall() {
        y += fallSpeed;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getDiameter() {
        return diameter;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, diameter, diameter);
    }
}


