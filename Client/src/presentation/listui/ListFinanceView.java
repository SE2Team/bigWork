package presentation.listui;

import businesslogicservice.ListblService;
import vo.GatheringVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class ListFinanceView extends JPanel{
    private ListblService bl;
    private GatheringVO gatheringVO;

    private DefaultTableModel financeTableModel;
    private JTable financeTable;

    private JTextField date;
    private JTextField workplace;
    private JTextField man;
    private JTextField money;
    private JTextField place;
    private JLabel info;

    public ListFinanceView(ListblService bl) {
        this.bl=bl;
//        this.setLayout(new FlowLayout());
        initItemField();
        initInfo();
        initSaveButton();
        this.validate();
    }

    private void initSaveButton() {
        JButton saveButton = new JButton("提交收款单");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gatheringVO=new GatheringVO(date.getText(),workplace.getText(),man.getText(),Integer.parseInt(money.getText()),place.getText());
                boolean result=bl.gathering(gatheringVO);
                if(true){
                    JOptionPane.showMessageDialog(null,"保存成功","",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"保存失败","",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.add(BorderLayout.SOUTH,saveButton);
    }
    private void initItemField(){
        JLabel dateLabel=new JLabel("收款日期：");
        date=new JTextField(10);
        JLabel workplaceLabel=new JLabel("收款单位：");
        workplace=new JTextField(15);
        JLabel manLabel=new JLabel("收款人：");
        man=new JTextField(5);
        JLabel moneyLabel=new JLabel("收款金额：");
        money=new JTextField(5);
        JLabel placeLabel=new JLabel("收款地点：");
        place=new JTextField(10);

        JPanel inputPanel=new JPanel();
//        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(BorderLayout.WEST,dateLabel);
        inputPanel.add(BorderLayout.WEST,date);
        inputPanel.add(workplaceLabel);
        inputPanel.add(workplace);
        inputPanel.add(manLabel);
        inputPanel.add(man);
        inputPanel.add(moneyLabel);
        inputPanel.add(money);
        inputPanel.add(placeLabel);
        inputPanel.add(place);
        this.add(BorderLayout.NORTH,inputPanel);
    }
    private void initInfo(){
        info=new JLabel("无收款信息");
        this.add(BorderLayout.CENTER,info);
    }
}
