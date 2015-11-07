package src.po;


import src.util.*;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/23 0023.
 */
public class OrderPO extends ListPO implements Serializable {
    private String senderName;
    private String senderAddress;
    private String senderWorkplace;
    private String senderTelephone;
    private String senderPhone;

    private String receiverName;
    private String receiverAddress;
    private String receiverWorkplace;
    private String receiverTelephone;
    private String receiverPhone;

    private int originalNum;
    private double weight;
    private double volume;
    private String goods_Name;

    private DeliveryType DeliveryType;
    private String wrapper;
    private double expenseOfTransport;
    private double expenseOfWrapper;
    private double expense;


    private double date;

    public OrderPO(String senderName, String senderAddress, String senderWorkplace, String senderTelephone,
                   String senderPhone, String receiverName, String receiverAddress, String receiverWorkplace,
                   String receiverTelephone, String receiverPhone, int originalNum, double weight, double volume,
                   String goods_Name, DeliveryType DeliveryType, String wrapper) {
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
        this.DeliveryType = DeliveryType;
        this.wrapper = wrapper;
    }

    /**
     * @return
     */
    public String getSenderName() {

        return senderName;
    }

    /**
     * @param senderName
     */
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

    public String getSenderTelephone() {
        return senderTelephone;
    }

    public void setSenderTelephone(String senderTelephone) {
        this.senderTelephone = senderTelephone;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
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

    public String getReceiverTelephone() {
        return receiverTelephone;
    }

    public void setReceiverTelephone(String receiverTelephone) {
        this.receiverTelephone = receiverTelephone;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
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

    public DeliveryType getDeliveryType() {
        return DeliveryType;
    }

    public void setDeliveryType(DeliveryType DeliveryType) {
        this.DeliveryType = DeliveryType;
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


}
