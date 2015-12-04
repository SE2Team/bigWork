package po;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class PaymentPO extends ListPO implements Serializable{
	private static final long serialVersionUID = 1L;//序列化编号
	
	/**
	 * 
	 * 包括付款日期、付款金额、付款人、付款账号、条目、备注
	 */
	
	private String payDate;
	private String payMoney;
	private String payHuman;
	private String payAccount;
	private String payReason;
	private String payComment;
	
	
	/**
	 * 
	 * @param payDate
	 * @param payMoney
	 * @param payHuman
	 * @param payAccount
	 * @param payReason
	 * @param payComment
	 */
	public PaymentPO(String payDate, String payMoney, String payHuman,
			String payAccount,String payReason,String payComment){
		this.payAccount=payAccount;
		this.payComment=payComment;
		this.payDate=payDate;
		this.payHuman=payHuman;
		this.payMoney=payMoney;
		this.payReason=payReason;
	}
	
	public  void setPayDate(String payDate){
		this.payDate=payDate;
	}
	
	public String getPayDate(){
		return payDate;
	}
	
	public void setPayMoney(String payMoney){
		this.payMoney=payMoney;
	}
	
	public String getPayMoney(){
		return payMoney;
	}
	
	public void setPayHuman(String payHuman){
		this.payHuman=payHuman;
	}
	
	public String getPayHuman(){
		return payHuman;
	}
	
	public void setPayAccount(String payAccount){
		this.payAccount=payAccount;
	}
	
	public String getPayAccount(){
		return payAccount;
	}
	
	public void setPayReason(String payReason){
		this.payReason=payReason;
	}
	
	public String getPayReason(){
		return payReason;
	}
	
	public void setPayComment(String payComment){
		this.payComment=payComment;
	}
	
	public String getPayComment(){
		return payComment;
	}


	
}
