package presentation.commonui;

import presentation.listui.DistributePanel;
import presentation.listui.LoadingPanel;
import presentation.listui.ReceiptPanel;
import presentation.listui.ReceivePanel;
import presentation.manageui.DriverPanel;
import presentation.manageui.VehiclePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class SalesmanPanel extends CommonPanel{
    @Override
    protected void init() {
        recAndDis.getReceive().addActionListener(this);
        recAndDis.getDistribute().addActionListener(this);

        jb_loading = new MyJLabel("车辆装车管理");
        jb_loading.setFont(jb_font);
        jb_loading.setBounds(x, (y - 5 * height) / 2 - 10, width, height);
        jb_loading.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "车辆装车管理");
            }
        });
        left.add(jb_loading);

        jb_recAndDis = new MyJLabel("接收与派件");
        jb_recAndDis.setFont(jb_font);
        jb_recAndDis.setBounds(x, (y - 5 * height) / 2 + height - 10, width,
                height);
        jb_recAndDis.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "接收与派件");
            }
        });
        left.add(jb_recAndDis);

        jb_recordReceipt = new MyJLabel("记录收款");
        jb_recordReceipt.setFont(jb_font);
        jb_recordReceipt.setBounds(x, (y - 5 * height) / 2 + 2 * height - 10,
                width, height);
        jb_recordReceipt.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "记录收款");
            }
        });
        left.add(jb_recordReceipt);

        jb_vehicleInfo = new MyJLabel("车辆信息管理");
        jb_vehicleInfo.setFont(jb_font);
        jb_vehicleInfo.setBounds(x, (y - 5 * height) / 2 + 3 * height - 10,
                width, height);
        jb_vehicleInfo.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "车辆信息管理");
            }
        });
        left.add(jb_vehicleInfo);

        jb_driverInfo = new MyJLabel("司机信息管理");
        jb_driverInfo.setFont(jb_font);
        jb_driverInfo.setBounds(x, (y - 5 * height) / 2 + 4 * height - 10,
                width, height);
        jb_driverInfo.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "司机信息管理");
            }
        });
        left.add(jb_driverInfo);

        cardPanel.add("车辆装车管理", new LoadingPanel());
        cardPanel.add("接收与派件", recAndDis);
        cardPanel.add("记录收款", new ReceiptPanel());
        cardPanel.add("车辆信息管理", new VehiclePanel());
        cardPanel.add("司机信息管理", new DriverPanel());
        cardPanel.add("输入接收单信息", new ReceivePanel());
        cardPanel.add("输入派件单信息", new DistributePanel());
    }
}
