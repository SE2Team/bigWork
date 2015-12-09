package presentation.commonui;

import businesslogic.loginbl.LoginController;
import businesslogicservice.LoginblService;
import presentation.userui.LogInPanel;
import util.ExistException;
import vo.UserVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class BigCardPanel extends JPanel implements ActionListener{

	LogInPanel lg=new LogInPanel();
	CardLayout bigCard;
    CommonPanel commonPanel = null;

	public BigCardPanel() {
		
		bigCard = new CardLayout();
		this.setLayout(bigCard);
		this.add("登录", lg);

		bigCard.show(this, "登录");
		
		lg.getButton().addActionListener(this);

	
}

	public void actionPerformed(ActionEvent e) {
        LoginblService bl=new LoginController();
        UserVO vo=null;
        try {
            vo=bl.login(lg.getVO());
        } catch (RemoteException e1) {
            e1.printStackTrace();
        } catch (ExistException e1) {
            e1.printStackTrace();
        }
        switch (vo.getPermission()){
            case COURIER:
                commonPanel=new CourierPanel();
                break;
            case MANAGER:
                commonPanel=new ManagerPanel();
                break;
            case FINANCIAL:
                commonPanel=new FinancePanel();
                break;
            case ADMIN:
                commonPanel=new AdminPanel();
                break;
            case TRANSFERMAN:
                commonPanel=new TransfermanPanel();
                break;
            case SALESMAN:
                commonPanel=new SalesmanPanel();
                break;
            case STOCKMANAGER:
                commonPanel=new StockManagerPanel();
                break;
            case FINANCIALPRO:
                commonPanel=new FinancePanel();
                break;
            default:
                System.out.println("login failed....");
                break;
        }

        this.add("菜单", commonPanel);
		bigCard.show(this, "菜单");
	}
	
}
