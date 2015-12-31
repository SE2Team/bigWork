package presentation.userui;

import presentation.commonui.BigCardPanel;
import presentation.commonui.BottomBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogInFrame extends JFrame {
    static Point origin = new Point();
    private static JFrame jf;
    private JButton closeB;
    private BottomBar buttom;
    private BigCardPanel bigCardPanel;


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

        bigCardPanel = new BigCardPanel();
        this.add(bigCardPanel);

        this.setResizable(false);//不允许用户改变窗体大小
        this.setUndecorated(true);
        this.setVisible(true);
        //居中
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = (screen.width - this.getWidth()) / 2;
        int y = (screen.height - this.getHeight()) / 2;
        this.setLocation(x, y - 20);

        buttom = BottomBar.getInstance();
        buttom.getCloseB().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
            }
        });

        this.add(buttom);


        //拟定的遮挡panel
        JPanel co = new JPanel();
        co.setBounds(0, 0, 900, 630);

//        this.add(co);
    }

    public static JFrame getInstance() {
        return jf;
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        bigCardPanel.setEnabled(b);
    }
}

