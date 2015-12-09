package dataservice.inquirydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogisticsPO;
import po.OperationLogPO;
import util.ExistException;

public interface InquiryDataService extends Remote{
    public LogisticsPO checkLogistics(String num) throws RemoteException;

    public ArrayList<OperationLogPO> checkOperationLog() throws RemoteException;

    public String checkForm(String type) throws RemoteException;
    
    public Boolean updateLogistics(LogisticsPO po) throws RemoteException, ExistException;
}
