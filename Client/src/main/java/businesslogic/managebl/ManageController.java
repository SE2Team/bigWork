package businesslogic.managebl;

import businesslogicservice.ManageblService;
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
public class ManageController implements ManageblService {
    /**
     * The Manage.
     */
    Manage manage;

    /**
     * Instantiates a new Manage controller.
     *
     * @throws RemoteException the remote exception
     */
    public ManageController() throws RemoteException {
        manage = new Manage();
    }

    public boolean addDriver(DriverVO driverVO) throws RemoteException, ExistException {
        return manage.addDriver(driverVO);
    }

    public ResultMessage delDriver(DriverVO drivervO) throws RemoteException {
        return manage.delDriver(drivervO);
    }

    public DriverVO checkDriver(String driveNumber) throws RemoteException {
        return manage.checkDriver(driveNumber);
    }

    public ResultMessage addVehicle(VehicleVO vehicleVO) throws RemoteException, ExistException {
        return manage.addVehicle(vehicleVO);
    }

    public ResultMessage delVehicle(VehicleVO vehiclevO) throws RemoteException {
        return manage.delVehicle(vehiclevO);
    }

    public VehicleVO checkVehicle(String vehicleNumber) throws RemoteException {
        return manage.checkVehicle(vehicleNumber);
    }

    public void updateSalary(String position, String Type) throws RemoteException {
        manage.updateSalary(position, Type);
    }

    public void updateConstant(ConstantVO constantVO) throws RemoteException {
        manage.updateConstant(constantVO);
    }
}
