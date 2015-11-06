package src.businesslogic.userbl;

import src.businesslogicservice.UserblService;
import src.vo.UserVO;

/**
 * Created by Administrator on 2015/11/4 0004.
 */
public class UserController implements UserblService {
    @Override
    public boolean login(UserVO userVO) {
        return false;
    }

    @Override
    public boolean add(UserVO userVO) {
        return false;
    }

    @Override
    public boolean delete(UserVO userVO) {
        return false;
    }

    @Override
    public boolean modify(UserVO userVOOld, UserVO userVONew) {
        return false;
    }
}
