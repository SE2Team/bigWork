package presentation.commonui.swing;

import presentation.userui.LogInFrame;

import javax.swing.*;

/**
 * Created by MYK on 2015/12/27 0027.
 */
public class MyDialog extends JDialog {

    private void init() {
        LogInFrame.getInstance().setEnabled(false);
    }


}
