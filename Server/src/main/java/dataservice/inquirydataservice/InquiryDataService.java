package dataservice.inquirydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogisticsPO;
import po.OperationLogPO;
import util.ExistException;
import util.ResultMessage;

public interface InquiryDataService extends Remote{
	/**
	 * 
	 * @param num
	 * @return
	 * @throws RemoteException
	 */
     LogisticsPO checkLogistics(String num) throws RemoteException;
     
     /**
      * 
      * @return
      * @throws RemoteException
      */
     ArrayList<OperationLogPO> checkOperationLog() throws RemoteException;
     
     /**
      * 
      * @param type
      * @return
      * @throws RemoteException
      */
     String checkForm(String type) throws RemoteException;
    
     /**
      * 
      * @param po
      * @return
      * @throws RemoteException
      * @throws ExistException
      */
     Boolean updateLogistics(LogisticsPO po) throws RemoteException, ExistException;
}
