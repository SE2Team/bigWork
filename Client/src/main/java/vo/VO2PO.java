package vo;

import po.*;

import java.util.ArrayList;

/**
 * Created by MYK on 2015/12/7 0007.
 */
public class VO2PO {
    public static AddresseeInformationPO convert(AddresseeInformationVO vo) {
        if (vo == null) {
            return null;
        }
        return new AddresseeInformationPO(vo.getAddresseeNum(), vo.getAddresseeName(), vo.getAddresseeDate(),
                vo.getIsCheck());
    }

    public static DistributePO convert(DistributeVO vo) {
        if (vo == null) {
            return null;
        }
        return new DistributePO(vo.getArriveDate(), vo.getOrderNum(), vo.getArriveDate(), vo.getIsCheck());
    }

    public static GatheringPO convert(GatheringVO vo) {
        if (vo == null) {
            return null;
        }
        return new GatheringPO(vo.getDate(), vo.getWorkplace(), vo.getMan(),
                vo.getMoney(), vo.getPlace(), vo.getIsCheck());
    }

    public static LoadingPO convert(LoadingVO vo) {
        if (vo == null) {
            return null;
        }
        return new LoadingPO(vo.getLoadingDate(), vo.getHallNum(), vo.getTransportNum(), vo.getStart(), vo.getEnd(),
                vo.getMonitor(), vo.getSupercargo(),
                vo.getVehicleNum(), vo.getConsignList(), vo.getTransportMoney(), vo.getIsCheck());
    }

    public static OrderPO convert(OrderVO vo) {
        if (vo == null) {
            return null;
        }
        return new OrderPO(vo.getSenderName(), vo.getSenderAddress(), vo.getSenderWorkplace(),
                vo.getSenderTelephone(), vo.getSenderPhone(), vo.getReceiverName(), vo.getReceiverAddress(),
                vo.getReceiverWorkplace(), vo.getReceiverTelephone(), vo.getReceiverPhone(),
                vo.getOriginalNum(), vo.getWeight(), vo.getVolume(), vo.getGoods_Name(), vo.getDeliveryType(),
                vo.getWrapper(), vo.getExpenseOfTransport(), vo.getExpenseOfWrapper(), vo.getExpense(), vo.getDate(),
                vo.getDeliveryNum(), vo.getIsCheck(), vo.getLogistics());
    }

    public static PaymentPO convert(PaymentVO vo) {
        if (vo == null) {
            return null;
        }
        return new PaymentPO(vo.getPayDate(), vo.getPayMoney(), vo.getPayHuman(), vo.getPayAccount(),
                vo.getPayReason(), vo.getPayComment(), vo.getIsCheck());
    }

    public static ReceiptPO convert(ReceiptVO vo) {
        if (vo == null) {
            return null;
        }
        return new ReceiptPO(vo.getReceiptDate(), vo.getReceiptMoney(), vo.getReceiptCourier(), vo.getOrderNum(),
                vo.getIsCheck());
    }

    public static ReceivePO convert(ReceiveVO vo) {
        if (vo == null) {
            return null;
        }
        return new ReceivePO(vo.getArriveDate(), vo.getTransferNum(), vo.getStart(), vo.getArriveState(),
                vo.getIsCheck());
    }

    public static StockInPO convert(StockInVO vo) {
        if (vo == null) {
            return null;
        }
        return new StockInPO(vo.getDeliveryNum(), vo.getInDate(), vo.getEnd(), vo.getZoneNum(), vo.getRowNum(),
                vo.getShelfNum(), vo.getPositionNum(), vo.getIsCheck());
    }

    public static StockOutPO convert(StockOutVO vo) {
        if (vo == null) {
            return null;
        }
        return new StockOutPO(vo.getDeliveryNum(), vo.getOutDate(), vo.getEnd(), vo.getTransportType(),
                vo.getTransferNum(), vo.getIsCheck());
    }

    public static TransferReceivePO convert(TransferReceiveVO vo) {
        if (vo == null) {
            return null;
        }
        return new TransferReceivePO(vo.getArriveDate(), vo.getStart(),
                vo.getCargoState(), vo.getTransferCenterNum(), vo.getTransferNum(), vo.getIsCheck());
    }

    public static TransferPO convert(TransferVO vo) {
        if (vo == null) {
            return null;
        }
        return new TransferPO(vo.getLoadingWay(), vo.getLoadingDate(), vo.getTransportNum(), vo.getVehicleNum(),
                vo.getStart(), vo.getEnd(), vo.getContainerNum(), vo.getMonitor(), vo.getSupercargo(), vo.getOrderNum(),
                vo.getMoney(), vo.getIsCheck());
    }


    public static UserPO convert(UserVO vo) {
        if (vo == null) {
            return null;
        }
        return new UserPO(vo.getId(), vo.getPassword(), vo.getName(), vo.getPermission());
    }


    public static AccountPO convert(AccountVO vo) {
        if (vo == null) {
            return null;
        }
        return new AccountPO(vo.getAccountName(), vo.getAccountBalance());
    }

    public static WorkerPO convert(WorkerVO vo) {
        if (vo == null) {
            return null;
        }
        return new WorkerPO(vo.getName(), vo.getIdNum(), vo.getPosition(), vo.getOrganization(), vo.getUserId(),
                vo.getSex(), vo.getAge());
    }

    public static StockPO convert(StockVO vo) {
        if (vo == null) {
            return null;
        }
        ArrayList<StockInPO> arrayList = new ArrayList<StockInPO>();
        for (StockInVO stockInVO : vo.getStockList()) {
            arrayList.add(VO2PO.convert(stockInVO));
        }
        return new StockPO(vo.getStockState(), arrayList);
    }

    public static VehiclePO convert(VehicleVO vo) {
        if (vo == null) {
            return null;
        }
        return new VehiclePO(vo.getVehicleNum(), vo.getLicensePlate(), vo.getBuyDate(), vo.getUseTime());
    }

    public static DriverPO convert(DriverVO driverVO) {
        if (driverVO == null) {
            return null;
        }
        return new DriverPO(driverVO.getDriverNum(), driverVO.getDriverName(), driverVO.getBirthDate(), driverVO.getIdNum(),
                driverVO.getPhone(), driverVO.getVehicleInstitution(), driverVO.getSex(), driverVO.getLicenseTime());
    }

    public static OrganizationPO convert(OrganizationVO vo) {
        if (vo == null) {
            return null;
        }
        return new OrganizationPO(vo.getNum(), vo.getCity(), vo.getName());
    }
}
