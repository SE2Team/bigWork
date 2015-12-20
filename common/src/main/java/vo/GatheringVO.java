package vo;

import util.ListType;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class GatheringVO extends ListVO {


    private static final long serialVersionUID = 1L;//序列化编号

    String date;
    String workplace;
    String man;
    String money;
    String place;

    public GatheringVO(String date, String workplace, String man, String money, String place, boolean isCheck) {
        super(isCheck);
        this.date = date;
        this.workplace = workplace;
        this.man = man;
        this.money = money;
        this.place = place;
        setType(ListType.GATHERING);
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


}
