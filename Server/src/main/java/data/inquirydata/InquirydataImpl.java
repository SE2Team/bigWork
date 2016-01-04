package data.inquirydata;

import data.Common.Common;
import dataservice.inquirydataservice.InquiryDataService;
import po.OperationLogPO;

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


    @Override
    public boolean saveOperationLog(OperationLogPO po) throws RemoteException {
        Common common=new Common("OperationLog");
        common.writeDataAdd(this.poToString(po));
        return true;
    }



	private OperationLogPO stringToOperationLogPO(String[] str) {
//		System.out.println(str);
        return new OperationLogPO(str[0], str[1], str[2]);
	}

    private String poToString(OperationLogPO po){
        return po.getTime()+";"+po.getHuman()+";"+po.getType();
    }

}
