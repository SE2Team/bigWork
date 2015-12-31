package dataservice.userdataservice;

import po.UserPO;
import util.ExistException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface UserDataService extends Remote{
	
	/**
	 * 遍历user.txt,查看是否存在该用户
	 * @param id
	 * @param password
	 * @return userPO(找不到时返回null)
	 * @throws RemoteException
	 */
     UserPO login(String id, String password) throws RemoteException;

     /**
      * 
      * @param po
      * @return 添加成功返回true
      * @throws RemoteException
      * @throws ExistException (已存在该用户时)
      */
     Boolean addUser(UserPO po) throws RemoteException, ExistException;
     
     /**
      * 
      * @param po
      * @return 删除成功返回true
      * @throws RemoteException
      */
     Boolean deleteUser(UserPO po) throws RemoteException;
     
     /**
      * 编辑成功返回true
      * @param oldPO
      * @param newPO
      * @return
      * @throws RemoteException
      */
     Boolean editUser(UserPO oldPO, UserPO newPO) throws RemoteException;
     
     
     /**
      * 查找成功返回true
      * @param id
      * @param password
      * @return
      * @throws RemoteException
      */
     UserPO find(String id, String password) throws RemoteException;

    /**
     * @return
     */
    ArrayList<UserPO> getUser() throws RemoteException;

    UserPO check(String ID) throws RemoteException;
}
