package businesslogic.managebl;

import dataservice.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.managedataservice.ManageDataService;
import po.ConstantPO;
import po.DriverPO;
import po.VehiclePO;
import util.ExistException;
import util.ResultMessage;
import vo.ConstantVO;
import vo.DriverVO;
import vo.VehicleVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/7 0007.
 *
 * @author myk
 */
public class Manage {
    /**
     * The Data factory.
     */
    DataFactoryService dataFactory;
    /**
     * The Manage.
     */
    ManageDataService manage;

    /**
     * Instantiates a new Manage.
     *
     * @throws RemoteException the remote exception
     */
    public Manage() throws RemoteException {
        dataFactory = DataFactory.getInstance();
        manage = dataFactory.getManageData();
    }

    /**
     * Add driver boolean.
     *
     * @param driverVO the driver vo
     * @return the boolean
     * @throws RemoteException the remote exception
     * @throws ExistException  the exist exception
     */
    public boolean addDriver(DriverVO driverVO) throws RemoteException, ExistException {
        DriverPO po = new DriverPO(driverVO.getDriverNum(), driverVO.getDriverName(), driverVO.getBirthDate(), driverVO.getIdNum(),
                driverVO.getPhone(), driverVO.getVehicleInstitution(), driverVO.getSex(), driverVO.getLicenseTime());
        manage.addDriver(po);
        return true;
    }

    /**
     * Del driver result message.
     *
     * @param driverVO the driver vo
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public ResultMessage delDriver(DriverVO driverVO) throws RemoteException {
        //判断
        //……

        return manage.deleteDriver(convert(driverVO));
    }

    /**
     * Check driver driver vo.
     *
     * @param driveNumber the drive number
     * @return the driver vo
     * @throws RemoteException the remote exception
     */
    public DriverVO checkDriver(String driveNumber) throws RemoteException {
        //判断
        //……

        return convert(manage.checkDriver(driveNumber));
    }

    /**
     * Add vehicle result message.
     *
     * @param vehicleVO the vehicle vo
     * @return the result message
     * @throws RemoteException the remote exception
     * @throws ExistException  the exist exception
     */
    public ResultMessage addVehicle(VehicleVO vehicleVO) throws RemoteException, ExistException {
        return manage.addVehicle(convert(vehicleVO));
    }

    /**
     * Del vehicle result message.
     *
     * @param vehiclevO the vehiclev o
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public ResultMessage delVehicle(VehicleVO vehiclevO) throws RemoteException {
        return manage.deleteVehicle(convert(vehiclevO));
    }

    /**
     * Check vehicle vehicle vo.
     *
     * @param vehicleNumber the vehicle number
     * @return the vehicle vo
     * @throws RemoteException the remote exception
     */
    public VehicleVO checkVehicle(String vehicleNumber) throws RemoteException {
        return convert(manage.checkVehicle(vehicleNumber));
    }

    /**
     * Update salary.
     *
     * @param position the position
     * @param Type     the type
     * @throws RemoteException the remote exception
     */
    public void updateSalary(String position, String Type) throws RemoteException {
        manage.updateSalary(position, Type);
    }

    /**
     * Update constant.
     *
     * @param constantVO the constant vo
     * @throws RemoteException the remote exception
     */
    public void updateConstant(ConstantVO constantVO) throws RemoteException {

        ConstantPO po = new ConstantPO(constantVO.getCity1(), constantVO.getCity2(), constantVO.getPrice(), constantVO.getDistance());

        manage.updateConstant(po);
    }

    /**
     * 私有vo和po之间转换的方法
     *
     * @param driverVO
     * @return
     */
    private DriverPO convert(DriverVO driverVO) {
        return new DriverPO(driverVO.getDriverNum(), driverVO.getDriverName(), driverVO.getBirthDate(), driverVO.getIdNum(),
                driverVO.getPhone(), driverVO.getVehicleInstitution(), driverVO.getSex(), driverVO.getLicenseTime());
    }

    private DriverVO convert(DriverPO driverPO) {
        return new DriverVO(driverPO.getDriverNum(), driverPO.getDriverName(), driverPO.getBirthDate(), driverPO.getIdNum(),
                driverPO.getPhone(), driverPO.getVehicleInstitution(), driverPO.getSex(), driverPO.getLicenseTime());
    }

    private VehicleVO convert(VehiclePO vehiclePO) {
        return new VehicleVO(vehiclePO.getVehicleNum(), vehiclePO.getLicensePlate(), vehiclePO.getBuyDate(), vehiclePO.getUseTime());
    }

    private VehiclePO convert(VehicleVO vehicleVO) {
        return new VehiclePO(vehicleVO.getVehicleNum(), vehicleVO.getLicensePlate(), vehicleVO.getBuyDate(), vehicleVO.getUseTime());
    }
}
