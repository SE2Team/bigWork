import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Text extends JFrame {
    public Text() {
        text1 p = new text1();
        setLayout(new BorderLayout());
        add(p);
    }

    class text1 extends JPanel {
        int x = 50, y = 50;

        public text1() {
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    x = e.getX();
                    y = e.getY();
                    repaint();
                }

                @Override
                public void mouseDragged(MouseEvent e) {//这个方法更好吧
                    x = e.getX();
                    y = e.getY();
                    System.out.println("drag");
                    repaint();
                }
            });
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.yellow);
            g.fillOval(x, y, 120, 30);
            g.setColor(Color.red);
            g.drawString("拖动我", x + 30, y + 20);
        }
    }

    public static void main(String args[]) {
        Text frame = new Text();
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}