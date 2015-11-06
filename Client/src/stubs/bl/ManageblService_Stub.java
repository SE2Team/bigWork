package src.stubs.bl;

import src.businesslogicservice.ManageblService;
import src.vo.ConstantVO;
import src.vo.DriverVO;
import src.vo.VehicleVO;

public class ManageblService_Stub implements ManageblService {


    public ManageblService_Stub() {

    }

    public boolean addDriver(DriverVO driverVO) {
        // TODO Auto-generated method stub
        return true;
    }


    public DriverVO checkDriver(String driveNumber) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean addVehicle(VehicleVO vehicleVO) {
        // TODO Auto-generated method stub
        return true;
    }


    public VehicleVO checkVehicle(String vehicleNumber) {
        // TODO Auto-generated method stub
        return null;
    }

    public void updateSalary(String position, String Type) {
        // TODO Auto-generated method stub
    }

    public void updateConstant(ConstantVO constantVO) {
        // TODO Auto-generated method stub
    }

    public boolean delDriver(DriverVO drivervO) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean delVehicle(VehicleVO vehiclevO) {
        // TODO Auto-generated method stub
        return false;
    }

}
