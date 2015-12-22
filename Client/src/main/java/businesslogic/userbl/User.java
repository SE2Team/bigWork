package businesslogic.userbl;

import dataservice.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.userdataservice.UserDataService;
import util.ExistException;
import vo.UserVO;
import vo.VO2PO;

import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/7 0007.
 */
public class User {
    private DataFactoryService dataFactoryService;
    private UserDataService dataService;

    public User() throws RemoteException {
        dataFactoryService= DataFactory.getInstance();
        dataService=dataFactoryService.getUserData();
    }

    public boolean add(UserVO userVO) throws RemoteException, ExistException {
        return dataService.addUser(VO2PO.convert(userVO));
    }

    public boolean delete(UserVO userVO) throws RemoteException {
        return dataService.deleteUser(VO2PO.convert(userVO));
    }

    public boolean modify(UserVO userVOOld, UserVO userVONew) throws RemoteException, ExistException {
        return dataService.editUser(VO2PO.convert(userVOOld),VO2PO.convert(userVONew));
    }
}
