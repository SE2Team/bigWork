package src.stubs.data;

import src.dataservice.inquirydataservice.InquiryDataService;
import src.po.LogisticsPO;
import src.po.OperationLogPO;

public class InquiryDataService_Stub implements InquiryDataService {

    public InquiryDataService_Stub() {

    }

    public LogisticsPO checkLogistics(String num) {
        System.out.println("Success");
        LogisticsPO po = new LogisticsPO();
        return po;
    }

    public OperationLogPO checkOperationLog() {
        System.out.println("Success");
        OperationLogPO po = new OperationLogPO();
        return po;
    }

    public String checkForm(String type) {
        System.out.println("Success");
        return "";
    }
}
