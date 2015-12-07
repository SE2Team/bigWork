package po;

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
    protected String content;
    protected boolean isCheck=false;
    public ListType getType() {
        return type;
    }

    public void setType(ListType type) {
        this.type = type;
    }

    protected ListType type;

    /**
     * id是自动根据日期生成的
     */
    public ListPO() {
        SimpleDateFormat df = new SimpleDateFormat("MMddHHmmss");//设置日期格式
        this.id = df.format(new Date());
    }

    public ListPO(boolean isCheck) {
        this.isCheck = isCheck;
        this.type = type;
    }

    public String getId() {
        return id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIsCheck(boolean isCheck){
        this.isCheck=isCheck;
    }

    public boolean getIsCheck(){
        return isCheck;
    }
}
