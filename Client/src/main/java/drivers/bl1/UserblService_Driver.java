package drivers.bl1;

import businesslogicservice.UserblService;
import vo.UserVO;


public class UserblService_Driver {
    UserVO userVO;
    String clue;
    private String userID;
    private String password;

    public void driver(UserblService userblService) {
        boolean isLogin = userblService.login(userID, password);
        if (isLogin == true) {
            System.out.println("Success!");
        }

        boolean isAdd = userblService.add(userVO);
        if (isAdd == true) {
            System.out.println("Success!");
        }

        boolean isDel = userblService.delete(userVO);
        if (isDel == true) {
            System.out.println("Success!");
        }

        boolean isModify = userblService.modify(userVO, userVO);
        if (isModify == true) {
            System.out.println("Success!");
        }


    }
}
