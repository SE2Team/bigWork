package presentation.commonui;

import presentation.userui.UserAdminPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class AdminPanel extends CommonPanel{
    @Override
    protected void init() {
        jb_user = new MyJLabel("用户管理");
        jb_user.setFont(jb_font);
        jb_user.setBounds(x, (y - height) / 2 - 20, width, height);
        jb_user.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "用户管理");
            }
        });
        left.add(jb_user);

        cardPanel.add("用户管理", new UserAdminPanel());
    }
}
