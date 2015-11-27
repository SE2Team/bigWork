package businesslogic.inquirybl;

import data.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.inquirydataservice.InquiryDataService;
import po.LogisticsPO;
import po.OperationLogPO;
import vo.LogisticsVO;
import vo.OperationLogVO;

/**
 * Created by Administrator on 2015/11/7 0007.
 */
public class Inquiry {
    DataFactoryService dataFactory=new DataFactory();
    InquiryDataService inquiry=dataFactory.getInquiryData();
    public OperationLogVO checkOperationLog() {
        OperationLogPO po=inquiry.checkOperationLog();
        OperationLogVO vo=new OperationLogVO(po.getTime(),po.getHuman(),po.getType());
        return vo;
    }

    public String checkForm(String type) {
        return inquiry.checkForm(type);
    }

    public LogisticsVO checkLogistics(String num) {
        LogisticsPO po=inquiry.checkLogistics(num);

        return new LogisticsVO(po.getDeliveryNum(),po.getTransportState());
    }
}
