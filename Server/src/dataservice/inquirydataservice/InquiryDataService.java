package src.dataservice.inquirydataservice;

import src.po.LogisticsPO;
import src.po.OperationLogPO;

public interface InquiryDataService {
    public LogisticsPO checkLogistics(String num);

    public OperationLogPO checkOperationLog();

    public String checkForm(String type);
}
