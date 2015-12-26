package presentation.commonui;

import org.junit.Test;

import javax.swing.*;

/**
 * Created by MYK on 2015/12/26 0026.
 */
public class DateChooserTest {

    @Test
    public void testDisplay() throws Exception {
        JFrame frame2 = new JFrame();
        frame2.getContentPane().setLayout(null);

        JTextField jt = new JTextField("date");
        DateChooser dateChooser = new DateChooser("yyyy-MM-dd", jt);
        dateChooser.setBounds(30, 30, 30, 30);

        frame2.add(jt);
        frame2.getContentPane().add(dateChooser);
        frame2.setSize(500, 400);
        frame2.setVisible(true);


    }
}