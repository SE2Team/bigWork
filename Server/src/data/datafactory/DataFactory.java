package src.data.datafactory;

import src.dataservice.datafactoryservice.DataFactoryService;
import src.dataservice.impl.ListDataServiceSerializableFileImpl;
import src.dataservice.listdataservice.ListDataService;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class DataFactory implements DataFactoryService {
    public ListDataService getListDataService() {
        ListDataService listDataService = new ListDataServiceSerializableFileImpl();
        return listDataService;
    }
}
