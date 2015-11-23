package vo;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public class LogisticsVO extends ListVO{
	
	/**
	 * 
	 * 快递编号，货运状态
	 */
	
	private String deliveryNum;
	private String transportState;
	
	public LogisticsVO(String deliveryNum,String transportState){
		this.deliveryNum=deliveryNum;
		this.transportState=transportState;
	}
	
	public LogisticsVO(){};
	
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
