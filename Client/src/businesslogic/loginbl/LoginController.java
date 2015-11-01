package src.businesslogic.loginbl;

import src.businesslogicservice.LoginblService;
import src.vo.UserVO;
import util.ResultMessage;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class LoginController implements LoginblService {

    private Login login;
    @Override
    public ResultMessage login(UserVO userVO) {
        login=new Login(userVO.getId());
        return login.login(userVO.getPassword());
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getUserId() {
        return null;
    }

    @Override
    public util.UserType getUserType() {
        return null;
    }
}
