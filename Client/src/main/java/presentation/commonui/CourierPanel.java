package presentation.commonui;

import presentation.listui.AddresseeInfoPanel;
import presentation.listui.OrderPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class CourierPanel extends CommonPanel{


    @Override
    protected void init() {
        jb_inputOrder = new MyJLabel("输入订单");
        jb_inputOrder.setFont(jb_font);
        jb_inputOrder.setBounds(x, (y - 2 * height) / 2 - 10, width, height);
        jb_inputOrder.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "输入订单");
            }
        });
        left.add(jb_inputOrder);

        jb_inputReceive = new MyJLabel("输入收件信息");
        jb_inputReceive.setFont(jb_font);
        jb_inputReceive.setBounds(x, (y - 2 * height) / 2 + height - 10,
                width, height);
        jb_inputReceive.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "输入收件信息");
            }
        });
        ;
        left.add(jb_inputReceive);

        cardPanel.add("输入订单", new OrderPanel());
        cardPanel.add("输入收件信息", new AddresseeInfoPanel());
    }
}
