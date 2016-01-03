package businesslogic.listbl;

import businesslogic.utilitybl.Helper;
import po.ExpenseAndDatePO;
import po.OperationLogPO;
import po.OrderPO;
import po.PO2VO;
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

    public boolean save2File(ListVO listVO) throws RemoteException {
        OrderVO vo = null;
        vo = (OrderVO) listVO;


        OrderPO po = VO2PO.convert(vo);

        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(), Helper.getUserType().toString(),
                "保存快递单"));


        return listDataService.save(po);
    }

    public ExpenseAndDateVO getExpenseAndDate(ExpenseAndDateVO vo) throws RemoteException, ExistException {
        ExpenseAndDatePO npo = listDataService.getExpenseOfTransport(new ExpenseAndDatePO(vo.getCity1(), vo.getCity2(),
                vo.getWrapper(), vo.getVolume(), vo.getDays(), vo.getDeliveryType(),
                vo.getExpenseOfWrap(), vo.getExpenseOfTransport(), vo.getExpense()));
        return new ExpenseAndDateVO(npo.getCity1(), npo.getCity2(), npo.getWrapper(), npo.getVolume(), npo.getDays(),
                npo.getDeliveryType(),
                npo.getExpenseOfWrap(), npo.getExpenseOfTransport(), npo.getExpense());
    }

    public boolean save(OrderVO vo) throws RemoteException {
        OrderPO po = null;
        po = VO2PO.convert(vo);
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(), Helper.getUserType().toString(),
                "新建快递单"));
        return listDataService.saveAsList(po);//保存为待审批
    }

    public boolean afterCheck(OrderVO vo) throws RemoteException {
        System.out.println("to data");
        return listDataService.deleteList(VO2PO.convert(vo));
    }

    public OrderVO getOrder(String num) throws RemoteException {
        return PO2VO.convert(listDataService.getOrder(num));
    }

}
