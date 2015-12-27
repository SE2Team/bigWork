package po;

import util.ListState;
import util.ListType;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class ReceiptPO extends ListPO{
	//收款日期、收款金额、收款快递员、对应的所有快递订单条形码号
	
	private String receiptDate;
	private String receiptMoney;
	private String receiptCourier;
	private ArrayList<String> orderNum;

	public ReceiptPO(String receiptDate, String receiptMoney, String receiptCourier, ArrayList<String> orderNum,
					 ListState isCheck) {
		super(isCheck);
		this.receiptDate = receiptDate;
		this.receiptMoney = receiptMoney;
		this.receiptCourier = receiptCourier;
		this.orderNum = orderNum;
		setType(ListType.RECEIPT);
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
	public void setOrderNum(ArrayList<String> orderNum){
		this.orderNum=orderNum;
	}

	/**
	 * 对应的所有快递订单条形码号
	 * @return
	 */
	public ArrayList<String> getOrderNum(){
		return orderNum;
	}
}
