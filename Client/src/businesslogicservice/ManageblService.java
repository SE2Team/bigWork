package businesslogicservice;

import enumClass.City;
import po.DriverPO;
import po.VehiclePO;
import vo.*;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface ManageblService {
	public DriverVO addDriver(String driverNumber,String name,String birthYear,String birthMonth,String birthDay,String telephingNumber,String vehicleNumber,String gender,String timeLimit);
	public DriverVO delDriver(DriverPO driverPO);
	public DriverVO checkDriver(String driveNumber);
	public VehicleVO addVehicle(String vehicleCode,String engineNumber,String vehicleNumber,String buyTime,String periodOfValidity);
	public VehicleVO delVehicle(VehiclePO vehiclePO);
	public VehicleVO checkVehicle(String vehicleNumber);

	public void updateSalary(String position,String Type);
	public void updateConstant(String start,String end,double price,double distance);
}
