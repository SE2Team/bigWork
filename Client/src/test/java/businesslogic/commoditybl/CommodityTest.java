package businesslogic.commoditybl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by MYK on 2015/12/8 0008.
 */
public class CommodityTest {

    Commodity commodity;

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testDate2int() throws Exception {
        commodity=new Commodity();
        int i=commodity.Date2int("2015-05-16");
        Assert.assertEquals(20150516,i);
    }
}