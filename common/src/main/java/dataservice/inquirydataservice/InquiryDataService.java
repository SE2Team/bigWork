package dataservice.inquirydataservice;

import po.OperationLogPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InquiryDataService extends Remote {
    /**
     * @return
     * @throws RemoteException
     */
    ArrayList<OperationLogPO> checkOperationLog() throws RemoteException;

    /**
     * @param type
     * @return
     * @throws RemoteException
     */
    String checkForm(String type) throws RemoteException;


    boolean saveOperationLog(OperationLogPO po) throws RemoteException;


}
