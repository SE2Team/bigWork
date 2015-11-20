package businesslogicservice;

import vo.*;

public interface InquiryblService {
    //不用传参数
    OperationLogVO checkOperationLog();

    String checkForm(String type);

    LogisticsVO checkLogistics(String num);
}
