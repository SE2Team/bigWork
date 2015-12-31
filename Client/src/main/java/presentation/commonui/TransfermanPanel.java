package presentation.commonui;

import presentation.listui.TransferPanel;
import presentation.listui.TransferReceivePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class TransfermanPanel extends CommonPanel{
    @Override
    protected void init() {
        jb_loadManage = new MyJLabel("装运管理");
        jb_loadManage.setFont(jb_font);
        jb_loadManage.setBounds(x, (y - 2 * height) / 2 - 10, width, height);
        jb_loadManage.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "装运管理");
            }
        });
        left.add(jb_loadManage);

        jb_transferRec = new MyJLabel("中转接收");
        jb_transferRec.setFont(jb_font);
        jb_transferRec.setBounds(x, (y - 2 * height) / 2 + height - 10, width,
                height);
        jb_transferRec.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "中转接收");
            }
        });
        left.add(jb_transferRec);

        cardPanel.add("装运管理", new TransferPanel());
        cardPanel.add("中转接收", new TransferReceivePanel());
    }
}
