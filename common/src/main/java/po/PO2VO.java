package po;

import vo.*;

/**
 * Created by MYK on 2015/12/7 0007.
 */
public class PO2VO {
    public static AddresseeInformationVO convert(AddresseeInformationPO PO) {
        return new AddresseeInformationVO(PO.getAddresseeNum(), PO.getAddresseeName(), PO.getAddresseeDate(), PO.getIsCheck());
    }

    public static DistributeVO convert(DistributePO PO) {
        return new DistributeVO(PO.getArriveDate(), PO.getOrderNum(), PO.getArriveDate(), PO.getIsCheck());
    }

    public static GatheringVO convert(GatheringPO gatheringPO) {
        return new GatheringVO(gatheringPO.getDate(), gatheringPO.getWorkplace(), gatheringPO.getMan(),
                gatheringPO.getMoney(), gatheringPO.getPlace(), gatheringPO.getIsCheck());
    }

    public static LoadingVO convert(LoadingPO PO) {
        return new LoadingVO(PO.getLoadingDate(), PO.getHallNum(), PO.getTransportNum(), PO.getStart(), PO.getEnd(),
                PO.getMonitor(), PO.getSupercargo(),
                PO.getVehicleNum(), PO.getConsignList(), PO.getTransportMoney(), PO.getIsCheck());
    }

    public static OrderVO convert(OrderPO PO) {
        return new OrderVO(PO.getSenderName(), PO.getSenderAddress(), PO.getSenderWorkplace(),
                PO.getSenderTelephone(), PO.getSenderPhone(), PO.getReceiverName(), PO.getReceiverAddress(),
                PO.getReceiverWorkplace(), PO.getReceiverTelephone(), PO.getReceiverPhone(),
                PO.getOriginalNum(), PO.getWeight(), PO.getVolume(), PO.getGoods_Name(), PO.getDeliveryType(),
                PO.getWrapper(), "1234", "1234", "1234", "1234", PO.getDeliveryNum(), PO.getIsCheck());
    }

    public static PaymentVO convert(PaymentPO PO) {
        return new PaymentVO(PO.getPayDate(), PO.getPayMoney(), PO.getPayHuman(), PO.getPayAccount(),
                PO.getPayReason(), PO.getPayComment(), PO.getIsCheck());
    }

    public static ReceiptVO convert(ReceiptPO PO) {
        return new ReceiptVO(PO.getReceiptDate(), PO.getReceiptMoney(), PO.getReceiptCourier(), PO.getOrderNum(),
                PO.getIsCheck());
    }

    public static ReceiveVO convert(ReceivePO PO) {
        return new ReceiveVO(PO.getArriveDate(), PO.getTransferNum(), PO.getStart(), PO.getArriveState(),
                PO.getIsCheck());
    }

    public static StockInVO convert(StockInPO PO) {
        return new StockInVO(PO.getDeliveryNum(), PO.getInDate(), PO.getEnd(), PO.getZoneNum(), PO.getRowNum(),
                PO.getShelfNum(), PO.getPositionNum(), PO.getIsCheck());
    }

    public static StockOutVO convert(StockOutPO PO) {
        return new StockOutVO(PO.getDeliveryNum(), PO.getOutDate(), PO.getEnd(), PO.getTransportType(),
                PO.getTransferNum(), PO.getIsCheck());
    }

    public static TransferReceiveVO convert(TransferReceivePO PO) {
        return new TransferReceiveVO(PO.getArriveDate(), PO.getStart(),
                PO.getCargoState(), PO.getTransferCenterNum(), PO.getTransferNum(), PO.getIsCheck());
    }

    public static TransferVO convert(TransferPO PO) {
        return new TransferVO(PO.getLoadingWay(), PO.getLoadingDate(), PO.getTransportNum(), PO.getVehicleNum(),
                PO.getStart(), PO.getEnd(), PO.getContainerNum(), PO.getMonitor(), PO.getSupercargo(), PO.getOrderNum(),
                PO.getMoney(), PO.getIsCheck());
    }


    public static UserVO convert(UserPO PO) {
        return new UserVO(PO.getId(), PO.getPassword(), PO.getName(), PO.getPermission());
    }

    public static ListVO convert(ListPO po) {
        switch (po.getType()) {
            case LOADINGINFO:
                return PO2VO.convert((LoadingPO) po);

            case ADDRESSEEINFOMATION:
                return PO2VO.convert((AddresseeInformationPO) po);

            case DISTRIBUTEINFO:
                return PO2VO.convert((DistributePO) po);

            case GATHERING:
                return PO2VO.convert((GatheringPO) po);

            case ORDER:
                return PO2VO.convert((OrderPO) po);

            case PAYMENT:
                return PO2VO.convert((PaymentPO) po);

            case RECEIPT:
                return PO2VO.convert((ReceiptPO) po);

            case RECEIVEINFO:
                return PO2VO.convert((ReceivePO) po);

            case STOCKIN:
                return PO2VO.convert((StockInPO) po);

            case STOCKOUT:
                return PO2VO.convert((StockOutPO) po);

            case TRANSARRIVE:
                return PO2VO.convert((TransferReceivePO) po);

            case TRANSINFO:
                return PO2VO.convert((TransferPO) po);

        }
        return null;
    }

    public static WorkerVO convert(WorkerPO po){
        return new WorkerVO(po.getName(),po.getIdNum(),po.getPosition(),po.getOrganization(),po.getUserId());
    }

    public static VehicleVO convert(VehiclePO po){
        return new VehicleVO(po.getVehicleNum(),po.getLicensePlate(),po.getBuyDate(),po.getUseTime());
    }

    public static DriverVO convert(DriverPO po){
        return new DriverVO(po.getDriverNum(),po.getDriverName(),po.getBirthDate(),po.getIdNum(),po.getPhone(),
                po.getVehicleInstitution(),po.getSex(),po.getLicenseTime());
    }
}