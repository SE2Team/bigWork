package dataservice.userdataservice;

import po.UserPO;
import util.ExistException;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface UserDataService extends Remote{
    public UserPO login(String id,String password) throws RemoteException, ExistException;

    public Boolean addUser(UserPO po) throws RemoteException, ExistException;

    public Boolean deleteUser(UserPO po) throws RemoteException;

    public Boolean editUser(UserPO oldPO,UserPO newPO) throws RemoteException, ExistException;

    public UserPO find(String id,String password) throws RemoteException;
}
