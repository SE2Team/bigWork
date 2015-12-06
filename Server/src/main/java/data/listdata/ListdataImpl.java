package data.listdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.print.attribute.standard.RequestingUserName;

import data.Common.Common;
import dataservice.listdataservice.ListDataService;
import po.*;
import util.ResultMessage;

/**
 * Created by MYK on 2015/11/23 0023.
 */
public class ListdataImpl extends UnicastRemoteObject implements ListDataService {

	public ListdataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage save(OrderPO orderPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("order");
		common.writeDataAdd(this.orderPoToString(orderPO));
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(AddresseeInformationPO addresseeInformationPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("addresseeInformation");
		common.writeDataAdd(this.addresseeInfoPOToString(addresseeInformationPO));
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(LoadingPO loadingPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("loading");
		common.writeDataAdd(this.loadingPOToString(loadingPO));
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(ReceivePO receivePO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("receive");
		common.writeDataAdd(this.receivePOToString(receivePO));
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(DistributePO distributePO) throws RemoteException {
		// TODO Auto-generated method stub
		
		Common common=new Common("distribute");
		common.writeDataAdd(this.distributePOToString(distributePO));
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(ReceiptPO receiptPO) throws RemoteException {
		// TODO Auto-generated method stub
		
		Common common=new Common("receipt");
		common.writeDataAdd(this.receiptPOToString(receiptPO));
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(TransferPO transferPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("transfer");
		common.writeDataAdd(this.transferPOToString(transferPO));
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(TransferReceivePO transferReceivePO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("transferReceive");
		common.writeDataAdd(this.transferReceivePOToString(transferReceivePO));
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(StockOutPO stockOutPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("stockOut");
		common.writeDataAdd(this.stockOutPOToString(stockOutPO));
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(StockInPO stockInPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("stockIn");
		common.writeDataAdd(this.stockInPOToString(stockInPO));
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(PaymentPO paymentPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("payment");
		common.writeDataAdd(this.paymentPOToString(paymentPO));
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(GatheringPO gatheringPO) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("gathering");
		common.writeDataAdd(this.gatheringPOToString(gatheringPO));
		return ResultMessage.SUCCESS;
	}

	public ResultMessage saveAsList(ListPO listPo) throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("list");
		common.writeDataAdd(this.listPOToString(listPo));
		return ResultMessage.SUCCESS;
	}

	public ArrayList<ListPO> checkList() throws RemoteException {
		// TODO Auto-generated method stub
		Common common=new Common("list");
		String[] str=new String[3];
		boolean isCheck=false;
		if(str[2].equals("true")){
			isCheck=true;
		}
		ArrayList< String> list=common.readData();
		ArrayList<ListPO> listPO=new ArrayList<ListPO>();
		
		for(int j=0;j<list.size();j++){
			str=list.get(j).split(";");
			listPO.add(new ListPO(str[0], str[1],isCheck));
		}
		
		return listPO;
	}

	/**
	 * 
	 * @param OrderPO
	 * @return
	 */
	private String orderPoToString(OrderPO po) {
		return po.getSenderName() + ";" + po.getSenderAddress() + ";" + po.getSenderWorkplace() + ";"
				+ po.getSenderTelephone() + ";" + po.getSenderPhone() + ";" + po.getReceiverName() + ";"
				+ po.getReceiverAddress() + po.getReceiverWorkplace() + ";" + po.getReceiverTelephone() + ";"
				+ po.getReceiverPhone() + ";" + po.getOriginalNum() + ";" + po.getWeight() + ";" + po.getVolume() + ";"
				+ po.getGoods_Name() + ";" + po.getDeliveryType() + ";" + po.getWrapper() + ";"
				+ po.getExpenseOfTransport() + ";" + po.getExpenseOfWrapper() + ";" + po.getExpense() + ";"
				+ po.getDate() + ";" + po.getDeliveryNum();
	}

	/**
	 * 
	 * @param AddresseeInformationPO
	 * @return
	 */
	private String addresseeInfoPOToString(AddresseeInformationPO po) {
		return po.getAddresseeNum() + ";" + po.getAddresseeName() + ";" + po.getAddresseeDate();
	}

	/**
	 * 
	 * @param LoadingPO
	 * @return
	 */
	private String loadingPOToString(LoadingPO po) {
		return po.getLoadingDate() + ";" + po.getHallNum() + ";" + po.getTransportNum() + ";" + po.getStart() + ";"
				+ po.getEnd() + ";" + po.getMonitor() + ";" + po.getSupercargo() + ";" + po.getVehicleNum() + ";"
				+ po.getConsignList() + ";" + po.getTransportMoney();
	}

	/**
	 * 
	 * @param ReceivePO
	 * @return
	 */
	private String receivePOToString(ReceivePO po) {
		return po.getArriveDate() + ";" + po.getTransferNum() + ";" + po.getStart() + ";" + po.getArriveDate();
	}

	/**
	 * 
	 * @param DistributePO
	 * @return
	 */
	private String distributePOToString(DistributePO po) {
		return po.getArriveDate() + ";" + po.getOrderNum() + ";" + po.getDistributeHuman();
	}

	/**
	 * 
	 * @param TransferPO
	 * @return
	 */
	private String transferPOToString(TransferPO po) {
		return po.getLoadingWay() + ";" + po.getLoadingDate() + ";" + po.getTransportNum() + ";" + po.getVehicleNum()
				+ ";" + po.getVehicleNum() + ";" + po.getStart() + ";" + po.getEnd() + ";" + po.getContainerNum() + ";"
				+ po.getMonitor() + ";" + po.getSupercargo() + ";" + po.getOrderNum() + ";" + po.getMoney();
	}
	
	/**
	 * 
	 * @param po
	 * @return
	 */
	private String transferReceivePOToString(TransferReceivePO po) {
		return po.getArriveDate() + ";" + po.getArriveDate() + ";" + po.getStart() + ";" + po.getCargoState() + ";"
				+ po.getTransferCenterNum() + ";" + po.getTransferNum();
	}
	
	/**
	 * 
	 * @param po
	 * @return
	 */
	private String stockOutPOToString(StockOutPO po) {
		return po.getDeliveryNum() + ";" + po.getOutDate() + ";" + po.getEnd() + ";" + po.getLoadingWay() + ";"
				+ po.getTransferNum();
	}
	
	/**
	 * 
	 * @param po
	 * @return
	 */
	private String stockInPOToString(StockInPO po) {
		return po.getDeliveryNum() + ";" + po.getInDate() + po.getEnd() + ";" + po.getZoneNum() + ";" + po.getRowNum()
				+ ";" + po.getShelfNum() + ";" + po.getPositionNum();
	}
	
	/**
	 * 
	 * @param po
	 * @return
	 */
	
	private String receiptPOToString(ReceiptPO po){
		return po.getReceiptDate()+";"+po.getReceiptMoney()+";"+po.getReceiptCourier()+";"+po.getOrderNum();
	}
	
	private String paymentPOToString(PaymentPO po){
		return po.getPayDate()+";"+po.getPayMoney()+";"+po.getPayHuman()+";"+po.getPayAccount()+";"+po.getPayReason()+";"+po.getPayComment();
	}
	
	/**
	 * 
	 * @param po
	 * @return
	 */
	private String  gatheringPOToString(GatheringPO po) {
		return po.getDate()+";"+po.getWorkplace()+";"+po.getMan()+";"+po.getMoney()+";"+po.getPlace();
	}
	
	/**
	 * 
	 * @param po
	 * @return
	 */
	private String listPOToString(ListPO po){
		if(po.getIsCheck()==true){
			return po.getId()+";"+po.getContent()+";"+"true";
		}
		return po.getId()+";"+po.getContent()+";"+"false";
		
	}

}
