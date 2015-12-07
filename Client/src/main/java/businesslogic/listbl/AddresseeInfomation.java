package businesslogic.listbl;

import po.AddresseeInformationPO;
import vo.AddresseeInformationVO;
import vo.ListVO;
import vo.VO2PO;

import java.rmi.RemoteException;

/**
 * 接收单
 * Created by Administrator on 2015/11/16 0016.
 *
 * @author myk
 */
public class AddresseeInfomation extends List {

    /**
     * Instantiates a new Addressee infomation.
     *
     * @throws RemoteException the remote exception
     */
    public AddresseeInfomation() throws RemoteException {
        super();
    }

    public boolean save(ListVO listvo) throws RemoteException {

        AddresseeInformationVO vo = null;
        try {
            vo = (AddresseeInformationVO) listvo;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("强制类型转换失败！");
        }

        AddresseeInformationPO po = VO2PO.convert(vo);

        return listDataService.save(po);
    }



}
