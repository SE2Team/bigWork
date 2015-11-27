package businesslogic.managebl;

import businesslogicservice.ManageblService;
import vo.ConstantVO;
import vo.DriverVO;
import vo.VehicleVO;

/**
 * Created by Administrator on 2015/11/7 0007.
 */
public class ManageController implements ManageblService {
    Manage manage=new Manage();
    public boolean addDriver(DriverVO driverVO) {
        return manage.addDriver(driverVO);
    }

    public boolean delDriver(DriverVO drivervO) {
        return manage.delDriver(drivervO);
    }

    public DriverVO checkDriver(String driveNumber) {
        return manage.checkDriver(driveNumber);
    }

    public boolean addVehicle(VehicleVO vehicleVO) {
        return manage.addVehicle(vehicleVO);
    }

    public boolean delVehicle(VehicleVO vehiclevO) {
        return manage.delVehicle(vehiclevO);
    }

    public VehicleVO checkVehicle(String vehicleNumber) {
        return manage.checkVehicle(vehicleNumber);
    }

    public void updateSalary(String position, String Type) {
        manage.updateSalary(position,Type);
    }

    public void updateConstant(ConstantVO constantVO) {
        manage.updateConstant(constantVO);
    }
}
