package src.drivers.data1;


import src.dataservice.managedataservice.ManageDataService;
import src.po.*;


public class ManageDataService_Driver {
	DriverPO driverPO;
	String driveNumber;
	VehiclePO vehiclePO;
	String vehicleNumber;

		public void drive(ManageDataService manageDataService){
			boolean isAddDriver=manageDataService.addDriver(driverPO);
			if(isAddDriver==true){
				System.out.println("Success!");
			}
			
			boolean isDelDriver=manageDataService.deleteDriver(driverPO);
			if(isDelDriver==true){
				System.out.println("Success!");
			}
			
			DriverPO isCheckDriver=manageDataService.checkDriver(driveNumber);
			if(isCheckDriver==driverPO){
				System.out.println("Success!");
			}
			
			boolean isAddVehicle=manageDataService.addVehicle(vehiclePO);
			if(isAddVehicle==true){
				System.out.println("Success!");
			}
			
			boolean isDelVehicle=manageDataService.deleteVehicle(vehiclePO);
			if(isDelVehicle==true){
				System.out.println("Success!");
			}
			
			VehiclePO isCheckVehicle=manageDataService.checkVehicle(vehicleNumber);
			if(isCheckVehicle==vehiclePO){
				System.out.println("Success!");
			}
		}
}
