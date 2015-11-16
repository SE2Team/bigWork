package src.businesslogic.listbl;

import src.data.DataFactory;
import src.dataservice.listdataservice.ListDataService;
import src.po.GatheringPO;
import src.util.ResultMessage;
import src.vo.GatheringVO;
import src.vo.ListVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class Gathering extends List {
    @Override
    public ResultMessage save(ListVO listVO) {
        dataFactory = new DataFactory();
        GatheringVO gatheringVO = (GatheringVO) listVO;
        ListDataService dataService = dataFactory.getListDataService();//通过datafactory去get
        GatheringPO po = new GatheringPO(gatheringVO.getDate(), gatheringVO.getWorkplace(), gatheringVO.getMan(), gatheringVO.getMoney(), gatheringVO.getPlace());
        dataService.saveGathering(po);
        return ResultMessage.SUCCESS;
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
