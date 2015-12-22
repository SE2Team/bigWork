package presentation.commonui;

import presentation.listui.ReceiveAndDistribute;
import util.UserType;
import vo.UserVO;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommonPanel extends JPanel implements ActionListener {

	protected int x = 0, y = 530, width = 250, height = 50;

	// 定义共同面板上的小面板
	protected JPanel upper, left, cardPanel, right;

	// 定义卡片布局对象
	protected CardLayout smallCard;

	// 定义欢迎、职位、退出label
	protected JLabel welcome, position, upper_wel, upper_pos, upper_exit;

	// 快递员功能的按钮
	protected JButton jb_inputOrder, jb_quatation, jb_inputReceive;

	// 营业厅业务员功能的按钮
	protected JButton jb_loading, jb_recAndDis, jb_recordReceipt,
			jb_vehicleInfo, jb_driverInfo;

	// 中转中心业务员功能的按钮
	protected JButton jb_loadManage, jb_transferRec;

	// 中转中心库存管理人员功能的按钮
	protected JButton jb_stockIn, jb_stockOut, jb_stockCheck, jb_stockInfo,
			jb_warning;

	// 财务人员功能的按钮
	protected JButton jb_settle, jb_cost, jb_init, jb_statis, jb_account,
			jb_log1, jb_analy1;

	// 总经理功能的按钮
	protected JButton jb_empAndIns, jb_approval, jb_salary, jb_city, jb_log2,
			jb_analy2;

	// 管理员功能的按钮
	protected JButton jb_user;

	// 定义字体
	protected Font jb_font = new Font("隶书", Font.PLAIN, 25);
	protected Font font1 = new Font("楷体", Font.PLAIN, 20);
	protected Font font2 = new Font("宋体", Font.PLAIN, 18);

	// 定义枚举类型的用户类型
	protected UserType userType;
	// 定义String类型的用户类型
	protected String user_pos;

	protected ReceiveAndDistribute recAndDis = new ReceiveAndDistribute();

	protected CommonPanel() {

		this.setLayout(null);

		initPanel();
		init();
	}

	public void initUpper(UserVO vo) {
		int x=350,y=20,addx1=90,addx2=120,width=90,width2=180,height=30;
		// 构建欢迎您的label
		welcome = new JLabel("欢迎您:",JLabel.RIGHT);
		welcome.setFont(font1);
		welcome.setBounds(x, y, width, height);
		upper.add(welcome);
		// 构建欢迎对象的label
		upper_wel = new JLabel(vo.getName());
		upper_wel.setFont(font2);
		upper_wel.setBounds(x+addx1, y, width-30, height);
		upper.add(upper_wel);
		//构建您的职位的label
		position = new JLabel("您的职位:",JLabel.LEFT);
		position.setFont(font1);
		position.setBounds(x+addx1+addx2,y,width,height);
		upper.add(position);
		//判断职位类型
		if (vo.getPermission() == userType.ADMIN) {
			user_pos = "管理员";
		} else if (vo.getPermission() == userType.COURIER) {
			user_pos = "快递员";
		} else if (vo.getPermission() == userType.FINANCIAL) {
			user_pos = "财务人员";
		} else if (vo.getPermission() == userType.MANAGER) {
			user_pos = "总经理";
		} else if (vo.getPermission() == userType.SALESMAN) {
			user_pos = "营业厅业务员";
		} else if (vo.getPermission() == userType.STOCKMANAGER) {
			user_pos = "库存管理人员";
		} else if (vo.getPermission() == userType.TRANSFERMAN) {
			user_pos = "中转中心业务员";
		}
		//构建职位信息的label
		upper_pos = new JLabel(user_pos);
		upper_pos.setFont(font2);
		upper_pos.setBounds(x+addx2+2*addx1, y, width2, height);
		upper.add(upper_pos);
		//构建退出的label
		upper_exit = new JLabel("退出",JLabel.LEFT);
		upper_exit.setFont(font1);
		upper_exit.setBounds(x+2*addx2+2*addx1+50, y, width, height);
		final BigCardPanel bigPanel = new BigCardPanel();
		upper_exit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				upper_exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
				upper_exit.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent me) {
				upper_exit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				upper_exit.setForeground(Color.BLACK);
			}
		});
		
		upper.add(upper_exit);
	}

	protected void init() {

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
		upper.setLayout(null);
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

	public JLabel getExit(){
		return upper_exit;
	}
	
}
