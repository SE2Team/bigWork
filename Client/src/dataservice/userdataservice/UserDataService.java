package src.dataservice.userdataservice;

import src.po.UserPO;

public interface UserDataService {
	public UserPO login (String loginInfo);
    public void addUser(UserPO po);
	public void deleteUser(UserPO po);
	public void editUser (UserPO po);
	public UserPO find(String userinfo);	
}
