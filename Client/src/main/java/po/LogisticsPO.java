package po;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class LogisticsPO extends ListPO implements Serializable{
	private static final long serialVersionUID = 1L;// 序列化编号
	
	/**
	 * 
	 * 快递编号，货运状态
	 */
	
	private String deliveryNum;
	private String transportState;
	
	public LogisticsPO(String deliveryNum,String transportState){
		this.deliveryNum=deliveryNum;
		this.transportState=transportState;
	}
	
	public void setDeliveryNum(String deliveryNum){
		this.deliveryNum=deliveryNum;
	}
	
	public String getDeliveryNum(){
		return deliveryNum;
	}
	
	public void setTransportState(String transportState){
		this.transportState=transportState;
	}
	
	public String getTransportState(){
		return transportState;
	}
	
	

}
