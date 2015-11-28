package vo;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class ListVO {
    protected String id;
    protected String content;

    public String getId() {
        return id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ListVO(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public ListVO() {
    }
}
