package businesslogic.loginbl;

import businesslogicservice.LoginblService;
import util.ResultMessage;
import vo.UserVO;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class LoginController implements LoginblService {

    private Login login;

    public ResultMessage login(UserVO userVO) {
        login = new Login(userVO.getId());
        return login.login(userVO.getPassword());
    }

    public String getUserName() {
        return null;
    }

    public String getUserId() {
        return null;
    }

    public util.UserType getUserType() {
        return null;
    }
}
