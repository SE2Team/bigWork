package presentation.manageui;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import vo.ListVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 完成
 * @author WANXING
 *
 */
//总经理审批单据
public class ListApprovalPanel extends JPanel{
	int width=100,height=20;
	private JButton waitButton;
	private JButton doneButton;
	private JButton checkButton;
    ListblService bl= null;
	
	private JScrollPane jsp;
	private JTable listTable;
    private DefaultTableModel model;
	
	Font font1=new Font("宋体", Font.PLAIN, 15);
	Font font2 = new Font("宋体", Font.PLAIN, 12);
    private ArrayList<ListVO> arrayList;

    public ListApprovalPanel(){
		//初始化各组件
		this.setSize(650, 530);
		this.setLayout(null);
		waitButton=new JButton("否决");
		doneButton=new JButton("已审批单据");
		checkButton=new JButton("查看");
        //todo 增加一个按钮
		
		//界面
		waitButton.setFont(font2);
		waitButton.setBounds(300, 15, width, height);
		
		doneButton.setFont(font2);
		doneButton.setBounds(460, 15, width, height);

        checkButton.setFont(font2);
        checkButton.setBounds(140,15,width,height);

		add(waitButton);
		add(doneButton);
		add(checkButton);
		
		String[] column = { "序号","审批状态","单据类型","详细信息"};

        arrayList=new ArrayList<ListVO>();
        Iterator<ListVO> itr=null;

        String row[][]=new String[50][4];

        try {
            bl = new ListController();
            itr=bl.push();

        } catch (RemoteException e) {
            e.printStackTrace();
        }

        int cout=1;
        while (itr.hasNext()){
            ListVO vo=itr.next();
            arrayList.add(vo);
            String[] temp={String.valueOf(cout), String.valueOf(vo.getIsCheck()),vo.getType().toString(),"00"};
            row[cout-1]=temp;
            cout++;
        }



//
//
//        for(ListVO vo:arrayList){
//            System.out.println(temp[0]);
//            rowArray.add(temp);
//            cout++;
//        }
//
//        for(int i=0;i<rowArray.size();i++){
//            if(i>=10){
//                break;
//            }
//            System.out.println("count"+i);
//            System.out.println(rowArray.get(i)[0]+rowArray.get(i)[1]+rowArray.get(i)[2]+rowArray.get(i)[3]);
//            row[i]=rowArray.get(i);
//        }
        model=new DefaultTableModel(row,column);
        listTable = new JTable(model);
		listTable.setFont(font1);
		listTable.setRowHeight(20);
		jsp = new JScrollPane(listTable);
		jsp.setBounds(0, 70, 650, 300);
		add(jsp);


        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pass();
            }
        });

    }
	
	public void paintComponent(java.awt.Graphics g){
		super.paintComponent(g);
		g.drawLine(0, 50, 650, 50);
	}

    public JButton getCheckButton() {
        return checkButton;
    }

    private void pass(){
        int i=listTable.getSelectedRow();
        arrayList.get(i).setIsCheck(true);
        ListVO tempVO=arrayList.get(i);

        try {
            bl.save2File(tempVO);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            JLabel tip = new JLabel("提示：网络异常");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        }
    }


}