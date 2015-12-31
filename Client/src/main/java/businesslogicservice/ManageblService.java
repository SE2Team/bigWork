package businesslogicservice;

import util.ExistException;
import vo.*;

import java.rmi.RemoteException;
import java.util.Iterator;

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

    String getSalary(String position) throws RemoteException;

    Iterator<ConstantVO> checkConstant() throws RemoteException;

    /**
     * 增加人员
     *
     * @param workerVO 传入工作人员vo
     * @return
     */
    boolean addWorker(WorkerVO workerVO) throws RemoteException, ExistException;

    /**
     * 删除人员
     *
     * @param workerVO 传入工作人员vo
     * @return
     */
    boolean delWorker(WorkerVO workerVO) throws RemoteException, ExistException;

    /**
     * @return 所有现有人员的列表
     */
    Iterator<WorkerVO> checkWorker() throws RemoteException;

    /**
     * 查找人员
     *
     * @param name 人员名字
     * @return 符合条件的人员列表（可能只有一个人员的ArrayList）
     */
    Iterator<WorkerVO> checkWorker(String name) throws RemoteException;

    /**
     * 编辑人员信息
     *
     * @param oldWorkerVO 传入旧的工作人员vo
     * @param newWorkerVO 传入新的工作人员vo
     * @return
     */
    boolean editWorker(WorkerVO oldWorkerVO, WorkerVO newWorkerVO) throws RemoteException, ExistException;

    boolean editDriver(DriverVO ovo, DriverVO nvo) throws RemoteException, ExistException;

    boolean editVehicle(VehicleVO ovo, VehicleVO nvo) throws RemoteException, ExistException;

    Iterator<DriverVO> checkDriver() throws RemoteException;
    Iterator<VehicleVO> checkVehicle() throws RemoteException;

    Iterator<OrganizationVO> checkOrganization() throws RemoteException;

    boolean addOrganization(OrganizationVO vo) throws RemoteException, ExistException;

    boolean delOrganization(OrganizationVO vo) throws RemoteException, ExistException;


}
