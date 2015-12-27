package vo;

import util.ListState;
import util.ListType;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class PaymentVO extends ListVO {

    private static final long serialVersionUID = 1L;//序列化编号

    /**
     * 包括付款日期、付款金额、付款人、付款账号、条目、备注
     */

    private String payDate;
    private String payMoney;
    private String payHuman;
    private String payAccount;
    private String payReason;
    private String payComment;


    public PaymentVO(String payDate, String payMoney, String payHuman,
                     String payAccount, String payReason, String payComment, ListState isCheck) {
        super(isCheck);
        this.payDate = payDate;
        this.payMoney = payMoney;
        this.payHuman = payHuman;
        this.payAccount = payAccount;
        this.payReason = payReason;
        this.payComment = payComment;
        setType(ListType.PAYMENT);
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public String getPayHuman() {
        return payHuman;
    }

    public void setPayHuman(String payHuman) {
        this.payHuman = payHuman;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getPayReason() {
        return payReason;
    }

    public void setPayReason(String payReason) {
        this.payReason = payReason;
    }

    public String getPayComment() {
        return payComment;
    }

    public void setPayComment(String payComment) {
        this.payComment = payComment;
    }


}
