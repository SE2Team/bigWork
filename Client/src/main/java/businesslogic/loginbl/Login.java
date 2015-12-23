package businesslogic.loginbl;

import businesslogic.utilitybl.Helper;
import dataservice.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import vo.UserVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/1 0001.
 *
 * @author myk
 */
public class Login {

    private UserDataService data;
    private DataFactoryService dataFactory;

    /**
     * Instantiates a new Login.
     *
     * @throws RemoteException the remote exception
     */
    public Login() throws RemoteException {
        dataFactory = DataFactory.getInstance();
        data = dataFactory.getUserData();
    }

    /**
     * 用户登录验证
     *
     * @param vo the vo
     * @return user po
     * @throws RemoteException the remote exception
     */
    public UserVO login(UserVO vo) throws RemoteException {
        UserPO po=data.login(vo.getId(), vo.getPassword());
        if(po==null){
            return null;
        }

        Helper.setUserType(po.getPermission());
        return new UserVO(po.getId(),po.getPassword(),po.getName(),po.getPermission());
    }


}
