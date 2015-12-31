package presentation.commonui.swing;

import javax.swing.table.DefaultTableModel;


/**
 * 设置表格不可编辑
 *
 * @author dell1
 */
public class myTableModel extends DefaultTableModel {
    public myTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);//这里一定要覆盖父类的构造方法，否则不能实例myTableModel
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

