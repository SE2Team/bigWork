package po;

import java.io.Serializable;

public class WorkerPO implements Serializable{
	private static final long serialVersionUID = 1L;//序列化编号
	/**
	 * 
	 * 姓名，身份证号、职位、所属机构，系统用户名
	 */
	private String name;
	private String idNum;
	private String position;
	private String organization;
	private String userId;
	
	public WorkerPO(String name, String idNum, String position,
			String organization, String userId){
		this.name=name;
		this.idNum=idNum;
		this.position=position;
		this.organization=organization;
		this.userId=userId;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setIdNum(String idNum){
		this.idNum=idNum;
	}
	
	public String getIdNum(){
		return idNum;
	}
	
	public void setPosition(String position){
		this.position=position;
	}
	
	public String getPosition(){
		return position;
	}
	
	public void setOrganization(){
		this.organization=organization;
	}
	
	public String getOrganization(){
		return organization;
	}
	
	public void setUserId(){
		this.userId=userId;
	}
	
	public String getUserId(){
		return userId;
	}
	
}
