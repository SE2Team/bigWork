package data.financedata;

import data.Common.Common;
import dataservice.financedataservice.FinanceDataService;
import po.*;
import util.ExistException;
import util.ListState;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by MYK on 2015/11/23 0023.
 */
public class FinancedataImpl extends UnicastRemoteObject implements FinanceDataService {
    public FinancedataImpl() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    public ArrayList<String> get() throws RemoteException {
        // TODO Auto-generated method stub
        ArrayList<String> list1 = new ArrayList<>();
        double paymentMoney = 0;
        double gatheringMoney = 0;
        Common common = new Common("payment");
        ArrayList<String> list = common.readData();
        if (list.size() != 0) {
            for (int j = 0; j < list.size(); j++) {
                String[] str = list.get(j).split(";");
                paymentMoney = paymentMoney + Double.parseDouble(this.stringToPaymentPO(str).getPayMoney());
            }
        }
        Common common2 = new Common("gathering");
        ArrayList<String> list2 = common2.readData();
        if (list2.size() != 0) {
            for (int i = 0; i < list2.size(); i++) {
                String[] str2 = list2.get(i).split(";");
                gatheringMoney = gatheringMoney + Double.parseDouble(this.stringToGatheringPO(str2).getMoney());
            }
        }
        list1.add(gatheringMoney + "");
        list1.add(paymentMoney + "");
        list1.add((gatheringMoney - paymentMoney) + "");
        return list1;
    }

    public ArrayList<String> get(String startDate, String endDate) throws RemoteException {
        // TODO Auto-generated method stub
        double paymentMoney = 0;
        double gatheringMoney = 0;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> payment = new ArrayList<String>();
        ArrayList<String> gathering = new ArrayList<String>();
        int start = this.DateToInt(startDate);
        int end = this.DateToInt(endDate);
        Common common = new Common("payment");
        ArrayList<String> list = common.readData();
        if (list.size() != 0) {
            for (int j = 0; j < list.size(); j++) {
                String[] str = list.get(j).split(";");
                int date = this.DateToInt(this.stringToPaymentPO(str).getPayDate());
                if (date >= start && date <= end) {
                    payment.add(list.get(j));
                }

            }
        }
        Common common2 = new Common("gathering");
        ArrayList<String> list2 = common2.readData();
        if (list2.size() != 0) {
            for (int i = 0; i < list2.size(); i++) {
                String[] str = list2.get(i).split(";");
                int date = this.DateToInt(this.stringToGatheringPO(str).getDate());
                if (date >= start && date <= end) {
                    gathering.add(list2.get(i));
                }
            }
        }
        for (int j = 0; j < payment.size(); j++) {
            String[] str = payment.get(j).split(";");
            paymentMoney = paymentMoney + Double.parseDouble(this.stringToPaymentPO(str).getPayMoney());
        }

        for (int i = 0; i < gathering.size(); i++) {
            String[] str2 = gathering.get(i).split(";");
            gatheringMoney = gatheringMoney + Double.parseDouble(this.stringToGatheringPO(str2).getMoney());
        }
        list1.add(gatheringMoney + "");
        list1.add(paymentMoney + "");
        list1.add((gatheringMoney - paymentMoney) + "");
        return list1;
    }

    public Boolean addAccount(AccountPO accountPO) throws ExistException {
        // TODO Auto-generated method stub
        Common common = new Common("account");
        ArrayList<String> list = common.readData();
        AccountPO po;
        for (int j = 0; j < list.size(); j++) {
            String[] str = list.get(j).split(";");
            po = this.stringToAccountPO(str);
            if (po.getAccountName().equals(accountPO.getAccountName())) {
                throw new ExistException();
            }
        }
        common.writeDataAdd(this.poToString(accountPO));
        return true;
    }

    public ArrayList<AccountPO> searchAccount() throws RemoteException {
        // TODO Auto-generated method stub
        Common common = new Common("account");
        ArrayList<String> s = common.readData();
        ArrayList<AccountPO> list = new ArrayList<AccountPO>();
        for (int j = 0; j < s.size(); j++) {
            String[] str = s.get(j).split(";");
            list.add(this.stringToAccountPO(str));
        }
        return list;
    }

    public AccountPO searchAccount(String name) throws RemoteException {
        // TODO Auto-generated method stub
        Common common = new Common("account");
        ArrayList<String> s = common.readData();
        for (int j = 0; j < s.size(); j++) {
            String[] str = s.get(j).split(";");
            if (str[0].equals(name)) {
                return this.stringToAccountPO(str);
            }
        }
        return null;
    }

    public Boolean DelAccount(AccountPO accountPO) throws RemoteException {
        // TODO Auto-generated method stub
        Common common = new Common("account");
        ArrayList<String> s = common.readData();
        s.remove(this.poToString(accountPO));
        common.clearData("account");
        common.writeData(s);
        return true;
    }

    public Boolean EditAccount(String name, AccountPO newAccountPO) throws RemoteException, ExistException {
        // TODO Auto-generated method stub
        Common common = new Common("account");
        ArrayList<String> s = common.readData();
        for (int i = 0; i < s.size(); i++) {
            String[] str = s.get(i).split(";");
            if (this.stringToAccountPO(str).getAccountName().equals(name)) {
                s.remove(i);
                s.add(this.poToString(newAccountPO));
                common.clearData("account");
                common.writeData(s);
                return true;
            } else {
                throw new ExistException();
            }
        }
        return null;
    }

    /**
     * po to String
     */
    private String poToString(AccountPO po) {
        return po.getAccountName() + ";" + po.getAccountBalance();

    }

    private VehiclePO stringToVehiclePO(String[] str) {
        return new VehiclePO(str[0], str[1], str[2], str[3]);
    }

    private AccountPO stringToAccountPO(String[] str) {
        return new AccountPO(str[0], str[1]);
    }

    private PaymentPO stringToPaymentPO(String[] str) {
        ListState isCheck = ListState.UNCHECK;
        if (str[6].equals("PASSED")) {
            isCheck = ListState.PASSED;
        } else if (str[6].equals("REJECTED")) {
            isCheck = ListState.REJECTED;
        }
        return new PaymentPO(str[0], str[1], str[2], str[3], str[4], str[5], isCheck);
    }

    private GatheringPO stringToGatheringPO(String[] str) {
        ListState isCheck = ListState.UNCHECK;
        if (str[6].equals("PASSED")) {
            isCheck = ListState.PASSED;
        } else if (str[6].equals("REJECTED")) {
            isCheck = ListState.REJECTED;
        }
        return new GatheringPO(str[0], str[1], str[2], str[3], str[4], isCheck);
    }

    private int DateToInt(String date) {
        String[] str = date.split("-");
        for (int i = 1; i < str.length; i++) {
            str[0] = str[0] + str[i];
        }
        System.out.println(str[0]);
        return Integer.parseInt(str[0]);
    }

    private String pOToString(WorkerPO po) {
        return po.getName() + ";" + po.getIdNum() + ";" + po.getPosition() + ";" + po.getOrganization() + ";" +
                po.getUserId() + po.getAge();
    }

    private String pOToString(VehiclePO po) {
        return po.getVehicleNum() + ";" + po.getLicensePlate() + ";" + po.getBuyDate() + ";" + po.getUseTime();
    }

    private ArrayList<String> pOToString(StockPO po) {
        ArrayList<StockInPO> list = po.getStockList();
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add(po.getStockState() + "");
        for (int i = 0; i < list.size(); i++) {
            StockInPO po1 = list.get(i);
            String str = po1.getIsCheck() + ";" + po1.getType() + ";" + po1.getDeliveryNum() + ";" + po1.getInDate() + ";" + po1.getEnd() + ";" + po1.getZoneNum() + ";" + po1.getShelfNum() + ";" + po1.getPositionNum();
            list2.add(str);
        }
        return list2;
    }

    private WorkerPO stringToWorkerPO(String[] str) {
        return new WorkerPO(str[0], str[1], str[2], str[3], str[4], str[5], str[6]);
    }

    @Override
    public boolean initial(WorkerPO po) throws RemoteException {
        // TODO Auto-generated method stub
        Common common = new Common("initialWorker");
        common.writeDataAdd(this.pOToString(po));
        return true;
    }

    @Override
    public boolean initial(VehiclePO po) throws RemoteException {
        // TODO Auto-generated method stub
        Common common = new Common("initialVehicle");
        common.writeDataAdd(this.pOToString(po));
        return true;
    }

    @Override
    public boolean initial(StockPO po) throws RemoteException {
        // TODO Auto-generated method stub
        ArrayList<String> list = this.pOToString(po);
        Common common = new Common("initialStock");
        common.clearData("initialStock");
        common.writeData(list);
        return true;
    }

    @Override
    public boolean initial(AccountPO po) throws RemoteException {
        // TODO Auto-generated method stub
        Common common = new Common("initialAccount");
        common.writeDataAdd(poToString(po));
        return true;
    }

    @Override
    public ArrayList<WorkerPO> checkInitWorker() throws RemoteException {
        // TODO Auto-generated method stub
        Common common = new Common("initialWorker");
        ArrayList<String> list = common.readData();
        ArrayList<WorkerPO> list2 = new ArrayList<WorkerPO>();
        for (int j = 0; j < list.size(); j++) {
            String[] str = list.get(j).split(";");
            list2.add(this.stringToWorkerPO(str));
        }
        return list2;

    }

    @Override
    public ArrayList<VehiclePO> checkInitVehicle() throws RemoteException {
        // TODO Auto-generated method stub
        Common common = new Common("initialVehicle");
        ArrayList<String> list = common.readData();
        ArrayList<VehiclePO> list2 = new ArrayList<VehiclePO>();

        for (int j = 0; j < list.size(); j++) {
            String[] str = list.get(j).split(";");
            list2.add(stringToVehiclePO(str));
        }
        return list2;
    }

    @Override
    public ArrayList<AccountPO> checkInitAccount() throws RemoteException {
        // TODO Auto-generated method stub
        Common common = new Common("initialAccount");
        ArrayList<String> list = common.readData();
        ArrayList<AccountPO> list2 = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            String[] str = list.get(j).split(";");
            list2.add(stringToAccountPO(str));
        }
        return list2;
    }

    @Override
    public StockPO checkInitStock() throws RemoteException {
        // TODO Auto-generated method stub
        Boolean stockState = false;
        Common common = new Common("initialStock");
        ArrayList<StockInPO> list2 = new ArrayList<>();
        ArrayList<String> list = common.readData();
        if (list.size() != 0) {
            if (list.get(0).equals("true")) {
                stockState = true;
            }
        }
        for (int j = 1; j < list.size(); j++) {
            String[] str = list.get(j).split(";");
            list2.add(stringToPO(str));
        }

        return new StockPO(stockState, list2);
    }

    private StockInPO stringToPO(String[] str) {
        ListState isCheck = ListState.UNCHECK;
        if (str[0].equals("PASSED")) {
            isCheck = ListState.PASSED;
        } else if (str[0].equals("REJECTED")) {
            isCheck = ListState.REJECTED;
        }
        return new StockInPO(str[2], str[3], str[4], str[5], str[6], str[7], str[8], isCheck);
    }

    @Override
    public ArrayList<GatheringPO> getGathering() throws RemoteException {
        // TODO Auto-generated method stub
        Common common = new Common("gathering");
        ArrayList<String> list = common.readData();
        ArrayList<GatheringPO> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] str = list.get(i).split(";");
            ListState isCheck = ListState.UNCHECK;
            if (str[5].equals("PASSED")) {
                isCheck = ListState.PASSED;
            } else if (str[5].equals("REJECTED")) {
                isCheck = ListState.REJECTED;
            }
            list1.add(new GatheringPO(str[0], str[1], str[2], str[3], str[4], isCheck));
        }
        return list1;
    }

    @Override
    public boolean initial(OrganizationPO po) throws RemoteException, ExistException {
        // TODO Auto-generated method stub
        Common common = new Common("initialOrganization");
        ArrayList<String> list = common.readData();
        String string = this.PoToString(po);
        if (list.contains(string)) {
            throw new ExistException();
        }
        common.writeDataAdd(string);
        return true;
    }

    @Override
    public ArrayList<OrganizationPO> checkInitOrganization() throws RemoteException {
        // TODO Auto-generated method stub
        Common common = new Common("initialOrganization");
        ArrayList<String> list = common.readData();
        ArrayList<OrganizationPO> list1 = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            String[] str = list.get(j).split(";");
            list1.add(new OrganizationPO(str[0], str[1], str[2]));
        }
        return list1;
    }

    private String PoToString(OrganizationPO po) {
        return po.getNum() + ";" + po.getCity() + ";" + po.getName();
    }
}
