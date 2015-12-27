package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.listui.OrderPanel;
import util.DeliveryType;
import util.ListState;
import vo.OrderVO;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class OrderChecking extends OrderPanel{
    private OrderChecking() {
        super();
    }

    public OrderChecking(OrderVO vo){
        this();
        button_1.setText("通过");
        button_2.setText("否决");
        s_name.setText(vo.getSenderName());
        s_address.setText(vo.getSenderAddress());
        s_workplace.setText(vo.getSenderWorkplace());
        s_tele.setText(vo.getSenderTelephone());
        s_phone.setText(vo.getSenderPhone());
        r_name.setText(vo.getReceiverName());
        r_address.setText(vo.getReceiverAddress());
        r_workplace.setText(vo.getReceiverWorkplace());
        r_tele.setText(vo.getReceiverTelephone());
        r_phone.setText(vo.getReceiverPhone());
        g_num.setText(vo.getOriginalNum());
        g_weight.setText(vo.getWeight());
        g_volume.setText(vo.getVolume());
        g_name.setText(vo.getGoods_Name());
        if(deliveryType==DeliveryType.ECONOMIC){
            o_type.setSelectedItem("经济快递");
        }else if(deliveryType==DeliveryType.STANDARD){
            o_type.setSelectedItem("标准快递");
        }else if(deliveryType==DeliveryType.FAST){
            o_type.setSelectedItem("特快快递");
        }
        o_wrapper.setSelectedItem(vo.getWrapper());
        o_transExpense.setText(vo.getExpenseOfTransport());
        o_wrapperExpense.setText(vo.getExpenseOfWrapper());
        o_expense.setText(vo.getExpense());
        o_dueDate.setText(vo.getDate());
        o_ordernum.setText(vo.getDeliveryNum());
    }

    @Override
    protected void performButton1() {
        if (o_type.getSelectedItem().toString().equals("经济快递")) {
            deliveryType = DeliveryType.ECONOMIC;
        } else if (o_type.getSelectedItem().toString().equals("标准快递")) {
            deliveryType = DeliveryType.STANDARD;
        } else if (o_type.getSelectedItem().toString().equals("特快快递")) {
            deliveryType = DeliveryType.FAST;
        }
        OrderVO order_vo = new OrderVO(s_name.getText(), s_address
                .getText(), s_workplace.getText(), s_tele.getText(),
                s_phone.getText(), r_name.getText(), r_address
                .getText(), r_workplace.getText(), r_tele
                .getText(), r_phone.getText(), g_num.getText(),
                g_weight.getText(), g_volume.getText(), g_name
                .getText(), deliveryType, o_wrapper
                .getSelectedItem().toString(),
                o_transExpense.getText(), o_wrapperExpense.getText(), o_expense
                .getText(), o_dueDate.getText(), o_ordernum.getText(), ListState.PASSED);

        ListblService bl;

        try {
            bl = new ListController();
            bl.save2File(order_vo);
        } catch (RemoteException e1) {
            // TODO Auto-generated catch block
            JLabel tip = new JLabel("提示：网络异常");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        }

        JLabel tip = new JLabel("提示：保存成功");
        tip.setFont(font2);
        JOptionPane.showMessageDialog(null, tip);
    }

}
