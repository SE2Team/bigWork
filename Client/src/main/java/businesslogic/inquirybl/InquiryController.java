package businesslogic.inquirybl;

import businesslogic.Exception.DeliverNumException;
import businesslogicservice.InquiryblService;
import vo.LogisticsVO;
import vo.OperationLogVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 没有类间协作
 * Created by Administrator on 2015/11/7 0007.
 *
 * @author myk
 */
public class InquiryController implements InquiryblService {
    /**
     * The Inquiry.
     */
    Inquiry inquiry;

    /**
     * Instantiates a new Inquiry controller.
     *
     * @throws RemoteException the remote exception
     */
    public InquiryController() throws RemoteException {
        inquiry = new Inquiry();
    }

    public ArrayList<OperationLogVO> checkOperationLog() throws RemoteException {
        return inquiry.checkOperationLog();
    }

    public String checkForm(String type) throws RemoteException {
        return inquiry.checkForm(type);
    }

    public LogisticsVO checkLogistics(String num) throws RemoteException, DeliverNumException {
        return inquiry.checkLogistics(num);
    }
}
