package businesslogicservice;

import util.ExistException;
import vo.*;

import java.rmi.RemoteException;
import java.util.Iterator;

/**
 * @author WANXING
 */
public interface ListblService {
//    /**
//     * @param orderVO 传入订单vo
//     * @return
//     * @throws RemoteException 网络异常
//     */
//    //订单
//    boolean order(OrderVO orderVO) throws RemoteException;
//
//    /**
//     * @param addresseeInformationVO 传入收件单vo
//     * @return
//     * @throws RemoteException 网络异常
//     */
//    //收件单
//    boolean addresseeInfomation(AddresseeInformationVO addresseeInformationVO) throws RemoteException;
//
//    /**
//     * @param loadingVO 传入装车单vo
//     * @return
//     * @throws RemoteException 网络异常
//     */
//    //装车单
//    boolean loadingInfo(LoadingVO loadingVO) throws RemoteException;
//
//    /**
//     * @param receiveVO 传入接收单vo
//     * @return
//     * @throws RemoteException 网络异常
//     */
//    //接收单
//    boolean receiveInfo(ReceiveVO receiveVO) throws RemoteException;
//
//    /**
//     * @param distributeVO 传入派件单vo
//     * @return
//     * @throws RemoteException 网络异常
//     */
//    //派件单
//    boolean distributeInfo(DistributeVO distributeVO) throws RemoteException;
//
//    /**
//     * @param receiptVO 传入营业厅业务员建的收款单vo
//     * @return
//     * @throws RemoteException 网络异常
//     */
//    //营业厅业务员建的收款单
//    boolean receipt(ReceiptVO receiptVO) throws RemoteException;
//
//    /**
//     * @param transferVO 传入中转单vo
//     * @return
//     * @throws RemoteException 网络异常
//     */
//    //中转单
//    boolean transInfo(TransferVO transferVO) throws RemoteException;
//
//    /**
//     * @param transferReceiveVO 传入中转中心到达单vo
//     * @return
//     * @throws RemoteException 网络异常
//     */
//    //中转中心到达单
//    boolean transArrive(TransferReceiveVO transferReceiveVO) throws RemoteException;
//
//    /**
//     * @param stockOutVO 传入出库单vo
//     * @return
//     * @throws RemoteException 网络异常
//     */
//    //出库单
//    boolean stockOut(StockOutVO stockOutVO) throws RemoteException;
//
//    /**
//     * @param stockInVO 传入入库单vo
//     * @return
//     * @throws RemoteException 网络异常
//     */
//    //入库单
//    boolean stockIn(StockInVO stockInVO) throws RemoteException;
//
//    /**
//     * @param gatheringVO 传入收款单vo
//     * @return
//     * @throws RemoteException 网络异常
//     */
//    //财务人员建的收款单
//    boolean gathering(GatheringVO gatheringVO) throws RemoteException;
//
//    /**
//     * 付款单
//     *
//     * @param paymentVO 传入付款单vo
//     * @return
//     * @throws RemoteException 网络异常
//     */
//    boolean payment(PaymentVO paymentVO) throws RemoteException;

    boolean afterCheck(AddresseeInformationVO vo) throws RemoteException;

    boolean afterCheck(DistributeVO vo) throws RemoteException;

    boolean afterCheck(LoadingVO vo) throws RemoteException;

    boolean afterCheck(OrderVO vo) throws RemoteException;

    boolean afterCheck(StockInVO vo) throws RemoteException;

    boolean afterCheck(StockOutVO vo) throws RemoteException;

    boolean afterCheck(PaymentVO vo) throws RemoteException;

    boolean afterCheck(GatheringVO vo) throws RemoteException;

    boolean afterCheck(TransferVO vo) throws RemoteException;

    boolean afterCheck(TransferReceiveVO vo) throws RemoteException;

    boolean afterCheck(ReceiptVO vo) throws RemoteException;

    boolean afterCheck(ReceiveVO vo) throws RemoteException;


    /**
     * 推送一个包含所有待审批单据的列表
     *
     * @return
     */
    Iterator<ListVO> push() throws RemoteException;

    /**
     * 保存为待审批
     *
     * @param vo 要保存的单据
     * @return
     * @throws ExistException  重复的编号错误
     * @throws RemoteException 网络异常
     */
//    boolean save(ListVO vo) throws  RemoteException;
    public boolean save(AddresseeInformationVO vo) throws RemoteException;

    public boolean save(DistributeVO vo) throws RemoteException;

    public boolean save(LoadingVO vo) throws RemoteException;

    public boolean save(OrderVO vo) throws RemoteException;

    public boolean save(StockInVO vo) throws RemoteException;

    public boolean save(StockOutVO vo) throws RemoteException;

    public boolean save(PaymentVO vo) throws RemoteException;

    public boolean save(GatheringVO vo) throws RemoteException;

    public boolean save(TransferVO vo) throws RemoteException;


    public boolean save(TransferReceiveVO vo) throws RemoteException;

    public boolean save(ReceiveVO vo) throws RemoteException;

    public boolean save(ReceiptVO vo) throws RemoteException;


    /**
     * 获取到目前最近订单的审批状态，传入一个起始日期
     *
     * @param date
     * @return
     * @throws RemoteException
     */
    Iterator<ListVO> getRecent(String date) throws RemoteException;

    boolean save2File(ListVO vo) throws RemoteException;

    boolean save2File(AddresseeInformationVO vo) throws RemoteException;

    boolean save2File(DistributeVO vo) throws RemoteException;

    boolean save2File(GatheringVO vo) throws RemoteException;

    boolean save2File(LoadingVO vo) throws RemoteException;

    boolean save2File(OrderVO vo) throws RemoteException;

    boolean save2File(PaymentVO vo) throws RemoteException;

    boolean save2File(ReceiptVO vo) throws RemoteException;

    boolean save2File(ReceiveVO vo) throws RemoteException;

    boolean save2File(StockInVO vo) throws RemoteException;

    boolean save2File(StockOutVO vo) throws RemoteException;

    boolean save2File(TransferReceiveVO vo) throws RemoteException;

    boolean save2File(TransferVO vo) throws RemoteException;

    OrderVO getOrder(String num) throws RemoteException;

    ExpenseAndDateVO getExpenseAndDate(ExpenseAndDateVO vo) throws RemoteException, ExistException;

    TransferReceiveVO getTransfer(String num) throws RemoteException;
}
