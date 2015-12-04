package businesslogic.financebl;

import businesslogic.Exception.DateException;
import businesslogic.Exception.InputNullException;
import businesslogic.Exception.InvalidDoubleException;
import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import data.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.financedataservice.FinanceDataService;
import po.AccountPO;
import businesslogic.utilitybl.Helper;
import businesslogic.utilitybl.IsValid;
import util.ResultMessage;
import vo.AccountVO;
import vo.GatheringVO;
import vo.PaymentVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class Finance {

    DataFactoryService dataFactory;



    FinanceDataService finance;

    public Finance() throws RemoteException {
        dataFactory=DataFactory.getInstance();
        finance = dataFactory.getFinanceData();
    }

    public ResultMessage gathering(GatheringVO gatheringVO) throws DateException, InvalidDoubleException {
        ListblService list=new ListController();
        /**
         *判断输入是否合法
         */
        if(Helper.compareTo(gatheringVO.getDate()))
            throw new DateException("日期错误！");
        if(!InvalidDoubleException.isValid(gatheringVO.getMoney()))
            throw new InvalidDoubleException("金额数据错误！");

        list.gathering(gatheringVO);

        return ResultMessage.SUCCESS;
    }

    public ResultMessage payment(PaymentVO paymentVO) throws DateException, InvalidDoubleException {
        ListblService list=new ListController();

        /**
         *判断输入是否合法
         */
        if(Helper.compareTo(paymentVO.getPayDate()))
            throw new DateException("日期错误！");
        if(!InvalidDoubleException.isValid(paymentVO.getPayMoney()))
            throw new InvalidDoubleException("金额数据错误！");

        list.payment(paymentVO);
        return ResultMessage.SUCCESS;
    }

    public ResultMessage generateForm() {
        finance.get();

        return ResultMessage.SUCCESS;
    }

    public ResultMessage generateForm(String startDate, String endDate) throws DateException, RemoteException {
        /**
         *判断输入是否合法
         */
        if(Helper.compareTo(endDate,startDate))
            throw new DateException("日期错误！");


        finance.get(startDate,endDate);
        return ResultMessage.SUCCESS;
    }

    //TODO data层接口待讨论
    public ResultMessage initial(String institution) {
        return null;
    }

    public ResultMessage addAccount(AccountVO accountVO) throws InvalidDoubleException, InputNullException {
        if(!IsValid.isDouble(accountVO.getAccountBalance())){
            //金额数据异常
            throw new InvalidDoubleException("账户余额数据错误!");
        }
        if(accountVO.getAccountName().length()==0){
            //缺少账户名
            throw new InputNullException("请输入账户名");
        }
        finance.addAccount(new AccountPO(accountVO.getAccountName(),accountVO.getAccountBalance()));
        //数据层的异常……
        return ResultMessage.SUCCESS;
    }

    /**
     * 完成
     * @return
     */
    public ArrayList<AccountVO> searchAccount() throws RemoteException {
        ArrayList<AccountPO> accountPOList=finance.searchAccount();
        ArrayList<AccountVO> accountVOList=new ArrayList<AccountVO>();

        for(AccountPO temp:accountPOList){
            accountVOList.add(new AccountVO(temp.getAccountName(),temp.getAccountBalance()));
        }

        return accountVOList;
    }

    public AccountVO searchAccount(String name) {
        if (name.length()==0){
            //抛出找不到的异常
        }
        AccountPO accountPO=finance.searchAccount(name);
        AccountVO accountVO=new AccountVO(accountPO.getAccountName(),accountPO.getAccountBalance());
        return accountVO;
    }

    public ResultMessage DelAccount(AccountVO accountVO) {
        AccountPO accountPO=new AccountPO(accountVO.getAccountName(),accountVO.getAccountBalance());

        return finance.DelAccount(accountPO);
    }

    public ResultMessage EditAccount(AccountVO accountVOOld, AccountVO accountVONew) throws InvalidDoubleException {
        //判断输入的合法性
        if(accountVONew.getAccountName().length()==0)
            accountVONew.setAccountName(accountVOOld.getAccountName());
        if (accountVONew.getAccountBalance().length()==0)
            accountVONew.setAccountBalance(accountVOOld.getAccountBalance());
        else if (!InvalidDoubleException.isValid(accountVONew.getAccountBalance()))
            //新输入的金额数据异常
            throw new InvalidDoubleException("账户余额格式错误！");
        if(accountVOOld.getAccountName()==accountVONew.getAccountName()&&accountVOOld.getAccountBalance()==accountVONew.getAccountBalance()){
            //throw ExistException
        }
            //名字与已存在的是否冲突交给数据层判断
        AccountPO accountPO=new AccountPO(accountVONew.getAccountName(),accountVONew.getAccountBalance());
        return finance.EditAccount(accountVOOld.getAccountName(),accountPO);
    }
}
