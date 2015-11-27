package po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class ListPO implements Serializable {

    protected String id;
    protected String content;

    public boolean isCheck() {
        return isCheck;
    }

    protected boolean isCheck=false;

    /**
     * id是自动根据日期生成的
     */
    public ListPO() {
        SimpleDateFormat df = new SimpleDateFormat("MMddHHmmss");//设置日期格式
        this.id = getClassName()+df.format(new Date());
    }

    public  String getClassName(){
        return "List";
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


}
