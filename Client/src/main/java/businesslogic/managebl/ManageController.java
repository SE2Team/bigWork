package businesslogic.managebl;

import businesslogicservice.ManageblService;
import vo.ConstantVO;
import vo.DriverVO;
import vo.VehicleVO;

/**
 * Created by Administrator on 2015/11/7 0007.
 */
public class ManageController implements ManageblService {
    public boolean addDriver(DriverVO driverVO) {
        return false;
    }

    public boolean delDriver(DriverVO drivervO) {
        return false;
    }

    public DriverVO checkDriver(String driveNumber) {
        return null;
    }

    public boolean addVehicle(VehicleVO vehicleVO) {
        return false;
    }

    public boolean delVehicle(VehicleVO vehiclevO) {
        return false;
    }

    public VehicleVO checkVehicle(String vehicleNumber) {
        return null;
    }

    public void updateSalary(String position, String Type) {

    }

    public void updateConstant(ConstantVO constantVO) {

    }
}
