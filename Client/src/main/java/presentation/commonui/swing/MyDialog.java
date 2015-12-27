package presentation.commonui.swing;

import presentation.userui.LogInFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MYK on 2015/12/27 0027.
 */
public class MyDialog extends JDialog {

    public MyDialog(Frame owner) {
        super(owner);
        init();
    }

    public MyDialog() {
        init();
    }

    public MyDialog(Frame owner, String title) {
        super(owner, title);
        init();
    }

    public MyDialog(Window owner) {
        super(owner);
        init();
    }

    @Override
    public void dispose() {
        super.dispose();
        LogInFrame.getInstance().setEnabled(true);
    }

    private void init() {
        this.setAlwaysOnTop(true);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            LogInFrame.getInstance().setEnabled(false);
        }

    }
}
