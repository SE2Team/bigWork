/**
 * 中转中心库存管理人员入库单界面
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
import vo.StockInVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

public class StockInPanel extends JPanel {

	protected int x = 110, y = 80, width = 200, height = 30, addx = 210,
			addy = 65, addx2 = 130, width2 = 100;

	// 定义入库单，快递编号，入库日期、目的地、区号，排号，架号，位号的label
	protected JLabel StockInList, deliveryNum, inDate, destination, zoneNum,
			rowNum, shelfNum, positionNum;
	// 定义对应的文本框
	protected JTextField jtf_deliveryNum, jtf_inDate, jtf_destination,
			jtf_zoneNum;

	protected JTextField jtf_rowNum;

	protected JTextField jtf_shelfNum;

	protected JTextField jtf_positionNum;
	// 定义确定，取消按钮
	protected JButton sure, cancel;
	// 定义出库单的字体
	protected Font font1 = new Font("楷体", Font.PLAIN, 30);
	// 定义文本框下拉框的字体
	protected Font font2 = new Font("宋体", Font.PLAIN, 18);
	// 定义其他字体
	protected Font font3 = new Font("宋体", Font.PLAIN, 20);
	// 定义错误提示信息的label
	protected JLabel tip1;
	// 错误提示信息是否已经被添加
	protected boolean isDelivAdd = false;
	// 定义日期选择器
	protected DateChooser datechooser;
	// 定义文本框的数组
	protected JTextField[] stockInJtf;

	public StockInPanel() {

		this.setLayout(null);

		StockInList = new JLabel("入库单", JLabel.CENTER);
		StockInList.setFont(font1);
		StockInList.setBounds(220, 30, width, height);

		deliveryNum = new JLabel("快递编号", JLabel.CENTER);
		deliveryNum.setFont(font3);
		deliveryNum.setBounds(x, y, width, height);

		jtf_deliveryNum = new JTextField();
		jtf_deliveryNum.setFont(font2);
		jtf_deliveryNum.setBounds(x + addx, y, width, height);
		jtf_deliveryNum.addFocusListener(new TextFocus());

		inDate = new JLabel("入库日期", JLabel.CENTER);
		inDate.setFont(font3);
		inDate.setBounds(x, y + addy, width, height);

		jtf_inDate = new JTextField();
		jtf_inDate.setFont(font2);
		jtf_inDate.setEditable(false);
		jtf_inDate.setBounds(x + addx, y + addy, width - 30, height);

		datechooser = new DateChooser("yyyy-MM-dd", jtf_inDate);
		datechooser.setBounds(x + addx + width - 30, y + addy, 30, height);
		jtf_inDate.setText(datechooser.commit());
		datechooser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				datechooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		destination = new JLabel("目的地", JLabel.CENTER);
		destination.setFont(font3);
		destination.setBounds(x, y + 2 * addy, width, height);

		jtf_destination = new JTextField();
		jtf_destination.setFont(font2);
		jtf_destination.setBounds(x + addx, y + 2 * addy, width, height);

		zoneNum = new JLabel("区号", JLabel.CENTER);
		zoneNum.setFont(font3);
		zoneNum.setBounds(x, y + 3 * addy, width, height);

		jtf_zoneNum = new JTextField();
		jtf_zoneNum.setFont(font2);
		jtf_zoneNum.setBounds(x + addx2, y + 3 * addy, width2, height);

		rowNum = new JLabel("排号", JLabel.CENTER);
		rowNum.setFont(font3);
		rowNum.setBounds(x + addx2 + 50, y + 3 * addy, width, height);

		jtf_rowNum = new JTextField();
		jtf_rowNum.setFont(font2);
		jtf_rowNum.setBounds(x + 2 * addx2 + 50, y + 3 * addy, width2, height);

		shelfNum = new JLabel("架号", JLabel.CENTER);
		shelfNum.setFont(font3);
		shelfNum.setBounds(x, y + 4 * addy, width, height);

		jtf_shelfNum = new JTextField();
		jtf_shelfNum.setFont(font2);
		jtf_shelfNum.setBounds(x + addx2, y + 4 * addy, width2, height);

		positionNum = new JLabel("位号", JLabel.CENTER);
		positionNum.setFont(font3);
		positionNum.setBounds(x + addx2 + 50, y + 4 * addy, width, height);

		jtf_positionNum = new JTextField();
		jtf_positionNum.setFont(font2);
		jtf_positionNum.setBounds(x + 2 * addx2 + 50, y + 4 * addy, width2,
				height);

		sure = new JButton("确定");
		sure.setFont(font3);
		sure.setBounds(x + 100, y + 5 * addy + 20, 80, height);
		sure.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performSure();
			}

		});

		stockInJtf = new JTextField[] { jtf_deliveryNum, jtf_destination,
				jtf_zoneNum, jtf_rowNum, jtf_shelfNum, jtf_positionNum };

		cancel = new JButton("取消");
		cancel.setFont(font3);
		cancel.setBounds(x + addx + 100, y + 5 * addy + 20, 80, height);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
                performCancel();
            }
		});

		this.add(StockInList);
		this.add(deliveryNum);
		this.add(jtf_deliveryNum);
		this.add(inDate);
		this.add(jtf_inDate);
		this.add(datechooser);
		this.add(destination);
		this.add(jtf_destination);
		this.add(zoneNum);
		this.add(jtf_zoneNum);
		this.add(rowNum);
		this.add(jtf_rowNum);
		this.add(shelfNum);
		this.add(jtf_shelfNum);
		this.add(positionNum);
		this.add(jtf_positionNum);
		this.add(sure);
		this.add(cancel);
	}

    protected void performCancel() {
        Empty emptyLoading = new Empty(stockInJtf);

    }

	protected void performSure() {
		boolean isOk = NumExceptioin.isOrderValid(jtf_deliveryNum);
		if(isOk&&isAllEntered.isEntered(stockInJtf)){
			StockInVO in_vo = new StockInVO(jtf_deliveryNum.getText(),
					jtf_inDate.getText(), jtf_destination.getText(),
					jtf_zoneNum.getText(), jtf_rowNum.getText(),
					jtf_shelfNum.getText(), jtf_positionNum.getText(), ListState.UNCHECK);
			ListblService bl;
			try {
				bl = new ListController();
				bl.save(in_vo);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
                RunTip.makeTip("网络异常", false);
            }

            RunTip.makeTip("保存成功", true);

        }else if((!isOk)&&isAllEntered.isEntered(stockInJtf)){
            RunTip.makeTip("请输入正确格式的信息", false);
        }else if(isOk&&!isAllEntered.isEntered(stockInJtf)){
            RunTip.makeTip("仍有信息未输入", false);
        }else if(!isOk&&!isAllEntered.isEntered(stockInJtf)){
            RunTip.makeTip("请输入所有正确格式的信息", false);
        }
		
	}

	/**
	 * 监听焦点
	 * 
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			JTextField temp = (JTextField) e.getSource();
			if (temp == jtf_deliveryNum) {
				if (!NumExceptioin.isOrderValid(jtf_deliveryNum)) {
					isDelivAdd = true;
					if (tip1 == null) {
						tip1 = new JLabel("快递编号位数应为10位", JLabel.CENTER);
						tip1.setBounds(x + addx, y + height, width, height);
						tip1.setFont(font2);
						tip1.setForeground(Color.RED);
						addTip(tip1);
					}
				} else {
					if (isDelivAdd
							&& !"".equalsIgnoreCase(jtf_deliveryNum.getText()
									.trim())) {
						isDelivAdd = false;
						removeTip(tip1);
						tip1 = null;
					}
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
