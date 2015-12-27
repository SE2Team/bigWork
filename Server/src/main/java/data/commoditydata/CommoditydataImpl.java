package data.commoditydata;

import data.Common.Common;
import dataservice.commoditydataservice.CommodityDataService;
import po.StockInPO;
import po.StockOutPO;
import po.StockPO;
import util.ListState;
import util.TransportType;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CommoditydataImpl extends UnicastRemoteObject implements CommodityDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommoditydataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void update(StockPO PO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("stock");
		ArrayList<StockInPO> list=PO.getStockList();
		ArrayList<String> list1=new ArrayList<String>();
		if(PO.getStockState()==true){
			list1.add("true");
		}else{
			list1.add("false");
		}
		
		for(int j=0;j<list.size();j++){
			list1.add(this.POToString(list.get(j)));
		}
		common.clearData("stock");
		common.writeData(list1);
	}

	public StockPO check() throws RemoteException {
		// TODO Auto-generated method stub
		Boolean stockState=false;
		Common common=new Common("stock");
		ArrayList<StockInPO> list2=new ArrayList<>();
		ArrayList<String> list=common.readData();
		if(list.get(0).equals("true")){
			stockState=true;
		}
		for(int j=1;j<list.size();j++){
			String[] str=list.get(j).split(";");
			list2.add(stringToPO(str));
		}
		
		return new StockPO(stockState, list2);
		
	}

	public StockPO initial() throws RemoteException {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	private StockInPO stringToPO(String[] str){
        ListState isCheck = ListState.UNCHECK;
        if (str[1].equals("PASSED")) {
            isCheck = ListState.PASSED;
        } else if (str[1].equals("REJECTED")) {
            isCheck = ListState.REJECTED;
        }
		return new StockInPO(str[2], str[3], str[4], str[5], str[6], str[7], str[8],isCheck);
	}
	
	private String POToString(StockInPO po){
		
		return po.getIsCheck()+";"+po.getType()+";"+po.getDeliveryNum()+";"+po.getInDate()+";"+po.getEnd()+";"+po.getZoneNum()+";"+po.getRowNum()
		+";"+po.getShelfNum()+";"+po.getPositionNum();
		
	}
	
	private int DateToInt(String date) {
		String[] str=date.split("-");
		for(int i=1;i<str.length;i++){
			str[0]=str[0]+str[i];
		}
		 return Integer.parseInt(str[0]);
	}
	
	private StockOutPO stringToStockOutPO(String[] str){
		TransportType transportType=TransportType.AIRPLANE;
        ListState isCheck = ListState.UNCHECK;
        if (str[1].equals("PASSED")) {
            isCheck = ListState.PASSED;
        } else if (str[1].equals("REJECTED")) {
            isCheck = ListState.REJECTED;
        }
		
		if(str[5].equals("CAR")){
			transportType=TransportType.CAR;
		}else if(str[5].equals("TRAIN")){
			transportType=transportType.TRAIN;
		}
		return new StockOutPO(str[2], str[3], str[4],transportType,str[6] ,isCheck);
	}

	@Override
	
	/**
	 * 
	 * 
	 * @param start
	 * @param end
	 * @return 出库数量/入库数量      库存数量
	 * @throws RemoteException
	 */
	public ArrayList<Integer> check(String start, String end) throws RemoteException {
		// TODO Auto-generated method stub
		int inNum=0;
		int outNum=0;
		int stockNum=0;
		int startDate=this.DateToInt(start);
		int endDate1=this.DateToInt(end);
		Common common=new Common("stockIn");
		Common common2=new Common("stockOut");
		Common common3=new Common("stock");
		ArrayList<String> listIn=common.readData();
		ArrayList<String> listOut=common2.readData();
		ArrayList<Integer> integers=new ArrayList<>();
		
		//计算库存数量
		ArrayList<String> stock=common3.readData();
		stockNum=stock.size()-1;
		
		//计算时间段内的入库数量
		for(int j=0;j<listIn.size();j++){
			
			String[] str=listIn.get(j).split(";");
			StockInPO po=stringToPO(str);
			int date=DateToInt(po.getInDate());
			
			if(startDate<=date&&date<=endDate1){
				
				inNum=inNum+1;
			}
		}
		
		for(int j=0;j<listOut.size();j++){
			String[] str=listOut.get(j).split(";");
			StockOutPO po=stringToStockOutPO(str);
			int date=DateToInt(po.getOutDate());

			if(startDate<=date&&date<=endDate1){
				outNum=outNum+1;
			}
		}
		
		integers.add(inNum);
		integers.add(outNum);
		integers.add(stockNum);
		return integers;
	}

}
