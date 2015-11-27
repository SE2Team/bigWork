package businesslogic.listbl;

import po.StockInPO;
import util.ResultMessage;
import vo.ListVO;
import vo.StockInVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class StockIn extends List{
    @Override
    public ResultMessage save(ListVO listVO) {
        StockInVO vo=null;
        vo= (StockInVO) listVO;
        StockInPO po=new StockInPO(vo.getDeliveryNum(),vo.getInDate(),vo.getEnd(),vo.getZoneNum(),vo.getRowNum(),vo.getShelfNum(),vo.getPositionNum());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }
}
