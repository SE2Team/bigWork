package presentation.commonui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyJLabel extends JLabel {

    static Color preColor = new Color(225, 242, 249);
    static Color clickColor = new Color(251, 251, 251);
    static Color enterColor = new Color(255, 237, 81);

    public MyJLabel(String text) {
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setText(text);
        this.setOpaque(true);
        this.setBackground(Color.white);
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                MyJLabel.this.setBackground(Color.white);
            }

            public void mouseEntered(MouseEvent e) {
                MyJLabel.this.setBackground(enterColor);
            }

            public void mouseExited(MouseEvent e) {
                MyJLabel.this.setBackground(Color.white);
            }
        });
    }

    public static void changeColor(MyJLabel clickedOne, MyJLabel[] labels) {
        for (int i = 0; i < labels.length; i++) {
            if (!clickedOne.equals(labels[i])) {
                labels[i].setBackground(preColor);
            }
        }
    }

}

