package businesslogic.listbl;

import po.DistributePO;
import util.ResultMessage;
import vo.DistributeVO;
import vo.ListVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class DistributeInfo extends List{
    @Override
    public ResultMessage save(ListVO listVO) {
        DistributeVO vo=null;
        vo= (DistributeVO) listVO;
        DistributePO po=new DistributePO(vo.getArriveDate(),vo.getOrderNum(),vo.getArriveDate());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }

    @Override
    public ResultMessage get() {
        return super.get();
    }
}
