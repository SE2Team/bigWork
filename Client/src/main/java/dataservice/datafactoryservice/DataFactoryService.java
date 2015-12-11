package dataservice.datafactoryservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.commoditydataservice.CommodityDataService;
import dataservice.financedataservice.FinanceDataService;
import dataservice.inquirydataservice.InquiryDataService;
import dataservice.listdataservice.ListDataService;
import dataservice.managedataservice.ManageDataService;
import dataservice.userdataservice.UserDataService;

public interface DataFactoryService extends Remote{
	
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	CommodityDataService getCommodityData() throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	FinanceDataService getFinanceData() throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	InquiryDataService getInquiryData() throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	ListDataService getListData() throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	ManageDataService getManageData() throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	UserDataService getUserData() throws RemoteException;
}
