package businesslogicservice;

import enumClass.City;
import enumClass.TransportType;
import enumClass.DeliveryType;
import po.ListPO;
import vo.ListVO;
import vo.OrderVO;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface ListblService {
    /**
     * Order order vo.
     *
     * @param senderName        the sender name
     * @param senderAddress     the sender address
     * @param senderWorkplace   the sender workplace
     * @param senderTelephone   the sender telephone
     * @param senderPhone       the sender phone
     * @param receiverName      the receiver name
     * @param receiverAddress   the receiver address
     * @param receiverWorkplace the receiver workplace
     * @param receiverTelephone the receiver telephone
     * @param receiverPhone     the receiver phone
     * @param originalNum       the original num
     * @param weight            the weight
     * @param volume            the volume
     * @param goods_Name        the goods name
     * @param DeliveryType      the delivery type
     * @param wrapper           the wrapper
     * @return the order vo
     */
//订单
    public OrderVO order(String senderName, String senderAddress, String senderWorkplace, String senderTelephone,
                         String senderPhone, String receiverName, String receiverAddress, String receiverWorkplace,
                         String receiverTelephone, String receiverPhone, int originalNum, double weight, double volume,
                         String goods_Name, DeliveryType DeliveryType, String wrapper);

    /**
     * Addressee infomation.
     *
     * @param num  the num
     * @param name the name
     */
//收件单
    public void addresseeInfomation(String num, String name);

    /**
     * Loading info.
     *
     * @param date            the date
     * @param businessHallNum the business hall num
     * @param transferNum     the transfer num
     * @param destination     the destination
     * @param carNum          the car num
     * @param name1           the name 1
     * @param name2           the name 2
     * @param orderNum        the order num
     */
//装车单
    public void loadingInfo(String date, String businessHallNum, String transferNum, String destination, String carNum,
                            String name1, String name2, String orderNum);

    /**
     * Receive info.
     *
     * @param date        the date
     * @param transferNum the transfer num
     * @param departPlace the depart place
     * @param state       the state
     */
//接收单
    public void receiveInfo(String date, String transferNum, String departPlace, String state);

    /**
     * Distribute info.
     *
     * @param date     the date
     * @param orderNum the order num
     * @param name     the name
     */
//派件单
    public void distributeInfo(String date, String orderNum, String name);

    /**
     * Receipt.
     *
     * @param date     the date
     * @param amount   the amount
     * @param name     the name
     * @param orderNum the order num
     */
//营业厅业务员建的收款单
    public void receipt(String date, String amount, String name, String orderNum);

    /**
     * Trans info.
     *
     * @param way         the way
     * @param date        the date
     * @param Num         the num
     * @param transNum    the trans num
     * @param departPlace the depart place
     * @param destination the destination
     * @param locNum      the loc num
     * @param name        the name
     * @param consignNum  the consign num
     */
//中转单
    public void transInfo(String way, String date, String Num, String transNum, String departPlace, String destination,
                          String locNum, String name, String consignNum);

    /**
     * Trans arrive.
     *
     * @param transCenterNum the trans center num
     * @param arriveDate     the arrive date
     * @param transNum       the trans num
     * @param departPlace    the depart place
     * @param state          the state
     */
//中转中心到达单
    public void transArrive(String transCenterNum, String arriveDate, String transNum, String departPlace, String state);

    /**
     * Stock out.
     *
     * @param deliveryNum   the delivery num
     * @param outDate       the out date
     * @param city          the city
     * @param transportType the transport type
     * @param transferNum   the transfer num
     */
//入库单
    public void stockOut(String deliveryNum, String outDate,
                         City city, TransportType transportType, String transferNum);

    /**
     * Stock in.
     *
     * @param deliveryNum the delivery num
     * @param outDate     the out date
     * @param city        the city
     */
//出库单
    public void stockIn(String deliveryNum, String outDate,
                        City city);

    /**
     * Receipt.
     *
     * @param date        the date
     * @param orgnization the orgnization
     * @param name        the name
     * @param amount      the amount
     * @param place       the place
     */
//财务人员建的收款单
    public void receipt(String date, String orgnization, String name, double amount, String place);

    /**
     * Payment.
     *
     * @param date    the date
     * @param money   the money
     * @param name    the name
     * @param account the account
     * @param entry   the entry
     * @param comment the comment
     */
//付款单
    public void payment(String date, int money, String name, String account, String entry, String comment);

    /**
     * Save list.保存待审批单据
     *
     * @param list the list
     */
    public void saveList(ListPO list);

    /**
     * 推送待审批单据
     * @return
     */
    public ListVO push();
}
