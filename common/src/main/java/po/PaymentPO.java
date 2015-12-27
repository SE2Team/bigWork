package po;

import util.ListState;
import util.ListType;

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


	public PaymentPO(String payDate, String payMoney, String payHuman,
					 String payAccount, String payReason, String payComment, ListState isCheck) {
		super(isCheck);
		this.payDate = payDate;
		this.payMoney = payMoney;
		this.payHuman = payHuman;
		this.payAccount = payAccount;
		this.payReason = payReason;
		this.payComment = payComment;
        setType(ListType.PAYMENT);
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
