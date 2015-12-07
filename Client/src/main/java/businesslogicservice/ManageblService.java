package businesslogicservice;

import po.WorkerPO;
import util.ExistException;
import vo.ConstantVO;
import vo.DriverVO;
import vo.VehicleVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface ManageblService {
    boolean addDriver(DriverVO driverVO) throws RemoteException, ExistException;

    boolean delDriver(DriverVO drivervO) throws RemoteException;

    DriverVO checkDriver(String driveNumber) throws RemoteException;

    boolean addVehicle(VehicleVO vehicleVO) throws RemoteException, ExistException;

    boolean delVehicle(VehicleVO vehiclevO) throws RemoteException;

    VehicleVO checkVehicle(String vehicleNumber) throws RemoteException;

    void updateSalary(String position, String Type) throws RemoteException;

    void updateConstant(ConstantVO constantVO) throws RemoteException, ExistException;

    /**
     * 增加人员
     * @param workerPO
     * @return
     */
    boolean addWorker(WorkerPO workerPO) throws RemoteException, ExistException;

    /**
     * 删除人员
     * @param workerPO
     * @return
     */
    boolean delWorker(WorkerPO workerPO) throws RemoteException, ExistException;

    /**
     *
     * @return 所有现有人员的列表
     */
    ArrayList<WorkerPO> check() throws RemoteException;

    /**
     * 查找人员
     * @param name 人员名字
     * @return 符合条件的人员列表（可能只有一个人员的ArrayList）
     */
    ArrayList<WorkerPO> check(String name) throws RemoteException;

    /**
     * 编辑人员信息
     * @param workerPO
     * @return
     */
    boolean editWorker(WorkerPO oldWorkerPO,WorkerPO newWorkerPO) throws RemoteException, ExistException;

}
