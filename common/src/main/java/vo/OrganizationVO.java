package vo;

import java.io.Serializable;

/**
 * Created by MYK on 2015/12/31 0031.
 */
public class OrganizationVO implements Serializable {
    String num;
    String transfer;
    String name;

    public OrganizationVO(String num, String transfer, String name) {
        this.num = num;
        this.transfer = transfer;
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
