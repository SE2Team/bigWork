package stubs.data1;

import dataservice.inquirydataservice.InquiryDataService;
import po.LogisticsPO;
import po.OperationLogPO;

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
