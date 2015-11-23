package data.datafactory;

import data.commoditydata.CommodityImpl;
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

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class DataFactory implements DataFactoryService{

    public CommodityDataService getCommodityData() {
        return new CommodityImpl();
    }

    public FinanceDataService getFinanceData() {
        return new FinancedataImpl();
    }

    public InquiryDataService getInquiryData() {
        return new InquirydataImpl();
    }

    public ListDataService getListData() {
        return new ListdataImpl();
    }

    public ManageDataService getManageData() {
        return new ManagedataImpl();
    }

    public UserDataService getUserData() {
        return new UserdataImpl();
    }
}
