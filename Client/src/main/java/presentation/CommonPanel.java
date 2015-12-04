package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CommonPanel extends JPanel implements ActionListener {
	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setContentPane(new CommonPanel());
//		f.add(new CommonPanel());
		f.setVisible(true);
	}

	int x = 0, y = 530, width = 250, height = 50;

	// 定义共同面板上的小面板
	JPanel upper, left, cardPanel;
	// 定义卡片布局对象
	CardLayout smallCard;
	// 定义欢迎、职位、退出label
	JLabel upper_wel, upper_pos, upper_exit;

	// 快递员功能的按钮
	JButton jb_inputOrder, jb_quatation, jb_inputReceive;
	// 营业厅业务员功能的按钮
	JButton jb_loading, jb_recAndDis, jb_recordReceipt, jb_vehicleInfo,
			jb_driverInfo;
	// 中转中心业务员功能的按钮

	// 定义字体
	Font jb_font = new Font("隶书", Font.PLAIN, 25);

	public CommonPanel() {
		
		Container container = this;

		container.setLayout(null);

		upper = new JPanel() {
			public void paintComponent(Graphics g) {
				Image upper_pic = new ImageIcon("images/上2.jpg").getImage();
				g.drawImage(upper_pic, 0, 0, 900, 70, this);
			}
		};
		upper.setBounds(0, 0, 900, 70);
		
		cardPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				Image right_pic = new ImageIcon("images/右.jpg").getImage();
				g.drawImage(right_pic, 0, 0, 650, 530, this);
			}
		};
		cardPanel.setLayout(smallCard);
		cardPanel.setBounds(250, 70, 650, 530);

		left = new JPanel() {
			public void paintComponent(Graphics g) {
				Image left_pic = new ImageIcon("images/左1.jpg").getImage();
				g.drawImage(left_pic, 0, 0, 250, 530, this);
			}
		};
		left.setBounds(0, 70, 250, 530);
		left.setLayout(null);
		
		// TODO 如果是快递员则添加这些
		jb_inputOrder = new JButton("输入订单");
		jb_inputOrder.setFont(jb_font);
		jb_inputOrder.setBounds(x, (y - 3 * height) / 2, width, height);
		jb_inputOrder.addActionListener(this);
		left.add(jb_inputOrder);
		jb_quatation = new JButton("查询报价和时间");
		jb_quatation.setFont(jb_font);
		jb_quatation.setBounds(x, (y - 3 * height) / 2 + height, width, height);
		jb_quatation.addActionListener(this);
		left.add(jb_quatation);
		jb_inputReceive = new JButton("输入收件信息");
		jb_inputReceive.setFont(jb_font);
		jb_inputReceive.setBounds(x, (y - 3 * height) / 2 + 2 * height, width,
				height);
		jb_inputReceive.addActionListener(this);
		left.add(jb_inputReceive);

//		cardPanel.add("输入订单", new OrderPanel());
//		cardPanel.add("查询报价和时间", new QuotationPanel());
//		cardPanel.add("输入收件信息", new AddresseeInfoPanel());
		// OrderPanel o = new OrderPanel();
		// QuotationPanel q = new QuotationPanel();
		// AddresseeInfoPanel r = new AddresseeInfoPanel();
		// VehiclePanel v = new VehiclePanel();
		// ReceiptPanel re = new ReceiptPanel();
		// ReceiveAndDistribute rd = new ReceiveAndDistribute();
		// ReceivePanel rp = new ReceivePanel();
		// DistributePanel dp = new DistributePanel();
		// DriverPanel dr= new DriverPanel();
		// LoadingPanel l = new LoadingPanel();
		// StockOutPanel so = new StockOutPanel();
		// StockInPanel si = new StockInPanel();
		// WarningPanel w = new WarningPanel();
		// CheckStockPanel c = new CheckStockPanel();
		// CheckingPanel cp = new CheckingPanel();
		// StockInfoPanel sp = new StockInfoPanel();
		// TransferReceivePanel t = new TransferReceivePanel();
		// TransferPanel tp = new TransferPanel();

		container.add(upper);
		container.add(left);
		container.add(cardPanel);
	}

	// public JButton getjb_inputOrder(){
	// return jb_inputOrder;
	// }
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb_inputOrder) {
			smallCard.show(cardPanel, "输入订单");
		}
		if (e.getSource() == jb_quatation) {
			smallCard.show(cardPanel, "查询报价和时间");
		}
		if (e.getSource() == jb_inputReceive) {
			smallCard.show(cardPanel, "输入收件信息");
		}
	}
}
