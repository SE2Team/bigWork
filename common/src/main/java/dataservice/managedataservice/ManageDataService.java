package dataservice.managedataservice;

import po.*;
import util.ExistException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ManageDataService extends Remote {

    /**
     * @param driverPO
     * @return
     * @throws RemoteException
     * @throws ExistException
     */
    Boolean addDriver(DriverPO driverPO) throws RemoteException, ExistException;

    /**
     * @param po
     * @return
     * @throws RemoteException
     */
    Boolean deleteDriver(DriverPO po) throws RemoteException;

    /**
     * @param driveNumber
     * @return
     * @throws RemoteException
     */
    DriverPO checkDriver(String driveNumber) throws RemoteException;

    /**
     * @return
     * @throws RemoteException
     */
    ArrayList<DriverPO> checkDriver() throws RemoteException;

    /**
     * @param vehiclePO
     * @return
     * @throws RemoteException
     * @throws ExistException
     */
    Boolean addVehicle(VehiclePO vehiclePO) throws RemoteException, ExistException;

    /**
     * @param po
     * @return
     * @throws RemoteException
     */
    Boolean deleteVehicle(VehiclePO po) throws RemoteException;

    /**
     * @param vehicleNumber
     * @return
     * @throws RemoteException
     */
    VehiclePO checkVehicle(String vehicleNumber) throws RemoteException;

    /**
     * @return
     * @throws RemoteException
     */
    ArrayList<VehiclePO> checkVehicle() throws RemoteException;

    /**
     * @param position
     * @param Type
     * @return
     * @throws RemoteException
     */
    Boolean updateSalary(String position, String Type) throws RemoteException;

    /**
     * @param constantPO
     * @return
     * @throws RemoteException
     * @throws ExistException
     */
    Boolean updateConstant(ConstantPO constantPO) throws RemoteException, ExistException;

    /**
     * @return
     * @throws RemoteException
     */
    String getSalary(String position) throws RemoteException;

    /**
     * @return
     * @throws RemoteException
     */
    ArrayList<ConstantPO> getConstant() throws RemoteException;


    /**
     * 增加人员
     *
     * @param workerPO
     * @return
     * @throws ExistException
     */
    boolean addWorker(WorkerPO workerPO) throws RemoteException, ExistException;

    /**
     * 删除人员
     *
     * @param workerPO
     * @return
     * @throws ExistException
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


    boolean editWorker(WorkerPO oldWorkerPO, WorkerPO newWorkerPO) throws RemoteException, ExistException;


    boolean editVehicle(VehiclePO oldVehiclePO, VehiclePO newVehiclePO) throws RemoteException, ExistException;

    boolean editDriver(DriverPO oldDriverPO, DriverPO newDriverPO) throws RemoteException, ExistException;

    boolean addOrganization(OrganizationPO po) throws RemoteException, ExistException;

    boolean delOrganization(OrganizationPO po) throws RemoteException, ExistException;

    boolean editOrganization(OrganizationPO oldPO, OrganizationPO newPO) throws RemoteException, ExistException;

    ArrayList<OrganizationPO> check() throws RemoteException;

    OrganizationPO check(String num) throws RemoteException;


}
