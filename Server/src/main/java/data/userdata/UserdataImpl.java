package data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.Common.Common;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import util.ExistException;
import util.ResultMessage;
import util.UserType;

/**
 * Created by MYK on 2015/11/23 0023.
 */
public class UserdataImpl extends UnicastRemoteObject implements UserDataService{
	Common common;
	public UserdataImpl() throws RemoteException {
		super();
		common=new Common("user");
		// TODO Auto-generated constructor stub
	}


	public Boolean addUser(UserPO po) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		ArrayList<String> list=common.readData();
		if(list.contains(this.userPOToString(po))){
			throw new ExistException();
		}
		common.writeDataAdd(this.userPOToString(po));
		return true;
	}

	
	
	/**
	 *@param UserPo 
	 * 如果原来账号就不存在的异常尚未实现
	 */
	public Boolean deleteUser(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> list=common.readData();
		list.remove(this.userPOToString(po));
		common.clearData("user");
		common.writeData(list);
		return true;
	}


	public UserPO login(String id, String password) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		String[] str=new String[4];
		ArrayList<String> list=common.readData();
		for(int j=0;j<list.size();j++){
			str=list.get(j).split(";");
			if(str[0].equals(id)&&str[1].equals(password)){
				return this.stringToPO(str);
			}else{
				throw new ExistException();
			}
		}
		return null;
	}


	public Boolean editUser(UserPO oldPO, UserPO newPO) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		ArrayList<String> list=common.readData();
		if(list.contains(this.userPOToString(oldPO))){
			list.remove(this.userPOToString(oldPO));
			list.add(this.userPOToString(newPO));
			common.clearData("user");
			common.writeData(list);
			return true;
		}else{
			throw new ExistException();
		}
	}


	public UserPO find(String id, String password) throws RemoteException {
		String[] str=new String[4];
		ArrayList<String> list=common.readData();
		for(int j=0;j<list.size();j++){
			str=list.get(j).split(";");
			if(str[0].equals(id)&&str[1].equals(password)){
				return this.stringToPO(str);
			}
		}
		return null;
	}

	private String userPOToString(UserPO po){
		return po.getId()+";"+po.getPassword()+";"+po.getName()+";"+po.getPermission();
	}
	
	private UserPO stringToPO(String[] s){
		UserType userType = null;
		switch (s[3]) {
		case "COURIER":
			userType=UserType.COURIER;
			break;
		case "MANAGER":
			userType=UserType.MANAGER;
			break;
		case "FINANCIAL":
			userType=UserType.FINANCIAL;
			break;
		case "FINANCIALPRO":
			userType=UserType.FINANCIALPRO;
			break;
		case "STOCKMANAGER":
			userType=UserType.STOCKMANAGER;
			break;
		case "SALESMAN":
			userType=UserType.SALESMAN;
			break;
		case "TRANSFERMAN":
			userType=UserType.TRANSFERMAN;
			break;
		default:
			break;
		}
		return new UserPO(s[0], s[1], s[2], userType);

	}
}