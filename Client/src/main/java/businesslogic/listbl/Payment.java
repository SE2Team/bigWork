package businesslogic.listbl;

import po.PaymentPO;
import util.ResultMessage;
import vo.ListVO;
import vo.PaymentVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class Payment extends List {
    public ResultMessage save(ListVO listVO) {
        PaymentVO vo=null;
        vo= (PaymentVO) listVO;
        PaymentPO po=new PaymentPO(vo.getPayDate(),vo.getPayMoney(),vo.getPayHuman(),vo.getPayAccount(),vo.getPayReason(),vo.getPayComment());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }

    @Override
    public ResultMessage get() {
        return super.get();
    }



}
