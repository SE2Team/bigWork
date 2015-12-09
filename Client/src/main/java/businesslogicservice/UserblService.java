package businesslogicservice;

import util.ExistException;
import vo.UserVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface UserblService {
    /**
     * @param userVO 传入用户vo
     * @return
     * @throws RemoteException 网络异常
     * @throws ExistException  异常，该用户已存在，无法添加
     */
    boolean add(UserVO userVO) throws RemoteException, ExistException;

    /**
     * @param userVO 传入用户vo
     * @return
     * @throws RemoteException 网络异常
     */
    boolean delete(UserVO userVO) throws RemoteException;

    /**
     * @param userVOOld 传入旧的用户vo
     * @param userVONew 传入新的用户vo
     * @return
     * @throws RemoteException 网络异常
     * @throws ExistException  异常，该用户不存在，无法删除
     */
    boolean modify(UserVO userVOOld, UserVO userVONew) throws RemoteException, ExistException;
}