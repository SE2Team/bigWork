package vo;

import util.ListState;
import util.ListType;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class StockInVO extends ListVO {
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


    public StockInVO(String deliveryNum, String inDate, String end, String zoneNum,
                     String rowNum, String shelfNum, String positionNum, ListState isCheck) {
        super(isCheck);
        this.deliveryNum = deliveryNum;
        this.inDate = inDate;
        this.end = end;
        this.zoneNum = zoneNum;
        this.rowNum = rowNum;
        this.shelfNum = shelfNum;
        this.positionNum = positionNum;
        setType(ListType.STOCKIN);
    }

    public String getDeliveryNum() {
        return deliveryNum;
    }

    public void setDeliveryNum(String deliveryNum) {
        this.deliveryNum = deliveryNum;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getZoneNum() {
        return zoneNum;
    }

    public void setZoneNum(String zoneNum) {
        this.zoneNum = zoneNum;
    }

    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public String getShelfNum() {
        return shelfNum;
    }

    public void setShelfNum(String shelfNum) {
        this.shelfNum = shelfNum;
    }

    public String getPositionNum() {
        return positionNum;
    }

    public void setPositionNum(String positionNum) {
        this.positionNum = positionNum;
    }


}
