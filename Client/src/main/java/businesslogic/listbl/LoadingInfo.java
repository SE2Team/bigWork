package businesslogic.listbl;

import po.LoadingPO;
import util.ResultMessage;
import vo.ListVO;
import vo.LoadingVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 *
 * @author myk
 */
public class LoadingInfo extends List {
    /**
     * Instantiates a new Loading info.
     *
     * @throws RemoteException the remote exception
     */
    public LoadingInfo() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage get() {


        return super.get();
    }

    @Override
    public ResultMessage save(ListVO listVO) throws RemoteException {
        LoadingVO vo = null;
        vo = (LoadingVO) listVO;

        LoadingPO po = new LoadingPO(vo.getLoadingDate(), vo.getHallNum(), vo.getTransportNum(), vo.getStart(), vo.getEnd(), vo.getMonitor(), vo.getSupercargo(),
                vo.getVehicleNum(), vo.getConsignList(), vo.getTransportMoney());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }

}
