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

    public CommodityDataService getCommodityData() throws RemoteException;

    public FinanceDataService getFinanceData() throws RemoteException;

    public InquiryDataService getInquiryData() throws RemoteException;

    public ListDataService getListData() throws RemoteException;

    public ManageDataService getManageData() throws RemoteException;

    public UserDataService getUserData( )throws RemoteException;
}
