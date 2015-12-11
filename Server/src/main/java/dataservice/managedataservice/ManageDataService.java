package dataservice.managedataservice;

import po.ConstantPO;
import po.DriverPO;
import po.VehiclePO;
import po.WorkerPO;
import util.ExistException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Iterator;

public interface ManageDataService extends Remote{
	
	/**
	 * 
	 * @param driverPO
	 * @return
	 * @throws RemoteException
	 * @throws ExistException
	 */
     Boolean addDriver(DriverPO driverPO) throws RemoteException, ExistException;
     
     /**
      * 
      * @param po
      * @return
      * @throws RemoteException
      */
     Boolean  deleteDriver(DriverPO po) throws RemoteException;

     /**
      * 
      * @param driveNumber
      * @return
      * @throws RemoteException
      */
     DriverPO checkDriver(String driveNumber) throws RemoteException;
     
     /**
      * 
      * @return
      * @throws RemoteException
      */
     Iterator<DriverPO> checkDriver() throws RemoteException;
     
     /**
      * 
      * @param vehiclePO
      * @return
      * @throws RemoteException
      * @throws ExistException
      */
     Boolean  addVehicle(VehiclePO vehiclePO) throws RemoteException, ExistException;
     
     /**
      * 
      * @param po
      * @return
      * @throws RemoteException
      */
     Boolean  deleteVehicle(VehiclePO po) throws RemoteException;
     
     /**
      * 
      * @param vehicleNumber
      * @return
      * @throws RemoteException
      */
     VehiclePO checkVehicle(String vehicleNumber) throws RemoteException;
     
     /**
      * 
      * @return
      * @throws RemoteException
      */
     Iterator<VehiclePO> checkVehicle() throws RemoteException;
     
     /**
      * 
      * @param position
      * @param Type
      * @return
      * @throws RemoteException
      */
     Boolean updateSalary(String position, String Type) throws RemoteException;
     
     /**
      * 
      * @param constantPO
      * @return
      * @throws RemoteException
      * @throws ExistException
      */
     Boolean updateConstant(ConstantPO constantPO) throws RemoteException, ExistException;
     
     /**
      * 
      * @return
      * @throws RemoteException
      */
     String[] getSalary() throws RemoteException;
    
     /**
      * 
      * @return
      * @throws RemoteException
      */
     ConstantPO getConstant() throws RemoteException;
  

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
    Iterator<WorkerPO> checkWorker() throws RemoteException;

    /**
     * 查找人员
     * @param name 人员名字
     * @return 符合条件的人员列表（可能只有一个人员的ArrayList）
     */
    Iterator<WorkerPO> checkWorker(String name) throws RemoteException;

    /**
     * 编辑人员信息
     * @param
     * @return
     * @throws ExistException 
     */
    boolean editWorker(WorkerPO oldWorkerPO,WorkerPO newWorkerPO) throws RemoteException, ExistException; 


}
