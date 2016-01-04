package dataservice.datafactoryservice;

import dataservice.commoditydataservice.CommodityDataService;
import dataservice.financedataservice.FinanceDataService;
import dataservice.inquirydataservice.InquiryDataService;
import dataservice.listdataservice.ListDataService;
import dataservice.managedataservice.ManageDataService;
import dataservice.userdataservice.UserDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataFactoryService extends Remote {


    CommodityDataService getCommodityData() throws RemoteException;

    FinanceDataService getFinanceData() throws RemoteException;

    InquiryDataService getInquiryData() throws RemoteException;

    ListDataService getListData() throws RemoteException;

    ManageDataService getManageData() throws RemoteException;

    UserDataService getUserData() throws RemoteException;
}
