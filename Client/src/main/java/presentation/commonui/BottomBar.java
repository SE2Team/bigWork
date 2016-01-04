package presentation.commonui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MYK on 2015/12/27 0027.
 */
public class BottomBar extends JPanel {

    private static BottomBar ME = null;
    private JButton closeB;
    private JButton jb_set;

    private BottomBar() {
        this.setLayout(null);
        this.setBounds(0, 600, 900, 30);

        initCloseButton();
        BottomBar.ME = this;

        initSetButton();
    }

    private void initCloseButton() {

        closeB = new JButton("退出系统");
        closeB.setSize(10, 10);
        closeB.setBounds(750, 0, 150, 30);

//        this.add(closeB);
    }

    private void initSetButton() {
        jb_set = new JButton(new ImageIcon("images/setting.png"));
        jb_set.setBounds(860, 0, 30, 30);
        this.add(jb_set);
        jb_set.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new SetIPDialog(BottomBar.this).setVisible(true);
            }
        });
        jb_set.setOpaque(true);
    }
    
    public static BottomBar getInstance() {
        if (BottomBar.ME == null) {
            return new BottomBar();
        } else {
            return ME;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(new ImageIcon("images/buttom.jpg").getImage(), 0, 0, this);
        repaint();
    }

    public JButton getCloseB() {
        return closeB;
    }

    public void warning() {

    }
}
