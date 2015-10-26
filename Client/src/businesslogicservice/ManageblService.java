package businesslogicservice;

import po.DriverPO;
import po.VehiclePO;
import vo.ConstantVO;
import vo.DriverVO;
import vo.VehicleVO;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface ManageblService {
	public DriverVO addDriver(DriverVO driverVO);
	public DriverVO delDriver(DriverPO driverPO);
	public DriverVO checkDriver(String driveNumber);
	public VehicleVO addVehicle(VehicleVO vehicleVO);
	public VehicleVO delVehicle(VehiclePO vehiclePO);
	public VehicleVO checkVehicle(String vehicleNumber);

	public void updateSalary(String position,String Type);
	public void updateConstant(ConstantVO constantVO);
}
