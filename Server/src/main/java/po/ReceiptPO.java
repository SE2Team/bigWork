package po;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class ReceiptPO extends ListPO implements Serializable{
	private static final long serialVersionUID = 1L;//序列化编号
	//收款日期、收款金额、收款快递员、对应的所有快递订单条形码号
	
	private String receiptDate;
	private String receiptMoney;
	private String receiptCourier;
	private String orderNum;
	
	/**
	 * 
	 * @param receiptDate
	 * @param receiptMoney
	 * @param receiptCourier
	 * @param orderNum
	 */
	public ReceiptPO(String receiptDate, String receiptMoney, 
			String receiptCourier,String orderNum){
		this.receiptDate=receiptDate;
		this.receiptMoney=receiptMoney;
		this.receiptCourier=receiptCourier;
		this.orderNum=orderNum;
	}
	
	/**
	 * 收款日期
	 * @param receiptDate
	 */
	public void setReceiptDate(String receiptDate){
		this.receiptDate=receiptDate;
	}
	
	/**
	 * 
	 * @return 收款日期
	 */
	public String getReceiptDate(){
		return receiptDate;
	}
	
	/**
	 * 收款金额
	 * @param receiptMoney
	 */
	public void setReceiptMoney(String receiptMoney){
		this.receiptMoney=receiptMoney;
	}
	
	/**
	 * 
	 * @return 收款金额
	 */
	public String getReceiptMoney(){
		return receiptMoney;
	}
	
	/**
	 * 收款快递员
	 * @param receiptCourier
	 */
	public void setReceiptCourier(String receiptCourier){
		this.receiptCourier=receiptCourier;
	}
	
	/**
	 * 收款快递员
	 * @return
	 */
	public String getReceiptCourier(){
		return receiptCourier;
	}
	
	/**
	 * 对应的所有快递订单条形码号
	 * @param orderNum
	 */
	public void setOrderNum(String orderNum){
		this.orderNum=orderNum;
	}
	
	/**
	 * 对应的所有快递订单条形码号
	 * @return
	 */
	public String getOrderNum(){
		return orderNum;
	}
}
