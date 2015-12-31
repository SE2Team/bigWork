package po;

import java.io.Serializable;

/**
 * Created by MYK on 2015/12/31 0031.
 */
public class OrganizationPO implements Serializable {
    String num;
    String city;
    String name;

    public OrganizationPO(String num, String city, String name) {
        this.num = num;
        this.city = city;
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
