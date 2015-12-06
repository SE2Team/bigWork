package businesslogic.listbl;

import businesslogic.Exception.*;
import dataservice.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.listdataservice.ListDataService;
import po.ListPO;
import util.ResultMessage;
import vo.ListVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/25 0025.
 *
 * @author myk
 */
public class List {
    /**
     * The Data factory.
     */
    DataFactoryService dataFactory;
    /**
     * The List data service.
     */
    ListDataService listDataService;

    /**
     * Instantiates a new List.
     *
     * @throws RemoteException the remote exception
     */
    public List() throws RemoteException {
        dataFactory = DataFactory.getInstance();
        listDataService = dataFactory.getListData();
    }

    /**
     * 以对应类型序列化或者txt
     *
     * @param listVO the list vo
     * @return result message
     * @throws InvalidDoubleException  the invalid double exception
     * @throws DateException           the date exception
     * @throws OtherException          the other exception
     * @throws InvalidIntegerException the invalid integer exception
     * @throws MoneyException          the money exception
     * @throws RemoteException         the remote exception
     * @throws DeliverNumException     the deliver num exception
     */
    public ResultMessage save(ListVO listVO) throws  RemoteException{
        return ResultMessage.FAILED;//留空，子类实现
    }


    /**
     * Get result message.
     *
     * @return the result message
     */
    public ResultMessage get() {
        return ResultMessage.FAILED;

    }

    /**
     * 返回一个待审批单据列表
     *
     * @return array list
     * @throws RemoteException the remote exception
     */
    public final ArrayList<ListVO> push() throws RemoteException {

        ArrayList<ListPO> pos = listDataService.checkList();
        ArrayList<ListVO> vos = new ArrayList<ListVO>();
        for (ListPO temp : pos) {
            vos.add(new ListVO(temp.getId(), temp.getContent()));
        }
        return vos;
    }
}
