package businesslogicservice;

import util.ExistException;
import vo.UserVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public interface LoginblService {
    UserVO login(UserVO userVO) throws RemoteException, ExistException;


}
