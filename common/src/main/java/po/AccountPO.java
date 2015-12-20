package po;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class AccountPO implements Serializable {
	private static final long serialVersionUID = 1L;//序列化编号
	
	/**
	 * 
	 * 账户名称和余额
	 */
	private String accountName;
	private String accountBalance;
	
	public AccountPO(String accountName, String accountBalance){
		this.accountName=accountName;
		this.accountBalance=accountBalance;
	}
	
	public void setAccountName(String accountName){
		this.accountName=accountName;
	}
	
	public String getAccountName(){
		return accountName;
	}
	
	public void setAccountBalance(String accountBalance){
		this.accountBalance=accountBalance;
	}
	
	public String getAccountBalance(){
		return accountBalance;
	}
	
	
}
