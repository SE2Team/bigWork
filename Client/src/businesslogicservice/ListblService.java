package businesslogicservice;

import enumClass.City;
import enumClass.TransportType;
import enumClass.DeliveryType;
import vo.OrderVO;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface ListblService {
	//订单
    public OrderVO order(String senderName, String senderAddress, String senderWorkplace, String senderTelephone,
                         String senderPhone, String receiverName, String receiverAddress, String receiverWorkplace,
                         String receiverTelephone, String receiverPhone, int originalNum, double weight, double volume,
                         String goods_Name, DeliveryType DeliveryType, String wrapper);
    //收件单
    public void addresseeInfomation(String num, String name);
    //装车单
    public void loadingInfo(String date, String businessHallNum, String transferNum, String destination, String carNum,
                            String name1, String name2, String orderNum);
    //接收单
    public void receiveInfo(String date, String transferNum, String departPlace, String state);
    //派件单
    public void distributeInfo(String date, String orderNum, String name);
    //营业厅业务员建的收款单
    public void receipt(String date, String amount, String name, String orderNum);
    //中转单
    public void transInfo(String way, String date, String Num, String transNum, String departPlace, String destination,
                          String locNum, String name, String consignNum);
    //中转中心到达单
    public void transArrive(String transCenterNum, String arriveDate, String transNum, String departPlace, String state);
    //入库单
    public void stockOut(String deliveryNum, String outDate,
                         City city, TransportType transportType, String transferNum);
    //出库单
    public void stockIn(String deliveryNum, String outDate,
                        City city);
    //财务人员建的收款单
    public void receipt(String date, String orgnization, String name, double amount, String place);
    //付款单
    public void payment(String date, int money, String name, String account, String entry, String comment);
    //总经理审批单据
    public void saveList();
}
