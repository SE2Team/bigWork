package data.managedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

import data.Common.Common;
import dataservice.managedataservice.ManageDataService;
import po.ConstantPO;
import po.DriverPO;
import po.VehiclePO;
import util.ExistException;
import util.ResultMessage;

/**
 * Created by MYK on 2015/11/23 0023.
 */
public class ManagedataImpl extends UnicastRemoteObject implements ManageDataService{

	public ManagedataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ResultMessage addDriver(DriverPO driverPO) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		Common common=new Common("driver");
		ArrayList<String> list=common.readData();
		if(list.contains(this.driverPOToString(driverPO))){
			throw new ExistException();
		}
		common.writeDataAdd(this.driverPOToString(driverPO));	
		return ResultMessage.SUCCESS;
	}

	public ResultMessage deleteDriver(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("driver");
		ArrayList<String> list=common.readData();
		list.remove(this.driverPOToString(po));
		common.clearData("driver");
		common.writeData(list);
		return ResultMessage.SUCCESS;
	}

	public DriverPO checkDriver(String driveNumber) throws RemoteException {
		// TODO Auto-generated method stub
		String[] str=new String[8];
		Common common=new Common("driver");
		ArrayList<String> list=common.readData();
		for(int j=0;j<list.size();j++){
			str=list.get(j).split(";");
			if(str[0].equals(driveNumber)){
				return stringToDriverPO(str);
			}
		}
		
		return null;
	}

	public ResultMessage addVehicle(VehiclePO vehiclePO) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		Common common=new Common("driver");
		ArrayList<String> list=common.readData();
		if(list.contains(this.vehiclePOToString(vehiclePO))){
			throw new ExistException();
		}
		common.writeDataAdd(this.vehiclePOToString(vehiclePO));
		return ResultMessage.SUCCESS;
	}

	public ResultMessage deleteVehicle(VehiclePO po) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("vehicle");
		ArrayList<String> list=common.readData();
		list.remove(this.vehiclePOToString(po));
		common.clearData("vehicle");
		common.writeData(list);
		return ResultMessage.SUCCESS;
	}

	public VehiclePO checkVehicle(String vehicleNumber) throws RemoteException {
		// TODO Auto-generated method stub
		String[] str=new String[8];
		Common common=new Common("vehicle");
		ArrayList<String> list=common.readData();
		for(int j=0;j<list.size();j++){
			str=list.get(j).split(";");
			if(str[0].equals(vehicleNumber)){
				return stringToVehiclePO(str);
			}
		}	
		
		return null;
	}

	public ResultMessage updateSalary(String position, String Type) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("salary");
		common.clearData("salary");
		common.writeDataAdd(position+";"+Type);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage updateConstant(ConstantPO constantPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("constant");
		common.clearData("constant");
		common.writeDataAdd(this.constantPOToString(constantPO));
		return ResultMessage.SUCCESS;
	}

	public String[] getSalary() throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("salary");
		ArrayList<String> list= common.readData();
		String[] str=list.get(0).split(";");
		return str;
	}

	public ConstantPO getConstant() throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("constant");
		ArrayList<String> list= common.readData();
		String[] str=list.get(0).split(";");
		return this.StringToConstantPO(str);
	}
	
	private String driverPOToString(DriverPO po){
		return po.getDriverNum()+";"+po.getDriverName()+";"+po.getBirthDate()+";"+po.getIdNum()+";"+po.getPhone()
		+";"+po.getVehicleInstitution()+";"+po.getSex()+";"+po.getLicenseTime();
	}
   
	private String vehiclePOToString(VehiclePO po){
		return po.getVehicleNum()+";"+po.getLicensePlate()+";"+po.getBuyDate()+";"+po.getUseTime();
	}
	
	private DriverPO stringToDriverPO(String[]  str){
		return new DriverPO(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7]);
	}
	
	private VehiclePO stringToVehiclePO(String[] str) {
		return new VehiclePO(str[0], str[1], str[2], str[3]);
	}
	
	private String constantPOToString(ConstantPO po){
		return po.getCity1()+";"+po.getCity2()+";"+po.getPrice()+";"+po.getDistance();
	}
	
	private ConstantPO StringToConstantPO(String[] str){
		return new ConstantPO(str[0], str[1], str[2], str[3]);
	}
}
