package presentation.financeui;

import businesslogic.inquirybl.InquiryController;
import businesslogicservice.InquiryblService;
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
        String row[][] = new String[50][4];


        ArrayList<OperationLogVO> arrayList=new ArrayList<OperationLogVO>();

        Iterator<OperationLogVO> itr=null;
        try {
            bl=new InquiryController();
            itr=bl.checkOperationLog();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        int cout=1;
        while (itr.hasNext()){
            OperationLogVO vo=itr.next();
            String[] temp={String.valueOf(cout),vo.getType().toString(),vo.getHuman(),vo.getTime()};
            row[cout-1]=temp;
            cout++;
        }

//        String[] s1 = { "1", "期初建账", "总经理", "2015-11-2 8:30:30" };
		operationTable = new JTable(row, column);
		operationTable.setFont(font);
		operationTable.setRowHeight(20);
		jsp = new JScrollPane(operationTable);
		jsp.setBounds(0, 0, 650, 530);
		add(jsp);

	}
}
