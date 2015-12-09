package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.UserPO;
import util.ExistException;


public interface UserDataService extends Remote{
    public UserPO login(String id,String password) throws RemoteException, ExistException;

    public Boolean addUser(UserPO po) throws RemoteException, ExistException;

    public Boolean deleteUser(UserPO po) throws RemoteException;

    public Boolean editUser(UserPO oldPO,UserPO newPO) throws RemoteException, ExistException;

    public UserPO find(String id,String password) throws RemoteException;
}
