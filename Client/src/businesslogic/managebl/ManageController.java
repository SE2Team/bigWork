package src.businesslogic.managebl;

import src.businesslogicservice.ManageblService;
import src.vo.ConstantVO;
import src.vo.DriverVO;
import src.vo.VehicleVO;
import util.ResultMessage;

/**
 * Created by Administrator on 2015/11/4 0004.
 */
public class ManageController implements ManageblService {

    @Override
    public boolean addDriver(DriverVO driverVO) {
        return false;
    }

    @Override
    public boolean delDriver(DriverVO drivervO) {
        return false;
    }

    @Override
    public DriverVO checkDriver(String driveNumber) {
        return null;
    }

    @Override
    public boolean addVehicle(VehicleVO vehicleVO) {
        return false;
    }

    @Override
    public boolean delVehicle(VehicleVO vehiclevO) {
        return false;
    }

    @Override
    public VehicleVO checkVehicle(String vehicleNumber) {
        return null;
    }

    @Override
    public void updateSalary(String position, String Type) {

    }

    @Override
    public ResultMessage updateConstant(ConstantVO constantVO) {
        return null;
    }
}
