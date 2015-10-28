package src.drivers.bl;


import src.businesslogicservice.FinanceblService;
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

		boolean isGathering = financeblService.gathering(gatheringVO);
		if (isGathering == true) {
			System.out.println("Success!");
		}

		boolean isPayment = financeblService.payment(paymentVO);
		if (isPayment == true) {
			System.out.println("Success!");
		}

		boolean isInitial = financeblService.initial(institution);
		if (isInitial == true) {
			System.out.println("Success!");
		}

		boolean isAdd = financeblService. addAccount(accountVO);
		if (isAdd == true) {
			System.out.println("Success!");
		}

		boolean isSearch = financeblService.searchAccount(name);
		if (isSearch == true) {
			System.out.println("Success!");
		}

		boolean isDel = financeblService. DelAccount(accountVO);
		if (isDel == true) {
			System.out.println("Success!");
		}

		boolean isEdit = financeblService.EditAccount(accountVOOld,accountVONew);

		if (isEdit == true) {
			System.out.println("Success!");
		}
	}

	
}
