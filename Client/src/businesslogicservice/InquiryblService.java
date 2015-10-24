package businesslogicservice;

import po.OperationLogPO;
import vo.LogisticsVO;
import vo.OperationLogVO;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface InquiryblService {
    public OperationLogVO checkOperationLog(OperationLogPO operationLogPO);
    public String checkForm(String type);
    public LogisticsVO checkLogistics(String num);
}
