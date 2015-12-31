package businesslogic.inquirybl;

import businesslogic.utilitybl.Helper;
import dataservice.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.inquirydataservice.InquiryDataService;
import dataservice.listdataservice.ListDataService;
import po.OperationLogPO;
import po.OrderPO;
import vo.OperationLogVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/7 0007.
 *
 * @author myk
 */
public class Inquiry {
    /**
     * The Inquiry.
     */
    private InquiryDataService inquiry;
    private ListDataService list;

    /**
     * Instantiates a new Inquiry.
     *
     * @throws RemoteException the remote exception
     */
    public Inquiry() throws RemoteException {
        DataFactoryService dataFactory = DataFactory.getInstance();
        inquiry = dataFactory.getInquiryData();
        list = dataFactory.getListData();
    }

    /**
     * Check operation log array list.
     *
     * @return the array list
     * @throws RemoteException the remote exception
     */
    public ArrayList<OperationLogVO> checkOperationLog() throws RemoteException {
        ArrayList<OperationLogPO> po = inquiry.checkOperationLog();
        ArrayList<OperationLogVO> vo = new ArrayList<OperationLogVO>();
        for (OperationLogPO temp : po) {
            vo.add(new OperationLogVO(temp.getTime(), temp.getHuman(), temp.getType()));
        }
        return vo;
    }

    /**
     * Check form string.
     *
     * @param type the type
     * @return the string
     * @throws RemoteException the remote exception
     */
    public String checkForm(String type) throws RemoteException {

        inquiry.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"查看报表"));
        return inquiry.checkForm(type);
    }

    /**
     * Check logistics logistics vo.
     *
     * @param num the num
     * @return the logistics vo
     * @throws RemoteException     the remote exception
     */
    public String checkLogistics(String num) throws RemoteException {
        OrderPO po = list.getOrder(num);
        if (po == null)
            return "找不到该快递单！";
        return po.getLogistics();
    }
}
