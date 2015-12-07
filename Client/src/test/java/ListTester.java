import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import junit.framework.TestCase;
import util.DeliveryType;
import vo.OrderVO;

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
        bl=new ListController();
        bl.order(new OrderVO("123","123","123","123","123","123","123","123","123","123","123","123","123","123", DeliveryType.FAST,
                "123","123","123","123","123","123",true));




    }
}
