package vo;

import util.ListState;
import util.ListType;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class ListVO implements Serializable {
    private static final long serialVersionUID = 1L;//序列化编号
    protected String id;
    protected ListState isCheck = ListState.UNCHECK;
    protected ListType type;
    protected String organization;

    /**
     * id是自动根据日期生成的
     */
    public ListVO() {
        SimpleDateFormat df = new SimpleDateFormat("MMddHHmmss");//设置日期格式
        this.id = df.format(new Date());
    }

    public ListVO(ListState isCheck, String organization) {
        this();
        this.isCheck = isCheck;
        this.organization = organization;
    }

    public ListType getType() {
        return type;
    }

    public void setType(ListType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public ListState getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(ListState isCheck) {
        this.isCheck = isCheck;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
