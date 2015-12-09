package presentation.commonui;

import presentation.userui.UserAdminPanel;

import javax.swing.*;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class AdminPanel extends CommonPanel{
    @Override
    protected void init() {
        jb_user = new JButton("用户管理");
        jb_user.setFont(jb_font);
        jb_user.setBounds(x, (y - height) / 2 - 20, width, height);
        jb_user.addActionListener(this);
        left.add(jb_user);

        cardPanel.add("用户管理", new UserAdminPanel());
    }
}
