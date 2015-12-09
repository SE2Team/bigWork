package businesslogic.loginbl;

import businesslogicservice.LoginblService;
import vo.UserVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/1 0001.
 *
 * @author myk
 */
public class LoginController implements LoginblService {

    private Login login;

    public UserVO login(UserVO userVO) throws RemoteException {
        login = new Login();
        return login.login(userVO);
    }
}
