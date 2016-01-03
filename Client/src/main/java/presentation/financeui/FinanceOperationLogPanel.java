package presentation.financeui;

import businesslogic.inquirybl.InquiryController;
import businesslogicservice.InquiryblService;
import presentation.commonui.RunTip;
import presentation.commonui.swing.Table;
import vo.OperationLogVO;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 财务人员查看操作日志界面
 * 
 * @author WANXING 完成
 */
public class FinanceOperationLogPanel extends JPanel {

	private JScrollPane jsp;
	private JTable operationTable;
	private InquiryblService bl;
	Font font = new Font("宋体", Font.PLAIN, 15);

	public FinanceOperationLogPanel() {
		// 初始化各组件
		this.setSize(650, 530);
		this.setLayout(null);
		String[] column = { "序号", "操作类型", "操作人员", "操作时间" };


        ArrayList<OperationLogVO> arrayList=new ArrayList<OperationLogVO>();

        Iterator<OperationLogVO> itr=null;
        ArrayList<OperationLogVO> list = new ArrayList<OperationLogVO>();
        try {
            bl=new InquiryController();
            itr=bl.checkOperationLog();
        } catch (RemoteException e) {
            RunTip.makeTip("网络异常", false);
        }
        int cout=1;
        while (itr.hasNext()){
            list.add(itr.next());
        }
        String[][] row = new String[list.size()][4];
        for (int j = list.size() - 1; j > -1; j--) {
            OperationLogVO vo = list.get(j);
            String[] temp = {String.valueOf(cout), vo.getType().toString(), vo.getHuman(), vo.getTime()};
            row[list.size() - j - 1] = temp;
            cout++;
        }

        operationTable = Table.getTable(column, row);
        operationTable.setFont(font);
		operationTable.setRowHeight(20);
		jsp = new JScrollPane(operationTable);
		jsp.setBounds(0, 0, 650, 530);
		add(jsp);

	}
}
