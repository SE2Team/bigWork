package businesslogic.listbl;

import businesslogicservice.ListblService;
import enumClass.City;
import enumClass.DeliveryType;
import enumClass.TransportType;
import po.ListPO;
import vo.ListVO;
import vo.OrderVO;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class ListBL implements ListblService{

    @Override
    public OrderVO order(String senderName, String senderAddress, String senderWorkplace, String senderTelephone, String senderPhone, String receiverName, String receiverAddress, String receiverWorkplace, String receiverTelephone, String receiverPhone, int originalNum, double weight, double volume, String goods_Name, DeliveryType DeliveryType, String wrapper) {
        return null;
    }

    @Override
    public void addresseeInfomation(String num, String name) {

    }

    @Override
    public void loadingInfo(String date, String businessHallNum, String transferNum, String destination, String carNum, String name1, String name2, String orderNum) {

    }

    @Override
    public void receiveInfo(String date, String transferNum, String departPlace, String state) {

    }

    @Override
    public void distributeInfo(String date, String orderNum, String name) {

    }

    @Override
    public void receipt(String date, String amount, String name, String orderNum) {

    }

    @Override
    public void transInfo(String way, String date, String Num, String transNum, String departPlace, String destination, String locNum, String name, String consignNum) {

    }

    @Override
    public void transArrive(String transCenterNum, String arriveDate, String transNum, String departPlace, String state) {

    }

    @Override
    public void stockOut(String deliveryNum, String outDate, City city, TransportType transportType, String transferNum) {

    }

    @Override
    public void stockIn(String deliveryNum, String outDate, City city) {

    }

    @Override
    public void receipt(String date, String orgnization, String name, double amount, String place) {

    }

    @Override
    public void payment(String date, int money, String name, String account, String entry, String comment) {

    }

    @Override
    public void saveList(ListPO list) {

    }

    @Override
    public ListVO push() {
        return null;
    }
}
