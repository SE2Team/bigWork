package businesslogic.inquirybl;

import businesslogicservice.InquiryblService;
import vo.LogisticsVO;
import vo.OperationLogVO;

/**
 * 没有类间协作
 * Created by Administrator on 2015/11/7 0007.
 */
public class InquiryController implements InquiryblService {
    Inquiry inquiry=new Inquiry();
    public OperationLogVO checkOperationLog() {
        return inquiry.checkOperationLog();
    }

    public String checkForm(String type) {
        return inquiry.checkForm(type);
    }

    public LogisticsVO checkLogistics(String num) {
        return inquiry.checkLogistics(num);
    }
}
