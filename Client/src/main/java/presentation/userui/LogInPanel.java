package presentation.userui;

import vo.UserVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LogInPanel extends JPanel{
	
	private JButton jb1,jb2;//登录、查询按钮
    public TextField username, ordernum, password;//输入用户名、订单号、密码文本框
    private JTextArea orderinfo;//显示物流信息的文本域
	private JScrollPane jsp;//放文本域的scrollPane
	private Font font = new Font("宋体", Font.PLAIN, 16);//定义字体
	private Font font2 = new Font("宋体", Font.PLAIN, 20);//定义字体


    public void paintComponent(Graphics g){
		Image bg = new ImageIcon("images/背景.jpg").getImage();
		Image user = new ImageIcon("images/用户头像.jpg").getImage();
		Image pw = new ImageIcon("images/密码.jpg").getImage();

		g.drawImage(bg, 0, 0, this);
		g.drawImage(user, 573, 210, 40, 40,this);
		g.drawImage(pw, 573, 300, 40, 40,this);
	}
	
	
	public LogInPanel(){
		
		this.setLayout(null);
		
		//设置登录按钮大小位置
		jb1 = new JButton(new ImageIcon("images/登录按钮.jpg"));
		jb1.setBounds(573, 390, 225, 40);
		
		//设置查询按钮大小位置
		jb2 = new JButton(new ImageIcon("images/查询.jpg"));
		jb2.setBounds(295, 215, 60, 30);
		
		//设置物流信息显示域的大小位置
		orderinfo = new JTextArea();
		orderinfo.setFont(font2);
		orderinfo.setEditable(false);
		jsp = new JScrollPane(orderinfo);
		jsp.setBounds(110, 270, 245, 200);
		
		//设置用户名文本框的大小位置字体
		username = new TextField(20);
		username.setBounds(613,210,175,40);
		username.setFont(font2);
		username.setText("请输入用户名");
		username.setForeground(Color.GRAY);
		username.addFocusListener(new TextFocus());
		
		//设置密码文本框的大小位置
		password = new TextField(20);
		password.setBounds(613,300,175,40);
		password.setFont(font2);
		password.setText("请输入密码");
		password.setForeground(Color.GRAY);
		password.addFocusListener(new TextFocus());
		
		//设置输入订单号的文本框的大小位置字体
		ordernum = new TextField(20);
		ordernum.setBounds(110,210,175,40);
		ordernum.setFont(font2);
		ordernum.setText("请输入订单号");
		ordernum.setForeground(Color.GRAY);
		ordernum.addFocusListener(new TextFocus());
		
		jb1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				UserVO vo = new UserVO(username.getText(), password.getText());
//				LoginblService bl = new LoginController();
//				try {
//					bl.login(vo);
//				} catch (RemoteException e1) {
//					// TODO Auto-generated catch block
//					JLabel tip = new JLabel("提示：网络异常");
//					tip.setFont(font);
//					JOptionPane.showMessageDialog(null, tip);
//				} catch (ExistException e1) {
//					// TODO Auto-generated catch block
//					JLabel tip = new JLabel("提示：用户名或密码错误");
//					tip.setFont(font);
//					JOptionPane.showMessageDialog(null, tip);
//				}
			}

			
		});
		
		jb2.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(jb1);
		this.add(jb2);
		this.add(username);
		this.add(password);
		this.add(ordernum);
		this.add(jsp);
	}
	
	class TextFocus implements FocusListener{

		
		public void focusGained(FocusEvent e) {		
			TextField text = (TextField) e.getSource();
			if(text==username){
				if("请输入用户名".equalsIgnoreCase(username.getText())){
					username.setText("");
					username.setForeground(Color.BLACK);
				}
				
			}
			if(text==password){
				if("请输入密码".equalsIgnoreCase(password.getText())){
					
					password.setText("");
					if(password.getText().trim()!=""&&!"请输入密码".equalsIgnoreCase(password.getText())){
						password.setEchoChar('*');
					}
					password.setForeground(Color.BLACK);
				}
				
			}
			if(text==ordernum){
				if("请输入订单号".equalsIgnoreCase(ordernum.getText())){
					ordernum.setText("");
					ordernum.setForeground(Color.BLACK);
					
				}
				
			}
		}

		public void focusLost(FocusEvent e) {
			TextField text = (TextField) e.getSource();
			if(text==username){
				if("".equalsIgnoreCase(username.getText().trim())){
					username.setForeground(Color.GRAY);
					username.setText("请输入用户名");
				}
	
			}
			if(text==password){
				if("".equalsIgnoreCase(password.getText().trim())){
					password.setForeground(Color.GRAY);
					password.setText("请输入密码");
					password.setEchoChar((char) 0);
				}	
			}
			if(text==ordernum){
				if("".equalsIgnoreCase(ordernum.getText().trim())){
					ordernum.setForeground(Color.GRAY);
					ordernum.setText("请输入订单号");
				}
			
			}
		}		

	}
	
	/**
	 * 获取登录按钮
	 * @return
	 */
	public JButton getButton(){
		return jb1;
	}
	
	/**
	 * 获取用户名的文本框
	 * @return
	 */
	public TextField getUsername(){
		return username;
	}
	
	/**
	 * 获取密码的文本框
	 * @return
	 */
	public TextField getPassword(){
		return password;
	}

	public UserVO getVO(){
		return new UserVO(username.getText(),password.getText());
	}


}