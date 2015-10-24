package businesslogicservice;

import po.DeliveryType;
import vo.OrderVO;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface ListblService {
    public OrderVO order(String senderName, String senderAddress, String senderWorkplace, String senderTelephone,
                         String senderPhone, String receiverName, String receiverAddress, String receiverWorkplace,
                         String receiverTelephone, String receiverPhone, int originalNum, double weight, double volume,
                         String goods_Name, DeliveryType DeliveryType, String wrapper);
    //不需要审批
    public void addresseeInformation(String num,String name);
}
