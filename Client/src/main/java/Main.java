import businesslogic.listbl.ListController;
import util.DeliveryType;
import vo.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
class Main {
    public static void main(String[] args) {
//    	JFrame mFrame = new JFrame();
//        mFrame.setSize(900, 600);
//        mFrame.setLocation(300, 300);
//        ListblService bl=new ListController();
//        JPanel panel=new ListFinanceView(bl);
//        mFrame.getContentPane().add(panel);
//        mFrame.setTitle("ss�");
//        mFrame.setVisible(true);
        try {
            new ListController().order(new OrderVO("123","123","123","123","123","123","123","123","123","123","123","123","123","123", DeliveryType.FAST,
                    "123","123","123","123","123","123",true));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
