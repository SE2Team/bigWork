package businesslogic.listbl;

import businesslogic.utilitybl.Helper;
import dataservice.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.inquirydataservice.InquiryDataService;
import dataservice.listdataservice.ListDataService;
import po.ListPO;
import po.PO2VO;
import vo.ListVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Administrator on 2015/10/25 0025.
 *
 * @author myk
 */
public class List {
    /**
     * The Data factory.
     */
    protected DataFactoryService dataFactory;
    /**
     * The List data service.
     */
    protected ListDataService listDataService;

    protected InquiryDataService inquiryDataService;

    /**
     * Instantiates a new List.
     *
     * @throws RemoteException the remote exception
     */
    public List() throws RemoteException {
        dataFactory = DataFactory.getInstance();
        listDataService = dataFactory.getListData();
        inquiryDataService = dataFactory.getInquiryData();
    }






    /**
     * 返回一个待审批单据列表
     *
     * @return array list
     * @throws RemoteException the remote exception
     */
    public Iterator<ListVO> push() throws RemoteException {
        ArrayList<ListPO> itr = listDataService.checkList();
        ArrayList<ListVO> vos = new ArrayList<ListVO>();
        for (ListPO temp : itr) {
            vos.add(PO2VO.convert(temp));
        }
        return vos.iterator();
    }

    public Iterator<ListVO> getRecent(String date) throws RemoteException {
        ArrayList<ListPO> itr = listDataService.getRecent(date, Helper.getTime());
        ArrayList<ListVO> arrayList = new ArrayList<ListVO>();
        for (ListPO temp : itr) {
            arrayList.add(PO2VO.convert(temp));
        }

        return arrayList.iterator();
    }

}
