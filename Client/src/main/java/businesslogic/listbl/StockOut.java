package businesslogic.listbl;

import po.StockOutPO;
import util.ResultMessage;
import vo.ListVO;
import vo.StockOutVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class StockOut extends List{
    @Override
    public ResultMessage save(ListVO listVO) {
        StockOutVO vo=null;
        vo= (StockOutVO) listVO;
        StockOutPO po=new StockOutPO(vo.getDeliveryNum(),vo.getOutDate(),vo.getEnd(),vo.getLoadingWay(),vo.getTransferNum());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }
}
