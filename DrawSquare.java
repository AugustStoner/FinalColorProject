import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawSquare extends JPanel {

    public Color color;
    public int x;
    public int y;
    private final int size;

    public DrawSquare(Color color, int x, int y, int size) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(color);
        g.fillRect(this.x, this.y, this.size, this.size); // x, y, width, height
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Square");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color myColor = new Color(125, 120, 70);
        DrawSquare square = new DrawSquare(myColor, 100, 100, 50);

        frame.add(square);
        frame.setSize(1024, 768);
        frame.setVisible(true);
    }
}