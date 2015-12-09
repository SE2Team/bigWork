package presentation.commonui;

import presentation.listui.TransferPanel;
import presentation.listui.TransferReceivePanel;

import javax.swing.*;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class TransfermanPanel extends CommonPanel{
    @Override
    protected void init() {
        jb_loadManage = new JButton("装运管理");
        jb_loadManage.setFont(jb_font);
        jb_loadManage.setBounds(x, (y - 2 * height) / 2 - 10, width, height);
        jb_loadManage.addActionListener(this);
        left.add(jb_loadManage);

        jb_transferRec = new JButton("中转接收");
        jb_transferRec.setFont(jb_font);
        jb_transferRec.setBounds(x, (y - 2 * height) / 2 + height - 10, width,
                height);
        jb_transferRec.addActionListener(this);
        left.add(jb_transferRec);

        cardPanel.add("装运管理", new TransferPanel());
        cardPanel.add("中转接收", new TransferReceivePanel());
    }
}
