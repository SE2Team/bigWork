package src.businesslogic.loginbl;

import util.ResultMessage;
import util.UserType;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class Login {

    public static String currentUserName;

    public static String currentUserId;

    public static UserType currentUserType;

    private int type;

    public Login(String id) {
        Login.currentUserId = id;
    }

    /**
     * 用户登录验证
     * @param password
     * @return
     * @throws
     */
    public ResultMessage login(String password) {

        return util.ResultMessage.FAILED;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public String getCurrentUserId() {
        return currentUserId;
    }

    public UserType getCurrentUserType() {
        return currentUserType;
    }

}
