package businesslogicservice;

import util.ExistException;
import vo.UserVO;

import java.rmi.RemoteException;

/**
 * @author WANXING
 *         Created by Administrator on 2015/11/1 0001.
 */
public interface LoginblService {
    /**
     * @param userVO 传入用户vo
     * @return
     * @throws RemoteException 网络异常
     * @throws ExistException  异常，该用户已登录，无法再次登录
     */
    UserVO login(UserVO userVO) throws RemoteException;


}
