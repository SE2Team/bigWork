/**
 * 判断所有编号的输入是否符合规范
 * @author Administrator
 */

package presentation.exception;

import javax.swing.JTextField;

public class NumExceptioin {

	/**
	 * 判断订单号是否符合规范（10位）
	 * @param text
	 * @return
	 */
	public static boolean isOrderValid(JTextField text) {
		text.getText();
		if (!"".equalsIgnoreCase(text.getText().trim())
				&& text.getText().length() != 10) {
			return false;
		}
		return true;
	}

	/**
	 * 判断营业厅编号是否符合规范（6位）
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isHallValid(JTextField text) {
		if (!"".equalsIgnoreCase(text.getText().trim())
				&& text.getText().length() != 6) {
			return false;
		}
		return true;
	}

	/**
	 * 判断汽运编号是否符合规范（19位）
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isCarValid(JTextField text) {
		if (!"".equalsIgnoreCase(text.getText().trim())
				&& text.getText().length() != 19) {
			return false;
		}
		return true;
	}

	/**
	 * 判断车辆代号是否符合规范（9位）
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isVehicleValid(JTextField text) {
		if (!"".equalsIgnoreCase(text.getText().trim())
				&& text.getText().length() != 9) {
			return false;
		}
		return true;
	}

	/**
	 * 判断司机编号是否符合规范（9位）
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isDriverValid(JTextField text) {
		if (!"".equalsIgnoreCase(text.getText().trim())
				&& text.getText().length() != 9) {
			return false;
		}
		return true;
	}

	/**
	 * 判断身份证号是否符合规范（18位）
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isIdValid(JTextField text) {
		if (!"".equalsIgnoreCase(text.getText().trim())
				&& text.getText().length() != 18) {
			return false;
		}
		return true;
	}

	/**
	 * 判断手机号是否符合规范（11位）
	 * @param text
	 * @return
	 */
	public static boolean isPhoneValid(JTextField text) {
		if (!"".equalsIgnoreCase(text.getText().trim())
				&& text.getText().length() != 11) {
			return false;
		}
		return true;
	}
	
	/**
	 * 判断电话是否符合规范
	 * @param text
	 * @return
	 */
	//TODO 有问题···
	public static boolean isTeleValid(JTextField text){
		if(!"".equalsIgnoreCase(text.getText().trim())&&text.getText().length()!=6){
			return false;
		}
		return true;
	}
	
	/**
	 * 判断中转中心编号是否符合规范(4位)
	 * @param text
	 * @return
	 */
	public static boolean isTransCenterValid(JTextField text){
		if(!"".equalsIgnoreCase(text.getText().trim())&&text.getText().length()!=4){
			return false;
		}
		return true;
	}
	
	/**
	 * 判断中转单编号是否符合规范(19位)
	 * @param text
	 * @return
	 */
	public static boolean isTransListValid(JTextField text){
		if(!"".equalsIgnoreCase(text.getText().trim())&&text.getText().length()!=19){
			return false;
		}
		return true;
	}
	
	/**
	 * 判断车牌号是否符合规范(除去空格7位)
	 * @param text
	 * @return
	 */
	public static boolean islicensePlateValid(JTextField text){
		if(!"".equalsIgnoreCase(text.getText().trim())&&text.getText().length()!=7){
			return false;
		}
		return true;
	}
	
	/**
	 * 判断账号输入是否符合规范(6~10位)
	 * @param text
	 * @return
	 */
	public static boolean isAccountNumValid(JTextField text){
		if(!"".equalsIgnoreCase(text.getText().trim())&&!(text.getText().length()>=6&&text.getText().length()<=10)){
			return false;
		}
		return true;
	}
	
	/**
	 * 判断机构编号输入是否符合规范(4位)
	 * @param text
	 * @return
	 */
	public static boolean isInstitutionValid(JTextField text){
		if(!"".equalsIgnoreCase(text.getText().trim())&&text.getText().length()!=6){
			return false;
		}
		return true;
	}
}
