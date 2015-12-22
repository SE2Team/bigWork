package data.inquirydata;

import data.Common.Common;
import dataservice.inquirydataservice.InquiryDataService;
import po.LogisticsPO;
import po.OperationLogPO;
import util.ExistException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by MYK on 2015/11/23 0023.
 */
public class InquirydataImpl extends UnicastRemoteObject implements InquiryDataService{

	public InquirydataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogisticsPO checkLogistics(String num) throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("logistics");
		ArrayList<String> list = common.readData();
		String[] str = new String[2];
		for (int j = 0; j < list.size(); j++) {
			str = list.get(j).split(";");
			if (str[0].equals(num)) {
				return this.stringToLogisticsPO(str);
			}
		}
		return null;
	}

	public ArrayList<OperationLogPO> checkOperationLog() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("operationLog");
		ArrayList<String> s = common.readData();

		ArrayList<OperationLogPO> list = new ArrayList<OperationLogPO>();
		for (int j = 0; j < s.size(); j++) {
            String[]  str = s.get(j).split(";");
			list.add(this.stringToOperationLogPO(str));
		}
		return list;
	}



	public String checkForm(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean updateLogistics(LogisticsPO po) throws RemoteException, ExistException {
		// TODO Auto-generated method stub
		Common common = new Common("logistics");
		ArrayList<String> list = common.readData();
		String[] str = new String[2];
		for (int j = 0; j < list.size(); j++) {
			str = list.get(j).split(";");
			if (str[0].equals(po.getDeliveryNum())) {
				list.remove(j);
				list.add(this.logisticsPOToString(po));
				common.clearData("logistics");
				common.writeData(list);
				return true;
			}else{
				throw new ExistException();
			}
		}
		return null;
	}

    @Override
    public boolean saveOperationLog(OperationLogPO po) throws RemoteException {
        Common common=new Common("OperationLog");
        common.writeDataAdd(this.poToString(po));
        return true;
    }

    private LogisticsPO stringToLogisticsPO(String[] str) {
		return new LogisticsPO(str[0], str[1]);
	}

	private String logisticsPOToString(LogisticsPO po) {
		return po.getDeliveryNum() + ";" + po.getTransportState();
	}

	private OperationLogPO stringToOperationLogPO(String[] str) {
		return new OperationLogPO(str[0], str[1], str[2]);
	}

    private String poToString(OperationLogPO po){
        return po.getTime()+";"+po.getHuman()+";"+po.getType();
    }

}
