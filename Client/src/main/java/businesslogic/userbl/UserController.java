package businesslogic.userbl;

import businesslogicservice.UserblService;
import util.ExistException;
import vo.UserVO;

import java.rmi.RemoteException;
import java.util.Iterator;

/**
 * Created by MYK on 2015/12/7 0007.
 */
public class UserController implements UserblService{
    private User user;

    public UserController() throws RemoteException {
        user = new User();
    }

    public boolean add(UserVO userVO) throws RemoteException, ExistException {
        return user.add(userVO);
    }

    public boolean delete(UserVO userVO) throws RemoteException {
        return user.delete(userVO);
    }

    public boolean modify(UserVO userVOOld, UserVO userVONew) throws RemoteException, ExistException {
        return user.modify(userVOOld,userVONew);
    }

    public Iterator<UserVO> getUser() throws RemoteException {
        return user.getUser();
    }
}
