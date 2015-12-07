package businesslogicservice;

import util.ExistException;
import vo.UserVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface UserblService {
    boolean add(UserVO userVO) throws RemoteException, ExistException;

    boolean delete(UserVO userVO) throws RemoteException;

    boolean modify(UserVO userVOOld, UserVO userVONew) throws RemoteException, ExistException;
}