package vo;

import po.*;

/**
 * Created by MYK on 2015/12/7 0007.
 */
public class VO2PO {
    public static AddresseeInformationPO convert(AddresseeInformationVO vo) {
        return new AddresseeInformationPO(vo.getAddresseeNum(), vo.getAddresseeName(), vo.getAddresseeDate(), vo.getIsCheck());
    }

    public static DistributePO convert(DistributeVO vo) {
        return new DistributePO(vo.getArriveDate(), vo.getOrderNum(), vo.getArriveDate(), vo.getIsCheck());
    }

    public static GatheringPO convert(GatheringVO gatheringVO) {
        return new GatheringPO(gatheringVO.getDate(), gatheringVO.getWorkplace(), gatheringVO.getMan(),
                gatheringVO.getMoney(), gatheringVO.getPlace(), gatheringVO.getIsCheck());
    }

    public static LoadingPO convert(LoadingVO vo) {
        return new LoadingPO(vo.getLoadingDate(), vo.getHallNum(), vo.getTransportNum(), vo.getStart(), vo.getEnd(),
                vo.getMonitor(), vo.getSupercargo(),
                vo.getVehicleNum(), vo.getConsignList(), vo.getTransportMoney(), vo.getIsCheck());
    }

    public static OrderPO convert(OrderVO vo) {
        return new OrderPO(vo.getSenderName(), vo.getSenderAddress(), vo.getSenderWorkplace(),
                vo.getSenderTelephone(), vo.getSenderPhone(), vo.getReceiverName(), vo.getReceiverAddress(),
                vo.getReceiverWorkplace(), vo.getReceiverTelephone(), vo.getReceiverPhone(),
                vo.getOriginalNum(), vo.getWeight(), vo.getVolume(), vo.getGoods_Name(), vo.getDeliveryType(),
                vo.getWrapper(), "1234", "1234", "1234", "1234", vo.getDeliveryNum(), vo.getIsCheck());
    }

    public static PaymentPO convert(PaymentVO vo) {
        return new PaymentPO(vo.getPayDate(), vo.getPayMoney(), vo.getPayHuman(), vo.getPayAccount(),
                vo.getPayReason(), vo.getPayComment(), vo.getIsCheck());
    }

    public static ReceiptPO convert(ReceiptVO vo) {
        return new ReceiptPO(vo.getReceiptDate(), vo.getReceiptMoney(), vo.getReceiptCourier(), vo.getOrderNum(),
                vo.getIsCheck());
    }

    public static ReceivePO convert(ReceiveVO vo) {
        return new ReceivePO(vo.getArriveDate(), vo.getTransferNum(), vo.getStart(), vo.getArriveState(),
                vo.getIsCheck());
    }

    public static StockInPO convert(StockInVO vo) {
        return new StockInPO(vo.getDeliveryNum(), vo.getInDate(), vo.getEnd(), vo.getZoneNum(), vo.getRowNum(),
                vo.getShelfNum(), vo.getPositionNum(), vo.getIsCheck());
    }

    public static StockOutPO convert(StockOutVO vo) {
        return new StockOutPO(vo.getDeliveryNum(), vo.getOutDate(), vo.getEnd(), vo.getTransportType(),
                vo.getTransferNum(), vo.getIsCheck());
    }

    public static TransferReceivePO convert(TransferReceiveVO vo) {
        return new TransferReceivePO(vo.getArriveDate(), vo.getStart(),
                vo.getCargoState(), vo.getTransferCenterNum(), vo.getTransferNum(), vo.getIsCheck());
    }

    public static TransferPO convert(TransferVO vo) {
        return new TransferPO(vo.getLoadingWay(), vo.getLoadingDate(), vo.getTransportNum(), vo.getVehicleNum(),
                vo.getStart(), vo.getEnd(), vo.getContainerNum(), vo.getMonitor(), vo.getSupercargo(), vo.getOrderNum(),
                vo.getMoney(), vo.getIsCheck());
    }


    public static UserPO convert(UserVO vo) {
        return new UserPO(vo.getId(), vo.getPassword(), vo.getName(), vo.getPermission());
    }


    public static AccountPO convert(AccountVO vo) {
        return new AccountPO(vo.getAccountName(), vo.getAccountBalance());
    }

    public static WorkerPO convert(WorkerVO vo) {
        return new WorkerPO(vo.getName(), vo.getIdNum(), vo.getPosition(), vo.getOrganization(), vo.getUserId(), vo.getSex());
    }

    public static StockPO convert(StockVO vo) {
        return new StockPO(vo.getStockState(), vo.getStockList());
    }

    public static VehiclePO convert(VehicleVO vo) {
        return new VehiclePO(vo.getVehicleNum(), vo.getLicensePlate(), vo.getBuyDate(), vo.getUseTime());
    }
}
