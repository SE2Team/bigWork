package businesslogic.managebl;

import data.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.managedataservice.ManageDataService;
import po.ConstantPO;
import po.DriverPO;
import po.VehiclePO;
import vo.ConstantVO;
import vo.DriverVO;
import vo.VehicleVO;

/**
 * Created by Administrator on 2015/11/7 0007.
 */
public class Manage {
    DataFactoryService dataFactory=new DataFactory();
    ManageDataService manage=dataFactory.getManageData();
    public boolean addDriver(DriverVO driverVO) {
        DriverPO po=new DriverPO(driverVO.getDriverNum(),driverVO.getDriverName(),driverVO.getBirthDate(),driverVO.getIdNum(),
                driverVO.getPhone(),driverVO.getVehicleInstitution(),driverVO.getSex(),driverVO.getLicenseTime());
        manage.addDriver(po);
        return true;
    }

    public boolean delDriver(DriverVO driverVO) {
        //判断
        //……
        
        return manage.deleteDriver(convert(driverVO));
    }

    public DriverVO checkDriver(String driveNumber) {
        //判断
        //……
        
        return convert(manage.checkDriver(driveNumber));
    }

    public boolean addVehicle(VehicleVO vehicleVO) {
        return manage.addVehicle(convert(vehicleVO));
    }

    public boolean delVehicle(VehicleVO vehiclevO) {
        return manage.deleteVehicle(convert(vehiclevO));
    }

    public VehicleVO checkVehicle(String vehicleNumber) {
        return convert(manage.checkVehicle(vehicleNumber));
    }

    public void updateSalary(String position, String Type) {
        manage.updateSalary(position,Type);
    }

    public void updateConstant(ConstantVO constantVO) {

        ConstantPO po=new ConstantPO(constantVO.getCity1(),constantVO.getCity2(),constantVO.getPrice(),constantVO.getDistance());

        manage.updateConstant(po);
    }

    /**
     * 私有vo和po之间转换的方法
     * @param driverVO
     * @return
     */
    private DriverPO convert(DriverVO driverVO){
        return new DriverPO(driverVO.getDriverNum(),driverVO.getDriverName(),driverVO.getBirthDate(),driverVO.getIdNum(),
                driverVO.getPhone(),driverVO.getVehicleInstitution(),driverVO.getSex(),driverVO.getLicenseTime());
    }
    
    private DriverVO convert(DriverPO driverPO){
        return new DriverVO(driverPO.getDriverNum(),driverPO.getDriverName(),driverPO.getBirthDate(),driverPO.getIdNum(),
                driverPO.getPhone(),driverPO.getVehicleInstitution(),driverPO.getSex(),driverPO.getLicenseTime());
    }
    
    private VehicleVO convert(VehiclePO vehiclePO){
        return new VehicleVO(vehiclePO.getVehicleNum(),vehiclePO.getLicensePlate(),vehiclePO.getBuyDate(),vehiclePO.getUseTime());
    }

    private VehiclePO convert(VehicleVO vehicleVO){
        return new VehiclePO(vehicleVO.getVehicleNum(),vehicleVO.getLicensePlate(),vehicleVO.getBuyDate(),vehicleVO.getUseTime());
    }
}
