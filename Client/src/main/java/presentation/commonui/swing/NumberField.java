package presentation.commonui.swing;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by MYK on 2015/12/27 0027.
 */
public class NumberField extends JTextField {
    public NumberField() {
        init();
    }

    public NumberField(String text) {
        super(text);
        init();

    }

    public NumberField(int columns) {
        super(columns);
        init();

    }

    public NumberField(String text, int columns) {
        super(text, columns);
        init();

    }

    public NumberField(Document doc, String text, int columns) {
        super(doc, text, columns);
        init();

    }

    private void init() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                if ((key < '0') || (key > '9')) {
                    String str = getNumberField().getText();
                    System.out.println(str);
                    str = str.substring(0, str.length() - 1);
                    getNumberField().setText(str);
                }
            }
        });
    }

    private NumberField getNumberField() {
        return this;
    }

}
