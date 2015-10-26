package businesslogicservice;

import vo.LogisticsVO;
import vo.OperationLogVO;

public interface InquiryblService {
    //不用传参数
    public OperationLogVO checkOperationLog();

    public String checkForm(String type);

    public LogisticsVO checkLogistics(String num);
}
