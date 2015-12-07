package businesslogicservice;

import util.ExistException;
import vo.*;

import java.rmi.RemoteException;
import java.util.Iterator;

public interface ListblService {
    //订单
    boolean order(OrderVO orderVO) throws RemoteException;

    //收件单
    boolean addresseeInfomation(AddresseeInformationVO addresseeInformationVO) throws RemoteException;

    //装车单
    boolean loadingInfo(LoadingVO loadingVO) throws RemoteException;

    //接收单
    boolean receiveInfo(ReceiveVO receiveVO) throws RemoteException;

    //派件单
    boolean distributeInfo(DistributeVO distributeVO) throws RemoteException;

    //营业厅业务员建的收款单
    boolean receipt(ReceiptVO receiptVO) throws RemoteException;

    //中转单
    boolean transInfo(TransferVO transferVO) throws RemoteException;

    //中转中心到达单
    boolean transArrive(TransferReceiveVO transferReceiveVO) throws RemoteException;

    //入库单
    boolean stockOut(StockOutVO stockOutVO) throws RemoteException;

    //出库单
    boolean stockIn(StockInVO stockInVO) throws RemoteException;

    //财务人员建的收款单
    boolean gathering(GatheringVO gatheringVO) throws RemoteException;

    /**
     * 付款单
     * @param paymentVO
     * @return
     * @throws RemoteException
     */
    boolean payment(PaymentVO paymentVO) throws RemoteException;


    /**
     * 推送一个包含所有待审批单据的列表
     * @return
     */
    Iterator<ListVO> push()throws RemoteException;

    /**
     * 真正保存到数据中。根据不同类型不同保存方法实现
     * @param vo 要保存的单据
     * @throws ExistException 重复的编号错误
     * @throws RemoteException
     * @return
     */
    boolean save(ListVO vo) throws ExistException, RemoteException;
}
