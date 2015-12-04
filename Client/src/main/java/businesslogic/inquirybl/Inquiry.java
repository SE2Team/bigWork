package businesslogic.inquirybl;

import businesslogic.Exception.DeliverNumException;
import data.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.inquirydataservice.InquiryDataService;
import po.LogisticsPO;
import po.OperationLogPO;
import vo.LogisticsVO;
import vo.OperationLogVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/7 0007.
 */
public class Inquiry {
    DataFactoryService dataFactory;
    InquiryDataService inquiry;

    public Inquiry() throws RemoteException {
        dataFactory = DataFactory.getInstance();
        inquiry = dataFactory.getInquiryData();
    }

    public ArrayList<OperationLogVO> checkOperationLog() throws RemoteException {
        ArrayList<OperationLogPO> po=inquiry.checkOperationLog();
        ArrayList<OperationLogVO> vo=new ArrayList<OperationLogVO>();
        for (OperationLogPO temp:po)
            vo.add(new OperationLogVO(temp.getTime(),temp.getHuman(),temp.getType()));

        return vo;
    }

    //type待商讨
    public String checkForm(String type) throws RemoteException {
        return inquiry.checkForm(type);
    }

    public LogisticsVO checkLogistics(String num) throws RemoteException, DeliverNumException {
        DeliverNumException.isValid(num);
        LogisticsPO po=inquiry.checkLogistics(num);

        return new LogisticsVO(po.getDeliveryNum(),po.getTransportState());
    }
}
