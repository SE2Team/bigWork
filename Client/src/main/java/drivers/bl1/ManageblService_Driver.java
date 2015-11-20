package drivers.bl1;

import businesslogicservice.ManageblService;
import vo.ConstantVO;
import vo.DriverVO;
import vo.VehicleVO;

public class ManageblService_Driver {
    DriverVO driverVO;
    String driveNumber;
    VehicleVO vehicleVO;
    String vehicleNumber;
    String position;
    String Type;
    ConstantVO constantVO;

    public void driver(ManageblService manageblService) {
        boolean isAddDriver = manageblService.addDriver(driverVO);
        if (isAddDriver == true) {
            System.out.println("Success!");
        }

        boolean isDelDriver = manageblService.delDriver(driverVO);
        if (isDelDriver == true) {
            System.out.println("Success!");
        }

        DriverVO isCheckDriver = manageblService.checkDriver(driveNumber);
        if (isCheckDriver == driverVO) {
            System.out.println("Success!");
        }

        boolean isAddVehicle = manageblService.addVehicle(vehicleVO);
        if (isAddVehicle == true) {
            System.out.println("Success!");
        }

        boolean isDelVehicle = manageblService.delVehicle(vehicleVO);
        if (isDelVehicle == true) {
            System.out.println("Success!");
        }

        VehicleVO isCheckVehicle = manageblService.checkVehicle(vehicleNumber);
        if (isCheckVehicle == vehicleVO) {
            System.out.println("Success!");
        }

    }
}
