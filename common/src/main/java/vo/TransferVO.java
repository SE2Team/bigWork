package vo;

import util.ListState;
import util.ListType;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class TransferVO extends ListVO {

    private static final long serialVersionUID = 1L;//序列化编号

    /**
     * 装运方式，装运日期、本中转中心航运编号（火车为货运编号，汽车为汽运编号）、航班号（火车和汽车为车次号）、
     * 出发地、到达地、货柜号
     * （火车为车厢号）、监装员、押运员（仅汽运有）、本次装箱所有托运单号、运费。
     */

    private String loadingWay;
    private String loadingDate;
    private String transportNum;
    private String vehicleNum;
    private String start;
    private String end;
    private String containerNum;
    private String monitor;
    private String supercargo;
    private String orderNum;
    private String money;

    public TransferVO(String loadingWay, String loadingDate, String transportNum,
                      String vehicleNum, String start, String end, String containerNum, String monitor,
                      String supercargo, String orderNum, String money, ListState isCheck, String organization) {
        super(isCheck, organization);
        this.loadingWay = loadingWay;
        this.loadingDate = loadingDate;
        this.transportNum = transportNum;
        this.vehicleNum = vehicleNum;
        this.start = start;
        this.end = end;
        this.containerNum = containerNum;
        this.monitor = monitor;
        this.supercargo = supercargo;
        this.orderNum = orderNum;
        this.money = money;
        setType(ListType.TRANSINFO);
    }

    public String getLoadingWay() {
        return loadingWay;
    }

    public void setLoadingWay(String loadingWay) {
        this.loadingWay = loadingWay;
    }

    public void setloadingDate(String loadingDate) {
        this.loadingDate = loadingDate;
    }

    public String getLoadingDate() {
        return loadingDate;
    }

    public String getTransportNum() {
        return transportNum;
    }

    public void setTransportNum(String transportNum) {
        this.transportNum = transportNum;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getContainerNum() {
        return containerNum;
    }

    public void setContainerNum(String containerNum) {
        this.containerNum = containerNum;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getSupercargo() {
        return supercargo;
    }

    public void setSupercargo(String supercargo) {
        this.supercargo = supercargo;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }


}
