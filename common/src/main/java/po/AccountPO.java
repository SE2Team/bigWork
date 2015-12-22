package po;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/25 0025.
 *
 * @author myk
 */
public class AccountPO implements Serializable {
	private static final long serialVersionUID = 1L;//序列化编号
	

	private String accountName;
	private String accountBalance;

	/**
	 * Instantiates a new Account po.
	 *
	 * @param accountName    the account name
	 * @param accountBalance the account balance
	 */
	public AccountPO(String accountName, String accountBalance){
		this.accountName=accountName;
		this.accountBalance=accountBalance;
	}

	/**
	 * set the name of account
	 *
	 * @param accountName the account name
	 */
	public void setAccountName(String accountName){
		this.accountName=accountName;
	}

	/**
	 * Get account name string.
	 *
	 * @return accountName string
	 */
	public String getAccountName(){
		return accountName;
	}

	/**
	 * Set account balance.
	 *
	 * @param accountBalance the account balance
	 */
	public void setAccountBalance(String accountBalance){
		this.accountBalance=accountBalance;
	}

	/**
	 * Get account balance string.
	 *
	 * @return the string
	 */
	public String getAccountBalance(){
		return accountBalance;
	}
	
	
}
