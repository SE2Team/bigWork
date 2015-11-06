package src.businesslogic.inquirybl;

import src.businesslogicservice.InquiryblService;
import src.vo.LogisticsVO;
import src.vo.OperationLogVO;
import util.FormType;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class InquiryController implements InquiryblService {
    Inquiry inquiry=new Inquiry();
    @Override
    public OperationLogVO checkOperationLog() {
        return null;
    }

    @Override
    public String checkForm(FormType formType) {
        return null;
    }

    @Override
    public LogisticsVO checkLogistics(String num) {
        return null;
    }
}
