import businesslogic.Exception.OtherException;
import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import junit.framework.Assert;
import junit.framework.TestCase;
import util.DeliveryType;
import util.ResultMessage;
import vo.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/3 0003.
 */
public class ListTester extends TestCase{
    private ListblService bl;

    public void setUp() throws Exception {
        super.setUp();
        bl= new ListController();

    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testOrder() throws Exception {
        Throwable throwable=null;
        try {
            bl.order(new OrderVO("123","123","123","","123","123","123","123","123","123","123","123","123","123", DeliveryType.FAST,"123","123"));
            Assert.fail();
        } catch (OtherException e) {
            throwable=e;
        } catch (RemoteException e) {
            throwable=e;
        }
        Assert.assertNotNull(throwable);
        Assert.assertEquals(OtherException.class,throwable.getClass());
        Assert.assertEquals("请输入寄件人电话",throwable.getMessage());
    }
    public void testOrder2() throws Exception {
        Throwable throwable = null;
        ResultMessage r=null;
        try {
            r=bl.order(new OrderVO("123","123","123","123","123","123","123","123","123","123","123","123","123","123", DeliveryType.FAST,"123","123"));

        } catch (OtherException e) {
            throwable=e;
            Assert.fail();
        } catch (RemoteException e) {
            throwable=e;
            Assert.fail();
        }
        Assert.assertEquals(ResultMessage.SUCCESS,r);
    }
}
