package src.businesslogicservice;

import src.vo.*;

public interface InquiryblService {
    //不用传参数
    public OperationLogVO checkOperationLog();

    public String checkForm(String type);

    public LogisticsVO checkLogistics(String num);
}
