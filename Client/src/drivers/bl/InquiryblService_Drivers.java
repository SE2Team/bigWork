package src.drivers.bl;


import src.businesslogicservice.InquiryblService;
import src.vo.LogisticsVO;
import src.vo.OperationLogVO;

public class InquiryblService_Drivers {
    private OperationLogVO operationLogVO;
    private LogisticsVO logisticsVO;
    private String type;
    private String num;

    public void driver(InquiryblService inquiryblService) {
        OperationLogVO isCheckLog = inquiryblService.checkOperationLog();
        if (isCheckLog == operationLogVO) {
            System.out.println("Success!");
        }

        String isCheckForm = inquiryblService.checkForm(type);
        if (isCheckForm == type) {
            System.out.println("Success!");
        }

        LogisticsVO isCheckLogistics = inquiryblService.checkLogistics(num);
        if (isCheckLogistics == logisticsVO) {
            System.out.println("Success!");
        }
    }
}
