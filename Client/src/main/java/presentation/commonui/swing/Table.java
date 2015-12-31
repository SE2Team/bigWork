package presentation.commonui.swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class Table {
    static DefaultTableModel tableModel;
    static JTable table;

    public static JTable getTable(String[] column, String[][] row) {
        table = new JTable();
        Font font2 = new Font("宋体", Font.PLAIN, 15);
        table.setFont(font2);
        table.setRowHeight(20);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 单选
        tableModel = new myTableModel(row, column);
        table = new JTable(tableModel);

        return table;
    }

}

