package businesslogic.listbl;

import po.ExpenseAndDatePO;
import po.OrderPO;
import util.ExistException;
import vo.ExpenseAndDateVO;
import vo.ListVO;
import vo.OrderVO;
import vo.VO2PO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 *
 * @author myk
 */
public class Order extends List {
    /**
     * Instantiates a new Order.
     *
     * @throws RemoteException the remote exception
     */
    public Order() throws RemoteException {
        super();
    }

    @Override
    public boolean save(ListVO listVO) throws RemoteException {
        OrderVO vo = null;
        vo = (OrderVO) listVO;


        OrderPO po = VO2PO.convert(vo);


        return listDataService.save(po);
    }

    public ExpenseAndDateVO getExpenseAndDate(ExpenseAndDateVO vo) throws RemoteException, ExistException {
        ExpenseAndDatePO npo=listDataService.getExpenseOfTransport(new ExpenseAndDatePO(vo.getCity1(),vo.getCity2(),vo.getDays(),vo.getWrapper(),vo.getVolume(),vo.getDeliveryType(),
                vo.getExpenseOfWrap(),vo.getExpenseOfTransport(),vo.getExpense()));
        return new ExpenseAndDateVO(npo.getCity1(),npo.getCity2(),npo.getDays(),npo.getWrapper(),npo.getVolume(),npo.getDeliveryType(),
                npo.getExpenseOfWrap(),npo.getExpenseOfTransport(),npo.getExpense());
    }
}
