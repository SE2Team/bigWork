package businesslogic.listbl;

import businesslogic.Exception.*;
import data.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.listdataservice.ListDataService;
import po.ListPO;
import util.ResultMessage;
import vo.ListVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class List {
    DataFactoryService dataFactory;
    ListDataService listDataService;

    public List() throws RemoteException {
        dataFactory= DataFactory.getInstance();
        listDataService=dataFactory.getListData();
    }

    /**
     * 以对应类型序列化或者txt
     *
     * @param listVO
     * @return
     */
    public ResultMessage save(ListVO listVO) throws InvalidDoubleException, DateException, OtherException, InvalidIntegerException, MoneyException, RemoteException, DeliverNumException {
        return ResultMessage.FAILED;//留空，子类实现
    }



    public ResultMessage get() {
        return ResultMessage.FAILED;

    }

    /**
     * 返回一个待审批单据列表
     * @return
     */
    public final ArrayList<ListVO> push() throws RemoteException {

        ArrayList<ListPO> pos=listDataService.checkList();
        ArrayList<ListVO> vos=new ArrayList<ListVO>();
        for (ListPO temp:pos){
            vos.add(new ListVO(temp.getId(),temp.getContent()));
        }
        return vos;
    }
}
