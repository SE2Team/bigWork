package businesslogicservice;

import vo.OperationLogVO;

import java.rmi.RemoteException;
import java.util.Iterator;

public interface InquiryblService {
    //不用传参数
    Iterator<OperationLogVO> checkOperationLog() throws RemoteException;

    String checkForm(String type) throws RemoteException;

    String checkLogistics(String num) throws RemoteException;


}
