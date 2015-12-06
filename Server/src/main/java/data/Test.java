package data;


import dataservice.datafactoryservice.DataFactoryService;
import dataservice.listdataservice.ListDataService;
import po.AddresseeInformationPO;
import po.OrderPO;
import po.StockInPO;
import util.DeliveryType;
import util.ExistException;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

public class Test {
		public static void main(String[] args) throws RemoteException, ExistException{
			File directory = new File("");//设定为当前文件夹
			try{
				System.out.println(directory.getCanonicalPath());//获取标准的路径
				System.out.println(directory.getAbsolutePath());//获取绝对路径
			} catch (IOException e) {
				e.printStackTrace();
			}
			DataFactoryService dataFactoryService=new DataFactory();
			ListDataService dataService=dataFactoryService.getListData();
			dataService.save(new AddresseeInformationPO("000", "0000", "0000"));
			dataService.save(new StockInPO("333", "333", "333", "333", "333", "333", "333"));
			dataService.save(new OrderPO("3", "3", "3", "3", "3", "3", "3","3", "3", "3", "3", "3", "3", 
					"3", DeliveryType.FAST, "3", "3", "3", "3","3", "3"));

		}
}
