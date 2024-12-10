import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class DrawPalette extends JComponent {

    public Build palette;
    public int size;
    public int x;
    public int y;
    
    public DrawPalette(Build initPalette, int squareSize, int x0, int y0){
        super();

        this.palette = initPalette;
        this.size = squareSize;
        this.x = 120;
        this.y = 50;

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        x = 120;
        y = 50;
        for (int i = 0; i < palette.getSize(); i++) {
            g.setColor(palette.getColor(i));

            int x1 = 120 + i*(size+5);
            g.fillRect(x1, y, size, size); // x, y, width, height

        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Palette");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        Build newPalette = new Build(10);
        newPalette.setColor(0, 125, 120, 70);
        newPalette.setColor(1, 77,125,70);
        newPalette.setColor(2, 111, 125, 109);
        newPalette.setColor(3, 51, 125, 40);
        newPalette.setColor(4, 68, 153, 53);
        newPalette.setColor(5,42,153,22);
        newPalette.setColor(6,23,153,0);
        newPalette.setColor(7,68,77,67);
        newPalette.setColor(8,32,77,27);
        newPalette.setColor(9, 18, 77, 12);

        DrawPalette view = new DrawPalette(newPalette, 50, 100, 100);
        frame.add(view);
        frame.setSize(1024, 768);
        frame.setVisible(true);

    }
}