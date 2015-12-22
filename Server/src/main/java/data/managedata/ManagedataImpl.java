package data.managedata;

import data.Common.Common;
import dataservice.managedataservice.ManageDataService;
import po.ConstantPO;
import po.DriverPO;
import po.VehiclePO;
import po.WorkerPO;
import util.ExistException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by MYK on 2015/11/23 0023.
 */
public class ManagedataImpl extends UnicastRemoteObject implements ManageDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManagedataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Boolean addDriver(DriverPO driverPO) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		Common common=new Common("driver");
		ArrayList<String> list=common.readData();
		if(list.contains(this.driverPOToString(driverPO))){
			throw new ExistException();
		}
		common.writeDataAdd(this.driverPOToString(driverPO));	
		return true;
	}

	public Boolean deleteDriver(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("driver");
		ArrayList<String> list=common.readData();
		list.remove(this.driverPOToString(po));
		common.clearData("driver");
		common.writeData(list);
		return true;
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

	public Boolean addVehicle(VehiclePO vehiclePO) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		Common common=new Common("vehicle");
		ArrayList<String> list=common.readData();
		if(list.contains(this.vehiclePOToString(vehiclePO))){
			throw new ExistException();
		}
		common.writeDataAdd(this.vehiclePOToString(vehiclePO));
		return true;
	}

	public Boolean deleteVehicle(VehiclePO po) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("vehicle");
		ArrayList<String> list=common.readData();
		list.remove(this.vehiclePOToString(po));
		common.clearData("vehicle");
		common.writeData(list);
		return true;
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

	public Boolean updateSalary(String position, String Type) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("salary");
		common.clearData("salary");
		common.writeDataAdd(position+";"+Type);
		return true;
	}

	public Boolean updateConstant(ConstantPO constantPO) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		Common common=new Common("constant");
		ArrayList<String> list=common.readData();
		for(int i=0;i<list.size();i++){
			String[] str=list.get(i).split(";");
			if(str[0].equals(constantPO.getCity1())&&str[1].equals(constantPO.getCity2())){
				list.remove(i);
				list.add(this.constantPOToString(constantPO));
			}else{
				throw new ExistException();
			}
		}
		common.clearData("constant");
		common.writeData(list);
		return true;
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
	
	@Override
	public boolean addWorker(WorkerPO workerPO) throws RemoteException, ExistException{
		// TODO Auto-generated method stub
		Common common=new Common("worker");
		ArrayList<String> list=common.readData();
		if(list.contains(this.workerPOToString(workerPO))){
			throw new ExistException();
		}else{
			common.writeDataAdd(this.workerPOToString(workerPO));
			return true;
		}
	}

	@Override
	public boolean delWorker(WorkerPO workerPO) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		Common common=new Common("worker");
		ArrayList<String> list=common.readData();
		if(list.contains(this.workerPOToString(workerPO))){
			list.remove(this.workerPOToString(workerPO));
			common.clearData("worker");
			common.writeData(list);
			return true;
		}else{
			throw new ExistException();
			
		}
		
	}

	@Override
	public Iterator<WorkerPO> checkWorker() throws RemoteException{
		Common common=new Common("worker");
		ArrayList<String> list=common.readData();
		ArrayList<WorkerPO> list2=new ArrayList<WorkerPO>();
		for(int j=0;j<list.size();j++){
			String[] str=list.get(j).split(";");
			list2.add(this.stringToWorkerPO(str));
		}
		return list2.iterator();
	}

	@Override
	public Iterator<WorkerPO> checkWorker(String name) throws RemoteException{
		// TODO Auto-generated method stub
		Common common=new Common("worker");
		ArrayList<String> list=common.readData();
		ArrayList<WorkerPO> list2=new ArrayList<WorkerPO>();
		for(int j=0;j<list.size();j++){
			String[] str=list.get(j).split(";");
			if(str[0].equals(name)){
				list2.add(this.stringToWorkerPO(str));
			}
		}
		
		return list2.iterator();
	}

	@Override
	public boolean editWorker(WorkerPO oldWorkerPO,WorkerPO newWorkerPO) throws RemoteException, ExistException{
		// TODO Auto-generated method stub
		Common common=new Common("worker");
		ArrayList<String> list=common.readData();
		if(list.contains(this.workerPOToString(oldWorkerPO))){
			list.remove(this.workerPOToString(oldWorkerPO));
			list.add(this.workerPOToString(oldWorkerPO));
			common.clearData("worker");
			common.writeData(list);
			return true;
		}else{
			throw new ExistException();
		}
		
	}
	
	private String workerPOToString(WorkerPO po){
		return po.getName()+";"+po.getIdNum()+";"+po.getPosition()+";"+po.getPosition()+";"+po.getUserId();
	}
	
	private String driverPOToString(DriverPO po){
		return po.getDriverNum()+";"+po.getDriverName()+";"+po.getBirthDate()+";"+po.getIdNum()+";"+po.getPhone()
		+";"+po.getVehicleInstitution()+";"+po.getSex()+";"+po.getLicenseTime();
	}
   
	private WorkerPO stringToWorkerPO(String[] str){
		return new WorkerPO(str[0], str[1], str[2], str[3], str[4], str[5]);
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

	public Iterator<DriverPO> checkDriver() throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("driver");
		ArrayList<String> list=common.readData();
		ArrayList<DriverPO> list2=new ArrayList<>();
		for(int j=0;j<list.size();j++){
			String[] str=list.get(j).split(";");
			list2.add(this.stringToDriverPO(str));
		}
		return list2.iterator();
	}

	@Override
	public Iterator<VehiclePO> checkVehicle() throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("vehicle");
		ArrayList<String> list=common.readData();
		ArrayList<VehiclePO> list2=new ArrayList<>();
		for(int j=0;j<list.size();j++){
			String[] str=list.get(j).split(";");
			list2.add(this.stringToVehiclePO(str));
		}
		return list2.iterator();

	}

}
