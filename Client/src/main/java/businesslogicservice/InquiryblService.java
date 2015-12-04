package businesslogicservice;

import businesslogic.Exception.DeliverNumException;
import vo.LogisticsVO;
import vo.OperationLogVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InquiryblService {
    //不用传参数
    ArrayList<OperationLogVO> checkOperationLog() throws RemoteException;

    String checkForm(String type) throws RemoteException;

    LogisticsVO checkLogistics(String num) throws RemoteException, DeliverNumException;
}
