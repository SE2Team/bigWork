package businesslogic.listbl;

import po.ReceiptPO;
import util.ResultMessage;
import vo.ListVO;
import vo.ReceiptVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class Receipt extends List{
    @Override
    public ResultMessage save(ListVO listVO) {
        ReceiptVO vo=null;
        vo= (ReceiptVO) listVO;
        ReceiptPO po=new ReceiptPO(vo.getReceiptDate(),vo.getReceiptMoney(),vo.getReceiptCourier(),vo.getOrderNum());

        listDataService.saveAsList(po);

        return listDataService.save(po);
    }
}
