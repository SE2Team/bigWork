package vo;

import util.ListState;
import util.ListType;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class LoadingVO extends ListVO {
    private static final long serialVersionUID = 1L;//序列化编号

    //装车日期，本营业厅编号，汽运编号，出发地，到达地，监装员，押运员，车辆代号，托运单号列表，运费。
    private String loadingDate;
    private String hallNum;
    private String transportNum;
    private String start;
    private String end;
    private String monitor;
    private String supercargo;
    private String vehicleNum;
    private String consignList;
    private String transportMoney;

    /**
     * @param loadingDate
     * @param hallNum
     * @param transportNum
     * @param start
     * @param end
     * @param monitor
     * @param supercargo
     * @param vehicleNum
     * @param consignList
     * @param transportMoney
     */
    public LoadingVO(String loadingDate, String hallNum, String transportNum,
                     String start, String end, String monitor, String supercargo, String vehicleNum, String consignList,
                     String transportMoney, ListState isCheck, String organization) {
        super(isCheck, organization);
        this.loadingDate = loadingDate;
        this.hallNum = hallNum;
        this.transportNum = transportNum;
        this.start = start;
        this.end = end;
        this.monitor = monitor;
        this.supercargo = supercargo;
        this.vehicleNum = vehicleNum;
        this.consignList = consignList;
        this.transportMoney = transportMoney;
        setType(ListType.LOADINGINFO);
    }

    /**
     * @return 运费
     */
    public String getTransportMoney() {
        return transportMoney;
    }

    /**
     * @param
     */
    public void setTransportMoney(String transportMoney) {
        this.transportMoney = transportMoney;
    }

    /**
     * @return 托运单号列表
     */
    public String getConsignList() {
        return consignList;
    }

    /**
     * @param
     */
    public void setConsignList(String consignList) {
        this.consignList = consignList;
    }

    /**
     * @return 车辆代号
     */
    public String getVehicleNum() {
        return vehicleNum;
    }

    /**
     * @param
     */
    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    /**
     * @return 押运员
     */
    public String getSupercargo() {
        return supercargo;
    }

    /**
     * @param
     */
    public void setSupercargo(String supercargo) {
        this.supercargo = supercargo;
    }

    /**
     * @return 监装员
     */
    public String getMonitor() {
        return monitor;
    }

    /**
     * @param
     */
    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    /**
     * @return 装车日期
     */
    public String getLoadingDate() {
        return loadingDate;
    }

    /**
     * @param
     */
    public void setLoadingDate(String loadingDate) {
        this.loadingDate = loadingDate;
    }

    /**
     * @return 营业厅编号
     */
    public String getHallNum() {
        return hallNum;
    }

    /**
     * @param
     */
    public void setHallNum(String hallNum) {
        this.hallNum = hallNum;
    }

    /**
     * @return 汽运编号
     */
    public String getTransportNum() {
        return transportNum;
    }

    /**
     * @param
     */
    public void setTransportNum(String transportNum) {
        this.transportNum = transportNum;
    }

    /**
     * @return 出发地
     */
    public String getStart() {
        return start;
    }

    /**
     * @param
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * @return 目的地
     */
    public String getEnd() {
        return end;
    }

    /**
     * @param
     */
    public void setEnd(String end) {
        this.end = end;
    }


}
