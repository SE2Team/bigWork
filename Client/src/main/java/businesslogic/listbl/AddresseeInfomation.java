package businesslogic.listbl;

import businesslogic.Exception.DateException;
import businesslogic.utilitybl.Helper;
import po.AddresseeInformationPO;
import util.ResultMessage;
import vo.AddresseeInformationVO;
import vo.ListVO;

import java.rmi.RemoteException;

/**
 * 接收单
 * Created by Administrator on 2015/11/16 0016.
 */
public class AddresseeInfomation extends List {

    public AddresseeInfomation() throws RemoteException {
        super();
    }

    public ResultMessage save(ListVO listvo) throws DateException, RemoteException {

        AddresseeInformationVO vo= null;
        try {
            vo = (AddresseeInformationVO) listvo;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("强制类型转换失败！");
        }
        if(Helper.compareTo(vo.getAddresseeDate()))
            throw new DateException("时间晚于当前时间！");
        AddresseeInformationPO po=new AddresseeInformationPO(vo.getAddresseeNum(),vo.getAddresseeName(),vo.getAddresseeDate());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }

    @Override
    public ResultMessage get() {
        return super.get();
    }




}
