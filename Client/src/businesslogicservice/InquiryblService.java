package src.businesslogicservice;

import src.vo.LogisticsVO;
import src.vo.OperationLogVO;
import util.FormType;

public interface InquiryblService {
    //不用传参数
    public OperationLogVO checkOperationLog();

    public String checkForm(FormType formType);

    public LogisticsVO checkLogistics(String num);
}
