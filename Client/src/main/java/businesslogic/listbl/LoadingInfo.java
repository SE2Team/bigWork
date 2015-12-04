package businesslogic.listbl;

import businesslogic.Exception.DateException;
import businesslogic.Exception.InvalidIntegerException;
import businesslogic.Exception.MoneyException;
import businesslogic.Exception.OtherException;
import businesslogic.utilitybl.Helper;
import po.LoadingPO;
import util.ResultMessage;
import vo.ListVO;
import vo.LoadingVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class LoadingInfo extends List {
    public LoadingInfo() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage get() {


        return super.get();
    }

    @Override
    public ResultMessage save(ListVO listVO) throws OtherException, InvalidIntegerException, DateException, MoneyException, RemoteException {
        LoadingVO vo=null;
        vo= (LoadingVO) listVO;

        if(Helper.compareTo(vo.getLoadingDate()))
            throw new DateException("时间晚于当前时间！");
        if(!InvalidIntegerException.isValid(vo.getHallNum())||vo.getHallNum().length()!=3)
            throw new InvalidIntegerException("营业厅编号错误！");
        if(vo.getTransportNum().length()!=(3+8+5)||Helper.compareTo(vo.getTransportNum().substring(3,11)))
            throw new OtherException("汽运编号格式错误！");
        if(!vo.getTransportNum().substring(0,3).equals(vo.getHallNum()))
            throw new OtherException("汽运编号和营业厅编号不对应！");
        if(vo.getStart()==vo.getEnd())
            throw new OtherException("始发地和目的地相同！");

        MoneyException.isValid(vo.getTransportMoney());//throw MoneyException;



        LoadingPO po=new LoadingPO(vo.getLoadingDate(),vo.getHallNum(),vo.getTransportNum(),vo.getStart(),vo.getEnd(),vo.getMonitor(),vo.getSupercargo(),
                vo.getVehicleNum(),vo.getConsignList(),vo.getTransportMoney());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }

}
