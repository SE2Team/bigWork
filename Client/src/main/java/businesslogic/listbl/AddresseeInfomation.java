package businesslogic.listbl;

import util.ResultMessage;
import vo.ListVO;

/**
 * 接收单
 * Created by Administrator on 2015/11/16 0016.
 */
public class AddresseeInfomation extends List {

    public ResultMessage save(ListVO listvo) {
        return super.save();
    }

    @Override
    public ResultMessage get() {
        return super.get();
    }

    @Override
    public ResultMessage saveAsList() {
        return super.saveAsList();
    }
}
