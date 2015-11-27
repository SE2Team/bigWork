package businesslogic.listbl;

import po.TransferPO;
import util.ResultMessage;
import vo.ListVO;
import vo.TransferVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class TransInfo extends List{
    @Override
    public ResultMessage save(ListVO listVO) {
        TransferVO vo=null;
        vo= (TransferVO) listVO;
        TransferPO po=new TransferPO(vo.getLoadingWay(),vo.getLoadingDate(),vo.getTransportNum(),vo.getVehicleNum(),
        vo.getStart(),vo.getEnd(),vo.getContainerNum(),vo.getMonitor(),vo.getSupercargo(),vo.getOrderNum(),vo.getMoney());
        listDataService.saveAsList(po);

        return listDataService.save(po);
    }
}
