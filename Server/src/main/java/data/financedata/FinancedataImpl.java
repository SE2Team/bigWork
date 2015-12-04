package data.financedata;

import data.Common.Common;
import dataservice.financedataservice.FinanceDataService;
import po.AccountPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by MYK on 2015/11/23 0023.
 */
public class FinancedataImpl extends UnicastRemoteObject implements FinanceDataService{
	public FinancedataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	public String get() {
		// TODO Auto-generated method stub
		return null;
	}

	public String get(String startDate, String endDate) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addAccount(AccountPO accountPO) {
		// TODO Auto-generated method stub
		Common common = new Common("account");
		common.writeDataAdd(this.poToString(accountPO));
		return ResultMessage.SUCCESS;
	}

	public ArrayList<AccountPO> searchAccount() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("account");
		ArrayList<String> s = common.readData();
		ArrayList<AccountPO> list = new ArrayList<AccountPO>();
		String[] str = new String[2];
		for (int j = 0; j < s.size(); j++) {
			str = s.get(j).split(";");
			list.add(this.stringToPo(str));
		}
		return list;
	}

	public AccountPO searchAccount(String name) {
		// TODO Auto-generated method stub
		Common common = new Common("account");
		ArrayList<String> s = common.readData();
		String[] str = new String[2];
		for (int j = 0; j < s.size(); j++) {
			str = s.get(j).split(";");
			if (str[0].equals(name)) {
				return this.stringToPo(str);
			}
		}
		return null;
	}

	public ResultMessage DelAccount(AccountPO accountPO) {
		// TODO Auto-generated method stub
		Common common = new Common("account");
		ArrayList<String> s = common.readData();
		s.remove(this.poToString(accountPO));
		common.clearData("account");
		common.writeData(s);           
		return ResultMessage.SUCCESS;
	}

	public ResultMessage EditAccount(String name, AccountPO newAccountPO) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * po to String
	 */
	private String poToString(AccountPO po){
		return po.getAccountName()+";"+po.getAccountBalance();
	
	}
	
	private AccountPO stringToPo(String[] str){
		return new AccountPO(str[0], str[1]);
	}
}
