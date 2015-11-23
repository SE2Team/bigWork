package data;

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
public class DataFactory  implements DataFactoryService{

    public CommodityDataService getCommodityData() {
        return null;
    }

    public FinanceDataService getFinanceData() {
        return null;
    }

    public InquiryDataService getInquiryData() {
        return null;
    }

    public ListDataService getListData() {
        return null;
    }

    public ManageDataService getManageData() {
        return null;
    }

    public UserDataService getUserData() {
        return null;
    }
}
