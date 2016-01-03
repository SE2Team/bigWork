package po;

import util.ListState;
import util.ListType;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class ListPO implements Serializable {
    private static final long serialVersionUID = 1L;//序列化编号


    protected String id;
    protected ListState state = ListState.UNCHECK;
    public ListType getType() {
        return type;
    }

    public void setType(ListType type) {
        this.type = type;
    }

    protected ListType type;
    protected String organization;

    /**
     * id是自动根据日期生成的
     */
    public ListPO() {
        super();
        SimpleDateFormat df = new SimpleDateFormat("MMddHHmmss");//设置日期格式
        this.id = df.format(new Date());
    }

    public ListPO(ListState state, String organization) {
        super();
        this.state = state;
        this.organization = organization;
    }

    public String getId() {
        return id;
    }


    public ListState getIsCheck() {
        return state;
    }

    public void setIsCheck(ListState state) {
        this.state = state;
    }

    public ListState getState() {
        return state;
    }

    public void setState(ListState state) {
        this.state = state;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
