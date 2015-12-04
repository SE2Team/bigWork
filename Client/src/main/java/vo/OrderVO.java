package vo;

import util.DeliveryType;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/23 0023.
 */
public class OrderVO extends ListVO implements Serializable {
	//寄件人姓名、住址、单位、电话、手机）

	private static final long serialVersionUID = 1L;//序列化编号
	private String senderName;
	private String senderAddress;
	private String senderWorkplace;
	private String senderTelephone;
	private String senderPhone;

	//收件人姓名、住址、单位、电话、手机
	private String receiverName;
	private String receiverAddress;
	private String receiverWorkplace;
	private String receiverTelephone;
	private String receiverPhone;

	//托运货物信息（原件数、实际重量、长宽高、内件品名），
	private String originalNum;
	private String weight;
	private String volume;
	private String goodsName;

	//快递类型，包装材料，运费和包装费，总费用，预计到达日期，订单条形码号（快递编号）。
	private DeliveryType DeliveryType;
	private String wrapper;
	private String expenseOfTransport;
	private String expenseOfWrapper;
	private String expense;
	private String date;
	private String deliveryNum;

	/**
	 * @param senderName
	 * @param senderAddress
	 * @param senderWorkplace
	 * @param senderTelephone
	 * @param senderPhone
	 * @param receiverName
	 * @param receiverAddress
	 * @param receiverWorkplace
	 * @param receiverTelephone
	 * @param receiverPhone
	 * @param originalNum 原件数
	 * @param weight
	 * @param volume
	 * @param goodsName
	 * @param DeliveryType
	 * @param wrapper
	 * @param expenseOfTransport 自动计算
	 * @param expenseOfWrapper  自动计算
	 * @param expense 自动计算
	 * @param date 预计到达日
	 * @param deliveryNum
	 */

	public OrderVO(String senderName, String senderAddress, String senderWorkplace, String senderTelephone,
				   String senderPhone, String receiverName, String receiverAddress, String receiverWorkplace,
				   String receiverTelephone, String receiverPhone, String originalNum, String weight, String volume,
				   String goodsName, DeliveryType DeliveryType, String wrapper, String deliveryNum) {
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.senderWorkplace = senderWorkplace;
		this.senderTelephone = senderTelephone;
		this.senderPhone = senderPhone;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.receiverWorkplace = receiverWorkplace;
		this.receiverTelephone = receiverTelephone;
		this.receiverPhone = receiverPhone;
		this.originalNum = originalNum;
		this.weight = weight;
		this.volume = volume;
		this.goodsName = goodsName;
		this.DeliveryType = DeliveryType;
		this.wrapper = wrapper;
		//TODO 自动计算项目
//        this.expenseOfTransport = expenseOfTransport;
//        this.expenseOfWrapper = expenseOfWrapper;
//        this.expense = expense;
//        this.date = date;
		this.deliveryNum = deliveryNum;
	}

	/**
	 * @return 寄件人姓名
	 */
	public String getSenderName() {

		return senderName;
	}

	/**
	 * @param 寄件人姓名
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/**
	 * @return 寄件人地址
	 */
	public String getSenderAddress() {
		return senderAddress;
	}

	/**
	 * @param 寄件人地址
	 */
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	/**
	 * @return 寄件人单位
	 */
	public String getSenderWorkplace() {
		return senderWorkplace;
	}

	/**
	 * @param 寄件人单位
	 */
	public void setSenderWorkplace(String senderWorkplace) {
		this.senderWorkplace = senderWorkplace;
	}

	/**
	 * @return 寄件人电话
	 */
	public String getSenderTelephone() {
		return senderTelephone;
	}

	/**
	 * @param 寄件人电话
	 */
	public void setSenderTelephone(String senderTelephone) {
		this.senderTelephone = senderTelephone;
	}

	/**
	 * @return 寄件人手机
	 */
	public String getSenderPhone() {
		return senderPhone;
	}

	/**
	 * @param 寄件人手机
	 */
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	/**
	 * @return 收件人姓名
	 */
	public String getReceiverName() {
		return receiverName;
	}

	/**
	 * @param 收件人姓名
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	/**
	 * @return 收件人地址
	 */
	public String getReceiverAddress() {
		return receiverAddress;
	}

	/**
	 * @param 收件人地址
	 */
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	/**
	 * @return 收件人单位
	 */
	public String getReceiverWorkplace() {
		return receiverWorkplace;
	}

	/**
	 * @param 收件人单位
	 */
	public void setReceiverWorkplace(String receiverWorkplace) {
		this.receiverWorkplace = receiverWorkplace;
	}

	/**
	 * @return 收件人电话
	 */
	public String getReceiverTelephone() {
		return receiverTelephone;
	}

	/**
	 * @param 收件人电话
	 */
	public void setReceiverTelephone(String receiverTelephone) {
		this.receiverTelephone = receiverTelephone;
	}

	/**
	 * @return 收件人手机
	 */
	public String getReceiverPhone() {
		return receiverPhone;
	}

	/**
	 * @param 收件人手机
	 */
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	/**
	 * @return 原件数
	 */
	public String getOriginalNum() {
		return originalNum;
	}

	/**
	 * @param 原件数
	 */
	public void setOriginalNum(String originalNum) {
		this.originalNum = originalNum;
	}

	/**
	 * @return 实际重量
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param 实际重量
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @return 体积
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * @param 体积
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * @return 内件物品名称
	 */
	public String getGoods_Name() {
		return goodsName;
	}

	/**
	 * @param 内件物品名称
	 */
	public void setGoods_Name(String goods_Name) {
		this.goodsName = goods_Name;
	}

	/**
	 * @return 快递类型
	 */
	public DeliveryType getDeliveryType() {
		return DeliveryType;
	}

	/**
	 * @param 快递类型
	 */
	public void setDeliveryType(DeliveryType DeliveryType) {
		this.DeliveryType = DeliveryType;
	}

	/**
	 * @return 包装材料
	 */
	public String getWrapper() {
		return wrapper;
	}

	/**
	 * @param 包装材料
	 */
	public void setWrapper(String wrapper) {
		this.wrapper = wrapper;
	}

	/**
	 * @return 运费
	 */
	public String getExpenseOfTransport() {
		return expenseOfTransport;
	}

	/**
	 * @param 运费
	 */
	public void setExpenseOfTransport(String expenseOfTransport) {
		this.expenseOfTransport = expenseOfTransport;
	}

	/**
	 * @return 包装费
	 */
	public String getExpenseOfWrapper() {
		return expenseOfWrapper;
	}

	/**
	 * @param 包装费
	 */
	public void setExpenseOfWrapper(String expenseOfWrapper) {
		this.expenseOfWrapper = expenseOfWrapper;
	}

	/**
	 * @return 总费用
	 */
	public String getExpense() {
		return expense;
	}

	/**
	 * @param 总费用
	 */
	public void setExpense(String expense) {
		this.expense = expense;
	}

	/**
	 * @return 预计到达日期
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param 预计到达日期
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return 快递单号
	 */
	public String getDeliveryNum() {
		return deliveryNum;
	}

	/**
	 * @param 快递单号
	 */
	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
}
