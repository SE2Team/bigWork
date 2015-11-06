package src.drivers.data;


import src.dataservice.financedataservice.FinanceDataService;
import src.po.AccountPO;

public class FinanceDataService_Driver {
	String date;
	String name;
	AccountPO accountPO;
	public void driver(FinanceDataService financeDataService){
		String isGet1=financeDataService.get();
		if(isGet1=="00"){
			System.out.println("Success");
		}
		
		String isGet2=financeDataService.get(date, date);
		if(isGet2=="00"){
			System.out.println("Success");
		}
		
		boolean isAddAccount=financeDataService.addAccount(accountPO);
		if(isAddAccount==true){
			System.out.println("Success");
		}
		
		AccountPO isSearchAccount1=financeDataService.searchAccount();
		if(isSearchAccount1==accountPO){
			System.out.println("Success");
		}
		
		AccountPO isSearchAccount2=financeDataService.searchAccount(name);
		if(isSearchAccount2==accountPO){
			System.out.println("Success");
		}
		
		boolean isDelAccount=financeDataService.DelAccount(accountPO);
		if(isDelAccount==true){
			System.out.println("Success");
		}
		
		boolean isEditAccount=financeDataService.EditAccount(name, accountPO);
		if(isEditAccount==true){
			System.out.println("Success");
		}
		
	}
}
