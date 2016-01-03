package po;

import util.ListState;
import util.ListType;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class ReceivePO extends ListPO implements Serializable {
    private static final long serialVersionUID = 1L;//序列化编号

    //到达日期、中转单编号、出发地、货物到达状态
    private String arriveDate;
    private String transferNum;
    private String start;
    private String arriveState;


    public ReceivePO(String arriveDate, String transferNum, String start, String arriveState,
                     ListState isCheck) {
        super(isCheck);
        this.arriveDate = arriveDate;
        this.transferNum = transferNum;
        this.start = start;
        this.arriveState = arriveState;
        setType(ListType.RECEIVEINFO);
    }

    /**
     * 到达日期
     *
     * @param arriveDate
     */
    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    /**
     * @return 到达日期
     */
    public String getArriveDate() {
        return arriveDate;
    }

    /**
     * 中转单编号
     *
     * @param transferNum
     */
    public void setTransferNum(String transferNum) {
        this.transferNum = transferNum;
    }


    /**
     * @return 中转单编号
     */
    public String getTransferNum() {
        return transferNum;
    }

    /**
     * 出发地
     *
     * @param start
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * 出发地
     *
     * @return
     */
    public String getStart() {
        return start;
    }


    /**
     * 货物到达状态
     *
     * @param arriveState
     */
    public void setArriveState(String arriveState) {
        this.arriveState = arriveState;
    }

    /**
     * 货物到达状态
     *
     * @return
     */
    public String getArriveState() {
        return arriveState;
    }


}
