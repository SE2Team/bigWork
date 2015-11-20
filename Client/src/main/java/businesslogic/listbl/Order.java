package businesslogic.listbl;

import util.ResultMessage;
import vo.ListVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class Order extends List {
    @Override
    public ResultMessage save(ListVO listVO) {
        return ResultMessage.FAILED;
    }
}
