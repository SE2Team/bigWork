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
    public boolean isCheck=false;

    /**
     * id是自动根据日期生成的
     */
    public ListPO() {
        SimpleDateFormat df = new SimpleDateFormat("MMddHHmmss");//设置日期格式
        this.id = df.format(new Date());
    }

    public ListPO(String id,String content,boolean isCheck ){
    	this.id=id;
    	this.content=content;
    	this.isCheck=isCheck;
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
