package businesslogic.listbl;

import util.ResultMessage;
import vo.ListVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class LoadingInfo extends List {
    @Override
    public ResultMessage get() {
        return super.get();
    }

    @Override
    public ResultMessage save(ListVO listVO) {
        return super.save(listVO);
    }

    @Override
    public ResultMessage saveAsList() {
        return super.saveAsList();
    }
}
