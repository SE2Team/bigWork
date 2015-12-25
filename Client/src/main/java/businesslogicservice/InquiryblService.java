package businesslogicservice;

import vo.LogisticsVO;
import vo.OperationLogVO;

import java.rmi.RemoteException;
import java.util.Iterator;

public interface InquiryblService {
    //不用传参数
    Iterator<OperationLogVO> checkOperationLog() throws RemoteException;

    String checkForm(String type) throws RemoteException;

    LogisticsVO checkLogistics(String num) throws RemoteException;


}
