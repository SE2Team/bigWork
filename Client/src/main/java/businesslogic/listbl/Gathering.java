package businesslogic.listbl;

import businesslogic.Exception.DateException;
import businesslogic.Exception.InvalidDoubleException;
import businesslogic.utilitybl.Helper;
import po.GatheringPO;
import util.ResultMessage;
import vo.GatheringVO;
import vo.ListVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class Gathering extends List {

    public Gathering() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage save(ListVO listVO) throws InvalidDoubleException, DateException, RemoteException {
        GatheringVO gatheringVO = (GatheringVO) listVO;

        if(Helper.compareTo(gatheringVO.getDate()))
            throw new DateException("时间晚于当前时间！");
        if(!InvalidDoubleException.isValid(gatheringVO.getMoney()))
            throw new InvalidDoubleException("金额数据异常！");
        GatheringPO po = new GatheringPO(gatheringVO.getDate(), gatheringVO.getWorkplace(), gatheringVO.getMan(), gatheringVO.getMoney(), gatheringVO.getPlace());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }

    @Override
    public ResultMessage get() {
        return super.get();
    }
}
