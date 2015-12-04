package businesslogic.listbl;

import businesslogic.Exception.DateException;
import businesslogic.Exception.MoneyException;
import po.PaymentPO;
import util.ResultMessage;
import vo.ListVO;
import vo.PaymentVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class Payment extends List {
    public Payment() throws RemoteException {
        super();
    }

    public ResultMessage save(ListVO listVO) throws DateException, MoneyException, RemoteException {
        PaymentVO vo=null;
        vo= (PaymentVO) listVO;
        if(!DateException.isValid(vo.getPayDate()))
            throw new DateException("收款日期错误！");
        MoneyException.isValid(vo.getPayMoney());

        PaymentPO po=new PaymentPO(vo.getPayDate(),vo.getPayMoney(),vo.getPayHuman(),vo.getPayAccount(),vo.getPayReason(),vo.getPayComment());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }

    @Override
    public ResultMessage get() {
        return super.get();
    }



}
