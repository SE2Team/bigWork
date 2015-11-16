package src.businesslogic.listbl;

import src.dataservice.datafactoryservice.DataFactoryService;
import src.util.ResultMessage;
import src.vo.ListVO;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class List {
    DataFactoryService dataFactory;

    public ResultMessage save(ListVO listVO) {
        return ResultMessage.FAILED;
    }

    public ResultMessage get() {
        return ResultMessage.FAILED;
    }

    /**
     * 作为待审核单据保存
     *
     * @return
     */
    public ResultMessage saveAsList() {
        return ResultMessage.FAILED;
    }


    /**
     * 将单据推送，不允许继承
     *
     * @return
     */
    public final ListVO push() {
        return null;
    }
}
