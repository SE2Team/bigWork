package data;

import data.commoditydata.CommoditydataImpl;
import data.financedata.FinancedataImpl;
import data.inquirydata.InquirydataImpl;
import data.listdata.ListdataImpl;
import data.managedata.ManagedataImpl;
import data.userdata.UserdataImpl;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.financedataservice.FinanceDataService;
import dataservice.inquirydataservice.InquiryDataService;
import dataservice.listdataservice.ListDataService;
import dataservice.managedataservice.ManageDataService;
import dataservice.userdataservice.UserDataService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class DataFactory extends UnicastRemoteObject implements DataFactoryService{
	private static DataFactory FACTORY=null;

	protected DataFactory() throws RemoteException {
		super();
	}

	public static DataFactory getInstance() throws RemoteException {
		if(DataFactory.FACTORY==null)
			FACTORY=new DataFactory();
		return FACTORY;
	}

	public CommodityDataService getCommodityData() throws RemoteException {
		// TODO Auto-generated method stub
		return new CommoditydataImpl();
	}

	public FinanceDataService getFinanceData() throws RemoteException {
		// TODO Auto-generated method stub
		return new FinancedataImpl();
	}

	public InquiryDataService getInquiryData() throws RemoteException {
		// TODO Auto-generated method stub
		return new InquirydataImpl();
	}

	public ListDataService getListData() throws RemoteException {
		// TODO Auto-generated method stub
		return new ListdataImpl();
	}

	public ManageDataService getManageData() throws RemoteException {
		// TODO Auto-generated method stub
		return new ManagedataImpl();
	}

	public UserDataService getUserData() throws RemoteException {
		// TODO Auto-generated method stub
		return  new UserdataImpl();
	}

    
}
