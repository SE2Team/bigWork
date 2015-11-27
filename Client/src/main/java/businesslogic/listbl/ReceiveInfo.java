package businesslogic.listbl;

import po.ReceivePO;
import util.ResultMessage;
import vo.ListVO;
import vo.ReceiveVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class ReceiveInfo extends List{
    @Override
    public ResultMessage save(ListVO listVO) {
        ReceiveVO vo=null;
        vo= (ReceiveVO) listVO;
        ReceivePO po=new ReceivePO(vo.getArriveDate(),vo.getTransferNum(),vo.getStart(),vo.getArriveState());

        listDataService.saveAsList(po);

        return listDataService.save(po);
    }
}
