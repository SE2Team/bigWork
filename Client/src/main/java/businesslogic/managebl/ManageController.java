package businesslogic.managebl;

import businesslogicservice.ManageblService;
import po.WorkerPO;
import util.ExistException;
import vo.ConstantVO;
import vo.DriverVO;
import vo.VehicleVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/7 0007.
 *
 * @author myk
 */
public class ManageController implements ManageblService {
    /**
     * The Manage.
     */
    private Manage manage;

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

    public boolean delDriver(DriverVO drivervO) throws RemoteException {
        return manage.delDriver(drivervO);
    }

    public DriverVO checkDriver(String driveNumber) throws RemoteException {
        return manage.checkDriver(driveNumber);
    }

    public boolean addVehicle(VehicleVO vehicleVO) throws RemoteException, ExistException {
        return manage.addVehicle(vehicleVO);
    }

    public boolean delVehicle(VehicleVO vehiclevO) throws RemoteException {
        return manage.delVehicle(vehiclevO);
    }

    public VehicleVO checkVehicle(String vehicleNumber) throws RemoteException {
        return manage.checkVehicle(vehicleNumber);
    }

    public void updateSalary(String position, String Type) throws RemoteException {
        manage.updateSalary(position,Type);
    }

    public void updateConstant(ConstantVO constantVO) throws RemoteException, ExistException {
        manage.updateConstant(constantVO);
    }

    public boolean addWorker(WorkerPO workerPO) throws RemoteException, ExistException {
        return manage.addWorker(workerPO);
    }

    public boolean delWorker(WorkerPO workerPO) throws RemoteException, ExistException {
        return manage.delWorker(workerPO);
    }

    public ArrayList<WorkerPO> checkWorker() throws RemoteException {
        return manage.checkWorker();
    }

    public ArrayList<WorkerPO> checkWorker(String name) throws RemoteException {
        return manage.checkWorker(name);
    }

    public boolean editWorker(WorkerPO oldWorkerPO,WorkerPO newWorkerPO) throws RemoteException, ExistException {
        return manage.editWorker(oldWorkerPO,newWorkerPO);
    }

}
