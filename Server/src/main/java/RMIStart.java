import data.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by MYK on 2015/12/4 0004.
 */
public class RMIStart{
    /**
     *
     * @param args  123
     */
    public static void main(String[] args) {
        try {
            // 启动默认端口8888
            LocateRegistry.createRegistry(8888);
            DataFactoryService dataFactory = DataFactory.getInstance();
            Naming.rebind("rmi://127.0.0.1:8888/DataFactory", dataFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
