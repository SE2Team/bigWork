package businesslogic.listbl;

import businesslogic.utilitybl.Helper;
import po.AddresseeInformationPO;
import po.OperationLogPO;
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

    public boolean save2File(ListVO listvo) throws RemoteException {

        AddresseeInformationVO vo = null;
        try {
            vo = (AddresseeInformationVO) listvo;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("强制类型转换失败！");
        }

        AddresseeInformationPO po = VO2PO.convert(vo);

        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "保存接收单"));

        return listDataService.save(po);
    }

    public boolean afterCheck(AddresseeInformationVO vo) throws RemoteException {
        return listDataService.deleteList(VO2PO.convert(vo));
    }

    public boolean save(AddresseeInformationVO vo) throws RemoteException {
        AddresseeInformationPO po = null;
        po = VO2PO.convert(vo);
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(), Helper.getUserType().toString(),
                "新建收件单"));
        return listDataService.saveAsList(po);//保存为待审批
    }
}
