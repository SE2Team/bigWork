package businesslogic.financebl;

import businesslogic.listbl.ListController;
import businesslogic.utilitybl.Helper;
import businesslogicservice.ListblService;
import dataservice.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.financedataservice.FinanceDataService;
import dataservice.inquirydataservice.InquiryDataService;
import po.AccountPO;
import po.OperationLogPO;
import util.ExistException;
import vo.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/25 0025.
 *
 * @author myk
 */
public class Finance {

    private InquiryDataService inquiryDataService;


    /**
     * The Finance.
     */
    private FinanceDataService finance;

    /**
     * Instantiates a new Finance.
     *
     * @throws RemoteException the remote exception
     */
    public Finance() throws RemoteException {
        /*
      The Data factory.
     */
        DataFactoryService dataFactory = DataFactory.getInstance();
        finance = dataFactory.getFinanceData();
        inquiryDataService=dataFactory.getInquiryData();
    }

    /**
     * Gathering result message.
     *
     * @param gatheringVO the gathering vo
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public boolean gathering(GatheringVO gatheringVO) throws RemoteException {
        ListblService list = new ListController();
        /**
         *判断输入是否合法
         */



        inquiryDataService.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"新建收款单"));

        return list.save(gatheringVO);
    }

    /**
     * Payment result message.
     *
     * @param paymentVO the payment vo
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public boolean payment(PaymentVO paymentVO) throws RemoteException {
        ListblService list = new ListController();

        /**
         *判断输入是否合法
         */

        inquiryDataService.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"新建付款单"));

        return list.save(paymentVO);
    }

    /**
     * Generate form result message.
     * 看不到内容
     *
     * @return the result message
     */
    public boolean generateForm() throws RemoteException {
        finance.get();

        inquiryDataService.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"生成报表"));

        return true;
    }

    /**
     * Generate form result message.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public boolean generateForm(String startDate, String endDate) throws RemoteException {

        inquiryDataService.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"生成报表"));

        finance.get(startDate, endDate);
        return false;
    }


    /**
     * Add account result message.
     *
     * @param accountVO the account vo
     * @return the result message
     */
    public boolean addAccount(AccountVO accountVO) throws RemoteException, ExistException {

        inquiryDataService.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"新增账户"));


        return finance.addAccount(new AccountPO(accountVO.getAccountName(), accountVO.getAccountBalance()));
    }

    /**
     * 完成
     *
     * @return array list
     * @throws RemoteException the remote exception
     */
    public ArrayList<AccountVO> searchAccount() throws RemoteException {
        ArrayList<AccountPO> accountPOList = finance.searchAccount();
        ArrayList<AccountVO> accountVOList = new ArrayList<AccountVO>();

        for (AccountPO temp : accountPOList) {
            accountVOList.add(new AccountVO(temp.getAccountName(), temp.getAccountBalance()));
        }


        return accountVOList;
    }

    /**
     * Search account account vo.
     *
     * @param name the name
     * @return the account vo
     */
    public AccountVO searchAccount(String name) throws RemoteException {
        AccountPO accountPO = finance.searchAccount(name);
        return new AccountVO(accountPO.getAccountName(), accountPO.getAccountBalance());
    }

    /**
     * Del account result message.
     *
     * @param accountVO the account vo
     * @return the result message
     */
    public boolean DelAccount(AccountVO accountVO) throws RemoteException {
        AccountPO accountPO = new AccountPO(accountVO.getAccountName(), accountVO.getAccountBalance());

        inquiryDataService.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"删除账户"));

        return finance.DelAccount(accountPO);
    }

    /**
     * Edit account result message.
     *
     * @param accountVOOld the account vo old
     * @param accountVONew the account vo new
     * @return the result message
     */
    public boolean EditAccount(AccountVO accountVOOld, AccountVO accountVONew) throws RemoteException, ExistException {

        AccountPO accountPO = new AccountPO(accountVONew.getAccountName(), accountVONew.getAccountBalance());


        inquiryDataService.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"编辑账户"));
        return finance.EditAccount(accountVOOld.getAccountName(), accountPO);
    }

    /**
     * @param vo
     * @return
     * @throws RemoteException
     */
    boolean initial(WorkerVO vo) throws RemoteException{

        inquiryDataService.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"期初建账：机构信息"));
        return finance.initial(VO2PO.convert(vo));
    }

    /**
     * @param vo
     * @return
     * @throws RemoteException
     */
    boolean initial(VehicleVO vo) throws RemoteException{

        inquiryDataService.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"期初建账：车辆信息"));
        return finance.initial(VO2PO.convert(vo));
    }

    /**
     *
     *
     * @param vo
     * @return
     */
    boolean initial(StockVO vo) throws RemoteException{


        inquiryDataService.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"期初建账：库存信息"));
        return finance.initial(VO2PO.convert(vo));

    }

    /**
     * @param vo
     * @return
     * @throws RemoteException
     */
    boolean initial(AccountVO vo) throws RemoteException{

        inquiryDataService.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"期初建账：账户信息"));
        return finance.initial(VO2PO.convert(vo));

    }
}
