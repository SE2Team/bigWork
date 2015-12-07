package dataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.*;
import util.ExistException;
import util.ResultMessage;

public interface ManageDataService extends Remote{
    public Boolean addDriver(DriverPO driverPO) throws RemoteException, ExistException;

    public Boolean  deleteDriver(DriverPO po) throws RemoteException;

    public DriverPO checkDriver(String driveNumber) throws RemoteException;

    public Boolean  addVehicle(VehiclePO vehiclePO) throws RemoteException, ExistException;

    public Boolean  deleteVehicle(VehiclePO po) throws RemoteException;

    public VehiclePO checkVehicle(String vehicleNumber) throws RemoteException;

    public Boolean updateSalary(String position, String Type) throws RemoteException;

    public Boolean updateConstant(ConstantPO constantPO) throws RemoteException, ExistException;
    
    public String[] getSalary() throws RemoteException;
    
    public ConstantPO getConstant() throws RemoteException;
  

    /**
     * 增加人员
     * @param workerPO
     * @return
     * @throws ExistException 
     */
    boolean addWorker(WorkerPO workerPO) throws RemoteException, ExistException;

    /**
     * 删除人员
     * @param workerPO
     * @return
     * @throws ExistException 
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
     * @throws ExistException 
     */
    boolean editWorker(WorkerPO oldWorkerPO,WorkerPO newWorkerPO) throws RemoteException, ExistException; 


}
