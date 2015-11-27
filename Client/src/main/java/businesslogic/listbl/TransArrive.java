package businesslogic.listbl;

import po.TransferReceivePO;
import util.ResultMessage;
import vo.ListVO;
import vo.TransferReceiveVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class TransArrive extends List{
    @Override
    public ResultMessage save(ListVO listVO) {
        TransferReceiveVO vo=null;
        vo= (TransferReceiveVO) listVO;
        TransferReceivePO po=new TransferReceivePO(vo.getOrderNum(),vo.getArriveDate(),vo.getStart(),vo.getCargoState(),vo.getTransferCenterNum(),vo.getTransferNum());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }
}
