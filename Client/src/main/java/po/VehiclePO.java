package po;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class VehiclePO implements Serializable{
	private static final long serialVersionUID = 1L;//序列化编号
	//车辆代号、车牌号、购买时间、服役时间
	
	private String vehicleNum;
	private String licensePlate;
	private String buyDate;
	private String useTime;
	
	/**
	 * 
	 * @param vehicleNum
	 * @param licensePlate
	 * @param buyDate
	 * @param useTime
	 */
	public VehiclePO(String vehicleNum,String licensePlate,
					String buyDate, String useTime){
		this.vehicleNum=vehicleNum;
		this.licensePlate=licensePlate;
		this.buyDate=buyDate;
		this.useTime=useTime;
	}
	
	/**
	 * 车辆代号
	 * @param vehicleNum
	 */
	public void setVehicleNum(String vehicleNum){
		this.vehicleNum=vehicleNum;
	}
	
	/**
	 * 车辆代号
	 * @return
	 */
	public String getVehicleNum(){
		return vehicleNum;
	}
	
	/**
	 * 车牌号
	 * @param licensePlate
	 */
	public void setLicensePlate(String licensePlate){
		this.licensePlate=licensePlate;
	}
	
	/**
	 * 车牌号
	 * @return
	 */
	public String getLicensePlate(){
		return licensePlate;
	}
	
	/**
	 * 购买时间
	 * @param buyDate
	 */
	public void setBuyDate(String buyDate){
		this.buyDate=buyDate;
	}
	
	/**
	 *购买时间
	 * @return
	 */
	public String getBuyDate(){
		return buyDate;
	}
	
	/**
	 * 服役时间
	 * @param useTime
	 */
	public void setUsetime(String useTime){
		this.useTime=useTime;
	}
	
	/**
	 * 服役时间
	 * @return
	 */
	public String getUseTime(){
		return useTime;
	}
}
