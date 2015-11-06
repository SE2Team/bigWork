package src.businesslogicservice;

import src.vo.UserVO;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface UserblService {
    public boolean login(UserVO userVO);

    public boolean add(UserVO userVO);

    public boolean delete(UserVO userVO);

    public boolean modify(UserVO userVOOld, UserVO userVONew);
}