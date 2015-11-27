package po;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class AddresseeInformationPO extends ListPO implements Serializable {
	//收件单号，收件人，收件时间。
	private static final long serialVersionUID = 1L;//序列化ID
	private String addresseeNum;
	private String addresseeName;
	private String addresseeDate;
	
	/**
	 * 
	 * @param addresseeNum
	 * @param addresseeName
	 * @param addresseeDate
	 */
	public  AddresseeInformationPO(String addresseeNum,String 
			addresseeName,String addresseeDate) {
		this.addresseeNum=addresseeNum;
		this.addresseeName=addresseeName;
		this.addresseeDate=addresseeDate;
	}
	
	/**
	 * 
	 * @return 收件单号
	 */
	public String getAddresseeNum(){
		return addresseeNum;
	}
	
	/**
	 * 
	 * @param
	 */
	public void setAddresseeNum(String addresseeNum){
		this.addresseeNum=addresseeNum;
	}
	
	/**
	 * 
	 * @return 收件人
	 */
	public String getAddresseeName(){
		return addresseeName;
	}
	
	/**
	 * 
	 * @param
	 */
	public void setAddresseeName(String addresseeName){
		this.addresseeName=addresseeName;
	}
	
	/**
	 * 
	 * @return 收件日期
	 */
	public String getAddresseeDate(){
		return addresseeDate;
	}
	
	/**
	 * 
	 * @param
	 */
	public void setAddresseeDate(String addresseeDate){
		this.addresseeDate=addresseeDate;
	}

	@Override
	public String getClassName() {
		return "Addressee";
	}


}
