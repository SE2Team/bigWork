package po;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class GatheringPO extends ListPO implements Serializable{
	private static final long serialVersionUID = 1L;//序列化编号
	
	String date;
    String workplace;
    String man;
    String money;
    String place;

    public GatheringPO(String date, String workplace, String man,
                       String money, String place) {
        this.date = date;
        this.workplace = workplace;
        this.man = man;
        this.money = money;
        this.place = place;
        content=this.toString();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "收款单  " +
                "时间：" + date +
                "  收款单位：" + workplace +
                "  收款人：" + man +
                "  金额：" + money +
                "  地点：" + place;
    }

}
