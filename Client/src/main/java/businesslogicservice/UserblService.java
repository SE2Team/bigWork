package businesslogicservice;

import vo.UserVO;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface UserblService {
    boolean login(String userID, String password);

    boolean add(UserVO userVO);

    boolean delete(UserVO userVO);

    boolean modify(UserVO userVOOld, UserVO userVONew);
//		public UserVO edit(UserVO );
}