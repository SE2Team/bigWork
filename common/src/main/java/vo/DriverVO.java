package vo;

public class DriverVO {
    //司机编号、姓名、出生日期、身份证号、手机、车辆单位、性别、行驶证期限
    private String driverNum;
    private String driverName;
    private String birthDate;
    private String idNum;
    private String phone;
    private String vehicleInstitution;
    private String sex;
    private String licenseTime;

    /**
     * @param driverNum
     * @param driverName
     * @param birthDate
     * @param idNum
     * @param phone
     * @param vehicleInstitution
     * @param sex
     * @param licenseTime
     */
    public DriverVO(String driverNum, String driverName,
                    String birthDate, String idNum, String phone,
                    String vehicleInstitution, String sex, String licenseTime) {
        this.birthDate = birthDate;
        this.driverName = driverName;
        this.driverNum = driverNum;
        this.idNum = idNum;
        this.licenseTime = licenseTime;
        this.phone = phone;
        this.sex = sex;
        this.vehicleInstitution = vehicleInstitution;
    }

    public DriverVO() {
    }

    public String getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(String driverNum) {
        this.driverNum = driverNum;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVehicleInstitution() {
        return vehicleInstitution;
    }

    public void setVehicleInstitution(String vehicleInstitution) {
        this.vehicleInstitution = vehicleInstitution;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLicenseTime() {
        return licenseTime;
    }

    public void setLicenseTime(String licenseTime) {
        this.licenseTime = licenseTime;
    }
}
