package businesslogic.listbl;

import data.DataFactory;
import dataservice.listdataservice.ListDataService;
import po.GatheringPO;
import util.ResultMessage;
import vo.GatheringVO;
import vo.ListVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class Gathering extends List {
    String date;
    String workplace;
    String man;
    String money;
    String place;
    String content;

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
        content = date + " " + workplace;

        return super.saveAsList();
    }
}
