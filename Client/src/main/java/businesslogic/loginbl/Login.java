package businesslogic.loginbl;

import data.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import vo.UserVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class Login {

    private UserDataService data;
    private DataFactoryService dataFactory;

    public Login() throws RemoteException {
        dataFactory=DataFactory.getInstance();
        data=dataFactory.getUserData();
    }

    /**
     * 用户登录验证
     *
     * @param
     * @return
     * @throws
     */
    public UserPO login(UserVO vo) throws RemoteException {


        return data.login(vo.getId(),vo.getPassword());
    }



}
