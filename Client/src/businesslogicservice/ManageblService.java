package src.businesslogicservice;

import src.vo.*;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface ManageblService {
	public boolean addDriver(DriverVO driverVO);
	public boolean delDriver(DriverVO drivervO);
	public DriverVO checkDriver(String driveNumber);
	public boolean addVehicle(VehicleVO vehicleVO);
	public boolean delVehicle(VehicleVO vehiclevO);
	public VehicleVO checkVehicle(String vehicleNumber);

	public void updateSalary(String position,String Type);
	public void updateConstant(ConstantVO constantVO);
}
