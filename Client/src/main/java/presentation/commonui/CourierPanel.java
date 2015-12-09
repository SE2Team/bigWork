package presentation.commonui;

import presentation.listui.AddresseeInfoPanel;
import presentation.listui.OrderPanel;

import javax.swing.*;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class CourierPanel extends CommonPanel{


    @Override
    protected void init() {
        jb_inputOrder = new JButton("输入订单");
        jb_inputOrder.setFont(jb_font);
        jb_inputOrder.setBounds(x, (y - 2 * height) / 2 - 10, width, height);
        jb_inputOrder.addActionListener(this);
        left.add(jb_inputOrder);

//		jb_quatation = new JButton("查询报价和时间");
//		jb_quatation.setFont(jb_font);
//		jb_quatation.setBounds(x, (y - 3 * height) / 2 + height - 10, width,
//				height);
//		jb_quatation.addActionListener(this);
//		left.add(jb_quatation);

        jb_inputReceive = new JButton("输入收件信息");
        jb_inputReceive.setFont(jb_font);
        jb_inputReceive.setBounds(x, (y - 2 * height) / 2 + height - 10,
                width, height);
        jb_inputReceive.addActionListener(this);
        left.add(jb_inputReceive);

        cardPanel.add("输入订单", new OrderPanel());
        //	cardPanel.add("查询报价和时间", new QuotationPanel());
        cardPanel.add("输入收件信息", new AddresseeInfoPanel());
    }
}
