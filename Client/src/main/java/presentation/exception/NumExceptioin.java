/**
 * 判断所有编号的输入是否符合规范
 * @author Administrator
 */

package presentation.exception;

import javax.swing.*;

public class NumExceptioin {

	/**
	 * 判断订单号是否符合规范（10位）
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isOrderValid(JTextField text) {
		String s = text.getText().trim();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if (!"".equalsIgnoreCase(text.getText().trim())
						&& (text.getText().length() != 7 && text.getText().length() != 10)) {
					return false;
				}
			} else {
				return false;
			}
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
		String s = text.getText().trim();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if (!"".equalsIgnoreCase(text.getText().trim())
						&& text.getText().length() != 3) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断汽运编号是否符合规范（19位）
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isCarValid(JTextField text, String date) {
		date = date.replace("-", "");
		String s = text.getText().trim();
		if ((!"".equalsIgnoreCase(s)) && s.length() != 16) {
			return false;
		}
		if (s.length() < 11)
			return false;
		boolean isEqual = s.substring(3, 11).equals(date);
		isEqual = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if (!"".equalsIgnoreCase(text.getText().trim())
						&& text.getText().length() != 16) {
					return false;
				}
				if (!isEqual) {
					return false;
				}
			} else {
				return false;
			}
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
		String s = text.getText().trim();
//		if(s.length()!=6){
//			return false;
//		}
//		String num = text.getText().substring(0, 3);
//		boolean isEqual = num.equals(citynum);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if ((!"".equalsIgnoreCase(text.getText().trim())
						&& text.getText().length() != 6)) {
					return false;
				}
//				if(!isEqual){
//					return false;
//				}
			} else {
				return false;
			}
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
		String s = text.getText().trim();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if (!"".equalsIgnoreCase(text.getText().trim())
						&& text.getText().length() != 3) {
					return false;
				}
			} else {
				return false;
			}
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
		String s = text.getText().trim();
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if (!"".equalsIgnoreCase(text.getText().trim())
						&& text.getText().length() != 18) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断手机号是否符合规范（11位）
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isPhoneValid(JTextField text) {
		String s = text.getText().trim();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if (!"".equalsIgnoreCase(text.getText().trim())
						&& text.getText().length() != 11) {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	/**
	 * 判断电话是否符合规范
	 * 
	 * @param text
	 * @return
	 */
	// TODO 有问题···
	public static boolean isTeleValid(JTextField text) {
		String s = text.getText().trim();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if (!"".equalsIgnoreCase(text.getText().trim())
						&& text.getText().length() != 6) {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	/**
	 * 判断中转中心编号是否符合规范(4位)
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isTransCenterValid(JTextField text) {
		String s = text.getText().trim();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if (!"".equalsIgnoreCase(text.getText().trim())
						&& text.getText().length() != 4) {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	/**
	 * 判断中转单编号是否符合规范(19位)
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isTransListValid(JTextField text, String date) {
		date = date.replaceAll("-", "");
		String s = text.getText().trim();
		if ((!"".equalsIgnoreCase(s)) && s.length() != 16) {
			return false;
		}
		if (text.getText().equals(""))
			return false;
//		boolean isEqual=s.substring(1,9).equals(date);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if (!"".equalsIgnoreCase(text.getText().trim())
						&& text.getText().length() != 16) {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	/**
	 * 判断车牌号是否符合规范(除去空格7位)
	 * 
	 * @param text
	 * @return
	 */
	public static boolean islicensePlateValid(JTextField text) {
		if (!"".equalsIgnoreCase(text.getText().trim())
				&& text.getText().replaceAll(" ", "").length() != 7) {
			return false;
		}
		return true;
	}

	/**
	 * 判断账号输入是否符合规范(6~10位)
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isAccountNumValid(JTextField text) {
//		String s = text.getText().trim();
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
//				if (!"".equalsIgnoreCase(text.getText().trim())
//						&& !(text.getText().length() >= 6 && text.getText()
//						.length() <= 10)) {
//					return false;
//				}
//			} else {
//				return false;
//			}
//		}

		return true;
	}

	/**
	 * 判断机构编号输入是否符合规范(6位)
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isInstitutionValid(JTextField text) {
		String s = text.getText().trim();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if (!"".equalsIgnoreCase(text.getText().trim())
						&& (text.getText().length() != 1 && text.getText().length() != 3)) {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	/**
	 * 判断付款账号是否符合规范(16位或19位)
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isBankNumValid(JTextField text) {
		String s = text.getText().trim();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if (!"".equalsIgnoreCase(text.getText().trim())
						&& (text.getText().length() != 16 && text.getText()
						.length() != 19)) {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	/**
	 * 判断是否为整数
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isInt(JTextField text) {
		try {
			if ("".equalsIgnoreCase(text.getText().trim()))
				return true;
			else {
				Long.parseLong(text.getText().trim());
				return true;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	/**
	 * 判断是否为浮点数
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isDouble(JTextField text) {
		try {
			if ("".equalsIgnoreCase(text.getText().trim()))
				return true;
			else {
				Double.parseDouble(text.getText().trim());
				return true;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
}
