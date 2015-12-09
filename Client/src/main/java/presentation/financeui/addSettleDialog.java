package presentation.financeui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addSettleDialog extends JDialog{

	private FinanceSettlePanel parent;
	public addSettleDialog(FinanceSettlePanel parent) {

		this.parent = parent;
		this.setContentPane(new addSettlePanel());
		this.setSize(400, 380);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	class addSettlePanel extends JPanel{
		int x = 20, y = 60, addx = 120, addy = 45,  jl_width = 100,
				jtf_width = 200, height = 25;
		
		// 设置所有文字的字体
		Font font = new Font("宋体", Font.PLAIN, 20);
		// 定义添加收款信息，收款日期，收款单位，收款人，收款金额，收款地点的label
		JLabel addInfo, gatheringDate, gatheringOrg, payee,amount,place;
		// 定义对应的文本框
		JTextField jtf_date, jtf_org, jtf_payee,jtf_amount,jtf_place;
		// 定义确定，取消按钮
		JButton sure, cancel;
		
		addSettlePanel(){
			this.setLayout(null);

			addInfo = new JLabel("添加收款信息", JLabel.CENTER);
			addInfo.setFont(new Font("楷体", Font.PLAIN, 25));
			addInfo.setBounds(100, 5, jtf_width, height);

			gatheringDate = new JLabel("收款日期", JLabel.CENTER);
			gatheringDate.setFont(font);
			gatheringDate.setBounds(x, y, jl_width, height);

			jtf_date = new JTextField();
			jtf_date.setFont(font);
			jtf_date.setBounds(x + addx, y, jtf_width, height);
			
			gatheringOrg = new JLabel("收款单位", JLabel.CENTER);
			gatheringOrg.setFont(font);
			gatheringOrg.setBounds(x, y+addy, jl_width, height);

			jtf_org = new JTextField();
			jtf_org.setFont(font);
			jtf_org.setBounds(x + addx, y+addy, jtf_width, height);
			
			payee = new JLabel("收款人", JLabel.CENTER);
			payee.setFont(font);
			payee.setBounds(x, y+2*addy, jl_width, height);

			jtf_payee = new JTextField();
			jtf_payee.setFont(font);
			jtf_payee.setBounds(x + addx, y+2*addy, jtf_width, height);
			
			amount = new JLabel("收款金额", JLabel.CENTER);
			amount.setFont(font);
			amount.setBounds(x, y+3*addy, jl_width, height);

			jtf_amount = new JTextField();
			jtf_amount.setFont(font);
			jtf_amount.setBounds(x + addx, y+3*addy, jtf_width, height);
			
			place = new JLabel("收款地点", JLabel.CENTER);
			place.setFont(font);
			place.setBounds(x, y+4*addy, jl_width, height);

			jtf_place = new JTextField();
			jtf_place.setFont(font);
			jtf_place.setBounds(x + addx, y+4*addy, jtf_width, height);
			
			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y+5*addy+10, 80, height);
			sure.addActionListener(new ActionListener() {		
				public void actionPerformed(ActionEvent arg0) {					
					dispose();
				}
			});
			
			cancel = new JButton("取消");
			cancel.setFont(font);
			cancel.setBounds(120+addx, y+5*addy+10, 80, height);
			cancel.addActionListener(new ActionListener() {		
				public void actionPerformed(ActionEvent arg0) {					
					dispose();
				}
			});
			
			this.add(addInfo);
			this.add(gatheringDate);
			this.add(jtf_date);
			this.add(gatheringOrg);
			this.add(jtf_org);
			this.add(payee);
			this.add(jtf_payee);
			this.add(amount);
			this.add(jtf_amount);
			this.add(place);
			this.add(jtf_place);
			this.add(sure);
			this.add(cancel);
		}
	}
}
