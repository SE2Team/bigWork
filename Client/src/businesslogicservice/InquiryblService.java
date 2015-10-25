package businesslogicservice;

import po.OperationLogPO;
import vo.LogisticsVO;
import vo.OperationLogVO;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface InquiryblService {
    /**
     * Check operation log operation log vo.
     *
     * @param operationLogPO the operation log po
     * @return the operationlogvo
     */
    public OperationLogVO checkOperationLog(OperationLogPO operationLogPO);

    /**
     * Check form string.
     *
     * @param type the type
     * @return the string
     */
    public String checkForm(String type);

    /**
     * Check logistics logistics vo.
     *
     * @param num the num
     * @return the logisticsvo
     */
    public LogisticsVO checkLogistics(String num);
}
