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
    /**
     * @param driverVO 传入司机vo
     * @return
     * @throws RemoteException 网络异常
     * @throws ExistException  异常，司机已存在，无法添加
     */
    boolean addDriver(DriverVO driverVO) throws RemoteException, ExistException;

    /**
     * @param drivervO 传入司机vo
     * @return
     * @throws RemoteException 网络异常
     */
    boolean delDriver(DriverVO drivervO) throws RemoteException;

    /**
     * @param driveNumber 传入司机编号
     * @return 返回司机vo
     * @throws RemoteException 网络异常
     */
    DriverVO checkDriver(String driveNumber) throws RemoteException;

    /**
     * @param vehicleVO 传入车辆vo
     * @return
     * @throws RemoteException 网络异常
     * @throws ExistException  异常，车辆以存在，无法添加
     */
    boolean addVehicle(VehicleVO vehicleVO) throws RemoteException, ExistException;

    /**
     * @param vehiclevO 传入车辆vo
     * @return
     * @throws RemoteException 网络异常
     */
    boolean delVehicle(VehicleVO vehiclevO) throws RemoteException;

    /**
     * @param vehicleNumber 传入车辆编号
     * @return 返回车辆vo
     * @throws RemoteException 网络异常
     */
    VehicleVO checkVehicle(String vehicleNumber) throws RemoteException;

    /**
     * @param position 传入职位
     * @param Type     传入工资类型
     * @throws RemoteException 网络异常
     */
    void updateSalary(String position, String Type) throws RemoteException;

    /**
     * @param constantVO 传入城市vo
     * @throws RemoteException 网络异常
     * @throws ExistException  异常，城市不存在，无法更新
     */
    void updateConstant(ConstantVO constantVO) throws RemoteException, ExistException;

    /**
     * 增加人员
     *
     * @param workerPO 传入工作人员vo
     * @return
     */
    boolean addWorker(WorkerPO workerPO) throws RemoteException, ExistException;

    /**
     * 删除人员
     *
     * @param workerPO 传入工作人员vo
     * @return
     */
    boolean delWorker(WorkerPO workerPO) throws RemoteException, ExistException;

    /**
     * @return 所有现有人员的列表
     */
    ArrayList<WorkerPO> checkWorker() throws RemoteException;

    /**
     * 查找人员
     *
     * @param name 人员名字
     * @return 符合条件的人员列表（可能只有一个人员的ArrayList）
     */
    ArrayList<WorkerPO> checkWorker(String name) throws RemoteException;

    /**
     * 编辑人员信息
     *
     * @param oldWorkerPO 传入旧的工作人员vo
     * @param newWorkerPO 传入新的工作人员vo
     * @return
     */
    boolean editWorker(WorkerPO oldWorkerPO, WorkerPO newWorkerPO) throws RemoteException, ExistException;

}
