package src.businesslogic.inquirybl;

import src.businesslogicservice.InquiryblService;
import src.vo.LogisticsVO;
import src.vo.OperationLogVO;

/**没有类间协作
 * Created by Administrator on 2015/11/7 0007.
 */
public class InquiryController implements InquiryblService {
    @Override
    public OperationLogVO checkOperationLog() {
        return null;
    }

    @Override
    public String checkForm(String type) {
        return null;
    }

    @Override
    public LogisticsVO checkLogistics(String num) {
        return null;
    }
}
