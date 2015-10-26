package src.vo;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class GatheringVO {
    String date;
    String workplace;
    String man;
    double money;
    String place;

    public GatheringVO(String date, String workplace, String man,
                       double money, String place) {
        this.date = date;
        this.workplace = workplace;
        this.man = man;
        this.money = money;
        this.place = place;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
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
        return "收款单{" +
                "日期：'" + date + '\'' +
                ", 收款地点：'" + workplace + '\'' +
                ", 收款人：'" + man + '\'' +
                ", 金额：" + money +
                ", 收款地点：'" + place + '\'' +
                '}';
    }
}
