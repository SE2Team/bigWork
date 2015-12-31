package presentation.commonui;

import presentation.commodityui.CheckingPanel;
import presentation.commodityui.StockInfoPanel;
import presentation.listui.StockInPanel;
import presentation.listui.StockOutPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class StockManagerPanel extends CommonPanel{
    @Override
    protected void init() {
        checkstock.getButton().addActionListener(this);

        jb_stockIn = new MyJLabel("入库");
        jb_stockIn.setFont(jb_font);
        jb_stockIn.setBounds(x, (y - 4 * height) / 2 - 10, width, height);
        jb_stockIn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "入库");
            }
        });
        left.add(jb_stockIn);

        jb_stockOut = new MyJLabel("出库");
        jb_stockOut.setFont(jb_font);
        jb_stockOut.setBounds(x, (y - 4 * height) / 2 + height - 10, width,
                height);
        jb_stockOut.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "出库");
            }
        });
        left.add(jb_stockOut);

        jb_stockCheck = new MyJLabel("库存查看");
        jb_stockCheck.setFont(jb_font);
        jb_stockCheck.setBounds(x, (y - 4 * height) / 2 + 2 * height - 10,
                width, height);
        jb_stockCheck.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "库存查看");
            }
        });
        left.add(jb_stockCheck);

        jb_stockInfo = new MyJLabel("库存盘点");
        jb_stockInfo.setFont(jb_font);
        jb_stockInfo.setBounds(x, (y - 4 * height) / 2 + 3 * height - 10,
                width, height);
        jb_stockInfo.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "库存盘点");
            }
        });
        left.add(jb_stockInfo);


        cardPanel.add("入库", new StockInPanel());
        cardPanel.add("出库", new StockOutPanel());
        cardPanel.add("库存查看", checkstock);
        cardPanel.add("库存盘点", new StockInfoPanel());
        cardPanel.add("库存查看时", new CheckingPanel());
    }
}
