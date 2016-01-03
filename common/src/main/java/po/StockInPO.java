package po;

import util.ListState;
import util.ListType;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class StockInPO extends ListPO implements Serializable {
    private static final long serialVersionUID = 1L;// 序列化编号

    /**
     * 快递编号、入库日期、目的地、区号、排号、架号、位号
     */

    private String deliveryNum;
    private String inDate;
    private String end;
    private String zoneNum;
    private String rowNum;
    private String shelfNum;
    private String positionNum;

    public StockInPO(String deliveryNum, String inDate, String end, String zoneNum,
                     String rowNum, String shelfNum, String positionNum, ListState isCheck, String organization) {
        super(isCheck, organization);
        this.deliveryNum = deliveryNum;
        this.inDate = inDate;
        this.end = end;
        this.zoneNum = zoneNum;
        this.rowNum = rowNum;
        this.shelfNum = shelfNum;
        this.positionNum = positionNum;
        setType(ListType.STOCKIN);
    }

    public void setDeliveryNum(String deliveryNum) {
        this.deliveryNum = deliveryNum;
    }

    public String getDeliveryNum() {
        return deliveryNum;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getInDate() {
        return inDate;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEnd() {
        return end;
    }

    public void setZoneNum(String zoneNum) {
        this.zoneNum = zoneNum;
    }

    public String getZoneNum() {
        return zoneNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public String getRowNum() {
        return rowNum;
    }

    public void setShelfNum(String shelfNum) {
        this.shelfNum = shelfNum;
    }

    public String getShelfNum() {
        return shelfNum;
    }

    public void setPositionNum(String positionNum) {
        this.positionNum = positionNum;
    }

    public String getPositionNum() {
        return positionNum;
    }


}
