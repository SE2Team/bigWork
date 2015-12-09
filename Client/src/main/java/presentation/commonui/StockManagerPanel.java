package presentation.commonui;

import presentation.commodityui.CheckStockPanel;
import presentation.commodityui.StockInfoPanel;
import presentation.commodityui.WarningPanel;
import presentation.listui.StockInPanel;
import presentation.listui.StockOutPanel;

import javax.swing.*;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class StockManagerPanel extends CommonPanel{
    @Override
    protected void init() {
        jb_stockIn = new JButton("入库");
        jb_stockIn.setFont(jb_font);
        jb_stockIn.setBounds(x, (y - 5 * height) / 2 - 10, width, height);
        jb_stockIn.addActionListener(this);
        left.add(jb_stockIn);

        jb_stockOut = new JButton("出库");
        jb_stockOut.setFont(jb_font);
        jb_stockOut.setBounds(x, (y - 5 * height) / 2 + height - 10, width,
                height);
        jb_stockOut.addActionListener(this);
        left.add(jb_stockOut);

        jb_stockCheck = new JButton("库存查看");
        jb_stockCheck.setFont(jb_font);
        jb_stockCheck.setBounds(x, (y - 5 * height) / 2 + 2 * height - 10,
                width, height);
        jb_stockCheck.addActionListener(this);
        left.add(jb_stockCheck);

        jb_stockInfo = new JButton("库存盘点");
        jb_stockInfo.setFont(jb_font);
        jb_stockInfo.setBounds(x, (y - 5 * height) / 2 + 3 * height - 10,
                width, height);
        jb_stockInfo.addActionListener(this);
        left.add(jb_stockInfo);

        jb_warning = new JButton("库存报警");
        jb_warning.setFont(jb_font);
        jb_warning.setBounds(x, (y - 5 * height) / 2 + 4 * height - 10, width,
                height);
        jb_warning.addActionListener(this);
        left.add(jb_warning);

        cardPanel.add("入库", new StockInPanel());
        cardPanel.add("出库", new StockOutPanel());
        cardPanel.add("库存查看", new CheckStockPanel());
        cardPanel.add("库存盘点", new StockInfoPanel());
        cardPanel.add("库存报警", new WarningPanel());
    }
}
