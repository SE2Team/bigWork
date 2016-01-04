package dataservice;

import dataservice.commoditydataservice.CommodityDataService;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.financedataservice.FinanceDataService;
import dataservice.inquirydataservice.InquiryDataService;
import dataservice.listdataservice.ListDataService;
import dataservice.managedataservice.ManageDataService;
import dataservice.userdataservice.UserDataService;
import presentation.commonui.UIdata.UIConstant;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class DataFactory extends UnicastRemoteObject implements DataFactoryService {
    private static DataFactoryService FACTORY = null;


    protected DataFactory() throws RemoteException {
        super();
    }

    public static DataFactoryService getInstance() throws RemoteException {

        if (FACTORY != null)
            return FACTORY;

        try {
            FACTORY = (DataFactoryService) Naming.lookup("rmi://" + UIConstant.address + ":" + UIConstant.port + "/DataFactory");
            System.out.println("连接成功！");
        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (RemoteException e) {
            e.printStackTrace();

        } catch (NotBoundException e) {
            e.printStackTrace();

        }
        return FACTORY;
    }


    public CommodityDataService getCommodityData() throws RemoteException {
        return null;
    }

    public FinanceDataService getFinanceData() throws RemoteException {
        return null;
    }

    public InquiryDataService getInquiryData() throws RemoteException {
        return null;
    }

    public ListDataService getListData() throws RemoteException {
        return null;
    }

    public ManageDataService getManageData() throws RemoteException {
        return null;
    }

    public UserDataService getUserData() throws RemoteException {
        return null;
    }
}
