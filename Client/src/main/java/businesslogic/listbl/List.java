package businesslogic.listbl;

import dataservice.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.listdataservice.ListDataService;
import po.ListPO;
import po.PO2VO;
import vo.*;

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

    /**
     * Instantiates a new List.
     *
     * @throws RemoteException the remote exception
     */
    public List() throws RemoteException {
        dataFactory = DataFactory.getInstance();
        listDataService = dataFactory.getListData();
    }

    /**
     * 保存为待审批单据
     * @param vo
     * @return
     * @throws RemoteException
     */
    public boolean save(ListVO vo) throws  RemoteException{
        ListPO po=null;
        switch (vo.getType()){
            case LOADINGINFO:
                po=VO2PO.convert((LoadingVO) vo);
                break;
            case ADDRESSEEINFOMATION:
                po=VO2PO.convert((AddresseeInformationVO) vo);
                break;
            case DISTRIBUTEINFO:
                po=VO2PO.convert((DistributeVO) vo);
                break;
            case GATHERING:
                po=VO2PO.convert((GatheringVO) vo);
                break;
            case ORDER:
                po=VO2PO.convert((OrderVO) vo);
                break;
            case PAYMENT:
                po=VO2PO.convert((PaymentVO) vo);
                break;
            case RECEIPT:
                po=VO2PO.convert((ReceiptVO) vo);
                break;
            case RECEIVEINFO:
                po=VO2PO.convert((ReceiveVO) vo);
                break;
            case STOCKIN:
                po=VO2PO.convert((StockInVO) vo);
                break;
            case STOCKOUT:
                po=VO2PO.convert((StockOutVO) vo);
                break;
            case TRANSARRIVE:
                po=VO2PO.convert((TransferReceiveVO) vo);
                break;
            case TRANSINFO:
                po=VO2PO.convert((TransferVO) vo);
                break;
        }

        return listDataService.saveAsList(po);//保存为待审批
    }


    /**
     * 返回一个待审批单据列表
     *
     * @return array list
     * @throws RemoteException the remote exception
     */
    public final Iterator<ListVO> push() throws RemoteException {
        Iterator<ListPO> itr=listDataService.checkList();
        ArrayList<ListVO> vos=new ArrayList<ListVO>();
        while (itr.hasNext()){
            vos.add(PO2VO.convert(itr.next()));
        }
        return vos.iterator();
    }
}
