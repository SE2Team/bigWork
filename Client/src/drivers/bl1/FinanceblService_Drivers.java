package src.drivers.bl1;


import src.businesslogicservice.FinanceblService;
import src.util.ResultMessage;
import src.vo.AccountVO;
import src.vo.GatheringVO;
import src.vo.PaymentVO;

public class FinanceblService_Drivers {
	GatheringVO gatheringVO;
	PaymentVO paymentVO;
	AccountVO accountVO;
	AccountVO accountVOOld;
	AccountVO accountVONew;
	String date;
	String payee;
	String name;
	int money;
	String location;
	String account;
	String entry;
	String comment;
	String originalName;
	String newName;
	String institution;

	public void driver(FinanceblService financeblService) {

		ResultMessage isGathering = financeblService.gathering(gatheringVO);
		if (isGathering == ResultMessage.SUCCESS) {
			System.out.println("Success!");
		}

		ResultMessage isPayment = financeblService.payment(paymentVO);
		if (isPayment == ResultMessage.SUCCESS) {
			System.out.println("Success!");
		}

		ResultMessage isInitial = financeblService.initial(institution);
		if (isInitial == ResultMessage.SUCCESS) {
			System.out.println("Success!");
		}

		ResultMessage isAdd = financeblService. addAccount(accountVO);
		if (isAdd == ResultMessage.SUCCESS) {
			System.out.println("Success!");
		}

		ResultMessage isSearch = financeblService.searchAccount(name);
		if (isSearch == ResultMessage.SUCCESS) {
			System.out.println("Success!");
		}

		ResultMessage isDel = financeblService. DelAccount(accountVO);
		if (isDel == ResultMessage.SUCCESS) {
			System.out.println("Success!");
		}

		ResultMessage isEdit = financeblService.EditAccount(accountVOOld,accountVONew);

		if (isEdit == ResultMessage.SUCCESS) {
			System.out.println("Success!");
		}
	}

	
}
