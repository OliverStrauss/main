import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Map extends JPanel {
    Graphics g1;

    public Map() {
        // Initialize g1
        g1 = getGraphics();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        p1score(g);
        p2score(g);
        paintLine(g);
    
    }

    public void paintLine(Graphics g) {
        for (int i = 0; i < 300; i += 30) {
            g.setColor(Color.BLACK);
            g.drawRect((500 / 2)-2, i, 2, 20);
            g.fillRect((500 / 2)-2, i, 2, 20);
        }
    }

    public void p1score(Graphics g) {
        Font f = new Font("MONOFONT", Font.PLAIN, 15);
        int i = ball.getP1score();
        String s = Integer.toString(i);
        g.setFont(f);
        g.drawString(s, 125, 15);
    }

    public void p2score(Graphics g) {
        Font f = new Font("MONOFONT", Font.PLAIN, 15);
        int i = ball.getP2score();
        String s = Integer.toString(i);
        g.setFont(f);
        g.drawString(s, 375, 15);
       
    }
}
