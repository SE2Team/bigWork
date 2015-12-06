package dataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.*;
import util.ExistException;
import util.ResultMessage;

public interface ManageDataService extends Remote{
    public ResultMessage addDriver(DriverPO driverPO) throws RemoteException, ExistException;

    public ResultMessage  deleteDriver(DriverPO po) throws RemoteException;

    public DriverPO checkDriver(String driveNumber) throws RemoteException;

    public ResultMessage  addVehicle(VehiclePO vehiclePO) throws RemoteException, ExistException;

    public ResultMessage  deleteVehicle(VehiclePO po) throws RemoteException;

    public VehiclePO checkVehicle(String vehicleNumber) throws RemoteException;

    public ResultMessage updateSalary(String position, String Type) throws RemoteException;

    public ResultMessage updateConstant(ConstantPO constantPO) throws RemoteException;
    
    public String[] getSalary() throws RemoteException;
    
    public ConstantPO getConstant() throws RemoteException;
}
