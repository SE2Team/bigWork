package data.managedata;

import data.Common.Common;
import dataservice.managedataservice.ManageDataService;
import po.*;
import util.ExistException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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
		ArrayList<String> list = common.readData();
		for (int j = 0; j < list.size(); j++) {
			String[] str = list.get(j).split(";");
			if (str[0].equals(position)) {
				list.remove(j);
				list.add(position + ";" + Type);
			}
		}
		common.clearData("salary");
		common.writeData(list);
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


	public ArrayList<ConstantPO> getConstant() throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("constant");
		ArrayList<String> list= common.readData();
		ArrayList<ConstantPO> list1 = new ArrayList<>();
		for (int j = 0; j < list.size(); j++) {
			String[] str = list.get(j).split(";");
			list1.add(this.StringToConstantPO(str));
		}
		return list1;
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
	public ArrayList<WorkerPO> checkWorker() throws RemoteException{
		Common common=new Common("worker");
		ArrayList<String> list=common.readData();
		ArrayList<WorkerPO> list2=new ArrayList<WorkerPO>();
		for(int j=0;j<list.size();j++){
			String[] str=list.get(j).split(";");
			list2.add(this.stringToWorkerPO(str));
		}
		return list2;
	}

	@Override
	public ArrayList<WorkerPO> checkWorker(String name) throws RemoteException{
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
		
		return list2;
	}

	@Override
	public boolean editWorker(WorkerPO oldWorkerPO,WorkerPO newWorkerPO) throws RemoteException, ExistException{
		// TODO Auto-generated method stub
		Common common=new Common("worker");
		ArrayList<String> list=common.readData();
		if(list.contains(this.workerPOToString(oldWorkerPO))){
			list.remove(this.workerPOToString(oldWorkerPO));
			list.add(this.workerPOToString(newWorkerPO));
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

	private String driverPOToString(DriverPO oldDriverPO) {
		return oldDriverPO.getDriverNum() + ";" + oldDriverPO.getDriverName() + ";" + oldDriverPO.getBirthDate() + ";" + oldDriverPO.getIdNum() + ";" + oldDriverPO.getPhone()
				+ ";" + oldDriverPO.getVehicleInstitution() + ";" + oldDriverPO.getSex() + ";" + oldDriverPO.getLicenseTime();
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

	public ArrayList<DriverPO> checkDriver() throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("driver");
		ArrayList<String> list=common.readData();
		ArrayList<DriverPO> list2=new ArrayList<>();
		for(int j=0;j<list.size();j++){
			String[] str=list.get(j).split(";");
			list2.add(this.stringToDriverPO(str));
		}
		return list2;
	}

	@Override
	public ArrayList<VehiclePO> checkVehicle() throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("vehicle");
		ArrayList<String> list=common.readData();
		ArrayList<VehiclePO> list2=new ArrayList<>();
		for(int j=0;j<list.size();j++){
			String[] str=list.get(j).split(";");
			list2.add(this.stringToVehiclePO(str));
		}
		return list2;

	}


	@Override
	public boolean editVehicle(VehiclePO oldVehiclePO, VehiclePO newVehiclePO) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		Common common = new Common("vehicle");
		ArrayList<String> list = common.readData();
		if (list.contains(this.vehiclePOToString(oldVehiclePO))) {
			list.remove(this.vehiclePOToString(oldVehiclePO));
			list.add(this.vehiclePOToString(newVehiclePO));
			common.clearData("vehicle");
			common.writeData(list);
			return true;
		} else {
			throw new ExistException();
		}
	}

	@Override
	public boolean editDriver(DriverPO oldDriverPO, DriverPO newDriverPO) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		Common common = new Common("driver");
		ArrayList<String> list = common.readData();
		if (list.contains(this.driverPOToString(oldDriverPO))) {
			list.remove(this.driverPOToString(oldDriverPO));
			list.add(this.driverPOToString(newDriverPO));
			common.clearData("vehicle");
			common.writeData(list);
			return true;
		} else {
			throw new ExistException();
		}
	}

	@Override
	public String getSalary(String position) throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("salary");
		ArrayList<String> list = common.readData();
		for (int j = 0; j < list.size(); j++) {
			String[] str = list.get(j).split(";");
			if (str[0].equals(position)) {
				return str[1];

			}
		}
		return null;
	}

	private String PoToString(OrganizationPO po) {
		return po.getNum() + ";" + po.getCity() + ";" + po.getName();
	}

	@Override
	public boolean addOrganization(OrganizationPO po) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		Common common = new Common("organization");
		ArrayList<String> list = common.readData();
		String string = this.PoToString(po);
		if (list.contains(string)) {
			throw new ExistException();
		}
		common.writeDataAdd(string);
		return true;
	}

	@Override
	public boolean delOrganization(OrganizationPO po) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		Common common = new Common("organization");
		ArrayList<String> list = common.readData();
		String string = this.PoToString(po);
		if (list.contains(string)) {
			list.remove(string);
			common.clearData("organization");
			common.writeData(list);
			return true;
		} else {
			throw new ExistException();
		}

	}

	@Override
	public boolean editOrganization(OrganizationPO oldPO, OrganizationPO newPO) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		Common common = new Common("organization");
		ArrayList<String> list = common.readData();
		String string = this.PoToString(oldPO);

		if (list.contains(string)) {
			list.remove(string);
			list.add(this.PoToString(newPO));
			common.clearData("organization");
			common.writeData(list);
			return true;
		} else {
			throw new ExistException();
		}
	}

	@Override
	public ArrayList<OrganizationPO> check() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("organization");
		ArrayList<String> list = common.readData();
		ArrayList<OrganizationPO> list1 = new ArrayList<>();
		for (int j = 0; j < list.size(); j++) {
			String[] str = list.get(j).split(";");
            list1.add(new OrganizationPO(str[0], str[1], str[2]));
        }
		return list1;
	}

	@Override
	public OrganizationPO check(String num) throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("organization");
		ArrayList<String> list = common.readData();
		for (int j = 0; j < list.size(); j++) {
			String[] str = list.get(j).split(";");
			if (str[0].equals(num)) {
				return new OrganizationPO(str[0], str[1], str[2]);
			}
		}
		return null;
	}

	@Override
	public WorkerPO checkWorkerByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("worker");
		ArrayList<String> list = common.readData();
		for (int j = 0; j < list.size(); j++) {
			String[] str = list.get(j).split(";");
			if (str[1].equals(id)) {
				return new WorkerPO(str[0], str[1], str[2], str[3], str[4], str[5]);
			}
		}
		return null;
	}

	@Override
	public ArrayList<String> checkCity() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("city");
		ArrayList<String> list = common.readData();
		ArrayList<String> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			list1.add(str[1]);
		}
		return list1;
	}

	@Override
	public String checkCity(String num) throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("city");
		ArrayList<String> list = common.readData();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			if (str[0].equals(num)) {
				return str[1];
			}
		}

		return null;
	}

	@Override
	public String checkCityNum(String city) throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("city");
		ArrayList<String> list = common.readData();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			if (str[1].equals(city)) {
				return str[0];
			}
		}

		return null;
	}

	@Override
	public ArrayList<String> checkCityNum() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("city");
		ArrayList<String> list = common.readData();
		ArrayList<String> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			list1.add(str[0]);
		}
		return list1;
	}
		
}
