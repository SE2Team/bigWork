package presentation.commonui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MYK on 2015/12/27 0027.
 */
public class ButtomBar extends JPanel {

    public ButtomBar() {
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("images/buttom.jpg").getImage(), 0, 0, this);
    }
}
