package data.financedata;

import dataservice.financedataservice.FinanceDataService;
import po.AccountPO;
import po.GatheringPO;
import po.PaymentPO;
import util.ExistException;
import util.ResultMessage;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.print.attribute.standard.RequestingUserName;

import data.Common.Common;

/**
 * Created by MYK on 2015/11/23 0023.
 */
public class FinancedataImpl extends UnicastRemoteObject implements FinanceDataService{
	public FinancedataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	public String get() throws RemoteException{
		// TODO Auto-generated method stub
		double paymentMoney=0;
		double gatheringMoney=0;
		Common common=new Common("payment");
		ArrayList<String> list=common.readData();
		for(int j=0;j<list.size();j++){
			String[] str=list.get(j).split(";");
			paymentMoney=paymentMoney+Double.parseDouble(this.stringToPaymentPO(str).getPayMoney());
		}
		
		Common common2=new Common("gathering");
		ArrayList<String> list2=common2.readData();
		for(int i=0;i<list2.size();i++){
			String[] str2=list2.get(i).split(";");
			gatheringMoney=gatheringMoney+Double.parseDouble(this.stringToGatheringPO(str2).getMoney());
		}
		return Double.toString(gatheringMoney-paymentMoney);
	}

	public String get(String startDate, String endDate) throws RemoteException {
		// TODO Auto-generated method stub
		double paymentMoney=0;
		double gatheringMoney=0;
		ArrayList<String> payment=new ArrayList<String>();
		ArrayList<String> gathering=new ArrayList<String>();
		int start=this.DateToInt(startDate);
		int end=this.DateToInt(endDate);
		Common common=new Common("payment");
		ArrayList<String> list=common.readData();
		for(int j=0;j<list.size();j++){
			String[] str=list.get(j).split(";");
			int date=this.DateToInt(this.stringToPaymentPO(str).getPayDate());
			if(date>=start&&date<=end){
				payment.add(list.get(j));
			}
			
		}
		
		Common common2=new Common("gathering");
		ArrayList<String> list2=common.readData();
		for(int i=0;i<list2.size();i++){
			String[] str=list2.get(i).split(";");
			int date=this.DateToInt(this.stringToGatheringPO(str).getDate());
			if(date>=start&&date<=end){
				gathering.add(list2.get(i));
			}		
		}
		
		for(int j=0;j<payment.size();j++){
			String[] str=payment.get(j).split(";");
			paymentMoney=paymentMoney+Double.parseDouble(this.stringToPaymentPO(str).getPayMoney());
		}
		
		for(int i=0;i<gathering.size();i++){
			String[] str2=gathering.get(i).split(";");
			gatheringMoney=gatheringMoney+Double.parseDouble(this.stringToGatheringPO(str2).getMoney());
		}
		return Double.toString(gatheringMoney-paymentMoney);
	}

	public Boolean addAccount(AccountPO accountPO) throws ExistException {
		// TODO Auto-generated method stub
		Common common = new Common("account");
		ArrayList<String> list=common.readData();
		if(list.contains(this.poToString(accountPO))){
			throw new ExistException();
		}
		common.writeDataAdd(this.poToString(accountPO));
		return true;
	}

	public ArrayList<AccountPO> searchAccount() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("account");
		ArrayList<String> s = common.readData();
		ArrayList<AccountPO> list = new ArrayList<AccountPO>();
		for (int j = 0; j < s.size(); j++) {
			String[] str = s.get(j).split(";");
			list.add(this.stringToAccountPO(str));
		}
		return list;
	}

	public AccountPO searchAccount(String name) throws RemoteException{
		// TODO Auto-generated method stub
		Common common = new Common("account");
		ArrayList<String> s = common.readData();
		for (int j = 0; j < s.size(); j++) {
			String[] str = s.get(j).split(";");
			if (str[0].equals(name)) {
				return this.stringToAccountPO(str);
			}
		}
		return null;
	}

	public Boolean DelAccount(AccountPO accountPO) throws RemoteException{
		// TODO Auto-generated method stub
		Common common = new Common("account");
		ArrayList<String> s = common.readData();
		s.remove(this.poToString(accountPO));
		common.clearData("account");
		common.writeData(s);           
		return true;
	}

	public Boolean EditAccount(String name, AccountPO newAccountPO) throws RemoteException, ExistException{
		// TODO Auto-generated method stub
		Common common = new Common("account");
		ArrayList<String> s = common.readData();
		for(int i=0;i<s.size();i++){
			String[] str=s.get(i) .split(";");
			if(this.stringToAccountPO(str).getAccountName().equals(name)){
				s.remove(i);
				s.add(this.poToString(newAccountPO));
				return true;
			}else{
				throw new ExistException();
			}
		}
		return null;
	}

	/**
	 * 
	 * po to String
	 */
	private String poToString(AccountPO po) {
		return po.getAccountName()+";"+po.getAccountBalance();
	
	}
	
	private AccountPO stringToAccountPO(String[] str) {
		return new AccountPO(str[0], str[1]);
	}
	
	private PaymentPO stringToPaymentPO(String[] str){
		boolean isCheck=false;
		if(str[6].equals("true")){
			isCheck=true;
		}
		return new PaymentPO(str[0], str[1], str[2], str[3], str[4], str[5],isCheck);
	}
	
	private GatheringPO stringToGatheringPO(String[] str){
		boolean isCheck=false;
		if(str[6].equals("true")){
			isCheck=true;
		}
		return new GatheringPO(str[0], str[1], str[2], str[3], str[4],isCheck);
	}
	
	private int DateToInt(String date) {
		String[] str=date.split("-");
		for(int i=1;i<str.length;i++){
			str[0]=str[0]+str[i];
		}
		 return Integer.parseInt(str[0]);
	}
	
}
