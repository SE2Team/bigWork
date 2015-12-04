package businesslogicservice;

import businesslogic.Exception.DateException;
import businesslogic.Exception.InvalidInput;
import businesslogic.Exception.TransferException;
import util.ResultMessage;
import vo.StockInVO;
import vo.StockOutVO;
import vo.StockVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CommodityblService {
    //出库

    public ResultMessage stockOut(StockOutVO stockOutVO) throws TransferException, InvalidInput, DateException, RemoteException;

    public ResultMessage stockIn(StockInVO stockInVO) throws DateException, InvalidInput, RemoteException;

    //日期的格式必须是：yyyy-mm-dd
    public StockVO checkStock(String startDate, String endDate);


    public ArrayList<StockInVO> stockSum();
}
