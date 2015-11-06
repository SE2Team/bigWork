package src.dataservice.managedataservice;

import src.po.ConstantPO;
import src.po.DriverPO;
import src.po.VehiclePO;

public interface ManageDataService {
    public boolean addDriver(DriverPO driverPO);

    public boolean deleteDriver(DriverPO po);

    public DriverPO checkDriver(String driveNumber);

    public boolean addVehicle(VehiclePO vehiclePO);

    public boolean deleteVehicle(VehiclePO po);

    public VehiclePO checkVehicle(String vehicleNumber);

    public void updateSalary(String position, String Type);

    public void updateConstant(ConstantPO constantPO);
}
