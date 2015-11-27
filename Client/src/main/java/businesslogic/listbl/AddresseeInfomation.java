package businesslogic.listbl;

import po.AddresseeInformationPO;
import util.ResultMessage;
import vo.AddresseeInformationVO;
import vo.ListVO;

/**
 * 接收单
 * Created by Administrator on 2015/11/16 0016.
 */
public class AddresseeInfomation extends List {

    public ResultMessage save(ListVO listvo) {

        AddresseeInformationVO vo= null;
        try {
            vo = (AddresseeInformationVO) listvo;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("强制类型转换失败！");
        }
        AddresseeInformationPO po=new AddresseeInformationPO(vo.getAddresseeNum(),vo.getAddresseeName(),vo.getAddresseeDate());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }

    @Override
    public ResultMessage get() {
        return super.get();
    }




}
