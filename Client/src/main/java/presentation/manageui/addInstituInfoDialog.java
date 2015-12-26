package presentation.manageui;

import presentation.commonui.isAllEntered;
import presentation.exception.NumExceptioin;
import presentation.financeui.FinanceInitialPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class addInstituInfoDialog extends JDialog {

	private EmpAndInsPanel parent;
	private FinanceInitialPanel parent2;

	public addInstituInfoDialog(EmpAndInsPanel parent) {
		this.parent = parent;
		this.setContentPane(new addInstituInfoPanel(parent));
		this.setSize(400, 380);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	public addInstituInfoDialog(FinanceInitialPanel parent) {
		this.parent2 = parent;
		this.setContentPane(new addInstituInfoPanel(parent2));
		this.setSize(400, 380);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	int x = 20, y = 100, addx = 120, addy = 65, jl_width = 100,
			jtf_width = 200, height = 25;

	// 设置所有文字的字体
	Font font = new Font("宋体", Font.PLAIN, 20);
	Font font2 = new Font("宋体", Font.PLAIN, 18);
	// 定义添加人员信息，姓名，年龄，职位，账号的label
	JLabel addInfo, institution, institutionNum;
	// 定义对应的文本框
	JTextField jtf_institution, jtf_institutionNum;
	// 定义确定，取消按钮
	JButton sure, cancel;
	// 定义错误提示的label
	JLabel tip1;
	// 定义用来存放用户输入信息的数组
	String[] rowContent;
	// 定义文本框的数组
	JTextField[] insJtf;

	class addInstituInfoPanel extends JPanel {

		addInstituInfoPanel(final JPanel jp) {
			this.setLayout(null);

			addInfo = new JLabel("添加机构信息", JLabel.CENTER);
			addInfo.setFont(new Font("楷体", Font.PLAIN, 25));
			addInfo.setBounds(100, 20, jtf_width, height);

			institution = new JLabel("机构名称", JLabel.CENTER);
			institution.setFont(font);
			institution.setBounds(x, y, jl_width, height);

			jtf_institution = new JTextField();
			jtf_institution.setFont(font2);
			jtf_institution.setBounds(x + addx, y, jtf_width, height);

			institutionNum = new JLabel("机构编号", JLabel.CENTER);
			institutionNum.setFont(font);
			institutionNum.setBounds(x, y + addy, jl_width, height);

			jtf_institutionNum = new JTextField();
			jtf_institutionNum.setFont(font2);
			jtf_institutionNum.setBounds(x + addx, y + addy, jtf_width, height);
			jtf_institutionNum.addFocusListener(new TextFocus());

			sure = new JButton("确定");
			sure.setFont(font);
			sure.setBounds(80, y + 2 * addy + 10, 80, height);
			sure.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

//					ManageblService bl;
//					bl = new ManageController();
//					
					insJtf = new JTextField[] { jtf_institution,
							jtf_institutionNum };
					boolean isOk = NumExceptioin
							.isInstitutionValid(jtf_institutionNum);
					if (isOk && isAllEntered.isEntered(insJtf)) {
						rowContent = new String[] { jtf_institution.getText(),
								jtf_institutionNum.getText() };
						if (jp == parent) {
							parent.addInsInfo(rowContent);
						}
						if (jp == parent2) {
							parent2.addInsInfo(rowContent);
						}
						dispose();
						JLabel tip = new JLabel("提示：保存成功");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					}else if((!isOk)&&isAllEntered.isEntered(insJtf)){
						JLabel tip = new JLabel("提示：请输入正确格式的信息");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					}else if(isOk&&!isAllEntered.isEntered(insJtf)){
						JLabel tip = new JLabel("提示：仍有信息未输入");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					}else if(!isOk&&!isAllEntered.isEntered(insJtf)){
						JLabel tip = new JLabel("请输入所有正确格式的信息");
						tip.setFont(font2);
						JOptionPane.showMessageDialog(null, tip);
					}

				}
			});

			cancel = new JButton("取消");
			cancel.setFont(font);
			cancel.setBounds(120 + addx, y + 2 * addy + 10, 80, height);
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});

			this.add(addInfo);
			this.add(institution);
			this.add(jtf_institution);
			this.add(institutionNum);
			this.add(jtf_institutionNum);
			this.add(sure);
			this.add(cancel);
		}
	}

	// 错误提示信息是否已经被添加
	boolean isInstitutionAdd = false;

	/**
	 * 监听焦点
	 * 
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub

		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if (!NumExceptioin.isInstitutionValid(jtf_institutionNum)) {
				isInstitutionAdd = true;
				if (tip1 == null) {
					tip1 = new JLabel("机构编号位数应为6位", JLabel.CENTER);
					tip1.setBounds(x + addx, y + addy + height, jtf_width,
							height);
					tip1.setFont(font2);
					tip1.setForeground(Color.RED);
					addTip(tip1);
				}

			} else {
				if (isInstitutionAdd
						&& !"".equalsIgnoreCase(jtf_institutionNum.getText()
								.trim())) {
					isInstitutionAdd = false;
					removeTip(tip1);
					tip1 = null;
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
