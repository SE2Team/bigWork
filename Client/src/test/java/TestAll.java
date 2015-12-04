import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by MYK on 2015/12/3 0003.
 */
public class TestAll extends TestCase {


    public static Test suite()
    {
        TestSuite suite = new TestSuite();

        suite.addTestSuite(ListTester.class);

        return suite;
    }
}
