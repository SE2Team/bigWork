package presentation.commonui;

import javax.swing.*;
import java.awt.*;

public class TipPanel extends JPanel implements Runnable {
    protected int width = 900, height = 30;
    protected int x = 0, y = height;
    String str = "";

    public TipPanel() {
        this.setSize(width, height);
    }

    public TipPanel(String str) {
        this();
        this.str = str;
        this.add(new TextArea(str));
    }

    public void paintComponent(Graphics g) {
        Image tipBar = new ImageIcon("images/buttom_nofi.jpg").getImage();
        g.drawImage(tipBar, 0, 0, width, height, this);
    }

    public void run() {
        BottomBar.getInstance().add(this);
        for (int i = 0; i <= height; i += 1) {
            this.setLocation(x, y - i);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        close();


    }

    public void close() {
        System.out.println("closing");
        for (int i = 0; i <= height; i += 1) {
            this.setLocation(x, y - height + i);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.setVisible(false);
    }

}
