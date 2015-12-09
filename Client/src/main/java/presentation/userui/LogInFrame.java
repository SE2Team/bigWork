package presentation.userui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import presentation.commonui.BigCardPanel;
import presentation.commonui.CommonPanel;
import presentation.listui.OrderPanel;
import presentation.listui.check.StockInChecking;
import vo.StockInVO;
import vo.StockVO;

public class LogInFrame extends JFrame{
	
	public LogInFrame(){
		this.setTitle("快递物流管理系统");//设置窗体名称
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭属性
		this.setSize(900,600);//设置窗体大小
		this.setResizable(false);//不允许用户改变窗体大小
		this.add(new BigCardPanel());
//		StockInVO vo = new StockInVO("1", "1", "1", "1", "1", "1", "1", false);
//		this.add(new StockInChecking(vo));
		this.setVisible(true);
		//居中
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		int x=(screen.width-this.getWidth())/2;
		int y=(screen.height-this.getHeight())/2;
		this.setLocation(x, y-20);
	}
}

