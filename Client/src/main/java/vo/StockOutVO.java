package vo;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class StockOutVO extends ListVO {
	
	/**
	 * 
	 * 快递编号、出库日期、目的地、装运形式（火车、飞机、汽车）、中转单编号
	 */
	private String deliveryNum;
	private String outDate;
	private String end;
	private String loadingWay;
	private String transferNum;
	
	
	/**
	 * 
	 * @param deliveryNum
	 * @param outDate
	 * @param end
	 * @param loadingWay
	 * @param transferNum
	 */
	public StockOutVO(String deliveryNum, String outDate,
			String end,String loadingWay,String transferNum){
		this.deliveryNum=deliveryNum;
		this.outDate=outDate;
		this.end=end;
		this.loadingWay=loadingWay;
		this.transferNum=transferNum;
	}
	
	public StockOutVO(){}
	
	public void setDeliveryNum(String deliveryNum){
		this.deliveryNum=deliveryNum;
	}
	
	public String getDeliveryNum(){
		return deliveryNum;
	}
	
	public void setOutdate(String outDate){
		this.outDate=outDate;
	}
	
	public String getOutDate(){
		return outDate;
	}
	
	public void setEnd(String end){
		this.end=end;
	}
	
	public String getEnd(){
		return end;
	}
	
	public void setLoadingWay(String loadingWay){
		this.loadingWay=loadingWay;
	}
	
	public String getLoadingWay(){
		return loadingWay;
	}
	
	public void setTransferNum(String transferNum){
		this.transferNum=transferNum;
	}
	
	public String getTransferNum(){
		return transferNum;
	}
}
