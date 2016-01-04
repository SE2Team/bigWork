package vo;

public class WorkerVO {
    /**
     * 姓名，身份证号、职位、所属机构，系统用户名
     */
    private String name;
    private String idNum;
    private String position;
    private String organization;
    private String userId;
    private String sex;
    private String age;

    public WorkerVO(String name, String idNum, String position,
                    String organization, String userId, String sex, String age) {
        this.name = name;
        this.idNum = idNum;
        this.position = position;
        this.organization = organization;
        this.userId = userId;
        this.sex = sex;
        this.age = age;
    }

    public WorkerVO() {
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

