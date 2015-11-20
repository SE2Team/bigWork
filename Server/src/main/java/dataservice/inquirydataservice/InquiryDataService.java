package dataservice.inquirydataservice;

import po.LogisticsPO;
import po.OperationLogPO;

public interface InquiryDataService {
    public LogisticsPO checkLogistics(String num);

    public OperationLogPO checkOperationLog();

    public String checkForm(String type);
}
