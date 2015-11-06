package src.drivers.data;

import src.dataservice.inquirydataservice.InquiryDataService;
import src.po.LogisticsPO;
import src.po.OperationLogPO;

public class InquiryDataService_Driver {
	String num;
	String type;
	LogisticsPO logisticsPO;
	OperationLogPO operationLogPO;
		public  void driver(InquiryDataService inquiryDataService) {
			LogisticsPO isCheckLogistics=inquiryDataService.checkLogistics(num);
			if(isCheckLogistics==logisticsPO){
				System.out.println("Success!");
			}
			
			OperationLogPO isCheckOperationLog=inquiryDataService.checkOperationLog();
			if(isCheckOperationLog==operationLogPO){
				System.out.println("Success!");
			}
			
			String isCheckForm=inquiryDataService.checkForm(type);
			if(isCheckForm=="00"){
				System.out.println("Success!");
			}
		}
}
