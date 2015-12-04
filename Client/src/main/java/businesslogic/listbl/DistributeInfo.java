package businesslogic.listbl;

import businesslogic.Exception.DateException;
import businesslogic.utilitybl.Helper;
import po.DistributePO;
import util.ResultMessage;
import vo.DistributeVO;
import vo.ListVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class DistributeInfo extends List{
    public DistributeInfo() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage save(ListVO listVO) throws DateException, RemoteException {
        DistributeVO vo=null;
        vo= (DistributeVO) listVO;
        if(Helper.compareTo(vo.getArriveDate()))
            throw new DateException("时间晚于当前时间！");
        DistributePO po=new DistributePO(vo.getArriveDate(),vo.getOrderNum(),vo.getArriveDate());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }

    @Override
    public ResultMessage get() {
        return super.get();
    }
}
