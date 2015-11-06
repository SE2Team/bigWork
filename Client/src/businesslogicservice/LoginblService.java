package src.businesslogicservice;

import src.vo.UserVO;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public interface LoginblService {
    public util.ResultMessage login(UserVO userVO);

    public String getUserName();

    public String getUserId();

    public util.UserType getUserType();
}
