package po;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class TransferPO extends ListPO implements Serializable{
	private static final long serialVersionUID = 1L;//序列化编号
	
	/**
	 * 装运方式，装运日期、本中转中心航运编号（火车为货运编号，汽车为汽运编号）、航班号（火车和汽车为车次号）、
	 * 出发地、到达地、货柜号
	 * （火车为车厢号）、监装员、押运员（仅汽运有）、本次装箱所有托运单号、运费。
	 */
	
	private String loadingWay;
	private String loadingDate;
	private String transportNum;
	private String vehicleNum;
	private String start;
	private String end;
	private String containerNum;
	private String monitor;
	private String supercargo;
	private String orderNum;
	private String money;
	
	/**
	 * 
	 * @param loadingWay
	 * @param loadingDate
	 * @param transportNum
	 * @param vehicleNum
	 * @param start
	 * @param end
	 * @param containerNum
	 * @param monitor
	 * @param supercargo
	 * @param orderNum
	 * @param money
	 */
	public TransferPO(String loadingWay,String loadingDate, 
			String transportNum, String vehicleNum, String start,
			String end, String containerNum, String monitor,
			String supercargo, String orderNum,String money){
		
		this.loadingWay=loadingWay;
		this.loadingDate=loadingDate;
		this.transportNum=transportNum;
		this.vehicleNum=vehicleNum;
		this.start=start;
		this.end=end;
		this.containerNum=containerNum;
		this.monitor=monitor;
		this.supercargo=supercargo;
		this.orderNum=orderNum;
		this.money=money;
	}
	
	public void setLoadingWay(String loadingWay){
		this.loadingWay=loadingWay;
	}
	
	public String getLoadingWay(){
		return loadingWay;
	}
	
	public void setloadingDate(String loadingDate){
		this.loadingDate=loadingDate;
	}
	
	public String getLoadingDate(){
		return loadingDate;
	}
	
	public void setTransportNum(String transportNum){
		this.transportNum=transportNum;
	}
	
	public String getTransportNum(){
		return transportNum;
	}
	
	public void setVehicleNum(String vehicleNum){
		this.vehicleNum=vehicleNum;
	}
	
	public String getVehicleNum(){
		return vehicleNum;
	}
	
	public void setStart(String start){
		this.start=start;
	}
	
	public String getStart(){
		return start;
	}
	
	public void setEnd(String end){
		this.end=end;
	}
	
	public String getEnd(){
		return end;
	}
	
	public void setContainerNum(String containerNum){
		this.containerNum=containerNum;
	}
	
	public String getContainerNum(){
		return containerNum;
	}
	
	public void setMonitor(String monitor){
		this.monitor=monitor;
	}
	
	public String getMonitor(){
		return monitor;
	}
	
	public void setSupercargo(String supercargo){
		this.supercargo=supercargo;
	}
	
	public String getSupercargo(){
		return supercargo;
	}
	
	public void setOrderNum(String orderNum){
		this.orderNum=orderNum;
	}
	
	public String getOrderNum(){
		return orderNum;
	}
	
	public void setMoney(String money){
		this.money=money;
	}
	
	public String getMoney(){
		return money;
	}




}
