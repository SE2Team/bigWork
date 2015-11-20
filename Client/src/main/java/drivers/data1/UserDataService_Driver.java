package drivers.data1;

import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDataService_Driver {
    String loginInfo;
    UserPO po;

    public void drive(UserDataService userDataService) {
        UserPO isLogin = userDataService.login(loginInfo);
        if (isLogin == po) {
            System.out.println("Success!");
        }

        UserPO isFind = userDataService.login(loginInfo);
        if (isFind == po) {
            System.out.println("Success!");
        }
    }
}
