package po;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/23 0023.
 */
public class OrderPO implements Serializable {
    private String senderName;
    private String senderAddress;
    private String senderWorkplace;
    private long senderTelephone;
    private long senderPhone;

    private String receiverName;
    private String receiverAddress;
    private String receiverWorkplace;
    private long receiverTelephone;
    private long receiverPhone;

    private int originalNum;
    private double weight;
    private double volume;
    private String goods_Name;

    private deliveryType deliveryType;
    private String wrapper;
    private double expenseOfTransport;
    private double expenseOfWrapper;
    private double expense;

    public OrderPO(String senderName, String senderAddress, String senderWorkplace, long senderTelephone,
                   long senderPhone, String receiverName, String receiverAddress, String receiverWorkplace,
                   long receiverTelephone, long receiverPhone, int originalNum, double weight, double volume,
                   String goods_Name, po.deliveryType deliveryType, String wrapper) {
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.senderWorkplace = senderWorkplace;
        this.senderTelephone = senderTelephone;
        this.senderPhone = senderPhone;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverWorkplace = receiverWorkplace;
        this.receiverTelephone = receiverTelephone;
        this.receiverPhone = receiverPhone;
        this.originalNum = originalNum;
        this.weight = weight;
        this.volume = volume;
        this.goods_Name = goods_Name;
        this.deliveryType = deliveryType;
        this.wrapper = wrapper;
    }

    public String getSenderName() {

        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderWorkplace() {
        return senderWorkplace;
    }

    public void setSenderWorkplace(String senderWorkplace) {
        this.senderWorkplace = senderWorkplace;
    }

    public long getSenderTelephone() {
        return senderTelephone;
    }

    public void setSenderTelephone(long senderTelephone) {
        this.senderTelephone = senderTelephone;
    }

    public long getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(long senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverWorkplace() {
        return receiverWorkplace;
    }

    public void setReceiverWorkplace(String receiverWorkplace) {
        this.receiverWorkplace = receiverWorkplace;
    }

    public long getReceiverTelephone() {
        return receiverTelephone;
    }

    public void setReceiverTelephone(long receiverTelephone) {
        this.receiverTelephone = receiverTelephone;
    }

    public long getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(long receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public int getOriginalNum() {
        return originalNum;
    }

    public void setOriginalNum(int originalNum) {
        this.originalNum = originalNum;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getGoods_Name() {
        return goods_Name;
    }

    public void setGoods_Name(String goods_Name) {
        this.goods_Name = goods_Name;
    }

    public po.deliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(po.deliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getWrapper() {
        return wrapper;
    }

    public void setWrapper(String wrapper) {
        this.wrapper = wrapper;
    }

    public double getExpenseOfTransport() {
        return expenseOfTransport;
    }

    public void setExpenseOfTransport(double expenseOfTransport) {
        this.expenseOfTransport = expenseOfTransport;
    }

    public double getExpenseOfWrapper() {
        return expenseOfWrapper;
    }

    public void setExpenseOfWrapper(double expenseOfWrapper) {
        this.expenseOfWrapper = expenseOfWrapper;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    private double date;
    private long serialNumber;
}
