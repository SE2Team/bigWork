package vo;

public class VehicleVO {
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
	public VehicleVO(String vehicleNum,String licensePlate,
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
