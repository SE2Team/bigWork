package stubs.bl1;

import businesslogicservice.InquiryblService;
import vo.LogisticsVO;
import vo.OperationLogVO;

import java.util.ArrayList;

public class InquiryblService_Stub implements InquiryblService {

    String checkForm;

    public InquiryblService_Stub(String cn) {
        checkForm = cn;
    }

    public InquiryblService_Stub() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<OperationLogVO> checkOperationLog() {
        // TODO Auto-generated method stub
        return null;
    }

    public String checkForm(String type) {
        // TODO Auto-generated method stub
        return checkForm;
    }

    public LogisticsVO checkLogistics(String num) {
        // TODO Auto-generated method stub
        return null;
    }

}
