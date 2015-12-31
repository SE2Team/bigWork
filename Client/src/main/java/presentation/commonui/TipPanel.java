package presentation.commonui;

import javax.swing.*;
import java.awt.*;

public class TipPanel extends JPanel implements Runnable {
    protected int width = 900, height = 30;
    protected int jl_width = 200, jl_height = 30;
    protected Font font = new Font("宋体", Font.PLAIN, 18);
    protected int x = 0, y = height;
    protected boolean flag;
    String str = "";

    public TipPanel() {
        this.setSize(width, height);
    }

    public TipPanel(String str, boolean flag) {
        this();
        this.str = str;
        this.flag = flag;
        JLabel jl = new JLabel(str);
        jl.setBounds(0, 0, jl_width, jl_height);
        jl.setFont(font);
        this.add(jl);
    }

    public void paintComponent(Graphics g) {
        Image tipBar = null;
        if (flag == false) {
            tipBar = new ImageIcon("images/buttom_nofi.jpg").getImage();
        } else {
            tipBar = new ImageIcon("images/true.jpg").getImage();
        }
        
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
            Thread.sleep(3000);
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
