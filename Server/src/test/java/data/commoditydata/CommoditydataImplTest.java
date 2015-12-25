package data.commoditydata;

import org.junit.Test;
import po.StockInPO;
import po.StockPO;

import java.util.ArrayList;

/**
 * Created by MYK on 2015/12/24 0024.
 */
public class CommoditydataImplTest {

    @Test
    public void testUpdate() throws Exception {

        ArrayList<StockInPO> arrayList=new ArrayList<>();
        arrayList.add(new StockInPO("0","0","0","0","0","0","0",false));
        arrayList.add(new StockInPO("0","0","0","0","0","0","1",false));
        StockPO po=new StockPO(false,arrayList);

        new CommoditydataImpl().update(po);
    }
}