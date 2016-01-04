package presentation.commonui;

import presentation.commonui.UIdata.UIConstant;
import presentation.commonui.swing.MyDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                height = 30, addy = 50;
        private JLabel inputIP, port;
        private JTextField jtf_ip, jtf_port;
        private JButton sure, cancel;
        private Font font1 = new Font("宋体", Font.PLAIN, 20);
        private Font font2 = new Font("宋体", Font.PLAIN, 18);

        private void initButton() {
            sure = new JButton("确定");
            sure.setFont(font1);
            sure.setBounds(addx - x, 300, 80, height);
            sure.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UIConstant.address = jtf_ip.getText();
                    UIConstant.port = jtf_port.getText();
                    dispose();
                }
            });

            cancel = new JButton("取消");
            cancel.setFont(font1);
            cancel.setBounds(220, 300, 80, height);
            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            this.add(sure);
            this.add(cancel);
        }
        setIPPanel() {
            this.setLayout(null);

            inputIP = new JLabel("服务端IP:");
            inputIP.setFont(font1);
            inputIP.setBounds(x, y, jl_width, height);

            jtf_ip = new JTextField();
            jtf_ip.setFont(font2);
            jtf_ip.setBounds(x + addx, y, jtf_width, height);
            jtf_ip.setText(UIConstant.address);

            port = new JLabel("端口：");
            port.setFont(font1);
            port.setBounds(x, y + addy, jl_width, height);

            jtf_port = new JTextField();
            jtf_port.setFont(font2);
            jtf_port.setBounds(x + addx, y + addy, jtf_width, height);
            jtf_port.setText(UIConstant.port);


            this.add(inputIP);
            this.add(jtf_ip);
            this.add(port);
            this.add(jtf_port);
            initButton();
        }
    }

}
