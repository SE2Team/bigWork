package businesslogic.listbl;

import data.DataFactory;
import po.GatheringPO;
import util.ResultMessage;
import vo.GatheringVO;
import vo.ListVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class Gathering extends List {

    @Override
    public ResultMessage save(ListVO listVO) {
        dataFactory = new DataFactory();
        GatheringVO gatheringVO = (GatheringVO) listVO;

        GatheringPO po = new GatheringPO(gatheringVO.getDate(), gatheringVO.getWorkplace(), gatheringVO.getMan(), gatheringVO.getMoney(), gatheringVO.getPlace());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }

    @Override
    public ResultMessage get() {
        return super.get();
    }
}
