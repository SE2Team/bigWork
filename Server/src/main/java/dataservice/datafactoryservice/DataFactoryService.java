package dataservice.datafactoryservice;

import dataservice.commoditydataservice.CommodityDataService;
import dataservice.financedataservice.FinanceDataService;
import dataservice.inquirydataservice.InquiryDataService;
import dataservice.listdataservice.ListDataService;
import dataservice.managedataservice.ManageDataService;
import dataservice.userdataservice.UserDataService;

public interface DataFactoryService {

    public CommodityDataService getCommodityData();

    public FinanceDataService getFinanceData();

    public InquiryDataService getInquiryData();

    public ListDataService getListData();

    public ManageDataService getManageData();

    public UserDataService getUserData();
}
