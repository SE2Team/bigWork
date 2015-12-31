/*
 * 营业厅业务员输入派件单界面
 */
package presentation.listui;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.DateChooser;
import presentation.commonui.Empty;
import presentation.commonui.RunTip;
import presentation.commonui.isAllEntered;
import presentation.exception.NumExceptioin;
import util.ListState;
import vo.DistributeVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

public class DistributePanel extends JPanel {

	protected int x = 120, y = 100, width = 200, height = 30, addx = 200, addy = 100;

	// 定义派件单，到达日期、托运订单条形码号、派送员的label
	protected JLabel distributeList, arriveDate, orderNum, distributeHuman;
	// 定义对应的文本框
	protected JTextField jtf_arriveDate, jtf_orderNum, jtf_distributeHuman;
	// 定义确定，取消按钮
	protected JButton sure, cancel;
	// 定义接收单的字体
	protected Font font1 = new Font("楷体", Font.PLAIN, 30);
	// 定义文本框下拉框的字体
	protected Font font2 = new Font("宋体", Font.PLAIN, 18);
	// 定义其他Label的字体
	protected Font font3 = new Font("宋体", Font.PLAIN, 20);
	// 定义错误提示的label
	protected JLabel tip;
	//定义日期选择器
	protected DateChooser datechooser;
	// 定义文本框的数组
	protected JTextField[] distributeJtf;

	public DistributePanel() {

		this.setLayout(null);

		distributeList = new JLabel("派件单", JLabel.CENTER);
		distributeList.setFont(font1);
		distributeList.setBounds(220, 30, width, height);

		arriveDate = new JLabel("到达日期", JLabel.CENTER);
		arriveDate.setFont(font3);
		arriveDate.setBounds(x, y, width, height);

		jtf_arriveDate = new JTextField();
		jtf_arriveDate.setFont(font2);
		jtf_arriveDate.setEditable(false);
		jtf_arriveDate.setBounds(x + addx, y, width-30, height);
		
		datechooser = new DateChooser("yyyy-MM-dd",jtf_arriveDate);
		datechooser.setBounds(x + addx+ width-30, y, 30, height);
		jtf_arriveDate.setText(datechooser.commit());
		datechooser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me){
				datechooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		orderNum = new JLabel("托运订单条形码号", JLabel.CENTER);
		orderNum.setFont(font3);
		orderNum.setBounds(x, y + addy, width, height);

		jtf_orderNum = new JTextField();
		jtf_orderNum.setFont(font2);
		jtf_orderNum.setBounds(x + addx, y + addy, width, height);
		jtf_orderNum.addFocusListener(new TextFocus());

		distributeHuman = new JLabel("派送员", JLabel.CENTER);
		distributeHuman.setFont(font3);
		distributeHuman.setBounds(x, y + 2 * addy, width, height);

		jtf_distributeHuman = new JTextField();
		jtf_distributeHuman.setFont(font2);
		jtf_distributeHuman.setBounds(x + addx, y + 2 * addy, width, height);

		sure = new JButton("确定");
		sure.setFont(font2);
		sure.setBounds(x + 80, y + 3 * addy, 80, height);
		sure.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performSure();
			}

		});
		
		distributeJtf = new JTextField[]{jtf_orderNum, jtf_distributeHuman};

		cancel = new JButton("取消");
		cancel.setFont(font2);
		cancel.setBounds(x + addx + 60, y + 3 * addy, 80, height);
		cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
                performCancel();
            }
		});

		this.add(distributeList);
		this.add(arriveDate);
		this.add(jtf_arriveDate);
		this.add(datechooser);
		this.add(orderNum);
		this.add(jtf_orderNum);
		this.add(distributeHuman);
		this.add(jtf_distributeHuman);
		this.add(sure);
		this.add(cancel);
	}

    protected void performCancel() {
        Empty emptyLoading = new Empty(distributeJtf);
    }

    protected void performSure() {
        boolean isOk = NumExceptioin.isOrderValid(jtf_orderNum);
		if(isOk&&isAllEntered.isEntered(distributeJtf)){
			DistributeVO dis_vo = new DistributeVO(
					jtf_arriveDate.getText(), jtf_orderNum.getText(),
                    jtf_distributeHuman.getText(), ListState.UNCHECK);
            ListblService bl;
			try {
				bl = new ListController();
				bl.save(dis_vo);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
                RunTip.makeTip("网络异常", false);
            }

            RunTip.makeTip("保存成功", true);

        }else if((!isOk)&&isAllEntered.isEntered(distributeJtf)){
            RunTip.makeTip("请输入正确格式的信息", false);
        }else if(isOk&&!isAllEntered.isEntered(distributeJtf)){
            RunTip.makeTip("仍有信息未输入", false);
        }else if(!isOk&&!isAllEntered.isEntered(distributeJtf)){
            RunTip.makeTip("请输入所有正确格式的信息", false);
        }
		
	}

	//错误提示信息是否已经被添加
	protected boolean isOrderAdd=false;
	
	/**
	 * 监听焦点
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub

		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub

			if (!NumExceptioin.isOrderValid(jtf_orderNum)) {
				isOrderAdd=true;
				if (tip == null) {
					tip = new JLabel("订单条形码号应为10位");
					tip.setBounds(x + addx, y + addy + 30, width, height);
					tip.setFont(font2);
					tip.setForeground(Color.red);
					addTip(tip);
				}
			} else {
				if (isOrderAdd&&!"".equalsIgnoreCase(jtf_orderNum.getText().trim())) {
					isOrderAdd=false;
					removeTip(tip);
					tip=null;
				}
			}
		}

	}

	/**
	 * 添加错误提示信息
	 * 
	 * @param tip
	 */
	public void addTip(JLabel tip) {
		this.add(tip);
		this.repaint();
	}

	/**
	 * 移除错误提示信息
	 * 
	 * @param tip
	 */
	public void removeTip(JLabel tip) {
		this.remove(tip);
		this.repaint();
	}
}
