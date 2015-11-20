package businesslogicservice;

import vo.*;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface ManageblService {
    boolean addDriver(DriverVO driverVO);

    boolean delDriver(DriverVO drivervO);

    DriverVO checkDriver(String driveNumber);

    boolean addVehicle(VehicleVO vehicleVO);

    boolean delVehicle(VehicleVO vehiclevO);

    VehicleVO checkVehicle(String vehicleNumber);

    void updateSalary(String position, String Type);

    void updateConstant(ConstantVO constantVO);
}
