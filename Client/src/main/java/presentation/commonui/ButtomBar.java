package presentation.commonui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MYK on 2015/12/27 0027.
 */
public class ButtomBar extends JPanel {

    private static ButtomBar ME = null;
    private JButton closeB;

    private ButtomBar() {
        this.setLayout(null);
        this.setBounds(0, 600, 900, 30);

        initCloseButton();
        ButtomBar.ME = this;
    }

    private void initCloseButton() {

        closeB = new JButton("退出系统");
        closeB.setSize(10, 10);
        closeB.setBounds(750, 0, 150, 30);

        this.add(closeB);
    }

    public static ButtomBar getInstance() {
        if (ButtomBar.ME == null) {
            return new ButtomBar();
        } else {
            return ME;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon("images/buttom.jpg").getImage(), 0, 0, this);
        repaint();
    }

    public JButton getCloseB() {
        return closeB;
    }

    public void warning() {

    }
}
