package presentation.userui;

import presentation.commonui.BigCardPanel;
import presentation.commonui.ButtomBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogInFrame extends JFrame{
    static Point origin = new Point();
    private JFrame jf;
    private JButton closeB;
    private ButtomBar buttom;


    public LogInFrame() {
        jf = this;
//		this.setTitle("快递物流管理系统");//设置窗体名称
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭属性
        this.setSize(900, 630);//设置窗体大小
        this.setLayout(null);


        jf.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                origin.x = e.getX();
                origin.y = e.getY();
                repaint();
            }

        });
        jf.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // 当鼠标拖动时获取窗口当前位置
                Point p = jf.getLocation();
                // 设置窗口的位置
                // 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
                jf.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
            }
        });


        this.add(new BigCardPanel());

        this.setResizable(false);//不允许用户改变窗体大小
        this.setUndecorated(true);
        this.setVisible(true);
		//居中
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		int x=(screen.width-this.getWidth())/2;
		int y=(screen.height-this.getHeight())/2;
		this.setLocation(x, y-20);

        buttom = new ButtomBar();
        buttom.setBounds(0, 600, 900, 30);

        closeB = new JButton("退出系统");
        closeB.setSize(10, 10);
        closeB.setBounds(750, 0, 150, 30);
        closeB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
            }
        });
        buttom.add(closeB);

        this.add(buttom);
    }
}

