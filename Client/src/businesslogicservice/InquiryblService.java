package src.businesslogicservice;

import src.vo.*;
import util.FormType;

public interface InquiryblService {
    //不用传参数
    public OperationLogVO checkOperationLog();

    public String checkForm(FormType formType);

    public LogisticsVO checkLogistics(String num);
}
