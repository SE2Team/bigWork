package presentation.commonui;

import presentation.listui.ReceiveAndDistribute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommonPanel extends JPanel implements ActionListener {

	protected int x = 0, y = 530, width = 250, height = 50;

	// 定义共同面板上的小面板
	protected JPanel upper, left, cardPanel, right;

	// 定义卡片布局对象
	protected CardLayout smallCard;

	// 定义欢迎、职位、退出label
	protected JLabel upper_wel, upper_pos, upper_exit;

	// 快递员功能的按钮
	protected JButton jb_inputOrder, jb_quatation, jb_inputReceive;

	// 营业厅业务员功能的按钮
	protected JButton jb_loading, jb_recAndDis, jb_recordReceipt, jb_vehicleInfo,
			jb_driverInfo;

	// 中转中心业务员功能的按钮
	protected JButton jb_loadManage, jb_transferRec;

	// 中转中心库存管理人员功能的按钮
	protected JButton jb_stockIn, jb_stockOut, jb_stockCheck, jb_stockInfo, jb_warning;

	// 财务人员功能的按钮
	protected JButton jb_settle, jb_cost, jb_init, jb_statis, jb_account, jb_log1,
			jb_analy1;

	// 总经理功能的按钮
	protected JButton jb_empAndIns, jb_approval, jb_salary, jb_city, jb_log2, jb_analy2;

	// 管理员功能的按钮
	protected JButton jb_user;

	// 定义字体
	protected Font jb_font = new Font("隶书", Font.PLAIN, 25);

	protected ReceiveAndDistribute recAndDis = new ReceiveAndDistribute();

	protected CommonPanel() {

		this.setLayout(null);

		initPanel();
        init();
//		initCourierPanel();
//		initHallPanel();
//		initTrans();
//		initStockManage();
//		initFinance();
//		initManager();
//		initAdmin();

	}


	protected void init(){

	}
	/**
	 * 展示相应的Panel
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb_inputOrder) {
			smallCard.show(cardPanel, "输入订单");
		}
		if (e.getSource() == jb_quatation) {
			smallCard.show(cardPanel, "查询报价和时间");
		}
		if (e.getSource() == jb_inputReceive) {
			smallCard.show(cardPanel, "输入收件信息");
		}
		if (e.getSource() == jb_loading) {
			smallCard.show(cardPanel, "车辆装车管理");
		}
		if (e.getSource() == jb_recAndDis) {
			smallCard.show(cardPanel, "接收与派件");
		}
		if (e.getSource() == recAndDis.getReceive()) {
			smallCard.show(cardPanel, "输入接收单信息");
		}
		if (e.getSource() == recAndDis.getDistribute()) {
			smallCard.show(cardPanel, "输入派件单信息");
		}
		if (e.getSource() == jb_recordReceipt) {
			smallCard.show(cardPanel, "记录收款");
		}
		if (e.getSource() == jb_vehicleInfo) {
			smallCard.show(cardPanel, "车辆信息管理");
		}
		if (e.getSource() == jb_driverInfo) {
			smallCard.show(cardPanel, "司机信息管理");
		}
		if (e.getSource() == jb_loadManage) {
			smallCard.show(cardPanel, "装运管理");
		}
		if (e.getSource() == jb_transferRec) {
			smallCard.show(cardPanel, "中转接收");
		}
		if (e.getSource() == jb_stockIn) {
			smallCard.show(cardPanel, "入库");
		}
		if (e.getSource() == jb_stockOut) {
			smallCard.show(cardPanel, "出库");
		}
		if (e.getSource() == jb_stockCheck) {
			smallCard.show(cardPanel, "库存查看");
		}
		if (e.getSource() == jb_stockInfo) {
			smallCard.show(cardPanel, "库存盘点");
		}
		if (e.getSource() == jb_warning) {
			smallCard.show(cardPanel, "库存报警");
		}
		if (e.getSource() == jb_settle) {
			smallCard.show(cardPanel, "结算管理");
		}
		if (e.getSource() == jb_cost) {
			smallCard.show(cardPanel, "成本管理");
		}
		if (e.getSource() == jb_init) {
			smallCard.show(cardPanel, "期初建账");
		}
		if (e.getSource() == jb_statis) {
			smallCard.show(cardPanel, "统计报表");
		}
		if (e.getSource() == jb_account) {
			smallCard.show(cardPanel, "账户管理");
		}
		if (e.getSource() == jb_log1) {
			smallCard.show(cardPanel, "查看操作日志");
		}
		if (e.getSource() == jb_analy1) {
			smallCard.show(cardPanel, "查看统计分析");
		}
		if (e.getSource() == jb_empAndIns) {
			smallCard.show(cardPanel, "人员机构管理");
		}
		if (e.getSource() == jb_approval) {
			smallCard.show(cardPanel, "审批单据");
		}
		if (e.getSource() == jb_salary) {
			smallCard.show(cardPanel, "制定薪水策略");
		}
		if (e.getSource() == jb_city) {
			smallCard.show(cardPanel, "制定城市距离、价格等常量");
		}
		if (e.getSource() == jb_log2) {
			smallCard.show(cardPanel, "查看操作日志1");
		}
		if (e.getSource() == jb_analy2) {
			smallCard.show(cardPanel, "查看统计分析1");
		}
		if (e.getSource() == jb_user) {
			smallCard.show(cardPanel, "用户管理");
		}
	}

	/**
	 * 初始化所有的Panel
	 */
    protected void initPanel() {
		// 初始化上方的Panel
		upper = new JPanel() {
			public void paintComponent(Graphics g) {
				Image upper_pic = new ImageIcon("images/上2.jpg").getImage();
				g.drawImage(upper_pic, 0, 0, 900, 70, this);
			}
		};
		upper.setBounds(0, 0, 900, 70);
		this.add(upper);

		// 初始化右边的Panel
		right = new JPanel() {
			public void paintComponent(Graphics g) {
				Image right_pic = new ImageIcon("images/右.jpg").getImage();
				g.drawImage(right_pic, 0, 0, 650, 530, this);
			}
		};

		// 初始化cardPanel
		smallCard = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(smallCard);
		cardPanel.setBounds(250, 70, 650, 530);
		cardPanel.add("r", right);
		this.add(cardPanel);

		// 初始化左边的Panel
		left = new JPanel() {
			public void paintComponent(Graphics g) {
				Image left_pic = new ImageIcon("images/左1.jpg").getImage();
				g.drawImage(left_pic, 0, 0, 250, 530, this);
			}
		};
		left.setBounds(0, 70, 250, 530);
		left.setLayout(null);
		this.add(left);
	}

}
