package po;

import util.UserType;

import java.io.Serializable;

public class UserPO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * 用户名和密码，姓名，权限
	 */
	
	private String id;
	private String password;
	private String name;
	private UserType permission;


	/**
	 * 
	 * @param id
	 * @param password
	 * @param name
	 * @param permission
	 */
	public UserPO(String id,String password, String 
			name,UserType permission){
		this.id=id;
		this.password=password;
		this.name=name;
		this.permission=permission;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public UserType getPermission() {
		return permission;
	}

	public void setPermission(UserType permission) {
		this.permission = permission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

}
