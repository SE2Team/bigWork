package po;

import vo.*;

import java.util.ArrayList;

/**
 * Created by MYK on 2015/12/7 0007.
 */
public class PO2VO {

    public static AddresseeInformationVO convert(AddresseeInformationPO PO) {
        if (PO == null)
            return null;
        return new AddresseeInformationVO(PO.getAddresseeNum(), PO.getAddresseeName(), PO.getAddresseeDate(),
                PO.getIsCheck());
    }

    public static DistributeVO convert(DistributePO PO) {
        if (PO == null)
            return null;
        return new DistributeVO(PO.getArriveDate(), PO.getOrderNum(), PO.getArriveDate(), PO.getIsCheck()
        );
    }

    public static GatheringVO convert(GatheringPO PO) {
        if (PO == null)
            return null;
        return new GatheringVO(PO.getDate(), PO.getWorkplace(), PO.getMan(),
                PO.getMoney(), PO.getPlace(), PO.getIsCheck());
    }

    public static LoadingVO convert(LoadingPO PO) {
        if (PO == null)
            return null;
        return new LoadingVO(PO.getLoadingDate(), PO.getHallNum(), PO.getTransportNum(), PO.getStart(), PO.getEnd(),
                PO.getMonitor(), PO.getSupercargo(),
                PO.getVehicleNum(), PO.getConsignList(), PO.getTransportMoney(), PO.getIsCheck());
    }

    public static OrderVO convert(OrderPO PO) {
        if (PO == null)
            return null;
        return new OrderVO(PO.getSenderName(), PO.getSenderAddress(), PO.getSenderWorkplace(),
                PO.getSenderTelephone(), PO.getSenderPhone(), PO.getReceiverName(), PO.getReceiverAddress(),
                PO.getReceiverWorkplace(), PO.getReceiverTelephone(), PO.getReceiverPhone(),
                PO.getOriginalNum(), PO.getWeight(), PO.getVolume(), PO.getGoods_Name(), PO.getDeliveryType(),
                PO.getWrapper(), "1234", "1234", "1234", "1234", PO.getDeliveryNum(), PO.getIsCheck(), PO.getLogistics());
    }

    public static PaymentVO convert(PaymentPO PO) {
        if (PO == null)
            return null;
        return new PaymentVO(PO.getPayDate(), PO.getPayMoney(), PO.getPayHuman(), PO.getPayAccount(),
                PO.getPayReason(), PO.getPayComment(), PO.getIsCheck());
    }

    public static ReceiptVO convert(ReceiptPO PO) {
        if (PO == null)
            return null;
        return new ReceiptVO(PO.getReceiptDate(), PO.getReceiptMoney(), PO.getReceiptCourier(), PO.getOrderNum(),
                PO.getIsCheck());
    }

    public static ReceiveVO convert(ReceivePO PO) {
        if (PO == null)
            return null;
        return new ReceiveVO(PO.getArriveDate(), PO.getTransferNum(), PO.getStart(), PO.getArriveState(),
                PO.getIsCheck());
    }

    public static StockInVO convert(StockInPO PO) {
        if (PO == null)
            return null;
        return new StockInVO(PO.getDeliveryNum(), PO.getInDate(), PO.getEnd(), PO.getZoneNum(), PO.getRowNum(),
                PO.getShelfNum(), PO.getPositionNum(), PO.getIsCheck());
    }

    public static StockOutVO convert(StockOutPO PO) {
        if (PO == null)
            return null;
        return new StockOutVO(PO.getDeliveryNum(), PO.getOutDate(), PO.getEnd(), PO.getTransportType(),
                PO.getTransferNum(), PO.getIsCheck());
    }

    public static StockVO convert(StockPO PO) {
        if (PO == null)
            return null;
        ArrayList<StockInVO> arrayList = new ArrayList<StockInVO>();
        for (StockInPO po : PO.getStockList()) {
            arrayList.add(PO2VO.convert(po));
        }
        return new StockVO(PO.getStockState(), arrayList);
    }

    public static TransferReceiveVO convert(TransferReceivePO PO) {
        if (PO == null)
            return null;
        return new TransferReceiveVO(PO.getArriveDate(), PO.getStart(),
                PO.getCargoState(), PO.getTransferCenterNum(), PO.getTransferNum(), PO.getIsCheck());
    }

    public static TransferVO convert(TransferPO PO) {
        if (PO == null)
            return null;
        return new TransferVO(PO.getLoadingWay(), PO.getLoadingDate(), PO.getTransportNum(), PO.getVehicleNum(),
                PO.getStart(), PO.getEnd(), PO.getContainerNum(), PO.getMonitor(), PO.getSupercargo(), PO.getOrderNum(),
                PO.getMoney(), PO.getIsCheck());
    }


    public static UserVO convert(UserPO PO) {
        if (PO == null)
            return null;
        return new UserVO(PO.getId(), PO.getPassword(), PO.getName(), PO.getPermission());
    }

    public static ListVO convert(ListPO PO) {
        if (PO == null)
            return null;
        switch (PO.getType()) {
            case LOADINGINFO:
                return PO2VO.convert((LoadingPO) PO);

            case ADDRESSEEINFOMATION:
                return PO2VO.convert((AddresseeInformationPO) PO);

            case DISTRIBUTEINFO:
                return PO2VO.convert((DistributePO) PO);

            case GATHERING:
                return PO2VO.convert((GatheringPO) PO);

            case ORDER:
                return PO2VO.convert((OrderPO) PO);

            case PAYMENT:
                return PO2VO.convert((PaymentPO) PO);

            case RECEIPT:
                return PO2VO.convert((ReceiptPO) PO);

            case RECEIVEINFO:
                return PO2VO.convert((ReceivePO) PO);

            case STOCKIN:
                return PO2VO.convert((StockInPO) PO);

            case STOCKOUT:
                return PO2VO.convert((StockOutPO) PO);

            case TRANSARRIVE:
                return PO2VO.convert((TransferReceivePO) PO);

            case TRANSINFO:
                return PO2VO.convert((TransferPO) PO);

        }
        return null;
    }

    public static WorkerVO convert(WorkerPO po){
        if (po == null)
            return null;
        return new WorkerVO(po.getName(), po.getIdNum(), po.getPosition(), po.getOrganization(), po.getUserId(), po.getSex()
                , po.getAge());
    }

    public static VehicleVO convert(VehiclePO po){
        if (po == null)
            return null;
        return new VehicleVO(po.getVehicleNum(),po.getLicensePlate(),po.getBuyDate(),po.getUseTime());
    }

    public static DriverVO convert(DriverPO po){
        if (po == null)
            return null;
        return new DriverVO(po.getDriverNum(),po.getDriverName(),po.getBirthDate(),po.getIdNum(),po.getPhone(),
                po.getVehicleInstitution(),po.getSex(),po.getLicenseTime());
    }

    public static ConstantVO convert(ConstantPO po) {
        if (po == null)
            return null;
        return new ConstantVO(po.getCity1(), po.getCity2(), po.getPrice(), po.getDistance());
    }

    public static AccountVO convert(AccountPO po) {
        if (po == null)
            return null;
        return new AccountVO(po.getAccountName(), po.getAccountBalance());
    }

    public static OrganizationVO convert(OrganizationPO po) {
        if (po == null)
            return null;
        return new OrganizationVO(po.getNum(), po.getCity(), po.getName());
    }
}