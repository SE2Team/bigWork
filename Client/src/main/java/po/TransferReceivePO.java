package po;

import util.ListType;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class TransferReceivePO extends ListPO implements Serializable{
	private static final long serialVersionUID = 1L;//���л����
	/**
	 * 
	 * ���ļ�����ţ��������ڣ������أ�����״̬���𻵡���������ʧ������ת���ı�ţ���ת�����
	 */
	
//	private String orderNum;
	private String arriveDate;
	private String start;
	private String cargoState;
	private String transferCenterNum;
	private String transferNum;

	public TransferReceivePO(String arriveDate, String start,
							 String cargoState, String transferCenterNum, String transferNum,
							 boolean isCheck) {
		super(isCheck);
//		this.orderNum = orderNum;
		this.arriveDate = arriveDate;
		this.start = start;
		this.cargoState = cargoState;
		this.transferCenterNum = transferCenterNum;
		this.transferNum = transferNum;
        setType(ListType.TRANSARRIVE);
	}

//	public void setOrderNum(String orderNum){
//		this.orderNum=orderNum;
//	}
//
//	public String getOrderNum(){
//		return orderNum;
//	}
	
	public void setArriveDate(String arriveDate){
		this.arriveDate=arriveDate;
	}
	
	public String getArriveDate(){
		return arriveDate;
	}
	
	public void setStart(String start){
		this.start=start;
	}
	
	public String getStart(){
		return start;
	}
	
	public void setCargoState(String cargoState){
		this.cargoState=cargoState;
	}
	
	public String getCargoState(){
		return cargoState;
	}
	
	public void setTransferCenterNum(String transferCenterNum){
		this.transferCenterNum=transferCenterNum;
	}
	
	public String getTransferCenterNum(){
		return transferCenterNum;
	}
	
	public void setTransferNum(String transferNum){
		this.transferNum=transferNum;
	}
	
	public String getTransferNum(){
		return transferNum;
	}

	public String getClassName() {
		return "TransferReceive";
	}

}	