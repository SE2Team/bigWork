package businesslogicservice;

import po.UserPO;
import vo.UserVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public interface LoginblService {
    UserPO login(UserVO userVO) throws RemoteException;


}
