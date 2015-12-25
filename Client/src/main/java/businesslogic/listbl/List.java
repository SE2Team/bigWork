package businesslogic.listbl;

import businesslogic.utilitybl.Helper;
import dataservice.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.inquirydataservice.InquiryDataService;
import dataservice.listdataservice.ListDataService;
import po.ListPO;
import po.OperationLogPO;
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

    protected InquiryDataService inquiryDataService;

    /**
     * Instantiates a new List.
     *
     * @throws RemoteException the remote exception
     */
    public List() throws RemoteException {
        dataFactory = DataFactory.getInstance();
        listDataService = dataFactory.getListData();
        inquiryDataService=dataFactory.getInquiryData();
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
                inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                        "新建装车单"));
                break;
            case ADDRESSEEINFOMATION:
                po=VO2PO.convert((AddresseeInformationVO) vo);
                inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                        "新建收件单"));
                break;
            case DISTRIBUTEINFO:
                po=VO2PO.convert((DistributeVO) vo);
                inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                        "新建派件单"));
                break;
            case GATHERING:
                po=VO2PO.convert((GatheringVO) vo);
                inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                        "新建收款单（财务）"));
                break;
            case ORDER:
                po=VO2PO.convert((OrderVO) vo);
                inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                        "新建快递单"));
                break;
            case PAYMENT:
                po=VO2PO.convert((PaymentVO) vo);
                inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                        "新建付款单"));
                break;
            case RECEIPT:
                po=VO2PO.convert((ReceiptVO) vo);
                inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                        "新建收款单（快递员）"));
                System.out.println(po.getType());
                break;
            case RECEIVEINFO:
                po=VO2PO.convert((ReceiveVO) vo);
                inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                    "新建接收单"));
                break;
            case STOCKIN:
                po=VO2PO.convert((StockInVO) vo);
                inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                        "新建入库单"));
                break;
            case STOCKOUT:
                po=VO2PO.convert((StockOutVO) vo);
                inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                        "新建出库单"));
                break;
            case TRANSARRIVE:
                po=VO2PO.convert((TransferReceiveVO) vo);
                inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                        "新建中转到达单"));
                break;
            case TRANSINFO:
                po=VO2PO.convert((TransferVO) vo);
                inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                        "新建中转信息单"));
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
        ArrayList<ListPO> itr=listDataService.checkList();
        ArrayList<ListVO> vos=new ArrayList<ListVO>();
        for(ListPO temp:itr){
            vos.add(PO2VO.convert(temp));
        }
        return vos.iterator();
    }

    public Iterator<ListVO> getRecent(String date) throws RemoteException {
        ArrayList<ListPO> itr=listDataService.getRecent(date, Helper.getTime());
        ArrayList<ListVO> arrayList=new ArrayList<ListVO>();
        for(ListPO temp:itr){
            arrayList.add(PO2VO.convert(temp));
        }

        return arrayList.iterator();
    }
    public boolean save2File(ListVO vo) throws RemoteException {
        return true;
    }

}
