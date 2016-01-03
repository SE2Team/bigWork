package presentation.commonui;

import presentation.commonui.swing.MyDialog;

import javax.swing.*;
import java.awt.*;

public class SetIPDialog extends MyDialog {
    private BottomBar parent;

    public SetIPDialog(BottomBar parent) {
        super();

        this.parent = parent;
        this.setContentPane(new setIPPanel());
        this.setSize(400, 380);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    class setIPPanel extends JPanel {
        int x = 20, y = 20, addx = 120, jl_width = 100, jtf_width = 200,
                height = 30;
        private JLabel inputIP;
        private JTextField jtf_ip;
        private JButton sure, cancel;
        private Font font1 = new Font("宋体", Font.PLAIN, 20);
        private Font font2 = new Font("宋体", Font.PLAIN, 18);

        setIPPanel() {
            this.setLayout(null);

            inputIP = new JLabel("客户端IP:");
            inputIP.setFont(font1);
            inputIP.setBounds(x, y, jl_width, height);

            jtf_ip = new JTextField();
            jtf_ip.setFont(font2);
            jtf_ip.setBounds(x + addx, y, jtf_width, height);

            sure = new JButton("确定");
            sure.setFont(font1);
            sure.setBounds(addx - x, 300, 80, height);

            cancel = new JButton("取消");
            cancel.setFont(font1);
            cancel.setBounds(220, 300, 80, height);

            this.add(inputIP);
            this.add(jtf_ip);
            this.add(sure);
            this.add(cancel);
        }
    }

}
