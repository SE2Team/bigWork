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

    public ListPO() {
        SimpleDateFormat df = new SimpleDateFormat("MMddHHmmss");//设置日期格式
        this.id = df.format(new Date());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    protected void save(ListPO list) {

    }
}
