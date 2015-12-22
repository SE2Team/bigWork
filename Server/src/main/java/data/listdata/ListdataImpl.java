package data.listdata;


import data.Common.Common;
import dataservice.listdataservice.ListDataService;
import po.*;
import util.DeliveryType;
import util.ExistException;
import util.TransportType;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by MYK on 2015/11/23 0023.
 */
public class ListdataImpl extends UnicastRemoteObject implements ListDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public ListdataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boolean save(OrderPO orderPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("order");
		common.writeDataAdd(this.orderPoToString(orderPO));
		return true;
	}

	public Boolean save(AddresseeInformationPO addresseeInformationPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("addresseeInformation");
		common.writeDataAdd(this.addresseeInfoPOToString(addresseeInformationPO));
		return true;
	}

	public Boolean save(LoadingPO loadingPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("loading");
		common.writeDataAdd(this.loadingPOToString(loadingPO));
		return true;
	}

	public Boolean save(ReceivePO receivePO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("receive");
		common.writeDataAdd(this.receivePOToString(receivePO));
		return true;
	}

	public Boolean save(DistributePO distributePO) throws RemoteException {
		// TODO Auto-generated method stub
		
		Common common=new Common("distribute");
		common.writeDataAdd(this.distributePOToString(distributePO));
		return true;
	}

	public Boolean save(ReceiptPO receiptPO) throws RemoteException {
		// TODO Auto-generated method stub
		
		Common common=new Common("receipt");
		common.writeDataAdd(this.receiptPOToString(receiptPO));
		return true;
	}

	public Boolean save(TransferPO transferPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("transfer");
		common.writeDataAdd(this.transferPOToString(transferPO));
		return true;
	}

	public Boolean save(TransferReceivePO transferReceivePO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("transferReceive");
		common.writeDataAdd(this.transferReceivePOToString(transferReceivePO));
		return true;
	}

	public Boolean save(StockOutPO stockOutPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("stockOut");
		common.writeDataAdd(this.stockOutPOToString(stockOutPO));
		return true;
	}

	public Boolean save(StockInPO stockInPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("stockIn");
		common.writeDataAdd(this.stockInPOToString(stockInPO));
		return true;
	}

	public Boolean save(PaymentPO paymentPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("payment");
		common.writeDataAdd(this.paymentPOToString(paymentPO));
		return true;
	}

	public Boolean save(GatheringPO gatheringPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("gathering");
		common.writeDataAdd(this.gatheringPOToString(gatheringPO));
		return true;
	}

	public Boolean saveAsList(ListPO listPo) throws RemoteException {
		 Common common = new Common("list");
	        String str = "";
	        switch (listPo.getType()) {
	            case LOADINGINFO:
	                str = loadingPOToString((LoadingPO) listPo);
	                break;
	            case ADDRESSEEINFOMATION:
	                str = addresseeInfoPOToString((AddresseeInformationPO) listPo);
	                break;
	            case DISTRIBUTEINFO:
	                str = distributePOToString((DistributePO) listPo);
	                break;
	            case GATHERING:
	                str = gatheringPOToString((GatheringPO) listPo);
	                break;
	            case ORDER:
	                str = orderPoToString((OrderPO)listPo);
	                break;
	            case PAYMENT:
	                str = paymentPOToString((PaymentPO) listPo);
	                break;
	            case RECEIPT:
	                str = receiptPOToString((ReceiptPO) listPo);
	                break;
	            case RECEIVEINFO:
	                str =receivePOToString((ReceivePO) listPo);
	                break;
	            case STOCKIN:
	                str = stockInPOToString((StockInPO) listPo);
	                break;
	            case STOCKOUT:
	                str = stockOutPOToString((StockOutPO) listPo);
	                break;
	            case TRANSARRIVE:
	                str = transferReceivePOToString((TransferReceivePO) listPo);
	                break;
	            case TRANSINFO:
	                str = transferPOToString((TransferPO) listPo);
	                break;
	            default:
	                return false;
	        }
	        common.writeDataAdd(str);
	        return true;
	    }

	public Iterator<ListPO> checkList() throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("list");
		ArrayList<String> list=common.readData();
		ArrayList<ListPO> list2=new ArrayList<ListPO>();
		ListPO listPO=null;
		for(int i=0;i<list.size();i++){
			boolean isCheck=false;
			String[] str=list.get(i).split(";");
			if(str[1].equals("true")){
				isCheck=true;
			}
			switch(str[0]){
			case "LOADINGINFO":
						listPO=new LoadingPO(str[2], str[3], str[4], str[5], str[6], str[7], str[8], str[9], str[10], str[11], isCheck);
						break;
            case "ADDRESSEEINFOMATION":
            			listPO=new AddresseeInformationPO(str[2], str[3], str[4], isCheck);
            			break;
            case "DISTRIBUTEINFO":
            			listPO=new DistributePO(str[2], str[3], str[4], isCheck);
            			break;
            case "GATHERING":
            			listPO=new GatheringPO(str[2], str[3], str[4], str[5], str[6], isCheck);
            					break;
            case "ORDER":
            			DeliveryType deliveryType=DeliveryType.ECONOMIC;
            			if(str[16].equals("FAST")){
            				deliveryType=DeliveryType.FAST;
            			}else if(str[16].equals("STANDARD")){
            				deliveryType=DeliveryType.STANDARD;
            			}
            			listPO=new OrderPO(str[2], str[3], str[4], str[5], str[6], str[7], str[8],str[9], str[10], str[11], str[12], str[13], str[14], str[15],deliveryType, str[17], str[18], str[19], str[20], str[21],str[22],isCheck);
            			break;
            case "PAYMENT":
                		listPO=new PaymentPO( str[2], str[3], str[4], str[5],str[6],str[7], isCheck);
                		break;
            case "RECEIPT":
						ArrayList<String> list3=new ArrayList<String>();
						for(int j=5;j<str.length;j++){
							list3.add(str[j]);
						}

            			listPO=new ReceiptPO(str[2], str[3],str[4],list3.iterator() ,isCheck);
            			break;
            case "RECEIVEINFO":
                		listPO=new ReceivePO(str[2], str[3], str[4], str[5], isCheck);
                break;
            case "STOCKIN":
            			listPO=new StockInPO(str[2], str[3], str[4], str[5], str[6],str[7],str[8], isCheck);
            			break;
            case "STOCKOUT":
            		TransportType transportType=TransportType.AIRPLANE;
            		if(str[5].equals("CAR")){
            			transportType=TransportType.CAR;
            		}else if(str[5].equals("TRAIN")){
            			transportType=transportType.TRAIN;
            		}
            			listPO=new StockOutPO(str[2], str[3], str[4],transportType,str[6] ,isCheck);
                break;
            case "TRANSARRIVE":
            			listPO=new TransferReceivePO(str[2], str[3], str[4], str[5],str[6], isCheck);
            			break;
            case "TRANSINFO":
            			listPO=new TransferPO( str[2], str[3],str[4], str[5], str[6], str[7], str[8], str[9], str[10], str[10],str[11],isCheck);
                break;
            default:
            	return null;
			}//close the switch
			
			list2.add(listPO);
		}
		
		return list2.iterator();
	}

	/**
	 *
	 * @param po
	 * @return
     */
	private String orderPoToString(OrderPO po) {
		return po.getType()+";"+po.getIsCheck()+";"+po.getSenderName() + ";" + po.getSenderAddress() + ";" + po.getSenderWorkplace() + ";"
				+ po.getSenderTelephone() + ";" + po.getSenderPhone() + ";" + po.getReceiverName() + ";"
				+ po.getReceiverAddress() + po.getReceiverWorkplace() + ";" + po.getReceiverTelephone() + ";"
				+ po.getReceiverPhone() + ";" + po.getOriginalNum() + ";" + po.getWeight() + ";" + po.getVolume() + ";"
				+ po.getGoods_Name() + ";" + po.getDeliveryType() + ";" + po.getWrapper() + ";"
				+ po.getExpenseOfTransport() + ";" + po.getExpenseOfWrapper() + ";" + po.getExpense() + ";"
				+ po.getDate() + ";" + po.getDeliveryNum()+";";
	}


	private String addresseeInfoPOToString(AddresseeInformationPO po) {
		return po.getType()+";"+po.getIsCheck()+";"+po.getAddresseeNum() + ";" + po.getAddresseeName() + ";" + po.getAddresseeDate()+";";

	}

	/**
	 * 
	 * @param po
	 * @return
	 */
	private String loadingPOToString(LoadingPO po) {
		return po.getType()+";"+po.getIsCheck()+";"+po.getLoadingDate() + ";" + po.getHallNum() + ";" + po.getTransportNum() + ";" + po.getStart() + ";"
				+ po.getEnd() + ";" + po.getMonitor() + ";" + po.getSupercargo() + ";" + po.getVehicleNum() + ";"
				+ po.getConsignList() + ";" + po.getTransportMoney()+";";

	}

	/**
	 * 
	 * @param po
	 * @return
	 */
	private String receivePOToString(ReceivePO po) {
		return po.getType()+";"+po.getIsCheck()+";"+po.getArriveDate() + ";" + po.getTransferNum() + ";" + po.getStart() + ";" + po.getArriveDate()+";";
	}

	/**
	 * 
	 * @param po
	 * @return
	 */
	private String distributePOToString(DistributePO po) {
		return po.getType()+";"+po.getIsCheck()+";"+po.getArriveDate() + ";" + po.getOrderNum() + ";" + po.getDistributeHuman()+";";
	}

	/**
	 * 
	 * @param po
	 * @return
	 */
	private String transferPOToString(TransferPO po) {
		return po.getType()+";"+po.getIsCheck()+";"+po.getLoadingWay() + ";" + po.getLoadingDate() + ";" + po.getTransportNum() + ";" + po.getVehicleNum()
				+ ";" + po.getVehicleNum() + ";" + po.getStart() + ";" + po.getEnd() + ";" + po.getContainerNum() + ";"
				+ po.getMonitor() + ";" + po.getSupercargo() + ";" + po.getOrderNum() + ";" + po.getMoney()+";";
	}
	
	/**
	 * todo 写了两遍getArriveDate?
	 * @param po
	 * @return
	 */
	private String transferReceivePOToString(TransferReceivePO po) {
		return po.getType()+";"+po.getIsCheck()+";"+po.getArriveDate() + ";" + po.getArriveDate() + ";" + po.getStart() + ";" + po.getCargoState() + ";"
				+ po.getTransferCenterNum() + ";" + po.getTransferNum();
	}
	
	/**
	 * 
	 * @param po
	 * @return
	 */
	private String stockOutPOToString(StockOutPO po) {
		return po.getType()+";"+po.getIsCheck()+";"+po.getDeliveryNum() + ";" + po.getOutDate() + ";" + po.getEnd() + ";" + po.getLoadingWay() + ";"
				+ po.getTransferNum();
	}
	
	/**
	 * 
	 * @param po
	 * @return
	 */
	private String stockInPOToString(StockInPO po) {
		return po.getType()+";"+po.getIsCheck()+";"+po.getDeliveryNum() + ";" + po.getInDate() +";"+ po.getEnd() + ";" + po.getZoneNum() + ";" + po.getRowNum()
				+ ";" + po.getShelfNum() + ";" + po.getPositionNum();
	}
	
	/**
	 * 
	 * @param po
	 * @return
	 */
	
	private String receiptPOToString(ReceiptPO po){
		String s=po.getType()+";"+po.getIsCheck()+";"+po.getReceiptDate()+";"+po.getReceiptMoney()+";"+po.getReceiptCourier()+";";
		Iterator<String> itr=po.getOrderNum();
		while(itr.hasNext()){
			s=s+";"+itr.next();
		}
		return s;
	}
	
	private String paymentPOToString(PaymentPO po){
		return po.getType()+";"+po.getIsCheck()+";"+po.getPayDate()+";"+po.getPayMoney()+";"+po.getPayHuman()+";"+po.getPayAccount()+";"+po.getPayReason()+";"+po.getPayComment();
	}
	
	private int DateToInt(String date) {
		String[] str=date.split("-");
		for(int i=1;i<str.length;i++){
			str[0]=str[0]+str[i];
		}
		 return Integer.parseInt(str[0]);
	}
	
	/**
	 * 
	 * @param po
	 * @return
	 */
	private String  gatheringPOToString(GatheringPO po) {
		return po.getType()+";"+po.getIsCheck()+";"+po.getDate()+";"+po.getWorkplace()+";"+po.getMan()+";"+po.getMoney()+";"+po.getPlace();
	}
	

	
	/**
	 * 
	 * a
	 */
	public ExpenseAndDatePO getExpenseOfTransport(ExpenseAndDatePO expenseAndDate) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		double transport=0;
		double wrapper=0;
		
		//计算运费和时间
		Common common=new Common("constant");
		ArrayList<String> list=common.readData();
		for(int i=0;i<list.size();i++){
			String[] str=list.get(i).split(";");
			//System.out.println(expenseAndDate.getCity1());
			if(str[0].equals(expenseAndDate.getCity1())&&str[1].equals(expenseAndDate.getCity2())){
				transport=Double.parseDouble(str[2])*Double.parseDouble(str[3])/1000.0;
				Double days=Double.parseDouble(str[2]);
				expenseAndDate.setDays(days.intValue()/300+"");
				if(expenseAndDate.getDeliveryType()==DeliveryType.FAST){
					transport=transport*2;
					}else if(expenseAndDate.getDeliveryType()==DeliveryType.ECONOMIC){
						transport=transport/2;
					}
				expenseAndDate.setExpenseOfTransport(transport+"");
				}else{
					throw new ExistException();
			}
		}
		
		//计算包装费
		Common common2=new Common("wrapper");
		ArrayList<String> list2=common2.readData();
		for(int i=0;i<list2.size();i++){
			String[] str2=list2.get(i).split(";");
			System.out.println(str2[0]);
			if(str2[0].equals(expenseAndDate.getWrapper())){
				wrapper=Double.parseDouble(str2[1])*Double.parseDouble(expenseAndDate.getVolume())/2.0;
				expenseAndDate.setExpenseOfWrap(wrapper+"");
				break;
				
			}else{
				throw new ExistException();
			}
		}
		expenseAndDate.setExpense((wrapper+transport)+"");
		return expenseAndDate;
	}

	@Override
	public Iterator<ListPO> getRecent(String start, String end) throws RemoteException {
		// TODO Auto-generated method stub
		int startDate=this.DateToInt(start);
		int endDate1=this.DateToInt(end);
		Iterator<ListPO> list=this.checkList();
		ArrayList<ListPO> list2=new ArrayList<>();
		while(list.hasNext()){
			int date=0;
			ListPO listPO=list.next();
			switch (listPO.getType()){
            case LOADINGINFO:
                date=this.DateToInt(((LoadingPO) listPO).getLoadingDate());
                
                break;
            case ADDRESSEEINFOMATION:
                date=this.DateToInt(((AddresseeInformationPO) listPO).getAddresseeDate());
                break;
            case DISTRIBUTEINFO:
                date=this.DateToInt(((DistributePO) listPO).getArriveDate());
                break;
            case GATHERING:
            	date=this.DateToInt(((GatheringPO) listPO).getDate());
                break;
            case ORDER:
                date=this.DateToInt(((OrderPO) listPO).getDate());
                break;
            case PAYMENT:
                date = this.DateToInt(((PaymentPO) listPO).getPayDate());
                break;
            case RECEIPT:
                date =this.DateToInt(((ReceiptPO) listPO).getReceiptDate());
                break;
            case RECEIVEINFO:
                date =this.DateToInt(((ReceivePO) listPO).getArriveDate());
                break;
            case STOCKIN:
                date = this.DateToInt(((StockInPO) listPO).getInDate());
                break;
            case STOCKOUT:
            	date = this.DateToInt(((StockOutPO) listPO).getOutDate());
                break;
            case TRANSARRIVE:
            	date = this.DateToInt(((TransferReceivePO) listPO).getArriveDate());
                break;
            case TRANSINFO:
            	date = this.DateToInt(((TransferPO) listPO).getLoadingDate());
                break;
            default:
                return null;
			}
			if(date>=startDate&&date<=endDate1){
				list2.add(listPO);
			}
		}
		return list2.iterator();
	}
	
}
