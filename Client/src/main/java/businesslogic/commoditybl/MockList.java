package businesslogic.commoditybl;

import businesslogic.listbl.List;
import businesslogic.managebl.Manage;
import businesslogicservice.CommodityblService;
import vo.StockInVO;

import java.rmi.RemoteException;

/**
 * tester生成一个PO过来，主要测试content内容是否符合
 *
 * @author Administrator
 */
public class MockList extends List {


    /**
     * Instantiates a new Mock list.
     *
     * @throws RemoteException the remote exception
     */
    public MockList() throws RemoteException {
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws RemoteException the remote exception
     */
    public static void main(String[] args) throws RemoteException {
        CommodityblService commodity = new CommodityController();

        StockInVO vo = new StockInVO("121", "121", "121", "121", "121", "121", "121",true);
        commodity.stockIn(vo);
        Manage manage=new Manage();
        List list=new List();
        list.save(vo);
    }


}
