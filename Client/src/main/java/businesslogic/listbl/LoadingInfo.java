package businesslogic.listbl;

import po.LoadingPO;
import util.ResultMessage;
import vo.ListVO;
import vo.LoadingVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class LoadingInfo extends List {
    @Override
    public ResultMessage get() {


        return super.get();
    }

    @Override
    public ResultMessage save(ListVO listVO) {
        LoadingVO vo=null;
        vo= (LoadingVO) listVO;
        LoadingPO po=new LoadingPO(vo.getLoadingDate(),vo.getHallNum(),vo.getTransportNum(),vo.getStart(),vo.getEnd(),vo.getMonitor(),vo.getSupercargo(),
                vo.getVehicleNum(),vo.getConsignList(),vo.getTransportMoney());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }

}
