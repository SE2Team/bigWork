package businesslogicservice;

import vo.UserVO;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public interface LoginblService {
    util.ResultMessage login(UserVO userVO);

    String getUserName();

    String getUserId();

    util.UserType getUserType();
}
