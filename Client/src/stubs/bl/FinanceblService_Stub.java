package src.stubs.bl;

import src.businesslogicservice.FinanceblService;
import src.vo.AccountVO;
import src.vo.GatheringVO;
import src.vo.PaymentVO;

public class FinanceblService_Stub implements FinanceblService {

    public FinanceblService_Stub() {

    }

    public boolean gathering(GatheringVO gatheringVO) {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean payment(PaymentVO paymentVO) {
        // TODO Auto-generated method stub
        return true;
    }

    public void generateForm() {
        // TODO Auto-generated method stub// TODO Auto-generated method stub
    }

    public void generateForm(String startDate, String endDate) {

    }

    public boolean initial(String institution) {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean addAccount(AccountVO accountVO) {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean searchAccount() {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean searchAccount(String name) {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean DelAccount(AccountVO accountVO) {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean EditAccount(AccountVO accountVOOld, AccountVO accountVONew) {
        // TODO Auto-generated method stub
        return true;
    }

}
