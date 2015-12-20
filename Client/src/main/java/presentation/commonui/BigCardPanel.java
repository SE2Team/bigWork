package presentation.commonui;

import businesslogic.loginbl.LoginController;
import businesslogicservice.LoginblService;
import presentation.userui.LogInPanel;
import vo.UserVO;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

public class BigCardPanel extends JPanel implements ActionListener {

	LogInPanel lg = new LogInPanel();
	CardLayout bigCard;
	CommonPanel commonPanel = null;

	Font font = new Font("宋体", Font.PLAIN, 18);

	public BigCardPanel() {

		bigCard = new CardLayout();
		this.setLayout(bigCard);
		this.add("登录", lg);

		bigCard.show(this, "登录");

		lg.getButton().addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		LoginblService bl = new LoginController();
		UserVO vo = null;
		String user = lg.getUsername().getText().trim();
		String password = lg.getPassword().getText().trim();
		boolean isNull;
		if("请输入用户名".equalsIgnoreCase(user)&&"请输入密码".equalsIgnoreCase(password)){
			isNull=true;
			JLabel tip = new JLabel("请输入用户名和密码");
			tip.setFont(font);
			JOptionPane.showMessageDialog(null, tip);
		}else if("请输入密码".equalsIgnoreCase(password)){
			isNull=true;
			JLabel tip = new JLabel("请输入密码");
			tip.setFont(font);
			JOptionPane.showMessageDialog(null, tip);
		}else if("请输入用户名".equalsIgnoreCase(user)){
			isNull=true;
			JLabel tip = new JLabel("请输入用户名");
			tip.setFont(font);
			JOptionPane.showMessageDialog(null, tip);
		}else{
			isNull=false;
		}
		if(!isNull){
			try {
				vo = bl.login(lg.getVO());
				
			} catch (RemoteException e1) {
				JLabel tip = new JLabel("提示：网络异常");
				tip.setFont(font);
				JOptionPane.showMessageDialog(null, tip);
				return;
			}
			if (vo == null) {
				JLabel tip = new JLabel("提示：用户名或密码错误");
				tip.setFont(font);
				JOptionPane.showMessageDialog(null, tip);
				return;
			}

			switch (vo.getPermission()) {
			case COURIER:
				commonPanel = new CourierPanel();
				break;
			case MANAGER:
				commonPanel = new ManagerPanel();
				break;
			case FINANCIAL:
				commonPanel = new FinancePanel();
				break;
			case ADMIN:
				commonPanel = new AdminPanel();
				break;
			case TRANSFERMAN:
				commonPanel = new TransfermanPanel();
				break;
			case SALESMAN:
				commonPanel = new SalesmanPanel();
				break;
			case STOCKMANAGER:
				commonPanel = new StockManagerPanel();
				break;
			case FINANCIALPRO:
				commonPanel = new FinancePanel();
				break;
			default:
				System.out.println("login failed....");
				break;
			}

			commonPanel.initUpper(vo);
			commonPanel.getExit().addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent me) {
					bigCard.show(BigCardPanel.this, "登录");
				}
			});
			this.add("菜单", commonPanel);
			bigCard.show(this, "菜单");
		}
		
	}

}
