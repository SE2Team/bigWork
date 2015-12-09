package businesslogic.utilitybl;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by MYK on 2015/12/8 0008.
 */
public class HelperTest {

    @Test
    public void testGetTime() throws Exception {

    }

    @Test
    public void testisEqual() throws Exception {
        Assert.assertEquals(true,Helper.isEqual("2015-12-08"));
        Assert.assertEquals(false,Helper.isEqual("2015-12-07"));


    }

    @Test
    public void testCompareTo() throws Exception {
        boolean b=Helper.compareTo("2015-05-26");
        Assert.assertEquals(true,b);
        Assert.assertEquals(false,Helper.compareTo("2015-12-26"));
    }

    @Test
    public void testCompareTo1() throws Exception {
        Assert.assertEquals(true,Helper.compareTo("2015-12-26","2015-12-27"));
        Assert.assertEquals(false,Helper.compareTo("2015-12-29","2015-12-27"));

    }

    @Test
    public void testIsBetween() throws Exception {
        Assert.assertEquals(true,Helper.isBetween("2015-12-06","2015-12-07"));
        Assert.assertEquals(false,Helper.isBetween("2015-12-07","2015-12-06"));

    }
}