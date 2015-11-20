package businesslogic.listbl;

import dataservice.datafactoryservice.DataFactoryService;
import util.ResultMessage;
import vo.ListVO;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class List {
    DataFactoryService dataFactory;

    /**
     * 以对应类型序列化或者txt
     *
     * @param listVO
     * @return
     */
    public ResultMessage save(ListVO listVO) {
        return ResultMessage.FAILED;//留空，子类实现
    }

    public ResultMessage get() {
        return ResultMessage.FAILED;
    }

    /**
     * 作为待审核单据保存
     * 每个子类实现
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
