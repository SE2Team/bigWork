package vo;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class AddresseeInformationVO extends ListVO{
		/**
		 * 
		 * 收件单号，收件人，收件时间。
		 */
		private String addresseeNum;
		private String addresseeName;
		private String addresseeDate;
		
		/**
		 * 
		 * @param addresseeNum
		 * @param addresseeName
		 * @param addresseeDate
		 */
		public  AddresseeInformationVO(String addresseeNum,String 
				addresseeName,String addresseeDate) {
			this.addresseeNum=addresseeNum;
			this.addresseeName=addresseeName;
			this.addresseeDate=addresseeDate;
		}
		
		public AddresseeInformationVO(){}
		
		/**
		 * 
		 * @return 收件单号
		 */
		public String getAddresseeNum(){
			return addresseeNum;
		}
		
		/**
		 * 
		 * @param 收件单号
		 */
		public void setAddresseeNum(String addresseeNum){
			this.addresseeNum=addresseeNum;
		}
		
		/**
		 * 
		 * @return 收件人
		 */
		public String getAddresseeName(){
			return addresseeName;
		}
		
		/**
		 * 
		 * @param 收件人
		 */
		public void setAddresseeName(String addresseeName){
			this.addresseeName=addresseeName;
		}
		
		/**
		 * 
		 * @return 收件日期
		 */
		public String getAddresseeDate(){
			return addresseeDate;
		}
		
		/**
		 * 
		 * @param 收件日期
		 */
		public void setAddresseeDate(String addresseeDate){
			this.addresseeDate=addresseeDate;
		}
		
	
}
