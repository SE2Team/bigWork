package data.managedata;

import dataservice.managedataservice.ManageDataService;
import po.ConstantPO;
import po.DriverPO;
import po.VehiclePO;

/**
 * Created by MYK on 2015/11/23 0023.
 */
public class ManagedataImpl implements ManageDataService{
    public boolean addDriver(DriverPO driverPO) {
        return false;
    }

    public boolean deleteDriver(DriverPO po) {
        return false;
    }

    public DriverPO checkDriver(String driveNumber) {
        return null;
    }

    public boolean addVehicle(VehiclePO vehiclePO) {
        return false;
    }

    public boolean deleteVehicle(VehiclePO po) {
        return false;
    }

    public VehiclePO checkVehicle(String vehicleNumber) {
        return null;
    }

    public void updateSalary(String position, String Type) {

    }

    public void updateConstant(ConstantPO constantPO) {

    }
}
